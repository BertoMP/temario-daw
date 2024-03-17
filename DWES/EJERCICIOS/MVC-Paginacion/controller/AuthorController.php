<?php

/**
 * Clase encargada de funcionar como controlador y de comunicarse
 * con la clase Author.model.php.
 *
 * Hereda de la clase Controller.
 */
class AuthorController extends Controller
{
    private Author $objAuthorModel;     // Almacenará una instancia de la clase Author.

    /**
     * Constructor de la clase.
     *
     * @param array $arrParams Recibe una serie de parámetros asociados que serán
     *                         utilizados en varios o todos los métodos de la
     *                         clase.
     */
    public function __construct(array $arrParams)
    {
        $this->strPageTitle = 'Listado de autores';     // Se asigna un título de página por defecto.
        $this->strView = 'authorList';                  // Se asigna una vista por defecto.
        $this->arrParams = $arrParams;                  // Se asocia el $arrParams que recibe por parámetro.
        $this->objAuthorModel = new Author();           // Se genera una instancia de Author.
    }

    /**
     * Muestra el listado de autores paginado.
     *
     * Esta función configura la página y la vista para mostrar el listado de autores paginado.
     * Utiliza la lógica común de paginación proporcionada por el método paginateData.
     *
     * @return array Un array que contiene parámetros y datos para la vista.
     *   - 'params': Array con los siguientes datos:
     *     - 'totalRegisters': El total de registros de autores en la base de datos.
     *     - 'maxPage': La cantidad máxima de páginas basada en la paginación y registros por página.
     *     - 'selectedPage': La página actual seleccionada.
     *   - 'data': Un array con los datos de los autores para la página actual.
     */
    public function list(): array
    {
        $this->strPageTitle = 'Listado de autores';
        $this->strView = 'authorList';

        // Obtención del total de autores en la base de datos
        $totalAuthors = $this->objAuthorModel->getTotalAuthors();

        // Obtención de la página seleccionada de los parámetros de la solicitud
        $intSelectedPage = $this->arrParams[0] ?? 1;

        // Utiliza la lógica común de paginación proporcionada por el método paginateData
        $arrReturn['params'] = $this->paginateData($totalAuthors, $intSelectedPage);
        $arrReturn['data'] = $this->objAuthorModel->getAuthors($arrReturn['params']['selectedPage']);

        return $arrReturn;
    }

    /**
     * Muestra la vista de edición de autor y recupera los datos del autor si se proporciona un ID válido.
     *
     * Esta función configura la página y la vista para mostrar el formulario de edición de autor.
     * Si se proporciona un ID de autor válido, recupera los datos del autor correspondiente.
     *
     * @return array Un array que contiene datos para la vista, si se proporciona un autor
     *               válido, en cualquier otro caso devuelve un array vacío.
     */
    public function edit(): array
    {
        $arrReturn['data'] = [];
        $this->strView = 'authorEdit';
        $strAuthorId = $this->arrParams[0] ?? '';

        // Si no se proporciona un ID de autor, la acción es añadir un nuevo autor
        if (empty($strAuthorId)) {
            $this->strPageTitle = 'Añadir autor';
            return $arrReturn;
        }

        // Si se proporciona un ID de autor, la acción es editar el autor existente
        $this->strPageTitle = 'Editar autor';
        $arrReturn['data'] = $this->objAuthorModel->getAuthorById($strAuthorId);

        return $arrReturn;
    }

    /**
     * Guarda los datos del autor, ya sea para editar un autor existente o añadir uno nuevo.
     *
     * Esta función procesa los datos del formulario de edición de autor, realiza correcciones de seguridad
     * para prevenir inyecciones SQL y valida los campos obligatorios. Luego, guarda los datos del autor
     * en la base de datos y devuelve los resultados para su visualización en la vista.
     *
     * @return array Un array que contiene parámetros y datos para la vista.
     *   - 'params':
     *     - 'response': Indica el resultado de la operación de guardado (true para éxito).
     *     - 'isAuthorCreation': Indica si la operación es la creación de un nuevo autor.
     *     - 'emptyData': Indica si hay campos obligatorios vacíos o datos no válidos.
     *   - 'data': Los datos del autor guardado o a editar, según el resultado de la operación.
     */
    public function save(): array
    {
        $this->strPageTitle = 'Editar autor';
        $this->strView = 'authorEdit';
        $arrReturn['params']['response'] = true;

        // Determina si la operación es la creación de un nuevo autor
        if (empty($this->arrParams[0])) {
            $arrReturn['params']['isAuthorCreation'] = true;
        }

        // Previene inyecciones SQL y recopila datos del formulario
        $correctedData = [
            'authorId' => Controller::preventSQLInjection($_REQUEST['authorId']),
            'authorFirstName' => Controller::preventSQLInjection($_REQUEST['authorFirstName']),
            'authorLastName' => Controller::preventSQLInjection($_REQUEST['authorLastName']),
            'authorBirthDate' => Controller::preventSQLInjection($_REQUEST['authorBirthDate']),
            'authorCountry' => Controller::preventSQLInjection($_REQUEST['authorCountry']),
            'authorBooks' => Controller::preventSQLInjection($_REQUEST['authorBooks'])
        ];

        // Validación de campos obligatorios y formato de fecha y número de libros
        if (trim($correctedData['authorFirstName'] === '')
            || trim($correctedData['authorLastName'] === '')
            || !AuthorController::checkFormatDate($correctedData['authorBirthDate'])
            || trim($correctedData['authorCountry'] === '')
            || !is_integer((int)$correctedData['authorBooks'])) {
            $arrReturn['params']['emptyData'] = true;

            // Configuración para manejar la visualización en caso de datos no válidos
            $strAuthorId = $_REQUEST['authorId'] ?? '';
            $this->strPageTitle = (empty($strAuthorId)) ? 'Añadir autor' : 'Editar autor';
            $arrReturn['data'] = [
                'ID_PERSONA' => $correctedData['authorId'],
                'NOMBRE' => $correctedData['authorFirstName'],
                'APELLIDO' => $correctedData['authorLastName'],
                'FECHA_NACIMIENTO' => $correctedData['authorBirthDate'],
                'PAIS_ORIGEN' => $correctedData['authorCountry'],
                'LIBROS_PUBLICADOS' => $correctedData['authorBooks']
                ];
            return $arrReturn;
        }

        // Guarda los datos del autor en la base de datos
        $strAuthorId = $this->objAuthorModel->saveAuthorEntry($correctedData);
        $arrReturn['data'] = $this->objAuthorModel->getAuthorById($strAuthorId);
        return $arrReturn;
    }

    /**
     * Muestra la vista de confirmación para eliminar un autor y recupera los datos del autor correspondiente.
     *
     * Esta función configura la página y la vista para mostrar el formulario de confirmación de eliminación de autor.
     * Recupera los datos del autor específico utilizando el ID proporcionado.
     *
     * @return array Un array que contiene datos para la vista. Los datos del autor a eliminar.
     */
    public function confirmDelete(): array
    {
        $this->strPageTitle = 'Eliminar autor';
        $this->strView = 'authorConfirmDelete';
        $strAuthorId = $this->arrParams[0] ?? '';

        // Obtención de los datos del autor a eliminar
        $arrReturn['data'] = $this->objAuthorModel->getAuthorById($strAuthorId);

        return $arrReturn;
    }

    /**
     * Elimina un autor de la base de datos y muestra la vista de confirmación de borrado completado.
     *
     * Esta función configura la página y la vista para mostrar el resultado después de eliminar un autor.
     * Se espera que el ID del autor a eliminar se proporcione a través de la variable de solicitud ($_REQUEST).
     * La función realiza la operación de eliminación en el modelo de autor.
     *
     * @return void
     */
    public function delete(): void
    {
        $this->strPageTitle = 'Borrado completado';
        $this->strView = 'authorDeleted';

        // Se espera que el ID del autor a eliminar se proporcione a través de la variable de solicitud
        $strAuthorId = $_REQUEST['authorId'];

        // Realiza la operación de eliminación en el modelo de autor
        $this->objAuthorModel->deleteAuthorById($strAuthorId);
    }

    /**
     * Realiza una búsqueda de autores basada en un término de búsqueda proporcionado.
     *
     * Esta función configura la página y la vista para mostrar los resultados de la búsqueda de autores.
     * Se espera que el término de búsqueda se proporcione a través de la variable de solicitud ($_REQUEST).
     * La función valida que el campo de búsqueda no esté vacío, realiza la búsqueda en el modelo de autor
     * y devuelve los resultados junto con información adicional para su visualización en la vista.
     *
     * @return array Un arreglo que contiene parámetros y datos para la vista.
     *   - 'data': Array con los datos de los autores que coinciden con el término de búsqueda.
     *   - 'params': Array que contiene:
     *     - 'error': Mensaje de error si el campo de búsqueda está vacío, o nulo si la búsqueda es exitosa.
     *     - 'totalResults': La cantidad total de resultados encontrados.
     *     - 'searchQuery': El término de búsqueda utilizado.
     */
    public function search(): array
    {
        $arrReturn = [];
        $this->strPageTitle = 'Resultados de la búsqueda de autores';
        $this->strView = 'authorSearch';

        if (empty($_REQUEST['searchQuery'])) {
            $arrReturn['params']['error'] = 'El campo de búsqueda no puede estar vacío.';
            return $arrReturn;
        }

        $strSearchQuery = Controller::preventSQLInjection($_REQUEST['searchQuery']);
        $arrReturn['data'] = $this->objAuthorModel->searchAuthors($strSearchQuery);
        $arrReturn['params']['totalResults'] = count($arrReturn['data']);
        $arrReturn['params']['searchQuery'] = $strSearchQuery;

        return $arrReturn;
    }

    /**
     * Verifica si una cadena tiene el formato de fecha esperado (YYYY-MM-DD).
     *
     * @param string $strValue La cadena que se va a verificar.
     *
     * @return bool Devuelve true si la cadena tiene el formato de fecha esperado, de lo contrario, false.
     */
    private static function checkFormatDate(string $strValue): bool
    {
        $arrDate = explode('-', $strValue);

        // Verifica la cantidad de elementos en el arreglo
        if (count($arrDate) !== 3) {
            return false;
        }

        [$strYear, $strMonth, $strDay] = $arrDate;

        // Verifica el formato y longitud del año
        if (!is_numeric($strYear)
            || strlen($strYear) !== 4
            || (int)$strYear === 0) {
            return false;
        }

        // Verifica el formato y longitud del mes
        if (!is_numeric($strMonth)
            || !checkdate((int)$strMonth, 1, 1)
            || strlen($strMonth) !== 2) {
            return false;
        }

        // Verifica el formato y longitud del día
        if (!is_numeric($strDay)
            || !checkdate((int)$strMonth, (int)$strDay, (int)$strYear)
            || strlen($strDay) !== 2) {
            return false;
        }

        return true;
    }
}
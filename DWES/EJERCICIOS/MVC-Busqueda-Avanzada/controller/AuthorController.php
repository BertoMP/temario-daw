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
        $_SESSION['bookSearch'] = null;
        $this->strPageTitle = 'Listado de autores';
        $this->strView = 'authorList';

        $arrReturn['params']['countries'] = $this->objAuthorModel->getDistintColumn('PAIS_ORIGEN');
        $arrReturn['params']['message'] = 'Realiza una búsqueda.';
        $arrReturn['data'] = [];

        if (isset($_POST['btn-search'])) {
            $correctedData = Author::preventSQLInjection($_POST);

            $numericFields = [$correctedData['minAuthorId'], $correctedData['maxAuthorId'],
                $correctedData['minAuthorBooks'], $correctedData['maxAuthorBooks']];
            $dateFields = [$correctedData['minAuthorDateOfBirth'], $correctedData['maxAuthorDateOfBirth']];

            if (!Author::checkNumeric($numericFields)) {
                $arrReturn['params']['message'] = 'Alguno de los campos no tiene el formato válido.';
                return $arrReturn;
            }

            if (!Author::checkDate($dateFields)) {
                $arrReturn['params']['message'] = 'Los campos de fecha no tienen el formato válido (AAAA-mm-DD)';
                return $arrReturn;
            }

            $_SESSION['authorSearch'] = $correctedData;
        }

        if (isset($_SESSION['authorSearch'])) {
            $totalAuthors = $this->objAuthorModel->getTotalAuthorsBySearch();

            $intSelectedPage = $this->arrParams[0] ?? 1;

            $arrReturn['params']['paginate'] = $this->paginateData($totalAuthors, $intSelectedPage);
            $arrReturn['data'] = $this->objAuthorModel->searchAuthors($arrReturn['params']['paginate']['selectedPage']);

            if ($totalAuthors === 0) {
                $arrReturn['params']['message'] = 'No hay autores con los criterios de búsqueda indicados.';
            } else {
                $arrReturn['params']['message'] = 'Se han encontrado ' . $totalAuthors
                    . ' resultados con los criterios de búsqueda indicados.';
            }
        }

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
        $correctedData = Author::preventSQLInjection($_POST);
        if (!Author::checkEmptyFields($correctedData)
            or !Author::checkDate([$correctedData['authorBirthDate']])
            or !Author::checkNumeric([$correctedData['authorId'], $correctedData['authorBooks']])) {
            $arrReturn['params']['emptyData'] = true;

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
}
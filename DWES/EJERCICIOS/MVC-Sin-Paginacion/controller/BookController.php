<?php

/**
 * Clase encargada de funcionar como controlador y de comunicarse
 * con la clase Book.model.php.
 *
 * Hereda de la clase Controller.
 */
class BookController extends Controller
{
    private Book $objBookModel; // Almacenará una instancia de la clase Book.

    /**
     * Constructor de la clase.
     *
     * @param array $arrParams Recibe una serie de parámetros asociados que serán
     *                         utilizados en varios o todos los métodos de la
     *                         clase.
     */
    public function __construct(array $arrParams)
    {
        $this->strPageTitle = 'Listado de libros';      // Se asocia un título por defecto.
        $this->strView = 'bookList';                    // Se asocia una vista por defecto.
        $this->arrParams = $arrParams;                  // Se asocia el $arrParams que recibe por parámetro.
        $this->objBookModel = new Book();               // Se genera una instancia de Book.
        $this->objAuthorModel = new Author();           // Se genera una instancia de Author.
    }

    /**
     * Muestra el listado de libros paginado.
     *
     * Configura la página y la vista para mostrar el listado de libros paginado.
     * Utiliza la lógica común de paginación proporcionada por el método paginateData.
     *
     * @return array Un array que contiene parámetros y datos para la vista.
     *   - 'params': Array con los siguientes datos:
     *     - 'totalRegisters': El total de registros de libros en la base de datos.
     *     - 'maxPage': La cantidad máxima de páginas basada en la paginación y registros por página.
     *     - 'selectedPage': La página actual seleccionada.
     *   - 'data': Un array con los datos de los libros para la página actual.
     */
    public function list(): array
    {
        $_SESSION['authorSearch'] = null;
        $this->strPageTitle = 'Listado de libros';
        $this->strView = 'bookList';

        $arrReturn['params']['message'] = 'Realiza una búsqueda.';
        $arrReturn['data'] = [];

        if (isset($_POST['btn-search'])) {
            $correctedData = Book::preventSQLInjection($_POST);

            $numericFields = [
                $correctedData['minBookId'],
                $correctedData['maxBookId'],
                $correctedData['minBookYear'],
                $correctedData['maxBookYear'],
                $correctedData['minBookPage'],
                $correctedData['maxBookPage']
            ];

            if (!Book::checkNumeric($numericFields)) {
                $arrReturn['params']['message'] = 'Alguno de los campos no tiene el formato correcto.';
                return $arrReturn;
            } else {
                $_SESSION['bookSearch'] = $correctedData;
            }
        }

        if (isset($_SESSION['bookSearch'])) {
            $totalBooks = $this->objBookModel->getTotalBooksBySearch();

            $intSelectedPage = $this->arrParams[0] ?? 1;

            $arrReturn['params']['paginate'] = $this->paginateData($totalBooks, $intSelectedPage);
            $arrReturn['data'] = $this->objBookModel->searchBooks($arrReturn['params']['paginate']['selectedPage']);

            if ($totalBooks === 0) {
                $arrReturn['params']['message'] = 'No hay libros con esos criterios de búsqueda indicados.';
            } else {
                $arrReturn['params']['message'] = 'Se han encontrado ' . $totalBooks
                    . ' resultados con los criterios de búsqueda indicados.';
            }
        }

        $arrReturn['params']['genres'] = $this->objBookModel->getDistinctColumn('GENERO');
        $arrReturn['params']['countries'] = $this->objBookModel->getDistinctColumn('PAIS');
        $arrReturn['params']['authors'] = $this->objAuthorModel->getAuthors();

        return $arrReturn;
    }

    /**
     * Muestra la vista de edición de libro y recupera los datos del libro correspondiente.
     *
     * Configura la página y la vista para mostrar el formulario de edición de libro.
     * Recupera los datos del libro específico utilizando el ID proporcionado.
     *
     * @return array Un array que contiene datos para la vista.
     *   - 'data': Los datos del libro para la edición.
     */
    public function edit(): array
    {
        $arrReturn['data'] = [];
        $this->strView = 'bookEdit';
        $strBookId = $this->arrParams[0] ?? '';

        $arrReturn['params']['authors'] = $this->objAuthorModel->getAuthors();

        if (empty($strBookId)) {
            $this->strPageTitle = 'Añadir libro';
            return $arrReturn;
        }

        // Recupera los datos del libro utilizando el ID proporcionado
        $this->strPageTitle = 'Editar libro';
        $arrReturn['data'] = $this->objBookModel->getBookById($strBookId);

        return $arrReturn;
    }

    /**
     * Guarda o actualiza un libro y muestra la vista correspondiente.
     *
     * Esta función configura la página y la vista para mostrar el formulario
     * de edición de libro.
     * Realiza la validación y corrección de los datos del libro proporcionados
     * a través de la solicitud.
     * Guarda o actualiza el libro en la base de datos y muestra la vista
     * correspondiente con los resultados.
     *
     * @return array Un array que contiene parámetros y datos para la vista.
     *   - 'params': Un array que contiene:
     *     - 'response': Indica si la operación fue exitosa.
     *     - 'isBookCreation'. Indica si se está creando un nuevo libro.
     *     - 'emptyData': Indica si algunos datos proporcionados estaban vacíos o no válidos.
     *   - 'data': Los datos del libro después de la operación.
     */
    public function save(): array
    {
        $this->strPageTitle = 'Editar libro';
        $this->strView = 'bookEdit';
        $arrReturn['params']['response'] = true;

        // Verifica si se está creando un nuevo libro
        if (empty($this->arrParams[0])) {
            $arrReturn['params']['isBookCreation'] = true;
        }

        $arrReturn['params']['authors'] = $this->objAuthorModel->getAuthors();

        // Obtiene y corrige los datos proporcionados a través de la solicitud
        $correctedData = Book::preventSQLInjection($_POST);

        // Verifica la validez de los datos
        if (!Book::checkEmptyFields($_POST)
            || !Book::checkNumeric([$correctedData['bookId'], $correctedData['bookYear']])) {
            $arrReturn['params']['emptyData'] = true;

            $strBookId = $_REQUEST['bookId'] ?? '';
            $this->strPageTitle = (empty($strBookId)) ? 'Añadir libro' : 'Editar libro';
            $arrReturn['data'] = [
                'ID_LIBRO' => $correctedData['bookId'],
                'TITULO' => $correctedData['bookTitle'],
                'GENERO' => $correctedData['bookGender'],
                'PAIS' => $correctedData['bookCountry'],
                'ANO' => $correctedData['bookYear'],
                'NUM_PAGINAS' => $correctedData['bookPages'],
                'ID_AUTOR' => $correctedData['bookAuthor']
            ];
            return $arrReturn;
        }

        // Guarda o actualiza el libro en la base de datos
        $strBookId = $this->objBookModel->saveBookEntry($correctedData);
        $arrReturn['data'] = $this->objBookModel->getBookById($strBookId);
        return $arrReturn;
    }

    /**
     * Muestra la vista de confirmación de eliminación de libro y recupera los
     * datos del libro correspondiente.
     *
     * Configura la página y la vista para mostrar el formulario de confirmación
     * de eliminación de libro.
     *
     * Recupera los datos del libro específico utilizando el ID proporcionado.
     *
     * @return array Un array que contiene datos para la vista.
     *   - 'data': Los datos del libro para la confirmación de eliminación.
     */
    public function confirmDelete(): array
    {
        $this->strPageTitle = 'Eliminar libro';
        $this->strView = 'bookConfirmDelete';
        $strBookId = $this->arrParams[0] ?? '';

        // Recupera los datos del libro utilizando el ID proporcionado
        $arrReturn['data'] = $this->objBookModel->getBookById($strBookId);

        return $arrReturn;
    }

    /**
     * Elimina un libro y muestra la vista correspondiente.
     *
     * Esta función configura la página y la vista para mostrar el estado
     * después de eliminar un libro.
     * Obtiene el ID del libro a eliminar a través de la solicitud y realiza
     * la eliminación en la base de datos.
     *
     * @return void
     */
    public function delete(): void
    {
        $this->strPageTitle = 'Borrado completado';
        $this->strView = 'bookDeleted';

        // Obtiene el ID del libro a eliminar a través de la solicitud
        $strBookId = $_REQUEST['bookId'];

        // Realiza la eliminación del libro en la base de datos
        $this->objBookModel->deleteBookById($strBookId);
    }
}
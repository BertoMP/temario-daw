<?php

class BookController
{
    private string $strPageTitle; // Atributo que almacenará el nombre de la página.
    private string $strView; // Atributo que almacenará la vista a renderizar.
    private array $arrParams; // Atributo con los parámetros a utilizar por los métodos del controlador.
    private Book $objBookModel; // Objeto Book para provocar consultas de la base de datos a la tabla LIBROS.

    // CONSTRUCTOR DE LA CLASE
    public function __construct(array $arrParams)
    {
        $this->strPageTitle = 'Listado de libros'; // Título por defecto.
        $this->strView = 'bookList'; // Vista por defecto.
        $this->arrParams = $arrParams; // Parámetros recibidos por el constructor.
        $this->objBookModel = new Book(); // Instanciación de objeto de la clase Book.
    }

    // MÉTODO LISTAR QUE GESTIONA LA BÚSQUEDA REALIZADA EN LA VISTA DE bookList.view.php
    // Gestiona un array de tipo POST que es generado cuando se pulsa el botón "BUSCAR" del formulario
    // de búsqueda.
    // Este array guarda los valores de los inputs en un array asociativo estilo ['minBookId' => 20, 'maxBookId' =>
    // '', 'bookTitle' => 'Dragonlance',... resto inputs].
    public function list(): array
    {
        $this->strPageTitle = 'Listado de libros'; // Título de la página.
        $this->strView = 'bookList'; // Vista del listado.

        // Generamos un subarray vacío dentro del array que vamos a devolver. Este subarray almacenará
        // los datos resultantes de la consulta de búsqueda (es el array que va a ser devuelto por searchBooks() del
        // modelo Book.model.php)
        $arrReturn['data'] = [];

        // El formulario necesita conocer los géneros y países disponibles en la base de datos, para construir los
        // desplegables de tipo select-option del formulario de búsqueda de la vista bookList.
        // Para recoger estos datos utilizamos el método getDistinctColumn del Book.model.php.
        // Cada uno de estos valores los guardamos en un subarray 'params' del array que vamos a devolver como
        // resultado de esta función.
        $arrReturn['params']['genres'] = $this->objBookModel->getDistinctColumn('GENERO');
        $arrReturn['params']['countries'] = $this->objBookModel->getDistinctColumn('PAIS');

        // Además guardamos un mensaje de información al usuario. Este mensaje aparecerá la primera vez que cargue la
        // vista bookList, en las búsquedas siguientes se verá sobreescrito por el valor del if de más abajo (líneas
        // 56 a 61).
        $arrReturn['params']['message'] = 'Realiza una búsqueda con el formulario superior.';

        // Comprobamos si el input btn-search está inicializado
        if (isset($_POST['btn-search'])) { // Si lo está...
            // Cargamos en el subarray 'params' el array POST, de esta forma los campos del formulario, la
            // siguiente vez que cargue la página, tendrán los valores de búsqueda que se hayan introducido en la
            // búsqueda anterior.
            $arrReturn['params']['searchValues'] = $_POST;

            // Lanzamos el método searchBooks pasándole el $_POST y guardamos el resultado en el subarray 'data'.
            $arrReturn['data'] = $this->objBookModel->searchBooks($_POST);

            // Comprobamos el número de resultados que se han producido, y en base a eso sobreescribimos el mensaje
            // que hemos inicializado más arriba (línea 40).
            if (count($arrReturn['data']) > 0) {
                $arrReturn['params']['message'] = 'Se han encontrado ' . count($arrReturn['data']) . ' resultados.';
            } else {
                $arrReturn['params']['message'] = 'No se han encontrado resultados.';
            }
        }

        return $arrReturn;
    }

    // MÉTODOS GET PARA DEVOLVER LOS VALORES DE LOS ATRIBUTOS
    public function getPageTitle(): string
    {
        return $this->strPageTitle;
    }

    public function getView(): string
    {
        return $this->strView;
    }
}
<?php

class Handler
{
    private string $strController; // Almacena el controlador.
    private string $strAction; // Almacena la acción.
    private array $arrParams; // Almacena otra serie de parámetros de la URL.

    // CONSTRUCTOR DE LA CLASE
    // Inicializa los atributos y llama a la función privada fillAttributes.
    public function __construct()
    {
        $this->strController = '';
        $this->strAction = '';
        $this->arrParams = [];
        $this->fillAttributes();
    }

    // Función encargada de dar el valor real a los atributos a partir de la URL de la barra de navegación.
    private function fillAttributes(): void
    {
        // Construimos la URL.
        $strURI = 'http://' . $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI'];

        // Comprobamos que está bien construida.
        $arrParseURL = parse_url($strURI);

        // Si lo está, $arrParseURL será un array, si no lo está podrá ser un boolean, un int...
        // Además comprobamos si contiene index.php en la URL (esto evita que suceda un warning
        // si el proyecto se carga desde la carpeta sin explicitar index.php en la URL).
        if (is_array($arrParseURL) && str_contains($strURI, 'index.php')) {
            // Se divide la URL en 2 teniendo en cuenta como separador el string 'index.php'
            // De esta forma la URL: http://localhost/MVC-Simple/index.php/BookController/list/2
            // Se dividirá de la siguiente forma:
            //      - [0] => http://localhost/MVC-Simple/
            //      - [1] => /BookController/list/2
            $arrStrUri = explode('index.php', $strURI);

            // El índice que nos interesa es el 1 ya que es el que contiene todos los parámetros
            // que queremos usar para decidir controlador, acción y otros parámetros necesarios.

            // Lo siguiente que hacemos es dividir ese índice [1] en un nuevo array utilizando
            // como separador la '/'.
            // Usando el ejemplo anterior (/BookController/list/2) se dividirá de la siguiente
            // forma:
            //      - [0] => vacío ('').
            //      - [1] => BookController
            //      - [2] => list
            //      - [3] => 2
            $arrAttributes = explode('/', $arrStrUri[1]);

            // Asociamos cada índice del array a un atributo en concreto.
            $this->strController = $arrAttributes[1] ?? ''; // El índice [1] será el controlador.
            $this->strAction = $arrAttributes[2] ?? ''; // El índice [2] será la acción.
            $this->arrParams = array_slice($arrAttributes, 3); // Del índice 3 en adelante serán los parámetros.
        }
    }

    // MÉTODOS GET PARA LA DEVOLUCIÓN DE ATRIBUTOS

    public function getController(): string
    {
        return $this->strController;
    }

    public function getAction(): string
    {
        return $this->strAction;
    }

    public function getParams(): array
    {
        return $this->arrParams;
    }
}
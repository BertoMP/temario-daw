<?php

/**
 * Clase handler que sirve para gestionar las propiedades
 * de la URL durante el uso de la aplicación.
 */
class Handler
{
    private string $strController;          // Almacena el controlador de la URL.
    private string $strAction;              // Almacena la acción de la URL.
    private array $arrParams;               // Almacena los parámetros de la URL.

    /**
     * Constructor de la clase Handler.
     *
     * Se inicializan las propiedades a vacío para que en caso de error
     * devolver vacíos.
     *
     * A continuación se llama a la función fillAttributes.
     */
    public function __construct()
    {
        $this->strController = '';          // Se asocia un controlador vacío por defecto.
        $this->strAction = '';              // Se asocia una acción vacía por defecto.
        $this->arrParams = [];              // Se asocia un array vacío de parámetros.
        $this->fillAttributes();            // Llamada a una función privada para rellenar los atributos.
    }

    /**
     * Rellena los atributos del controlador a partir de la URL actual.
     *
     * Extrae la información del controlador, la acción y los parámetros de la URL actual.
     * Se utiliza para inicializar los atributos del controlador en el constructor.
     *
     * @return void
     */
    private function fillAttributes(): void
    {
        // Obtiene la URL completa con el protocolo, nombre de servidor y URI.
        $strURI = 'http://' . $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI'];

        // Analiza la URL para extraer sus componentes.
        $arrParseURL = parse_url($strURI);

        // Verifica si la URL contiene 'index.php'.
        if (is_array($arrParseURL) && str_contains($strURI, 'index.php')) {
            // Divide la URL en dos partes utilizando 'index.php' como separador.
            $arrStrUri = explode('index.php', $strURI);

            // Divide la segunda parte (después de 'index.php') en segmentos usando '/' como separador.
            $arrAttributes = explode('/', $arrStrUri[1]);

            // Asigna valores a los atributos del controlador.
            $this->strController = $arrAttributes[1] ?? '';
            $this->strAction = $arrAttributes[2] ?? '';
            $this->arrParams = array_slice($arrAttributes, 3);
        }
    }

    /**
     * Devuelve el valor del atributo $strController.
     *
     * @return string El valor del atributo $strController.
     */
    public function getController(): string
    {
        return $this->strController;
    }

    /**
     * Devuelve el valor del atributo $strAction.
     *
     * @return string El valor del atributo $strAction.
     */
    public function getAction(): string
    {
        return $this->strAction;
    }

    /**
     * Devuelve el valor del atributo $arrParameters.
     *
     * @return array El valor del atributo $arrParameters.
     */
    public function getParams(): array
    {
        return $this->arrParams;
    }
}
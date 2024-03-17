<?php
/**
 * Clase Handler para gestionar las propiedades de la
 * aplicación según la URL solicitada.
 */
class Handler {
    private array $arrProperties; // Almacena las propiedades de la aplicación.

    /**
     * Constructor de la clase Handler.
     */
    public function __construct() {
        $this->arrProperties = ['controller'=>'', 'action'=>'', 'parameters'=>[]];
        $this->fillProperties();
    }

    /**
     * Rellena el array $arrProperties con información extraída de la URL.
     *
     * Esta función analiza la URL actual para identificar el controlador, la acción y los parámetros
     * asociados a la solicitud, almacenando esta información en el array $arrProperties.
     *
     * @return void
     */
    private function fillProperties(): void {
        // Construye la URL completa.
        $strUri = 'http://' . $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI'];

        // Obtiene un array con los componentes de la URL.
        $arrParseURL = parse_url($strUri);

        // Verifica que la URL sea un array válido y contiene '.php'.
        if (is_array($arrParseURL) && str_contains($strUri, '.php')) {
            // Extrae la parte de la URL después de '.php'.
            $arrUri = explode('.php', $strUri)[1];

            // Divide la URL en segmentos utilizando '/' como separador.
            $arrParams = explode('/', $arrUri);

            // Asigna el controlador y la acción a $arrProperties.
            $this->arrProperties['controller'] = $arrParams[1] ?? '';
            $this->arrProperties['action'] = $arrParams[2] ?? '';

            // Obtiene los parámetros de la URL después del controlador y la acción.
            $parameters = array_slice($arrParams, 3);

            // Verifica si existen parámetros.
            if ($parameters !== []) {
                // Evalúa el controlador actual para determinar cómo procesar los parámetros.
                switch ($this->arrProperties['controller']) {
                    case 'ControladorNota':
                        // Si el controlador es 'ControladorNota', evalúa la acción.
                        switch ($this->arrProperties['action']) {
                            case 'list':
                                // Si la acción es 'list', asigna el parámetro 'page'.
                                $this->arrProperties['parameters']['page'] = $parameters[0] ?? '';
                                break;
                            case 'save':
                            case 'edit':
                            case 'confirmDelete':
                                // Si la acción es 'save', 'edit' o 'confirmDelete', asigna el parámetro 'id'.
                                $this->arrProperties['parameters']['id'] = $parameters[0] ?? '';
                                break;
                        }
                        break;
                    case 'ControladorUsuario':
                        // Si el controlador es 'ControladorUsuario', evalúa la acción.
                        switch ($this->arrProperties['action']) {
                            case 'login':
                            case 'logout':
                            case 'accessDenied':
                                // Si la acción es 'login', 'logout' o 'accessDenied', no se esperan parámetros.
                                $this->arrProperties['parameters'] = [];
                                break;
                        }
                        break;
                }
            }
        }
    }

    /**
     * Función encargada de devolver el array de propiedades.
     * @return array - Devuelve un array con las propiedades.
     */
    public function getProperties(): array {
        return $this->arrProperties;
    }
}
<?php
// Incluir los archivos de configuración y clases necesarios
use view\View;

require_once 'config/config.php';
require_once 'model/Db.php';
require_once 'model/Handler.php';
require_once 'view/View.php';
require_once 'include/functions.include.php';

// Iniciar la sesión
session_start();

// Crear una instancia del objeto Handler
$handler = new Handler();

// Obtener propiedades del objeto Handler
$properties = $handler->getProperties();
$handlerController = $properties['controller']; // Controlador elegido
$handlerAction = $properties['action']; // Acción a realizar por el controlador
$handlerParameters = $properties['parameters']; // Parámetros que requiere la acción para funcionar

// Verificar si hay una sesión activa
if (isset($_SESSION['acceso'])) {
    // Configurar el controlador por defecto si no se especifica uno
    if (empty($handlerController)) {
        $handlerController = 'ControladorNota';
    } else if ($handlerController === 'ControladorUsuario') {
        /* Redirigir a 'ControladorNota' si el controlador actual
         * es 'ControladorUsuario' y la acción no es 'logout'. */
        if (!empty($handlerAction) and $handlerAction !== 'logout') {
            $handlerController = 'ControladorNota';
            $handlerAction = 'list';
        }
    }

    // Configurar la acción por defecto si no se especifica una
    if (!isset($handlerAction)) {
        $handlerAction = 'list';
    }
} else {
    // Configurar el controlador y la acción por defecto si no hay una sesión activa
    if (!empty($handlerController) and $handlerController !== constant("DEFAULT_CONTROLLER")) {
        $handlerController = constant("DEFAULT_CONTROLLER");
        $handlerAction = constant("DENIED_ACTION");
    } else {
        $handlerController = constant("DEFAULT_CONTROLLER");
        $handlerAction = constant("DEFAULT_ACTION");
    }
}

// Obtener la ruta del controlador
$controller_path = 'controller/'.$handlerController.'.php';

// Si no existe el archivo del controlador, cargar el controlador por defecto
if(!file_exists($controller_path)) {
    $controller_path = 'controller/ControladorNota.php';
    $handlerController = 'ControladorNota';
}

// Cargar el controlador
require_once $controller_path;
$controllerName = $handlerController;

// Crear una instancia del controlador
$controller = new $controllerName();

/* Crear un array asociado a ['data'] que recogerá los datos que devuelva
 * la acción a realizar por el controlador */
$dataToView["data"] = [];

// Comprobar que el método (la acción elegida) existe en el controlador
if (method_exists($controller, $handlerAction)) {
    // Si existe, lanza la acción y recoge los datos que recibe como resultado.
    $dataToView["data"] = $controller->{$handlerAction}($handlerParameters);
} else {
    /* Si no existe, genera una instancia de ControladorNota y lanza
     * el método list cuyo resultado será guardado en el array asociativo. */
    $controller = new ControladorNota();
    $dataToView['data'] = $controller->list($handlerParameters);
}

// Carga de cabecera, vista y pie de página.
View::render($controller, $dataToView['data']);

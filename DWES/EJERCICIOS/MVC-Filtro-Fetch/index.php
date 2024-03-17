<?php
// Inclusión de archivos de configuración, manejador, modelos, vista y clases auxiliares

include_once 'config/config.php';               // Archivo de configuración que guarda las constantes del proyecto.
include_once 'handler/Handler.php';             // Archivo del manejador para poder instanciarlo.
include_once 'controller/Controller.php';       // Archivo del controlador padre para poder instanciar el resto.
include_once 'model/Database.model.php';        // Archivo del modelo Database para poder generar una conexión a la BD.
include_once 'model/Author.model.php';          // Archivo del modelo Author para poder instanciar objetos de este tipo.
include_once 'model/Book.model.php';            // Archivo del modelo Book para poder instanciar objetos de este tipo.
include_once 'model/User.model.php';            // Archivo del modelo User para poder instanciar objetos de este tipo.
include_once 'view/View.php';                   // Archivo del renderizador de la página.
include_once 'classes/Functionality.php';       // Archivo de funcionalidades estáticas necesarias para mostrar datos.

// Inicio de la sesión
session_start();

// Creación de una instancia del manejador
$objHandler = new Handler();

// Obtención del controlador, acción y parámetros del manejador
$objHandlerController = $objHandler->getController();
$objHandlerAction = $objHandler->getAction();
$objHandlerParams = $objHandler->getParams();

// Verificación del estado de inicio de sesión del usuario
if (User::isLogged()) {
    // Si el usuario está autenticado
    if (empty($objHandlerController) or ($objHandlerController === 'UserController' and $objHandlerAction !== 'logout')) {
        $objHandlerController = DEFAULT_CONTROLLER;
        $objHandlerAction = DEFAULT_ACTION;
    }

    if (empty($objHandlerAction)) {
        $objHandlerAction = DEFAULT_ACTION;
    }
} else {
    // Si el usuario no está autenticado
    if (!empty($objHandlerController) and $objHandlerController !== 'UserController') {
        $objHandlerController = 'UserController';
        $objHandlerAction = 'deniedAccess';
    } elseif ($objHandlerAction !== 'register'
            and $objHandlerAction !== 'save'
            and $objHandlerAction !== 'userRegisterCompleted') {
        $objHandlerController = 'UserController';
        $objHandlerAction = 'login';
    }
}

// Construcción de la ruta del controlador
$controllerPath = 'controller/' . $objHandlerController . '.php';

// Verificación de la existencia del archivo del controlador
if (!file_exists($controllerPath)) {
    $controllerPath = 'controller/' . DEFAULT_CONTROLLER . '.php';
    $objHandlerController = DEFAULT_CONTROLLER;
}

// Inclusión del archivo del controlador
include_once $controllerPath;

// Creación de una instancia del controlador
$objController = new $objHandlerController($objHandlerParams);

// Creación del array que guardará los datos
$dataToView = array();

// Verificación de la existencia de la acción en el controlador
if (method_exists($objController, $objHandlerAction)) {
    // Ejecución de la acción del controlador
    $dataToView = $objController->{$objHandlerAction}();
} else {
    // Si la acción no existe, se utiliza la acción predeterminada del controlador predeterminado
    $objHandlerController = DEFAULT_CONTROLLER;
    $objHandlerAction = DEFAULT_ACTION;
    $objHandlerParams = DEFAULT_PARAMS;

    // Inclusión del archivo del controlador por defecto.
    include_once 'controller/' . $objHandlerController . '.php';

    // Instanciación de un objeto de la clase por defecto.
    $objController = new $objHandlerController($objHandlerParams);

    // Ejecución de la acción por defecto.
    $dataToView = $objController->$objHandlerAction();
}

// Configuración de datos adicionales para la vista
$dataToView['params']['pageTitle'] = $objController->getPageTitle();
$dataToView['params']['view'] = $objController->getView();

// Renderizado de la vista
View::render($dataToView);
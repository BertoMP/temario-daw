<?php
// 1. Carga en la aplicación todos aquellos ficheros que vayan a ser necesarios.
use model\User;

include_once 'config/config.php'; // Archivo con los datos de configuración.
include_once 'handler/Handler.php'; // Archivo de clase para el manejador.
include_once 'model/Database.model.php'; // Archivo para el modelo Database => Genera una conexión a la BD.
include_once 'model/User.model.php'; // Archivo para el modelo User => Realiza consultas sobre la tabla USUARIOS.
include_once 'model/Book.model.php'; // Archivo para el modelo Book => Realiza consultas sobre la tabla LIBROS.
include_once 'view/View.php'; // Archivo para el renderizado de la página.

// 2. Inicia o recarga la sesión del programa. En esta sesión guardaremos por ejemplo si el usuario está logado.
session_start();

// 3. Generamos una instancia del manejador para conocer lo que contiene la URL.
$objHandler = new Handler();

// 4. Guardamos en variables los valores de controlador, acción y parámetros.
$objHandlerController = $objHandler->getController();
$objHandlerAction = $objHandler->getAction();
$objHandlerParams = $objHandler->getParams();

// 5. PRIMERA DECISIÓN: ¿ESTÁ EL USUARIO LOGADO?
// Para comprobar esto usamos el método estático isLogged() del fichero User.model.php
if (User::isLogged()) { // Si está logado...
    if (empty($objHandlerController)) { // En el caso de que el controlador está vacío, colocamos el de por defecto.
        $objHandlerController = DEFAULT_CONTROLLER;
    }

    if (empty($objHandlerAction)) { // En el caso de que la acción esté vacío, colocamos la de por defecto.
        $objHandlerAction = DEFAULT_ACTION;
    }
} else { // Si no está logado...
    $objHandlerController = 'UserController'; // El controlador será el de usuario.
    $objHandlerAction = 'login'; // La acción será el login.
}

// 6. Construimos una dirección de proyecto teniendo en cuenta el directorio
//    controller/, el valor que tenga el controlador en este momento (por defecto,
//    UserController, uno que haya introducido el usuario...) y la terminación .php.
$controllerPath = 'controller/' . $objHandlerController . '.php';

// 7. SEGUNDA DECISIÓN: ¿EXISTE EL FICHERO?
// Para comprobar esto usamos el método base file_exists que nos devuelve true si
// el fichero existe (por ejemplo, controller/BookController.php) o false si
// no existe (por ejemplo, controller/FilmController.php).
if (!file_exists($controllerPath)) { // Si no existe...
    $controllerPath = 'controller/' . DEFAULT_CONTROLLER . '.php'; // Establecemos el valor la ruta de directorio a la del controlador por defecto.
    $objHandlerController = DEFAULT_CONTROLLER; // El controlador será el controlador por defecto.
}

// 8. Incluimos el fichero de controlador (bien el que haya solicitado el usuario
//    si existía, bien el de por defecto si no existía).
include_once $controllerPath;

// 9. Generamos una instancia del controlador y le pasamos los parámetros de la URL que hemos
//    recogido antes (línea 19).
// Esto sería lo mismo que poner $objController = new UserController($objHandlerParams);
// pero de esta forma es más versátil al poder tener $objHandlerController cualquier valor.
// En otro caso tendríamos que hacer un switch con los diferentes controladores para instancia
// uno u otro.
$objController = new $objHandlerController($objHandlerParams);

// 10. Generamos un array vacío, este array guardará toda la información que nos devuelvan las acciones.
$dataToView = array();

// 11. TERCERA DECISIÓN: ¿EXISTE EL MÉTODO EN LA CLASE?
// Para ello utilizamos el método base method_exists que comprueba si un objeto instanciado tiene
// acceso al método (acción) seleccionado, por ejemplo, un objUserController tendrá acceso al método login
// o al método logout, pero no lo tendrá a por ejemplo un método list o un método search porque no
// existen en la clase UserController.php.
if (method_exists($objController, $objHandlerAction)) { // Si existe el método...
    // Ejecutamos la acción y guardamos el resultado en el array $dataToView.
    // Esto es lo mismo que poner, por ejemplo, $dataToView = $objBookController->list();
    $dataToView = $objController->{$objHandlerAction}();
} else { // Si no existe el método...
    $objHandlerController = DEFAULT_CONTROLLER; // Establecemos el controlador como el de por defecto.
    $objHandlerAction = DEFAULT_ACTION; // Establecemos la acción como la acción por defecto.
    $objHandlerParams = DEFAULT_PARAMS; // Establecemos los parámetros como los parámetros por defecto.

    include_once 'controller/' . $objHandlerController . '.php'; // Incluimos el fichero del nuevo controlador (por defecto).

    $objController = new $objHandlerController($objHandlerParams); // Instanciamos un nuevo objeto del controlador por defecto

    $dataToView = $objController->$objHandlerAction(); // Ejecutamos la acción por defecto.
}

// 12. Almacenamos en el subarray 'params' del array $dataToView los valores del título de la página
//     y de la vista de la página.
$dataToView['params']['pageTitle'] = $objController->getPageTitle();
$dataToView['params']['view'] = $objController->getView();

// 13. Renderizamos la página a partir de los datos del $dataToView que recibe por parámetro.
View::render($dataToView);
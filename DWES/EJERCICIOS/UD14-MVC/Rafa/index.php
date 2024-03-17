<?php

require_once 'config/config.php';
require_once 'model/Db.php';
session_start();

if (isset($_SESSION['logueado'])) {
    if (!isset($_GET["controller"]))
        $_GET["controller"] = constant("DEFAULT_CONTROLLER");
    if (!isset($_GET["action"]))
        $_GET["action"] = constant("DEFAULT_ACTION");
} else {
    $_GET["controller"] = "ControladorLogin";
    $_GET["action"] ="check";
}


$controller_path = 'controller/' . $_GET["controller"] . '.php';

/* Check if controller exists */
if (!file_exists($controller_path))
    $controller_path = 'controller/' . constant("DEFAULT_CONTROLLER") . '.php';

/* Load controller */
require_once $controller_path;
$controllerName = $_GET["controller"];
$controller = new $controllerName();

/* Check if method is defined */
$dataToView["data"] = [];

if (method_exists($controller, $_GET["action"]))
    $dataToView["data"] = $controller->{$_GET["action"]}();
else
    $dataToView["data"] = $controller->{constant("DEFAULT_ACTION")()};


/* Load view */
require_once 'view/template/cabecera.php';
require_once 'view/' . $controller->view . '.php';
require_once 'view/template/pie.php';

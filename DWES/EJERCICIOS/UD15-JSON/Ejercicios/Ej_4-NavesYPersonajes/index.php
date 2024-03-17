<?php
include_once 'classes/Functionality.php';

Functionality::includeAll();

$objHandler = new Handler();

$objHandlerController = $objHandler->getController();
$objHandlerAction = $objHandler->getAction();
$objHandlerParams = $objHandler->getParams();

if (empty($objHandlerController)) {
    $objHandlerController = DEFAULT_CONTROLLER;
}

if (empty($objHandlerAction)) {
    $objHandlerAction = DEFAULT_ACTION;
}

$controllerPath = 'controller/' . $objHandlerController . '.php';

if (!file_exists($controllerPath)) {
    $controllerPath = 'controller/' . DEFAULT_CONTROLLER . '.php';
    $objHandlerController = DEFAULT_CONTROLLER;
}

include_once $controllerPath;

$objController = new $objHandlerController($objHandlerParams);

$dataToView = array();

if (method_exists($objController, $objHandlerAction)) {
    $dataToView = $objController->{$objHandlerAction}();
} else {
    $objHandlerController = DEFAULT_CONTROLLER;
    $objHandlerAction = DEFAULT_ACTION;
    $objHandlerParams = DEFAULT_PARAMS;

    include_once 'controller/' . $objHandlerController . '.php';

    $objController = new $objHandlerController($objHandlerParams);

    $dataToView = $objController->$objHandlerAction();
}

$dataToView['params']['pageTitle'] = $objController->getPageTitle();
$dataToView['params']['view'] = $objController->getView();

View::render($dataToView);
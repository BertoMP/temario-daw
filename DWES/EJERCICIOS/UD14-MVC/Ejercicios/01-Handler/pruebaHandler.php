<?php

use model\Handler;

include './includes/functions.include.php';
include './classes/Handler.php';

// Primero imprimimos los valores llamando de forma independiente a cada get de la clase.
echo '<h2>MÉTODOS INDEPENDIENTES</h2>';

$handler = new Handler(); // Generamos un objeto Handler.

// Recogemos e imprimimos el controlador con el método getController()
$controller = $handler->getController();
echo 'Controlador: ' . ($controller !== '' ? $controller : 'No se ha determinado el controlador.') . '<br/>';

// Recogemos e imprimimos la acción con el método getAction()
$action = $handler->getAction();
echo 'Acción: ' . ($action !== '' ? $action : 'No se ha determinado la acción.') . '<br/>';

// Recogemos e imprimimos el array de parámetros con el método getParameters().
$parameters = $handler->getParameters();
echo 'Parámetros: ';
echo printParameters($parameters); // Lo hacemos a través de la función printParametres(array).

// Ahora imprimimos los valores recogiendo el array asociativo del Handler
echo '<h2>CON UN ÚNICO ARRAY ASOCIATIVO</h2>';

// Recogemos el array asociativo a través del método getProperties().
$properties = $handler->getProperties();

// Elegimos el controlador y lo imprimimos.
$controllerAssoc = $properties['controller'];
echo 'Controlador: ' . ($controllerAssoc !== '' ? $controllerAssoc : 'No se ha determinado el controlador.') . '<br/>';

// Elegimos la acción y la imprimimos.
$actionAssoc = $properties['action'];
echo 'Acción: ' . ($actionAssoc !== '' ? $actionAssoc : 'No se ha determinado la acción.') . '<br/>';

// Elegimos el array de parámetros y lo imprimimos.
$parametersAssoc = $properties['parameters'];
echo 'Parámetros: ';
echo printParameters($parametersAssoc); // Lo hacemos a través de la función printParametres(array).
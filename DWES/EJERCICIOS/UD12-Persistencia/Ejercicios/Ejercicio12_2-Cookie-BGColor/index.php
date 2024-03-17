<?php
$strRutaCss = './css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Contador de visitas'; // Título de la página
$arrValueColores = array( // Array que contiene los colores disponibles y sus nombres
    'lightcoral' => 'Rojo Claro',
    'lightblue' => 'Azul Claro',
    'lightgreen' => 'Verde Claro',
    'lightpink' => 'Rosa Claro',
    'lightyellow' => 'Amarillo Claro',
    'lightgray' => 'Gris Claro',
    'lightcyan' => 'Cian Claro',
    'lightsalmon' => 'Salmón Claro',
    'lightseagreen' => 'Verde-mar Claro',
    'lightsteelblue' => 'Azul-acero Claro',
);
$strScript = ''; // Variable para almacenar el script de cambio de color
$strColorElegido = ''; // Variable para almacenar el color elegido actualmente

// MANEJO DE LA COOKIE
if (isset($_REQUEST['reiniciaColor'])) {
    setcookie('colorFondo', '', -1);
} else if (isset($_REQUEST['seleccionColor']) && !empty($_REQUEST['seleccionColor'])) {
    $strColorElegido = $_REQUEST['seleccionColor'];
    $strScript = 'document.body.style.backgroundColor = \'' . $strColorElegido . '\'';
    setcookie('colorFondo', $_REQUEST['seleccionColor'], time() + 86400);
} else if (isset($_COOKIE['colorFondo'])) {
    $strColorElegido = $_COOKIE['colorFondo'];
    $strScript = 'document.body.style.backgroundColor = \'' . $strColorElegido . '\'';
}

// Includes de cabecera, contenido principal y pie de página
include('./includes/cabecera.inc.php');
include('./includes/main.inc.php');
include('./includes/pie.inc.php');

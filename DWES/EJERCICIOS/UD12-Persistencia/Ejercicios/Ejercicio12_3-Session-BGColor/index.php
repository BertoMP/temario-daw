<?php
$strRutaCss = './css/styles.css'; // Ruta del archivo CSS utilizado
$strTitulo = 'Cambio de color del fondo'; // Título de la página
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
$strColorElegido = ''; // Variable para almacenar el color elegido actualmente
$strScript = ''; // Variable para almacenar el script de cambio de color

// Inicio de la sesión
session_start();

if (isset($_REQUEST['seleccionColor']) && !empty($_REQUEST['seleccionColor'])) {
    $strColorElegido = $_REQUEST['seleccionColor'];
    $_SESSION['colorElegido'] = $strColorElegido;
}

if (isset($_SESSION['colorElegido'])) {
    $strColorElegido = $_SESSION['colorElegido'];
    $strScript = 'document.body.style.backgroundColor = \'' . $strColorElegido . '\'';
}

// Include de cabecera, contenido principal y pie de página
include('./includes/cabecera.inc.php');
include('./includes/main.inc.php');
include('./includes/pie.inc.php');

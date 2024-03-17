<?php
$strRutaCss = '../css/style-verColor.css'; // Ruta del archivo CSS utilizado
$strTitulo = 'Muestra del color'; // Título de la página
$strScript = ''; // Variable para almacenar el script de cambio de color

// Include del archivo de cabecera
include('../includes/cabecera.inc.php');

// Reanuda la sesión
session_start();

if (isset($_SESSION['colorElegido'])) {
    $strColor = $_SESSION['colorElegido'];
    $strScript = 'document.body.style.backgroundColor = \'' . $strColor . '\'';
    include('../includes/verColor.inc.php');
} else {
    header('Location: ../index.php');
}

// Include del pie de página
include('../includes/pie.inc.php');

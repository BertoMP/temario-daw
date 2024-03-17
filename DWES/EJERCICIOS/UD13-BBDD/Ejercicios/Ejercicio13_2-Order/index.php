<?php
// Include de las funciones de la base de datos.
include('./includes/PDO.inc.php');

$strRutaCss = './css/stylesIndex.css'; // Ruta al archivo CSS utilizado.
$strTitulo = 'Héroes'; // Título de la página web

// Inicio de la sesión.
session_start();

// Include de los elementos cabecera, main y pie de la página.
include('./includes/cabecera.inc.php');
include('./includes/mainIndex.inc.php');
include('./includes/pie.inc.php');

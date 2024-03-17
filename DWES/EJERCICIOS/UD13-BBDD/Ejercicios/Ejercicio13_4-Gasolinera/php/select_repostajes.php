<?php
// Include de las funciones PDO asociadas a la base de datos.
include ('../includes/PDO.inc.php');

$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Listado repostajes'; // Título de la página.

// Restauración de la sesión.
session_start();
$_SESSION['ultima-opcion'] = 'listado-repostajes'; // Asigna el valor 'listado-repostajes' a $_SESSION['ultima-opcion'].

// Includes de la cabecera, el cuerpo y el pie de la página.
include ('../includes/cabecera.inc.php');
include('../includes/mainListarRepostajes.inc.php');
include ('../includes/pie.inc.php');
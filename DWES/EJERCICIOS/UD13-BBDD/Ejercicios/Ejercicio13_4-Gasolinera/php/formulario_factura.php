<?php
// Include de las funciones PDO asociadas a la base de datos.
include ('../includes/PDO.inc.php');

$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Repostaje factura'; // Título de la página.

// Restauración de la sesión.
session_start();
$_SESSION['ultima-opcion'] = 'insert-factura'; // Asigna el valor 'insert-factura' a $_SESSION['ultima-opcion'].

// Includes de la cabecera, el cuerpo y el pie de la página.
include ('../includes/cabecera.inc.php');
include ('../includes/mainRepostajeFactura.inc.php');
include ('../includes/pie.inc.php');
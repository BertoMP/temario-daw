<?php
// Include de las funciones PDO asociadas a la base de datos.
include ('../includes/PDO.inc.php');

$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Repostaje normal';// Título de la página.

// Restauración de la sesión.
session_start();
$_SESSION['ultima-opcion'] = 'insert-repostaje'; // Asigna el valor 'insert-repostaje' a $_SESSION['ultima-opcion'].

include ('../includes/cabecera.inc.php');
include ('../includes/mainRepostajeNormal.inc.php');
include ('../includes/pie.inc.php');
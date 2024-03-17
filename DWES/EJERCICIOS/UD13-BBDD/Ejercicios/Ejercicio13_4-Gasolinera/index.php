<?php
// Include de las funciones PDO asociadas a la base de datos.
include ('./includes/PDO.inc.php');

// Include de las funciones del fichero funciones.inc.php.
include ('./includes/funciones.inc.php');

$strRutaCss = './css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Menú gasolinera'; // Título de la página.

$arrBotones = array( // Array que contiene los datos de los botones del menú.
    array('./php/formulario_ticket.php', 'rep-normal', 'Repostaje normal'),
    array('./php/formulario_factura.php', 'rep-factura', 'Repostaje factura'),
    array('./php/select_repostajes.php', 'list-rep', 'Listar repostajes'),
    array('./index.php', 'importe-total', 'Importe total combustible vendido'),
    array('./php/formulario_deposito.php', 'llenado-depositos', 'Llenado de depósito gasolinera'),
    array('index.php', 'del-llenado', 'Eliminar último llenado de depósito gasolinera'),
    array('./php/select_depositos.php', 'list-llenado', 'Listar llenados depósito gasolinera')
);

// Inicio o restauración de la sesión.
session_start();

// Llamada a la función eliminaValoresSession del fichero funciones.inc.php.
eliminaValoresSession($_SESSION);

// Includes de la cabecera, el cuerpo y el pie de la página.
include ('./includes/cabecera.inc.php');
include ('./includes/mainIndex.inc.php');
include ('./includes/pie.inc.php');
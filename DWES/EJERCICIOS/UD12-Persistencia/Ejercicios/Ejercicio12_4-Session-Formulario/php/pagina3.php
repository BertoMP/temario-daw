<?php
// Include del archivo de funciones
include('../includes/funciones.inc.php');
$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS utilizado
$strTitulo = 'Resultados'; // Título de la página

session_start();

$_SESSION['convivientes'] = $_REQUEST['convivientes'];
$_SESSION['aficiones'] = $_REQUEST['aficiones'];
$_SESSION['menu'] = $_REQUEST['menu'];

if (isset($_REQUEST['envio-datos'])) {
    $arrCamposAComprobar = array(
        'convivientes',
        'aficiones',
        'menu',
    );
    if (tieneCamposVacios($_SESSION, $arrCamposAComprobar)) {
        $_SESSION['camposVacios'] = true;
        header('Location: ./pagina2.php');
    } else {
        unset($_SESSION['camposVacios']);
    }
}

include('../includes/cabecera.inc.php');
include('../includes/mainPagina3.inc.php');
include('../includes/pie.inc.php');

<?php
$strTitulo = 'Apuesta Quiniela'; // Título del HTML.

// Incluye las variables compartidas.
include('./includes/variablesCompartidas.inc.php');

// Incluye las funciones necesarias.
include('./includes/funciones.inc.php');

// Incluye la cabecera de la página.
include('./includes/cabecera.inc.php');

if (isset($_REQUEST['partido'])) {
    $arrPartidosUser = $_REQUEST['partido']; // Array con la apuesta del usuario.

    // Llamada a la función compruebaApuesta(array): void
    compruebaApuesta($arrPartidosUser);

    // Llamada a la función generaHTMLApuesta(array, array): void
    generaHTMLApuesta($arrayPartidos, $arrPartidosUser);
}

// Incluye el pie de página de la página
include('./includes/pie.inc.html');
?>
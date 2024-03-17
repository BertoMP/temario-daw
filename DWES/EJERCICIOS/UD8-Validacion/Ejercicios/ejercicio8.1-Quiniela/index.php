<?php
$strTitulo = 'Quiniela'; // Título del HTML.
$strRuta = './apuestaUsuario.php'; // Ruta de redirección del formulario.

// Incluye las variables compartidas.
include('./includes/variablesCompartidas.inc.php');

// Incluye las funciones necesarias.
include('./includes/funciones.inc.php');

// Incluye la cabecera de la página.
include('./includes/cabecera.inc.php');

// Llamada a la función generaHTMLQuiniela(array, string): void
generaHTMLQuiniela($arrayPartidos, $strRuta);

// Incluye el pie de página de la página
include('./includes/pie.inc.html');
?>
<?php
$strRutaCss = './css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Contador de visitas'; // Título de la página
$strTexto = ''; // Variable para almacenar el texto a mostrar
$intContador = isset($_COOKIE['contadorVisitas']) ? $_COOKIE['contadorVisitas'] : 1; // Contador de visitas, inicializado a 1 si la cookie no existe

// MANEJO DE LA COOKIE
if (isset($_REQUEST['reinicio'])) {
    $intContador = 1;
    setcookie('contadorVisitas', '', -1);
}

if ($intContador === 1) {
    $strTexto = 'Esta es tu primera visita.';
    setcookie('contadorVisitas', $intContador);
    setrawcookie('contadorVisitasRaw', $intContador);
} else {
    $strTexto = 'Veces que has visitado el sitio: <span>' . $intContador . '</span>';
}

$intContador++;
setcookie('contadorVisitas', $intContador, time() + 86400);
setrawcookie('contadorVisitasRaw', $intContador, time() + 86400);

// Includes de cabecera, contenido principal y pie de página
include('./includes/cabecera.inc.php');
include('./includes/main.inc.php');
include('./includes/pie.inc.php');

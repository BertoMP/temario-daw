<?php
$strRutaCss = './css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Contador de visitas'; // Título de la página
$strTexto = ''; // Variable para almacenar el texto a mostrar
$intContador = isset($_COOKIE['contadorVisitas']) ? $_COOKIE['contadorVisitas'] : 0; // Contador de visitas, inicializado a 1 si la cookie no existe

// MANEJO DE LA COOKIE
if (isset($_REQUEST['reinicio'])) {
    $strTexto = 'Cookie destruida. <br /> Contador reiniciado.';
    setcookie('contadorVisitas', '', -1);
} else if ($intContador === 0) {
    $intContador = 1;
    $strTexto = 'Esta es tu primera visita.';
    setcookie('contadorVisitas', $intContador, time() + 86400);
} else {
    $intContador++;
    setcookie('contadorVisitas', $intContador, time() + 86400);

    $strTexto = 'Veces que has visitado el sitio: <span>' . $intContador . '</span>';
}

// Includes de cabecera, contenido principal y pie de página
include('./includes/cabecera.inc.php');
include('./includes/main.inc.php');
include('./includes/pie.inc.php');

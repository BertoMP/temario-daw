<?php
// Include del archivo que contiene los arrays de películas y series.
include('../includes/arraysPeliSeries.inc.php');
$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Series'; // Título de la página

// Reanudación de la sesión
session_start();

// Include de cabecera
include('../includes/cabecera.inc.php');

if (isset($_SESSION['login-correcto']) && $_SESSION['login-correcto']) {
    // Include del contenido principal
    include('../includes/mainSeries.inc.php');
} else {
    echo '<p class="acceso-invalido">Debes <a href="../index.php">logarte</a> para ver esta página.</p>';
}

// Include de pie de página
include('../includes/pie.inc.php');

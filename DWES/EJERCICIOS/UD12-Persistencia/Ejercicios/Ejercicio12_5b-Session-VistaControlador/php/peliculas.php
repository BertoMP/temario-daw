<?php
$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Películas'; // Título de la página

// Reanudación de la sesión
session_start();

// Include de cabecera
include('../includes/cabecera.inc.php');

if (isset($_SESSION['login-correcto']) && $_SESSION['login-correcto']) {
    // Include del contenido principal
    include('../includes/mainPeliculas.inc.php');
} else {
    echo '<p class="acceso-invalido">Debes <a href="../index.php">logarte</a> para ver esta página.</p>';
}

// Include de pie de página
include('../includes/pie.inc.php');

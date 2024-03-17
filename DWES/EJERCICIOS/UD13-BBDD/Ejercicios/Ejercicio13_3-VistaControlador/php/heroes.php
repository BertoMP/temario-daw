<?php
// Include de las funciones de la base de datos para la tabla de héroes.
include('../includes/PDOHeroes.inc.php');

$strRutaCss = '../css/stylesHeroes.css'; // Ruta al archivo CSS utilizado.
$strTitulo = 'Héroes'; // Título de la página web

// Reanudación de la sesión de la sesión.
session_start();

// Include de la cabecera.
include('../includes/cabecera.inc.php');

if (isset($_SESSION['login-correcto']) && $_SESSION['login-correcto']) { // En caso de que el login sea correcto.
    // Include del main de la página
    include('../includes/mainHeroes.inc.php');
} else { // En cualquier otro caso (p.e. acceso directo a la web).
    echo '<p class="acceso-invalido">Debes <a href="../index.php">logarte</a> para ver esta página.</p>';
}

// Include del pie de página.
include('../includes/pie.inc.php');

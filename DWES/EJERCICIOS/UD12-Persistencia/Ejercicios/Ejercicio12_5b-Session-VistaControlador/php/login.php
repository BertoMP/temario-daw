<?php
// Include del archivo que contiene los arrays de películas y series.
include('../includes/arraysPeliSeries.inc.php');

// Reanudación de la sesión
session_start();

if (isset($_REQUEST['envio-datos'])) {
    $strUsuario = $_REQUEST['usuario'];
    $strPassword = $_REQUEST['password'];

    if ($strUsuario === 'usuario' && $strPassword === '1234') {
        $_SESSION['login-correcto'] = true;
        $_SESSION['peliculas'] = $arrPeliculas;
        $_SESSION['series'] = $arrSeries;
        header('Location: ./peliculas.php');
    } else {
        $_SESSION['login-correcto'] = false;
        header('Location: ../index.php');
    }
} else {
    header('Location: ../index.php');
}

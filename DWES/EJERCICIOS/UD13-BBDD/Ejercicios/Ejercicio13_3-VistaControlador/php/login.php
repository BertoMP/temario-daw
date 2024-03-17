<?php
// Includes de las funciones de base de datos para las tablas USERS y HEROES.
include('../includes/PDOHeroes.inc.php');
include('../includes/PDOUser.inc.php');

// Reanudación de la sesión
session_start();

if (isset($_REQUEST['envio-datos'])) { // Si se ha producido un envío de datos.

    $strUsuario = $_REQUEST['usuario'];
    $strPassword = $_REQUEST['password'];

    if (compruebaContrasena($strUsuario, $strPassword)) { // Comprobación de contraseña correcta
        $_SESSION['login-correcto'] = true; // Se crea (o modifica) un campo en el array $_SESSION con valor true.
        header('Location: ./heroes.php');
    } else {
        $_SESSION['login-correcto'] = false; // Se crea un campo en el array $_SESSION con valor false.
        header('Location: ../index.php');
    }
} else { // En caso de que no se produzca el envío de datos (p.e. acceso directo a esta web).
    header('Location: ../index.php');
}
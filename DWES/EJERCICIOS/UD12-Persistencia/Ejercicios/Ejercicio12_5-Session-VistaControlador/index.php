<?php
$strRutaCss = './css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Login'; // Título de la página
$arrCampos = array( // Array que define los campos del formulario de inicio de sesión y sus etiquetas
    'usuario' => 'Usuario',
    'password' => 'Contraseña',
);

// Inicio de la sesión
session_start();

// Include de cabecera, contenido principal y pie de página
include('./includes/cabecera.inc.php');
include('./includes/mainIndex.inc.php');
include('./includes/pie.inc.php');

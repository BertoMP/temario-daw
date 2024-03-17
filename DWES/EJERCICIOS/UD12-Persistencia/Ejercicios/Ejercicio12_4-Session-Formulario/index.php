<?php
$strRutaCss = './css/styles.css'; // Ruta del archivo CSS utilizado
$strTitulo = 'Formulario 1'; // Título de la página
$arrCampos = array( // Array que define los campos del formulario y sus label
    'nombre' => 'Nombre',
    'apellidos' => 'Apellidos',
    'email' => 'Email',
    'url' => 'URL',
    'sexo' => array(
        'hombre' => 'Hombre',
        'mujer' => 'Mujer',
        'otro' => 'Otro'
    ),
);

// Inicio de la sesión
session_start();

// Include de cabecera, contenido principal y pie de página
include('./includes/cabecera.inc.php');
include('./includes/main.inc.php');
include('./includes/pie.inc.php');

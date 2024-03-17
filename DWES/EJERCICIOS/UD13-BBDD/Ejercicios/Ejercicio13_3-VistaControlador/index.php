<?php
// Include de las funciones de la base de datos.
include('./includes/PDOHeroes.inc.php');
include('./includes/PDOUser.inc.php');

$strRutaCss = './css/stylesIndex.css'; // Ruta del archivo CSS
$strTitulo = 'Login'; // Título de la página
$arrCampos = array( // Array que define los campos del formulario de inicio de sesión y sus etiquetas
    'usuario' => 'Usuario',
    'password' => 'Contraseña',
);

$arrUsuarios = array( // Array con los usuarios iniciales
    'Usuario 1' => [
        'ID' => 1,
        'NOMBRE' => 'Alberto',
        'USUARIO' => 'usuario',
        'PASSWORD' => 'usuario',
        'EMAIL' => 'miEmail@email.com'
    ],
    'Usuario 2' => [
        'ID' => 2,
        'NOMBRE' => 'Sara',
        'USUARIO' => 'usuario2',
        'PASSWORD' => 'usuario2',
        'EMAIL' => 'miEmail2@email.com'
    ],
    'Usuario 3' => [
        'ID' => 3,
        'NOMBRE' => 'Enrique',
        'USUARIO' => 'usuario3',
        'PASSWORD' => 'usuario3',
        'EMAIL' => 'miEmail3@email.com'
    ],
);

// Inicio de la sesión
session_start();

// Llamada a la función insertInicial(array $arrUsuarios) del archivo PDOUser.inc.php.
insertInicial($arrUsuarios);

// Include de cabecera, contenido principal y pie de página
include('./includes/cabecera.inc.php');
include('./includes/mainIndex.inc.php');
include('./includes/pie.inc.php');

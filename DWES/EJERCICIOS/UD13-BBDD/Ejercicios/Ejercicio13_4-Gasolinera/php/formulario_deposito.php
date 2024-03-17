<?php
$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS
$strTitulo = 'Formulario deposito'; // Título de la página.

// Restauración de la sesión.
session_start();
$_SESSION['ultima-opcion'] = 'llenado-deposito'; // Asigna el valor 'llenado-deposito' a $_SESSION['ultima-opcion'].

$arrTiposGasolina = array( // Array que contiene los tipos de gasolina.
    'gasoil' => 'Gasoil',
    'gasolina-95' => 'Gasolina 95',
    'gasolina-98' => 'Gasolina 98',
    'gasoil-agricola' => 'Gasoil agrícola'
);

// Includes de la cabecera, el cuerpo y el pie de la página.
include ('../includes/cabecera.inc.php');
include ('../includes/mainLlenadoDeposito.inc.php');
include ('../includes/pie.inc.php');
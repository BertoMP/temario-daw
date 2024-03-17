<?php
// Include del archivo de funciones
include('../includes/funciones.inc.php');
$strRutaCss = '../css/styles.css'; // Ruta del archivo CSS utilizado
$strTitulo = 'Formulario 2'; // Título de la página

$arrCampos = array( // Arreglo que define los campos del formulario y sus etiquetas
    'convivientes' => 'Convivientes',
    'aficiones' => array(
        'deportes' => 'Deportes',
        'lectura' => 'Leer',
        'peliculas' => 'Ver películas',
        'anime' => 'Ver anime',
        'musica' => 'Escuchar música',
        'cocina' => 'Cocinar',
        'viajar' => 'Viajar',
        'juegos' => 'Juegos de mesa',
    ),
    'menu' => array(
        'pasta' => 'Ensalada de pasta',
        'tarta' => 'Tarta de chocolate',
        'marmitako' => 'Marmitako',
        'paella' => 'Paella',
        'sushi' => 'Sushi',
        'lasanya' => 'Lasaña',
        'hamburguesa' => 'Hamburgesa',
        'pollo-asado' => 'Pollo Asado',
        'tacos' => 'Tacos',
    ),
);

// Reanudación de la sesión
session_start();

if (isset($_REQUEST['envio-datos'])) {
    $_SESSION['nombre'] = $_REQUEST['nombre'];
    $_SESSION['apellidos'] = $_REQUEST['apellidos'];
    $_SESSION['email'] = $_REQUEST['email'];
    $_SESSION['url'] = $_REQUEST['url'];
    $_SESSION['sexo'] = $_REQUEST['sexo'];

    $arrCamposAComprobar = array(
        'nombre',
        'apellidos',
        'email',
        'url',
        'sexo',
    );
    if (tieneCamposVacios($_SESSION, $arrCamposAComprobar)) {
        $_SESSION['camposVacios'] = true;
        header('Location: ../index.php');
    } else {
        $_SESSION['camposVacios'] = false;
    }
}

// Include de cabecera, contenido principal y pie de página
include('../includes/cabecera.inc.php');
include('../includes/mainPagina2.inc.php');
include('../includes/pie.inc.php');

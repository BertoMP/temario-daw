<?php 
// Definición del título de la página
$strTitulo = 'Comparativa ficheros';

// Definición de la ubicación de la hoja de estilo CSS
$strEstilo = './styles/style.css';

// Inclusión del archivo de funciones
include('./includes/funciones.inc.php');

// Inclusión del archivo de cabecera HTML
include('./includes/cabecera.inc.php');

// Llamada a la funcion compruebaFicheros(): string
$strMensaje = compruebaFicheros();

// Inclusión de un archivo HTML que probablemente contenga un formulario
include('./includes/formulario.inc.html');

echo $strMensaje;

// Inclusión del archivo HTML que contiene la parte final de la página
include('./includes/pie.inc.html');
?>
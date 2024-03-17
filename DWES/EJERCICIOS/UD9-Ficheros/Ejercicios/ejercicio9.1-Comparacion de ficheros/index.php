<?php 
$strTitulo = 'Comparativa ficheros';
$strEstilo = './styles/style.css';

include('./includes/funciones.inc.php');
include('./includes/cabecera.inc.php');

$strMensaje = compruebaFicheros();

include('./includes/formulario.inc.html');

echo $strMensaje;

include('./includes/pie.inc.html');
?>
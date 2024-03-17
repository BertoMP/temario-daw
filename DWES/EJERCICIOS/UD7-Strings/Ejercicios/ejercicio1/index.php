<?php 
/**
 * generador.inc.php: Crea una función que permite generar una letra aleatoria, 
 * mayúscula o minúscula.
 */
$titulo = 'Ejercicio 1 - Caracter ASCII aleatorio';
include('./includes/cabecera.inc.php');
include('./includes/generador.inc.php');

echo "<form action=\"index.php\" method=\"get\">";
echo "<label for=\"generaLetra\">Pulsa el botón para generar un carácter aleatorio:</label>";
echo "<button type=\"submit\" name=\"generaLetra\">Pulsa</button></form>";

if(isset($_REQUEST['generaLetra'])) {
    echo "<p>Se ha generado la letra: " . generaLetra() . ".</p>";
}

include('./includes/pie.inc.php');
?>


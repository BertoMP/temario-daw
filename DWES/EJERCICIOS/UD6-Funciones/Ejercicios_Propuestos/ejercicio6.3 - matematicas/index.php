<?php
/**
 * Añade las siguientes funciones:
 * 
 *  digitos(int $num): int → devuelve la cantidad de dígitos de un número.
 *  digitoN(int $num, int $pos): int → devuelve el dígito que ocupa, empezando 
 *  por la izquierda, la posición $pos.
 *  quitaPorDetras(int $num, int $cant): int → le quita por detrás (derecha) 
 *  $cant dígitos.
 *  quitaPorDelante(int $num, int $cant): int → le quita por delante (izquierda) 
 *  $cant dígitos.
 * 
 * Para probar las funciones, haz uso tanto de paso de argumentos posicionales 
 * como argumentos con nombre.
 */
$titulo = "Matematicas";
include("./includes/cabecera.inc.php");
include("./includes/matematicas2.inc.php");

echo "<form action=\"index.php\" method=\"get\"><table><tbody>";

echo "<tr><td><label for=\"numero\">Introduce un número:</label></td>";
echo "<td><input type=\"number\" name=\"numero\" id=\"numero\"></td></tr>";

echo "<tr><td><label for=\"numero\">Introduce la posicion que quieres conocer (desde la izquierda):</label></td>";
echo "<td><input type=\"number\" name=\"posicion\" id=\"posicion\" min=\"1\"></td></tr>";

echo "<tr><td><label for=\"cantDetras\">Dígitos a eliminar por detrás:</label></td>";
echo "<td><input type=\"number\" name=\"cantDetras\" id=\"cantDetras\" min=\"0\"></td></tr>";

echo "<tr><td><label for=\"cantDelante\">Dígitos a eliminar por delante:</label></td>";
echo "<td><input type=\"number\" name=\"cantDelante\" id=\"cantDetras\" min=\"0\"></tr>";

echo "<tr><td colspan=\"2\"><input type=\"submit\" value=\"Enviar\"></td></tr>";

echo "</form></tbody></table>";

if (isset($_GET["numero"]) && isset($_GET["posicion"]) && isset($_GET["cantDetras"]) && isset($_GET["cantDelante"])) {
    $num = $_GET["numero"];
    $pos = $_GET["posicion"];
    $cantDt = $_GET["cantDetras"];
    $cantDl = $_GET["cantDelante"];

    echo "<p>Número de dígitos en $num: " . digitos($num) . "</p>";
    echo "<p>Dígito en la posición $pos de $num: " . digitoN($num, $pos - 1) . "</p>";
    echo "<p>Eliminar $cantDt dígitos por detrás de $num: " . quitaPorDetras($num, $cantDt) . "</p>";
    echo "<p>Eliminar $cantDl dígitos por delante de $num: " . quitaPorDelante($num, $cantDl) . "</p>";

    echo "<p>Número de dígitos en $num: " . digitos(num: $num) . "</p>";
    echo "<p>Dígito en la posición $pos de $num: " . digitoN(num: $num, pos: $pos - 1) . "</p>";
    echo "<p>Eliminar $cantDt dígitos por detrás de $num: " . quitaPorDetras(num: $num, cant: $cantDt) . "</p>";
    echo "<p>Eliminar $cantDl dígitos por delante de $num: " . quitaPorDelante(num: $num, cant: $cantDl) . "</p>";
}

include("./includes/pie.inc.php");
?>
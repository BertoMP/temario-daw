<?php

/** 
 * Crea las siguientes funciones:
 * 
 *  Una función que averigüe si un número es par: esPar(int $num): bool
 *  Una función que devuelva un array de tamaño $tam con números aleatorios comprendido entre 
 *  $min y $max : arrayAleatorio(int $tam, int $min, int $max) : array
 *  Una función que reciba un $array por referencia y devuelva la cantidad de números pares 
 *  que hay almacenados: arrayPares(array &$array): int
 */

include ("./includes/arrayPar.inc.php");
$titulo = "Números pares";
include ("./includes/cabecera.inc.php");

echo "<h2>DETERMINAR SI UN NÚMERO ES PAR</h2>";
echo "<form action=\"./index.php\" method=\"get\">";
echo "<table>";

echo "<tr><td><label for=\"numero\">Introduce un número: </label></td>";
echo "<td><input type=\"number\" name=\"numero\" id=\"numero\"></td></tr>";

echo "<td colspan=\"2\"><input type=\"submit\" value=\"Enviar\"></td></tr>";

echo "</table>";
echo "</form>";

if (isset($_GET["numero"])) {
    $numeroUsuario = $_GET["numero"];
    echo "<p>El número $numeroUsuario es un número " . (esPar($numeroUsuario) ? " par" : " impar") . ".</p>";
} else {
    echo "<p>Los campos deben estar rellenos.</p>";
}

echo "<br><br><br><br><br>";

echo "<h2>GENERAR UN ARRAY DE NÚMEROS ALEATORIOS</h2>";
echo "<form action=\"./index.php\" method=\"get\">";
echo "<table>";

echo "<tr><td><label for=\"longitud\">Introduce la longitud del array: </label></td>";
echo "<td><input type=\"number\" name=\"longitud\" id=\"longitud\" min=\"1\"></td></tr>";

echo "<tr><td><label for=\"minimo\">Introduce el número mínimo: </label></td>";
echo "<td><input type=\"number\" name=\"minimo\" id=\"minimo\"></td></tr>";

echo "<tr><td><label for=\"maximo\">Introduce el número máximo: </label></td>";
echo "<td><input type=\"number\" name=\"maximo\" id=\"maximo\"></td></tr>";

echo "<td colspan=\"2\"><input type=\"submit\" value=\"Enviar\"></td></tr>";

echo "</table>";
echo "</form>";

if (isset($_GET["longitud"]) && isset($_GET["minimo"]) && isset($_GET["maximo"])) {
    $long = $_GET["longitud"];
    $min = $_GET["minimo"];
    $max = $_GET["maximo"];
    $arrNumeros = array();
    $cantPares = 0;

    $arrNumeros = arrayAleatorio($long, $min, $max);

    echo "<p>El array generado es: [";

    for($intCont = 0; $intCont < count($arrNumeros); $intCont++) {
        if ($intCont !== 0) {
            echo ", $arrNumeros[$intCont]";
        } else {
            echo $arrNumeros[$intCont];
        }
    }

    echo "]</p>";

    echo "<p>En el array hay " . arrayPares($arrNumeros) . " números pares.</p>";
} else {
    echo "<p>Los campos deben estar rellenos.</p>";
}
include ("./includes/pie.inc.php");
?>
<?php
/**
 * Crea las siguientes funciones:
 * 
 *  Una función que devuelva el mayor de todos los números recibidos 
 *  como parámetros: function mayor(): int. No puedes usar la función max().
 *  Una función que concatene todos los parámetros recibidos separándolos 
 *  con un espacio: function concatenar(...$palabras) : string.
 */
include("./includes/parametrosVariables.inc.php");

$numeroMayor = mayor(1, 0, 20, 3, 40, 30);

$frase = concatenar("hola", "mundo", "adios", "mundo");

echo "<p>El número mayor es el $numeroMayor.</p>";
echo "<p>Las palabras introducidas generan el string: \"$frase\".</p>";
?>
<?php
/**
 * Investiga las siguientes funciones de cadena (explica para qué sirven mediante 
 * comentarios, y programa un pequeño ejemplo de cada una de ellas): ucwords, 
 * strrev, str_repeat y md5.
 */
$texto = 'hola mundo adios mundo';

// ucwords: Sirve para colocar cada palabra con una letra mayúscula.
$textoUcwords = ucwords($texto);
echo "ucwords --> $textoUcwords <br />";

// strrev: Devuelve un String dado la vuelta.
$textoStrrev = strrev($texto);
echo "strrev --> $textoStrrev <br />";

// str_repeat: Devuelve el input repetido n veces.
$textoRepeat = str_repeat('-|', 10);
echo "str_repeat --> $textoRepeat <br />";

// md5: Calcula el hash md5 de un String
$textoMD5 = md5($texto);
echo "md5 --> $textoMD5 <br />";
?>
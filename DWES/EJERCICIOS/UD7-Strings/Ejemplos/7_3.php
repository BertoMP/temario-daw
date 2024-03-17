<?php
$strCadena = "El caballero oscuro";
$intLongitud = strlen($strCadena);
echo "La longitud de '$strCadena' es: $intLongitud <br />";
$strPalabra1 = substr($strCadena, 13); // desde 13 al final 
echo "Palabra: $strPalabra1<br />";
$strPalabra2 = substr($strCadena, 3, 4); // desde 3, 4 letras
echo "Palabra: $strPalabra2<br />"; 
$strCporK = str_replace("c", "k", $strCadena); 
echo "$strPalabra1 ahora es " . substr($strCporK, 13) . "<br />"; 
echo "Grande " . strtoupper($strCadena) . "<br />"; 
?>
<?php
$strCadena1 = "Alfa";
$strCadena2 = "Alfa";
$strCadena3 = "Beta";
$strCadena4 = "Alfa5";
$strCadena5 = "Alfa10";

echo "Son iguales == strCadena1 y strCadena2: " . ($strCadena1 == $strCadena2) . "<br />";
echo "Son iguales === strCadena1 y strCadena2: " . ($strCadena1 === $strCadena2)  . "<br />";
echo "Son iguales <=> strCadena1 y strCadena2: " . ($strCadena1 <=> $strCadena2) . "<br />";
echo "Son iguales <=> strCadena1 y strCadena3: " . ($strCadena1 <=> $strCadena3) . "<br />";
echo "Son iguales <=> strCadena3 y strCadena1: " . ($strCadena3 <=> $strCadena1) . "<br />";
echo "Son iguales strcmp strCadena1 y strCadena2: " . strcmp($strCadena1, $strCadena2) . "<br />";
echo "Son iguales strcmp strCadena1 y strCadena5 en sus 3 primeros caracteres: " . strncmp($strCadena1, $strCadena5, 3) . "<br />";
echo "Es menor strCadena2 que strCadena3: " . ($strCadena2 < $strCadena3)  . "<br />";
echo "Son iguales strcmp strCadena2 y strCadena3: " . strcmp($strCadena2, $strCadena3) . "<br />";
echo "Es menor strCadena4 que strCadena5: " . ($strCadena4 < $strCadena5) . "<br />";
echo "Son iguales strcmp strCadena4 y strCadena5: " . strcmp($strCadena4, $strCadena5) . "<br />";
echo "Son iguales strnatcmp strCadena4 y strCadena5: " . strnatcmp($strCadena4, $strCadena5) . "<br />";
?>
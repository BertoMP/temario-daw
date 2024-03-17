<?php
    $strCadena1 = "hola";
    $strCadena2 = "hola33";
    $strCadena3 = "33";
    $strCadena4 = ",.()[]";
    $strCadena5 = " ,.()[]";

    echo "Caracteres alfabéticos cadena1: " . ctype_alpha($strCadena1) . "<br />"; // true
    echo "Caracteres alfabéticos cadena2: " . ctype_alpha($strCadena2) . "<br />"; // false
    echo "Caracteres alfanuméricos cadena2: " . ctype_alnum($strCadena2) . "<br />"; // true
    echo "Caracteres numéricos cadena3: " . ctype_digit($strCadena3) . "<br />"; // true
    echo "Caracteres de puntuación sin espacios cadena4: " . ctype_punct($strCadena4) . "<br />"; // true
    echo "Caracteres de puntuación tipo espacios cadena5: " . ctype_space($strCadena5) . "<br />"; // false
    echo "Caracteres de puntuación tipo espacios cadena5 caracter 0: " . ctype_space($strCadena5[0]) . "<br />"; // true
?>
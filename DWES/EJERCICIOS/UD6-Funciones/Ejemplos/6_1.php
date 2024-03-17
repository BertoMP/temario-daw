<?php
    $strCadena1 = $strCadena2 = "3.1416"; // asignamos a las dos variables la misma cadena de texto
    settype($strCadena2, "float"); // y cambiamos $b a tipo float
    echo "\$strCadena1 vale $strCadena1 y es de tipo " . gettype($strCadena1) . "<br />";
    echo "\$strCadena2 vale $strCadena2 y es de tipo " . gettype($strCadena2) . "<br />";
    $strCadena2 = "adios";
    echo "\$strCadena2 vale $strCadena2 y es de tipo " . gettype($strCadena2);
?>
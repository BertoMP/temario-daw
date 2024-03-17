<?php
class tipo{};
class tipo_devuelve{};

    
    $strCadena1 = $strCadena2 = "3.1416"; // asignamos a las dos variables la misma cadena de texto
    settype($strCadena2, "float"); // y cambiamos $b a tipo float
    print "\$strCadena1 vale $strCadena1 y es de tipo " . gettype($strCadena1) . "<br />";
    print "\$strCadena2 vale $strCadena2 y es de tipo " . gettype($strCadena2);
    $strCadena2 = "adios";
    print "\$strCadena2 vale $strCadena2 y es de tipo " . gettype($strCadena2);

?>

<html>
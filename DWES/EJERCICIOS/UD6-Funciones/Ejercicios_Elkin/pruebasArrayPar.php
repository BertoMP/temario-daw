<?php
    $titulo = "Prueba arrayPar.inc.php";
    include("arrayPar.inc.php");
    echo "2 es par " . (esPar(2)==true?'true':'false') . "<br />";
    echo "3 es par " . (esPar(3)==true?'true':'false') . "<br />";
    echo "Array de aleatorios de tamaño 5 entre 3 y 20 ";
    $intArray = arrayAleatorio(5, 3, 20);
    print_r($intArray);
    echo "<br />El número de pares en el array es " . arrayPares($intArray);
    include("pie.inc.html");
?>
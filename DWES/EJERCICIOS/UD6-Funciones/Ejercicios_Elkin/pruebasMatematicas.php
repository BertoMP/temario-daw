<?php
    $titulo = "Prueba matematicas.inc.php";
    include("matematicas.inc.php");
    echo "Número de digitos de 1234: " . (digitos(1234)) . "<br />";
    echo "Del número 4321: digito 2: " . (digitoN(4321,2)) . ", digito 4: " . (digitoN(4321,4)). "<br />";
    echo "Quita 3 de digitos de 123456: " . (quitaPorDetras(123456, 3)) . "<br />";
    echo "Quita por delante 3 de digitos de 123456: " . (quitaPorDelante(123456, 4)) . "<br />";
    include("pie.inc.html");
?>
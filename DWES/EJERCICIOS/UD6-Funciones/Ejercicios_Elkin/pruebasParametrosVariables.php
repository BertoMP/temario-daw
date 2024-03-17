<?php
    $titulo = "Prueba parametrosVariables.inc.php";
    include("parametrosVariables.inc.php");
    echo "valor mayor de los valores (3, 5, 2 ,23, 12) es " . mayor(3, 5, 2 ,23, 12) . "<br />";
    echo "Valores recibidos por la función " . concatenar('uno',1,'dos',12.7,'tres','cadena');
    include("pie.inc.html");
?>
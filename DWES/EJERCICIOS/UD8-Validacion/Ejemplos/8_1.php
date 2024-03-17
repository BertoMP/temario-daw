<?php
    $titulo = "Variables entorno";
    include("../general/cabecera.inc.php");
    foreach($_SERVER as $key=>$valor)
    echo "$key=>$valor<br />";
    include("../general/pie.inc.html");
?>
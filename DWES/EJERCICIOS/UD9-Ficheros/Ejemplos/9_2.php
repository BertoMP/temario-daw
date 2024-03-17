<?php
    $titulo = "ficheros";
    $fich = fopen("$_SERVER[DOCUMENT_ROOT]/Entorno_Servidor/UD9-Ficheros/ejemplos/ficheroAAA", 'wb');
    fwrite($fich,'Hola', 3);//strlen('Hola'));
    fclose($fich);
    //include("../general/pie.inc.html");
?>
<?php
    $titulo = "Funciones para las Clases";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('Producto.php');
    include('Tv.php'); 

    $objetoTv = new Tv();
    echo $objetoTv->mostrarResumen();
    
    //include("../general/pie.inc.html");
?>
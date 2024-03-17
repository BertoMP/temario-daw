<?php
    $titulo = "Funciones para las Clases";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('Producto.php');
    include('Tv.php'); 

    $objetoTv = new Tv();
    $objetoTv->setCodigo(33);
    //$objetoTv = new Tv('OLED55CX6LA',55, 'OLED');
    if ($objetoTv instanceof Producto)
        echo $objetoTv->mostrarResumen();

    $clasePadre = get_parent_class($objetoTv);
    echo "<br>La clase padre es: " . $clasePadre;
    
    $objetoPadre = new $clasePadre;
    $objetoPadre->setCodigo(20);
    //$objetoPadre = new $clasePadre('MacBook Air M2');
    echo $objetoPadre->mostrarResumen();

    if (is_subclass_of($objetoTv, 'Producto')) 
        echo "<br>Soy hijo de Producto";

    //include("../general/pie.inc.html");
?>
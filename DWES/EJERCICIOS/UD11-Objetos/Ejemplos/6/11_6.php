<?php
    $titulo = "Funciones para las Clases";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('Producto.php'); 

    $objProd1 = new Producto("PS5");
    if ($objProd1 instanceof Producto) {
        echo "Es un producto <br />";
        echo "La clase es " . get_class($objProd1) . '<br />';
    
        class_alias("Producto", "Articulo"); // intentar no usarlo
        $objProd2 = new Articulo("Nintendo Switch");
        echo "Un articulo es un " . get_class($objProd2) . '<br />';
    
        print_r(get_class_methods("Producto")); // métodos de la clase Producto
        echo  '<br />';
        print_r(get_class_vars("Producto"));
        echo  '<br />';
        print_r(get_object_vars($objProd1));
        echo  '<br />';
    
        if (method_exists($objProd1, "mostrarResumen"))
            echo $objProd1->mostrarResumen();
    }
    //include("../general/pie.inc.html");
?>
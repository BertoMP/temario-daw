<?php
    $titulo = "Funciones para las Clases";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('Producto.php'); 

    $objProd1 = new Producto("PS5");
    $objProd1->aniade(3);
    $objProd1->aniade(7);
    $objProd1->aniade(28);
    $objProd2 = clone($objProd1);
    $objProd1->aniade(8);
    $objProd2->cambiaNombre('maria');
    echo 'Objeto1 ' . $objProd1 . '<br />';
    echo 'Objeto2 ' . $objProd2 . '<br />';
    //include("../general/pie.inc.html");
?>
<?php
    $titulo = "Clases Estáticas";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('Producto.php'); 

    $objProd1 = new Producto("PS5");
    $objProd2 = new Producto("XBOX Series X");
    $objProd3 = new Producto("Nintendo Switch");
    $objProd2 = null; // libero el objeto2
    new Producto("Steam Deck"); // el objeto existe, pero no lo puedo instanciar
    echo $objProd3->mostrarResumen();
    echo '<br />Imprime el total: ' . Producto::getNumProductos();
    echo '<br />Imprime el total: ' . $objProd3::getNumProductos(); // no hacerlo así
    echo '<br />Imprime el total: ' . $objProd3->getNumProductos(); // no hacerlo así
    echo '<br />Imprime el total: ' . $objProd3::$intNumProductos; // no hacerlo así
    echo '<br />Imprime el total: ' . Producto::IVA;
    echo '<br />Imprime el total: ' . $objProd3::IVA; // no hacerlo así
    //include("../general/pie.inc.html");
?>
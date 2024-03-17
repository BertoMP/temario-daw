<?php
    $titulo = "Clases: Encapsulación";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('MayorMenor.php'); 

    $objMayorMenor = new MayorMenor(); // creamos un objeto
    $objMayorMenor->setMayor(15);
    $objMayorMenor->setMenor(6);
    echo 'Mayor: ' . $objMayorMenor->getMayor() . '<br />';
    echo 'Menor: ' . $objMayorMenor->getMenor();
    
    //include("../general/pie.inc.html");
?>
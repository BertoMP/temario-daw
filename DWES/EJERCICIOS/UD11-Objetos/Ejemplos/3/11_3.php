<?php
    $titulo = "Clases: Paso Parámetros";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('MayorMenor.php'); 
    
    function maymen(array $intArrumeros) : ?MayorMenor {
        $intMayor = max($intArrumeros);
        $intMenor = min($intArrumeros);
    
        $objeto = new MayorMenor();
        $objeto->setMayor($intMayor);
        $objeto->setMenor($intMenor);
    
        return $objeto;
    }
    function incrementaMayor(MayorMenor $objeto){//function incrementaMayor(MayorMenor &$objeto){
        $objeto->setMayor(($objeto->getMayor())+1);
    }

    $objMayorMenor = maymen([12,6,8,22,3]); // creamos un objeto
    incrementaMayor($objMayorMenor);
    echo 'Mayor: ' . $objMayorMenor->getMayor() . '<br />';
    echo 'Menor: ' . $objMayorMenor->getMenor();
    
    //include("../general/pie.inc.html");
?>
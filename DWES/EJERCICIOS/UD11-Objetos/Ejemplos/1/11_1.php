<?php
    $titulo = "Clases";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('Persona.php'); 

    $objPersona = new Persona(); // creamos un objeto
    $objPersona->setNombre("Pepe Perez");
    $objPersona->imprimir();
    
    //include("../general/pie.inc.html");
?>
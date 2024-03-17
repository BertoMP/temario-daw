<?php
    $titulo = "Clases";
    //include("../general/cabecera.inc.php");
    //falla porque abre para leer un fichero existente
    include('Persona.php'); 

    $objPersona = new Persona("Pepe Perez"); // creamos un objeto
    $objPersona->imprimir();
    
    //include("../general/pie.inc.html");
?>
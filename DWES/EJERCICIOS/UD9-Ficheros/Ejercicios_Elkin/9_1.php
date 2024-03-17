<?php
    $titulo = "Ficheros Iguales";
    include("general/cabecera.inc.php");

    $strFich1 = $_REQUEST["ficheros"][0];
    $strFich2 = $_REQUEST["ficheros"][1];
    
    if(!file_exists($strFich1) || !file_exists($strFich2))
        echo "No existe uno de los ficheros";
    else{
        $strContenidoFichero1 = file_get_contents($strFich1);
        $strContenidoFichero2 = file_get_contents($strFich2);
        $intTamanioFichero1 = filesize($strFich1);
        $intTamanioFichero2 = filesize($strFich2);

        if ($intTamanioFichero1 === $intTamanioFichero2 && $strContenidoFichero1 === $strContenidoFichero2)
        echo "TAMAÑO Y CONTENIDO IGUAL";
        else if ($intTamanioFichero1 === $intTamanioFichero2 && $strContenidoFichero1 !== $strContenidoFichero2) 
                echo "TAMAÑO IGUAL, CONTENIDO DIFERENTE";
            else 
                echo "TAMAÑO Y CONTENIDO DIFERENTE";
    }
        
    include("general/pie.inc.html");
?>
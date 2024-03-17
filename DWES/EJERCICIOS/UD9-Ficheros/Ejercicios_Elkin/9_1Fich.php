<?php
    $titulo = "Ficheros Iguales";
    include("general/cabecera.inc.php");
    echo "<form method=\"get\" action=\"9_1.php\">";
        for($intCont=1; $intCont<3; $intCont++)
            echo "<input type=\"text\" name=\"ficheros[]\" placeholder=\"Fichero$intCont\"><br />";
        echo "<input type=\"submit\" value=\"Enviar\"><br />";    
    echo '</form>';
    
    include("general/pie.inc.html");
?>
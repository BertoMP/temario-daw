<?php
    $titulo = "Variables entorno";
    include("general/cabecera.inc.php");
    echo "<form method=\"post\" action=\"quiniela.php\">";
        for($intCont=1; $intCont<16; $intCont++)
            echo "<input type=\"text\" name=\"partidos[]\" placeholder=\"partido$intCont\"><br />";
        echo "<input type=\"submit\" value=\"Enviar\"><br />";    
    echo '</form>';
    
    include("general/pie.inc.html");
?>
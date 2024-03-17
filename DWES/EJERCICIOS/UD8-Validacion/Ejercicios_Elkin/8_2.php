 <?php
    $titulo = "Letra DNI";
    include("general/cabecera.inc.php");
    echo "<form method=\"post\" action=\"dni.php\">";
		echo "<label for=\"ndni\">Número: </label>";  
		echo "<input type=\"number\" name=\"ndni\" min=\"1\" max=\"99999999\"><br />";
        echo "<input type=\"submit\" value=\"Enviar\"><br />";    
    echo '</form>';
    
    include("general/pie.inc.html");
?>
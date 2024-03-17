<?php
    $titulo = "Subir varios archivos";
    include("../general/cabecera.inc.php");

    echo "<form method=\"post\" enctype=\"multipart/form-data\">";
    for($intCont=0; $intCont<3; $intCont++)
        echo "<input type=\"file\" name=\"imagen[]\"><br /><br />";
    echo "<input type=\"submit\" value=\"Enviar\"><br />";    
    echo "</form><br /><br />";
    
    for($intCont=0; isset($_FILES['imagen']) && $intCont<count($_FILES['imagen']['name']); $intCont++)
        echo "Nombre: " . $_FILES['imagen']['name'][$intCont]. "<br />";

    
    include("../general/pie.inc.html");
?>

<?php
    $titulo = "Subir archivos";
    //include("../general/cabecera.inc.php");
?>
<form method="post" enctype="multipart/form-data">
    <p> <!-- Campo imagen --><input type="file" name="fichero_uno"></p>
    <p> <!-- Campo imagen --><input type="file" name="fichero_dos"></p>
    <p><!-- Botón submit --><input type="submit" name="btnSubir" value="Subir"></p>
</form>

<?php
    foreach($_FILES as $key=>$valor){
        echo "$key=>";
        print_r($valor);
        echo "<br />";
    }
    if (isset($_POST['btnSubir']) && $_POST['btnSubir'] == 'Subir') {
        if (is_uploaded_file($_FILES['fichero_uno']['tmp_name'])) {
            // subido con éxito
            $nombre = $_FILES['fichero_uno']['name'];
            move_uploaded_file($_FILES['fichero_uno']['tmp_name'], "$_SERVER[DOCUMENT_ROOT]/Tema9/ejemplos/$nombre");
    
            echo "<p>Archivo $nombre subido con éxito</p>";
        }
    }
    
    //include("../general/pie.inc.html");
?>

<?php
    $titulo = "Cookies";
    //include("../general/cabecera.inc.php"); //quitar el body de aqui
    $color='white';
    session_start();
    if (isset($_REQUEST['colores'])){
        $color=$_REQUEST['colores'];
        $_SESSION['colorFondo']= $_REQUEST['colores'];
        echo "<body bgcolor='" . $_REQUEST['colores'] ."'>";
    }else if (isset($_SESSION['colorFondo'])){
            $color=$_SESSION['colorFondo'];
            echo "<body bgcolor='" . $_SESSION['colorFondo'] ."'>";
          }else
            echo "<body>";

?>
<form action="12_3.php">
    <label for="colores">Color de Fondo:</label>
    <select name="colores" id="colores">
        <option value="white"<?= ($color=='white')?'selected':'' ?>>Blanco</option>
        <option value="red"  <?= ($color=='red')?'selected':'' ?>>Rojo</option>
        <option value="blue" <?= ($color=='blue')?'selected':'' ?>>Azul</option>
        <option value="pink" <?= ($color=='pink')?'selected':'' ?>>Rosa</option>
    </select>
    <br />
    <input type="submit" name="envia" value="Cambiar Color">
    <input type="submit" name="envia2" formaction="12_3bis.php">

</form>
<?php    
    //include("../general/pie.inc.html");
?>
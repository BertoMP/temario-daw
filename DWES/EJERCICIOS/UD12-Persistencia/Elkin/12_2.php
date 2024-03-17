<?php
    $titulo = "Cookies";
    //include("../general/cabecera.inc.php"); //quitar el body de aqui
    $color='white';
    if (isset($_REQUEST['colores'])){
        $color=$_REQUEST['colores'];
        setcookie('colorFondo', $_REQUEST['colores'],time()+24*60*60);
        echo "<body bgcolor='" . $_REQUEST['colores'] ."'>";
    }else if (isset($_COOKIE['colorFondo'])){
              $color=$_COOKIE['colorFondo'];      
              echo "<body bgcolor='" . $_COOKIE['colorFondo'] ."'>";
          }else
              echo "<body>";

?>
<form action="12_2.php">
    <label for="colores">Color de Fondo:</label>
    <select name="colores" id="colores">
        <option value="white"<?= ($color=='white')?'selected':'' ?>>Blanco</option>
        <option value="red"  <?= ($color=='red')?'selected':'' ?>>Rojo</option>
        <option value="blue" <?= ($color=='blue')?'selected':'' ?>>Azul</option>
        <option value="pink" <?= ($color=='pink')?'selected':'' ?>>Rosa</option>
    </select>
    <br />
    <input type="submit" name="envia" value="Cambiar Color">

</form>
<?php    
    //include("../general/pie.inc.html");
?>
<?php
    $titulo = "Cookies";
    //include("../general/cabecera.inc.php"); //quitar el body de aqui
    $color='white';
    session_start();
    if(isset($_REQUEST['enviaReset'])){
        unset($_SESSION['colorFondo']);
        header('Location:12_3.php');
    }
    if (isset($_SESSION['colorFondo'])){
            $color=$_SESSION['colorFondo'];
            echo "<body bgcolor='" . $_SESSION['colorFondo'] ."'>";
          }else
            echo "<body>";

?>
<form action="12_3.php">
    <input type="submit" name="envia" value="Volver">
    <input type="submit" name="enviaReset" formaction="12_3bis.php" value="Resetear">

</form>
<?php    
    //include("../general/pie.inc.html");
?>
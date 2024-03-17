
<?php

    function noNulo(array $strArray): bool{
        $blnDevuelve = true;
        foreach($strArray as $key=>$strValor)
            if($strArray[$key]=='' && $key!='enviar'){
                $blnDevuelve = false;
                break;
            }
        return $blnDevuelve;
    }

    if (isset($_REQUEST['mensaje']) && $_REQUEST['mensaje']='vacios')
        echo "No puedes dejar campos vacíos";
    $titulo = "12_4";
    //include("../general/cabecera.inc.php");
    session_start();
    if (!noNulo($_REQUEST))
        foreach($_REQUEST as $key=>$value)
            if($key!='enviar' && $key!='mensaje') 
                $_SESSION[$key]= isset($_REQUEST[$key])?$_REQUEST[$key]:'';
    else
        header("Location:12_4.php?mensaje=vacios");
  //include("../general/pie.inc.html"); // poner al final
?>
<form action="pagina3.php">
    <label for="convivientes">Convivientes</label>
    <input type="text" name="convivientes">
    <br />
    <label for="aficiones[]" >Aficiones</label>
    <select name="aficiones[]" multiple>
        <option value="musica">musica</option>
        <option value="lectura">lectura</option>
        <option value="pesca">pesca</option>
        <option value="trekking">trekking</option>
        <option value="gimnasio">gimnasio</option>
    </select>
    <br />
    <label for="menu[]" >Menu</label>
    <select name="menu[]" multiple>
        <option value="ensalada">ensalada</option>
        <option value="pescado">pescado</option>
        <option value="filete">filete</option>
        <option value="fruta">fruta</option>
        <option value="postre">postre</option>
    </select>
    <br />
    <input type="submit" name="enviar">
</form>
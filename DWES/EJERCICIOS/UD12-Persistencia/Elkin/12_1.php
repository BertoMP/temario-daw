<?php
    $titulo = "Cookies";
    //include("../general/cabecera.inc.php");

    if (isset($_REQUEST['reset']))
        setcookie('intVisitas', 1);
    else
        if (isset($_COOKIE['intVisitas'])){
            echo 'Has visitado la página ' . $_COOKIE['intVisitas'] . ' veces';
            setcookie('intVisitas', $_COOKIE['intVisitas']+1);
        }else
            setcookie('intVisitas', 1);

?>
<form action="12_1.php">
    <input type="submit" name="reset">
</form>
<?php    
    //include("../general/pie.inc.html");
?>
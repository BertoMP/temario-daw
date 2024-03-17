<?php
    if(!isset($_SESSION["usuario"]))
        header("Location: ../index.php");

    $blnBandera = false;
    $arrUsuarios = ["nahuel1234" => "nahuel1234", "jacket" => "jacket1234", "jorge" => "jorge1234"];
    session_start();

    foreach($arrUsuarios as $key => $value) {
        if($key == $_REQUEST["user"] and $value == $_REQUEST["password"])
            $blnBandera = true;
    }

    if($blnBandera){
        $_SESSION["usuario"] = $_REQUEST["user"];
        header("Location: ../index.php?vista=home");
    }else
        header("Location: ../index.php?access=$blnBandera");
?>
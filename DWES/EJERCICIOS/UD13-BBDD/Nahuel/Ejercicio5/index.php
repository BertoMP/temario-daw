<?php
    session_start();

    include("./Includes/cabecera.inc.php");

    if(!isset($_REQUEST["vista"])){
        include("./Vistas/formulario.php");
        echo isset($_REQUEST["access"])?($_REQUEST["access"] == false?"<p style=\"color: red;\">Usuario o Contraseña incorrecto</p>":""):"";
    }else{
        $vista = $_REQUEST["vista"];
        include("./Vistas/$vista.php");
    }

    include("./Includes/final.inc.php");
?>
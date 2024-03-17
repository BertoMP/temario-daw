<?php
    $titulo = "Session";
    //include("../general/cabecera.inc.php");

    // Recuperamos la información de la sesión
    session_start();

    // Y la destruimos
    session_destroy();
    header("Location: 12_5.php")

    //include("../general/pie.inc.html");
?>
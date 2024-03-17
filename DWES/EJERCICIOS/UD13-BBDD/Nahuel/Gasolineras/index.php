<?php

session_start();

include ('./BD/FacturasBD.php');
include ('./Includes/EstructuraHTML/cabecera.inc.php');

if(!isset($_REQUEST['vista'])){
    include ('./Includes/Vistas/home.inc.php');
}else
    include ('./Includes/Vistas/' . $_REQUEST['vista'] . '.inc.php');

include ('./Includes/EstructuraHTML/pie.inc.php');
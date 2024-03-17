<?php

session_start();

include ('../Class/Ticket.php');
include ('../Class/Factura.php');
include ('../BD/FacturasBD.php');

function actualizarSesion($strkey,string $strTipo):void{
    $_SESSION[$strkey] = $strTipo;
}

if(isset($_REQUEST['dni'])) {
    insercionFactura(new Factura($_REQUEST['importe'], $_REQUEST['dni'], $_REQUEST['matricula']));
    actualizarSesion('tipo','factura');
}else if(isset($_REQUEST['tipo_combustible'])) {
    insercionDeposito($_REQUEST);
    actualizarSesion('tipo','deposito');
}else if(isset($_REQUEST['importe'])) {
    insercionTicket(new Ticket($_REQUEST['importe']));
    actualizarSesion('tipo','ticket');
}
header('Location: ../index.php');
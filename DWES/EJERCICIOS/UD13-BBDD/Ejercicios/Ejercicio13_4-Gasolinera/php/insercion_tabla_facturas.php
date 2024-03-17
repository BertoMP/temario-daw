<?php
// Include de la clase Ticket
include ('../includes/classes/Ticket.php');
// Include de la clase Factura
include ('../includes/classes/Factura.php');
// Include de las funciones PDO asociadas a la base de datos.
include ('../includes/PDO.inc.php');
// Include de las funciones del fichero funciones.inc.php
include ('../includes/funciones.inc.php');

// Restauración de la sesión.
session_start();

if (isset($_REQUEST['envio-datos-factura'])) {
    if (compruebaDatosFactura($_REQUEST)) { // Llamada a compruebaDatosTicket() del fichero funciones.inc.php.
        $factura = new Factura($_REQUEST['importe'], $_REQUEST['dni'], $_REQUEST['matricula']);
        // Llamada a la función insertTicket del fichero PDO.inc.php.
        insertFactura($factura);
        header('Location: ../index.php');
    } else { // En el caso de que los datos sean incorrectos o estén en blanco.
        $_SESSION['datos-incorrectos'] = true;
        header('Location: ./formulario_factura.php');
    }
} else { // En el caso de un acceso directo a esta página.
    header('Location: ../index.php');
}

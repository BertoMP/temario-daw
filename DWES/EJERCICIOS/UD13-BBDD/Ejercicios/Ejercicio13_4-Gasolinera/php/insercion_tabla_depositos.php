<?php
// Include de la clase Deposito
include ('../includes/classes/Deposito.php');
// Include de las funciones PDO asociadas a la base de datos.
include ('../includes/PDO.inc.php');
// Include de las funciones del fichero funciones.inc.php
include ('../includes/funciones.inc.php');

// Restauración de la sesión.
session_start();

if (isset($_REQUEST['envio-datos-factura'])) {
    if (compruebaDatosDeposito($_REQUEST)) { // Llamada a compruebaDatosTicket() del fichero funciones.inc.php.
        $deposito = new Deposito($_REQUEST['litros'], $_REQUEST['tipo-gasolina'], $_REQUEST['importe']);
        // Llamada a la función insertTicket del fichero PDO.inc.php.
        insertDeposito($deposito);
        header('Location: ../index.php');
    } else { // En el caso de que los datos sean incorrectos o estén en blanco.
        $_SESSION['datos-incorrectos'] = true;
        header('Location: ./formulario_deposito.php');
    }
} else { // En el caso de un acceso directo a esta página.
    header('Location: ../index.php');
}
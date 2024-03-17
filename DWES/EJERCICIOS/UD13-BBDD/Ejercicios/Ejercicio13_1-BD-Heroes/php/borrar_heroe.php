<?php
if (isset($_REQUEST['id'])) {
    // Include de las funciones de la base de datos.
    include('../includes/PDO.inc.php');

    $id = $_REQUEST['id']; // ID del héroe a borrar.

    // Llamada a la función delete(string $id) del archivo PDO.inc.php.
    delete($id);
}
header('Location: ../index.php');

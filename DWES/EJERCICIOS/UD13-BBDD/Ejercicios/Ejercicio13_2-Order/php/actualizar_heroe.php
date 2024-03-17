<?php
if (isset($_REQUEST['id'])) {
    // Include de las funciones de la base de datos.
    include('../includes/PDO.inc.php');

    // Llamada a la función update(array $arrDatos) del archivo PDO.inc.php.
    update($_REQUEST);
}

header('Location: ../index.php');

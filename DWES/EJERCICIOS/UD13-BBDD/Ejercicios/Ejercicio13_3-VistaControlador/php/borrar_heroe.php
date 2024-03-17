<?php
if (isset($_REQUEST['id'])) {
    // Include de las funciones de la base de datos.
    include('../includes/PDOHeroes.inc.php');

    $id = $_REQUEST['id']; // ID del héroe a borrar.

    // Llamada a la función delete(string $id) del archivo PDOHeroes.inc.php.
    delete($id);
}
header('Location: ./heroes.php');
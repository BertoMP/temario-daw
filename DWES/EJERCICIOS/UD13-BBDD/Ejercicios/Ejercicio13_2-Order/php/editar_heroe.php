<?php
if (isset($_REQUEST['id'])) {
    // Include de las funciones de la base de datos.
    include('../includes/PDO.inc.php');

    $id = $_REQUEST['id']; // ID del héroe a editar.
    $strRutaCss = '../css/stylesEdit.css'; // Ruta al archivo CSS utilizado.
    $strTitulo = 'Editar héroes'; // String con el título de la página.

    // Include de los elementos cabecera, main y pie de la página.
    include('../includes/cabecera.inc.php');
    include('../includes/mainEditar.inc.php');
    include('../includes/pie.inc.php');
} else { // En caso de que el $_REQUEST['id'] no esté seteado (p.e. un acceso directo a esta página).
    header('Location: ../index.php');
}
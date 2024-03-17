<?php 
$strTitulo = 'Letra DNI'; // Título de la página.
$strEstilo = './styles/style.css'; // Ruta al archivo de hoja de estilos.
$strRuta = './index.php'; // Ruta de la página.

// Incluye la cabecera de la página.
include('./includes/cabecera.inc.php');

// Incluye las funciones necesarias.
include('./includes/funciones.inc.php');

// Incluye el formulario para que los usuarios ingresen el número del DNI.
include('./includes/formulario.inc.php');

if (isset($_REQUEST['dni'])) {
    $intNumDni = $_REQUEST['dni'];
    echo "<section>";

    if (is_numeric($intNumDni)) {
        // Llamada a la función compruebaDni(int).
        compruebaDni($intNumDni);
    } else {
        echo "<p class=\"vacio\">El campo DNI no puede estar vacío.</p>";
    }

    echo "</section>";
}

// Incluye el pie de página de la página.
include('./includes/pie.inc.html');
?>


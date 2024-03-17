<?php 
$strTitulo = 'Recorrer directorios';
$strEstilo = './styles/style.css';

include('./includes/cabecera.inc.php');

if (isset($_REQUEST['dir'])) {
    $strRutaActual = $_REQUEST['dir'];
} else {
    $strRutaActual = getcwd();
}

echo "<section>";
if ($strRutaActual !== "D:\\" && $strRutaActual !== "C:\\" && $strRutaActual !== "/") {
    $srtDirectorioPadre = dirname($strRutaActual);
    echo "<a id=\"directorioPadre\" href=\"?dir=$srtDirectorioPadre\">Ir al directorio padre</a>";
} else {
    echo "<p id=\"directorioPadreP\">Directorio raíz</p>";
}
echo "<h2>Contenido de $strRutaActual</h2>";
echo "</section>";


if (is_dir($strRutaActual)) {
    echo "<section>";
    $arrArchivosDireccion = array_diff(scandir($strRutaActual), array('.', '..'));
    
    foreach ($arrArchivosDireccion as $strArchivo) {
        echo "<a href=\"?dir=$strRutaActual\\$strArchivo\">$strArchivo</a>";
    }
    echo "</section>";
} else {
    echo "<pre><code>";
    $strContenidoArchivo = file_get_contents($strRutaActual);
    echo htmlspecialchars($strContenidoArchivo);
    echo "</code></pre>";
}

include('./includes/pie.inc.html');

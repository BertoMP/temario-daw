<?php 
$strTitulo = 'Recorrer directorios';
$strEstilo = './styles/style.css';

include('./includes/cabecera.inc.php');

function listarDirectorios($ruta) {
    $contenidoDelDirectorio = scandir($ruta);

    echo "<ul>";
    foreach ($contenidoDelDirectorio as $itemDirectorio) {
        if ($itemDirectorio !== "." && $itemDirectorio !== "..") {
            $itemRuta = $ruta . "/" . $itemDirectorio;
            if (is_dir($itemRuta)) {
                echo "<li>$itemDirectorio<ul>";
                listarDirectorios($itemRuta);
                echo "</ul></li>";
            } else {
                echo "<li>$itemDirectorio</li>";
            }
        }
    }
    
    echo "</ul>";
}

$rutaInicial = "C:\\xampp";
echo "<h2>Contenido de $rutaInicial</h2>";
listarDirectorios($rutaInicial);

include('./includes/pie.inc.html'); 

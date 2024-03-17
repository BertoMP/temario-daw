<?php 
function letrasTotales(string $strTexto): int {
    $intCantidadLetras = 0;

    for($intCont = 0; $intCont < strlen($strTexto); $intCont++) {
        if (ctype_alpha($strTexto[$intCont])) {
            $intCantidadLetras++;
        }
    }

    return $intCantidadLetras;
}

function cantidadPalabras(string $strTexto) {
    $arrPalabras = explode(' ', $strTexto);

    echo "<p>En la frase \"$strTexto\" hay un total de " . count($arrPalabras) . " palabras.</p>";

    echo "<ul>";
    foreach($arrPalabras as $palabra) {
        echo "<li>La palabra \"$palabra\" tiene " . letrasTotales($palabra) . " letras.</li>";
    }
    echo "</ul>";
}
?>
<?php
/**
 * Función que genera el formulario HTML de una quiniela.
 *
 * @param array     $arrQuiniela    Un array con los partidos de la quiniela.
 * @param string    $strRuta        La ruta a la que se enviarán los datos del formulario.
 * @return void
 */
function generaHTMLQuiniela(array $arrQuiniela, string $strRuta): void {
    // Incluye las instrucciones.
    include('./includes/instrucciones.inc.html');

    echo "<section><form action=\"$strRuta\" method=\"get\">";

    foreach ($arrQuiniela as $indice => $partido) {
        $partidoNumero = $indice + 1; // Número del partido.
        echo "<section>";
        echo "<label for=\"partido$partidoNumero\">$partido</label>";
        echo "<input type=\"number\" name=\"partido[]\" id=\"partido$partidoNumero\">";
        echo "</section>";
    }

    echo "<input type=\"submit\" value=\"Enviar datos\">";
    echo "</form></section>";
}

/**
 * Función que comprueba y corrige las apuestas del usuario en un array de partidos.
 * Si una apuesta no es un número entero entre 1 y 3, se asigna un valor aleatorio entre 1 y 3.
 *
 * @param array     $arrPartidosUser    El array de apuestas del usuario (se pasa por referencia para modificarlo directamente).
 * @return void
 */
function compruebaApuesta(array &$arrPartidosUser): void {
    foreach($arrPartidosUser as &$partidoUser) {
        if (!filter_var($partidoUser, FILTER_VALIDATE_INT, ["options" => ["min_range" => 1 , "max_range" => 3]])) {
            $partidoUser = rand(1, 3);
        }
    }
}

/**
 * Función que genera una tabla HTML con la apuesta del usuario.
 *
 * @param array     $partidosQuiniela   Un array con los partidos de la quiniela.
 * @param array     $partidosUser       Un array con las apuestas del usuario.
 * @return void
 */
function generaHTMLApuesta(array $partidosQuiniela, array $partidosUser): void {
    echo "<h2>TU APUESTA</h2>";
    echo "<section><table>";
    echo "<thead>";
    echo "<tr><th>Partido</th><th>Tu apuesta</th></tr>";
    echo "</thead><tbody>";

    foreach ($partidosQuiniela as $indice => $partido) {
        $strApuestaUser = (int) $partidosUser[$indice]; // Almacena el valor del índice del array de apuestas.
        if ($strApuestaUser === 3) {
            $strApuestaUser = 'X';
        }
        echo "<tr><td>$partido</td><td>{$strApuestaUser}</td></tr>";
    }

    echo "</tbody></table></section>";

    echo "<section><a href=\"index.php\" class=\"button-link\">Realizar otra apuesta</a></section>";
}
?>
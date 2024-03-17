<?php
/**
 * A partir de una frase con palabras sólo separadas por espacios, devolver
 *      - Letras totales y cantidad de palabras
 *      - Una línea por cada palabra indicando su tamaño
 * Realiza el ejercicio sinusar la función str_word_count y usándola.
 */
$titulo = 'Ejercicio 3 - Datos texto';
include('./includes/cabecera.inc.php');
include('./includes/contadorLetras.inc.php');
?>
<form action="index.php" method="get">
    <label for="texto">Introduce un texto del que quieras conocer los datos:</label>
    <input type="text" name="texto" id="texto">

    <input type="submit" value="Enviar datos">
</form>
<?php
include('./includes/pie.inc.php');

if (isset($_REQUEST['texto'])) {
    $strTexto = $_REQUEST['texto'];

    if(!empty($strTexto)) {
        $cantLetras = letrasTotales($strTexto);
        $cantPalabras = cantidadPalabras($strTexto);

        echo "<p>En total hay $cantLetras letras.</p>";

        echo "<p>Usando el método str_word_count():</p>";
        echo "<p>En total hay " . str_word_count($strTexto) . " palabras.</p>";
    } else {
        echo "<p>El texto no puede estar vacío.</p>";
    }
}
?>
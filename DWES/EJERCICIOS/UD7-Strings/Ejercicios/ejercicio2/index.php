<?php
/**
 * Utilizando las funciones para trabajar con caracteres, a partir de una cadena 
 * y un desplazamiento: Si el desplazamiento es 1, sustituye la A por B, la B por C, etc.
 *      - El desplazamiento no puede ser negativo
 *      - Si se sale del abecedario, debe volver a empezar.
 *      - Hay que respetar los espacios, puntos y comas.
 */
$titulo = 'Ejercicio 2 - Cifrado César';
include('./includes/cabecera.inc.php');
include('./includes/cifradoCesar.inc.php');
?>
<form action="index.php" method="get">
    <label for="texto">Introduce un texto a cifrar:</label>
    <input type="text" name="texto" id="texto">

    <label for="desplazamiento">Introduce un número de desplazamiento:</label>
    <input type="number" name="desplazamiento" id="desplazamiento" min="1">

    <input type="submit" value="Enviar datos">
</form>
<?php
include('./includes/pie.inc.php');

if (isset($_REQUEST['texto']) && isset($_REQUEST['desplazamiento'])) {
    $strTexto = $_REQUEST['texto'];
    $intDesplazamiento = $_REQUEST['desplazamiento'];
    $strTextoOriginal = $strTexto;

    if(!empty($strTexto) && $intDesplazamiento > 0) {
        cifradoCesar($strTexto, $intDesplazamiento);
        echo "<p>Texto a cifrar: $strTextoOriginal</p>";
        echo "<p>El resultado del cifrado es: $strTexto</p>";
    } else {
        echo "<p>El texto no puede estar vacío y el desplazamiento debe ser positivo.</p>";
    }
}
?>
<?php
/**
 * crea un archivo con funciones para sumar, restar, multiplicar y dividir dos números.
 * 
 * haciendo uso de un array que almacene el nombre de las funciones del archivo anterior, 
 * a partir de dos números recibidos por URL, recorre el array e invoca a las funciones 
 * de manera dinámica haciendo uso de funciones variable
 */
include "./includes/biblioteca.inc.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table {
            border-collapse: collapse;
            background-color: skyblue;
        }

        input[type="submit"] {
            width: 100%;
        }
    </style>
</head>
<body>
    <form action="arrayFunciones.php" method="get">

        <table>
            <tr>
                <td><label for="num1">Primer número</label></td>
                <td><input type="number" name="num1" id="num1"></td>
            </tr>
            <tr>
                <td><label for="num2">Segundo número:</label></td>
                <td><input type="number" name="num2" id="num2"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Enviar números"></td>
            </tr>
        </table>

    </form>
</body>
</html>
<?php 
$arrayOperaciones = ["suma", "resta", "multiplicacion", "division"];

if (isset($_GET["num1"]) && isset($_GET["num2"])) {
    $num1 = $_GET["num1"];
    $num2 = $_GET["num2"];

    foreach($arrayOperaciones as $operacion) {
        $resultado = $operacion($num1, $num2);
        if ($resultado !== null) {
            echo "<p>El resultado de la $operacion de $num1 y $num2 es $resultado.</p>";
        }
    }
}
?>
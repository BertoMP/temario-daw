<!-- 
    Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100 y que los almacene en un array. 
    El programa debe ser capaz de pasar todos los números pares a las primeras posiciones del array (del 0 en 
    adelante) y todos los números impares a las celdas restantes.
-->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 2 - Array pares e impares separados</title>
</head>
<body>
    <?php
    //VARIABLES
    $arrNumeros = array(); //Array de numeros enteros.
    $intAuxiliar = 0; //Variable que funcionará como auxiliar para guardar un valor.
    $blnCambiado = false; //Variable que funcionará como bandera para comprobar si el número ha sido cambiado.

    for ($intCont = 0; $intCont < 20; $intCont++) {
        $arrNumeros[$intCont] = rand(0, 100);
    }
    echo "<p>Todos los números del array:</p>";
    print_r($arrNumeros);

    for ($intCont = 0; $intCont < count($arrNumeros); $intCont++) {
        $blnCambiado = false;
        if ($arrNumeros[$intCont] % 2 != 0) {
            for ($intCont2 = $intCont + 1; $intCont2 < count($arrNumeros) && !$blnCambiado; $intCont2++) {
                if ($arrNumeros[$intCont2] % 2 == 0) {
                    $intAuxiliar = $arrNumeros[$intCont];
                    $arrNumeros[$intCont] = $arrNumeros[$intCont2];
                    $arrNumeros[$intCont2] = $intAuxiliar;
                    $blnCambiado = true;
                }
            }
        }
    }

    echo "<p>Todos los números del array separados en pares e impares:</p>";
    print_r($arrNumeros);
    ?>
</body>
</html>
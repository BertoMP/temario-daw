<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 6 - Alfil</title>
    <style>
        img {
            width: 45px;
        }

        table {
            border-collapse: collapse;
        }

        td {
            width: 50px;
            height: 50px;
            text-align: center;
            border: 1px solid black;
            font-family: Arial, Helvetica, sans-serif;
        }

        .numLet {
            border: 0px;
        }

        .casillaMarronClaro {
            background-color: #C19A6B;
        }

        .casillaMarronOscuro {
            background-color: #67403A;
        }

        .casillaVerde {
            background-color: green;
        }
    </style>
</head>

<body>
    <form action="index.php" method="get">
        <label for="posicionAlfil">Posición inicial del alfil</label> &nbsp;&nbsp;
        <?php
        if (isset($_GET["posicionAlfil"])) {
            $posicionUser = $_GET["posicionAlfil"];
            echo "<input type='text' name='posicionAlfil' id='posicionAlfil' value='$posicionUser' required> &nbsp;&nbsp;";
        } else {
            echo "<input type='text' name='posicionAlfil' id='posicionAlfil' placeholder='E4' required> &nbsp;&nbsp;";
        }
        ?>
        <input type="submit" value="Definir posición">
    </form>
    <br />
    <?php
    $arrLetraValor = [ //Array que guarda la letra y el valor de la misma.
        "A" => 1, "B" => 2, "C" => 3, "D" => 4, "E" => 5, "F" => 6, "G" => 7, "H" => 8
    ];
    $strLetra = ""; //String que guarda la letra introducida por el usuario.
    $intNumero = 0; //Int que guarda el número introducido por el usuario.
    $intColumnaAlfil = 0; //Int que guarda la columna en la que se encuentra el alfil.
    $intFilaAlfil = 0; //Int que guarda la fila en la que se encuntra el alfil.
    $blnPosicionValida = false; //Booleano para comprobar que la posición es válida.
    $strTipoClase = ""; //String que guarda la clase de la casilla.

    if (isset($_GET["posicionAlfil"])) {
        $strPosicionUser = strtoupper($_GET["posicionAlfil"]);
        $strLetra = $strPosicionUser[0];
        $intNumero = substr($strPosicionUser, 1);

        if (key_exists($strLetra, $arrLetraValor) && $intNumero > 0 && $intNumero <= 8) {
            $blnPosicionValida = true;
            $intColumnaAlfil = $arrLetraValor[$strLetra];
            $intFilaAlfil = $strPosicionUser[1];
            echo "<h3>Las posiciones de movimiento con el alfil en $strPosicionUser son:</h3>";
        } else {
            echo "<h3>La posición $strPosicionUser no es válida.</h3>";
        }
    } else {
        echo "<h3>Define la posición inicial del alfil.</h3>";
    }

    echo "<table><tbody>";

    for ($intContFila = 8; $intContFila > 0; $intContFila--) {
        echo "<tr>";
        for ($intContColumna = 0; $intContColumna <= 8; $intContColumna++) {
            if ($intContColumna == 0) {
                $strTipoClase = "numLet";
            } else {
                if ($intContFila % 2 == 0) {
                    $strTipoClase = ($intContColumna % 2 != 0) ? "casillaMarronClaro" : "casillaMarronOscuro";
                } else {
                    $strTipoClase = ($intContColumna % 2 == 0) ? "casillaMarronClaro" : "casillaMarronOscuro";
                }

                if (
                    $blnPosicionValida && (abs($intContFila - $intFilaAlfil) == abs($intContColumna - $intColumnaAlfil))
                    && ($intContColumna != $intColumnaAlfil && $intContFila != $intFilaAlfil)
                ) {
                    $strTipoClase = "casillaVerde";
                }
            }
            echo "<td class='$strTipoClase'>";
            if ($intContColumna == 0) {
                echo $intContFila;
            } else if ($intContColumna == $intColumnaAlfil && $intContFila == $intFilaAlfil) {
                echo "<img src='./source/img/alfilNegro.png' alt='imagenDeAlfil' />";
            }
            echo "</td>";
        }

        echo "</tr>";
    }

    echo "<tr>";
    echo "<td class='numLet'>";
    if (!$blnPosicionValida) {
        echo "<img src='./source/img/alfilNegro.png' alt='imagenDeAlfil' />";
    }
    echo "</td>";
    foreach ($arrLetraValor as $letra => $numero) {
        echo "<td class='numLet'>$letra</td>";
    }
    echo "</tr>";
    echo "</tbody></table>";
    ?>
</body>

</html>
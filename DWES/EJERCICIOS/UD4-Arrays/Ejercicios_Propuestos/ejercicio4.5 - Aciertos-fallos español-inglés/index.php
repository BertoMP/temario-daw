<!-- 
    Realiza un programa que escoja al azar 5 palabras en español del minidiccionario del ejercicio 
    anterior. El programa pedirá que el usuario teclee la traducción al inglés de cada una de las 
    palabras y comprobará si son correctas. Al final, el programa deberá mostrar cuántas respuestas 
    son válidas y cuántas erróneas.
-->
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 5 - Aciertos-Fallos en un diccionario español-inglés</title>
    <style>
        table {
            border-collapse: collapse;
            align-self: center;
        }

        td {
            width: 200px;
            text-align: center;
        }

        .correcta {
            background-color: lightgreen;
        }

        .incorrecta {
            background-color: lightcoral;
        }
    </style>
</head>

<body>
    <form action="index.php" method="get">
        <?php
        $arrDiccionarioEspIng = [ //Array que funciona como mapa donde la clave es la palabra en castellano y el valor la palabra en inglés.
            "perro" => "dog",
            "gato" => "cat",
            "casa" => "house",
            "coche" => "car",
            "manzana" => "apple",
            "naranja" => "orange",
            "mesa" => "table",
            "silla" => "chair",
            "libro" => "book",
            "ordenador" => "computer",
            "agua" => "water",
            "fuego" => "fire",
            "sol" => "sun",
            "luna" => "moon",
            "amigo" => "friend",
            "familia" => "family",
            "trabajo" => "work",
            "comida" => "food",
            "teclado" => "keyboard",
            "dinero" => "money"
        ];

        $arrPalabrasEsp = array_keys($arrDiccionarioEspIng); //Array que guarda las letras.
        $arrPalabrasElegidas = array(); //Array que guarda las letras.
        $intNumAleatorio = 0; //Int que guarda un número aleatorio.
        $intCont = 0; //Int que funciona como contador.
        $intAciertos = 0; //Int que gunciona como contador de acietos.
        $intFallos = 0; //Int que funciona como contador de fallos.
        $strRespuestaUsuario = ""; //String que guarda la palabra introducida por el usuario.
        $stRespuestaCorrecta = ""; //String que guarda la respuesta correcta.
        $strPalabraEsp = ""; //String con la palabra en español.
        $strPalabraIng = ""; //String con la palabra en inglés.
        $strTipoClase = ""; //String que guarda la clase del elemento.

        while ($intCont < 5) {
            $intNumAleatorio = rand(0, count($arrPalabrasEsp) - 1);
            if (!in_array($arrPalabrasEsp[$intNumAleatorio], $arrPalabrasElegidas)) {
                $arrPalabrasElegidas[] = $arrPalabrasEsp[$intNumAleatorio];
                $strPalabraEsp = $arrPalabrasEsp[$intNumAleatorio];
                $strPalabraIng = $arrDiccionarioEspIng[$strPalabraEsp];

                echo "<label for='palabra$intCont'>$strPalabraEsp</label><br />";
                echo "<input type='text' name='palabra$intCont' id='palabra$intCont'>";
                echo "<input type='text' name='palabraIng$intCont' id='palabra$intCont' value='$strPalabraIng' hidden>";
                echo "<input type='text' name='palabraEsp$intCont' id='palabra$intCont' value='$strPalabraEsp' hidden><br /><br />";
                $intCont++;
            }
        }
        echo "<input type='submit' value='Enviar respuestas'><br /><br /><br />";

        
        if (isset($_GET["palabra0"]) && isset($_GET["palabra1"]) && isset($_GET["palabra2"]) && isset($_GET["palabra3"]) && isset($_GET["palabra4"])) {
            echo "<table>";
            echo "<caption>RESULTADOS DE LA RONDA ANTERIOR</caption>";
            echo "<thead><th>PALABRA ESP</th><th>TU RESPUESTA</th><th>RESPUESTA CORRECTA</th></thead>";
            for ($intCont = 0; $intCont < 5; $intCont++) {
                $strRespuestaUsuario = strtolower(trim($_GET["palabra$intCont"]));
                $stRespuestaCorrecta = $_GET["palabraIng$intCont"];

                if ($strRespuestaUsuario == $stRespuestaCorrecta) {
                    $strTipoClase = "correcta";
                    $intAciertos++;
                } else {
                    $strTipoClase = "incorrecta";
                    $intFallos++;
                }

                echo "<tr class='$strTipoClase'>";
                echo "<td>" . $_GET["palabraEsp$intCont"] . "</td>";
                echo "<td>$strRespuestaUsuario</td>";
                echo "<td>$stRespuestaCorrecta</td>";
                echo "</tr>";
            }
            echo "</table>";
            echo "Has acertado $intAciertos palabra/s y has fallado $intFallos palabra/s.";

        } else {
            echo "Completa todas las palabras antes de enviar el formulario.";
        }
        ?>
    </form>
</body>

</html>
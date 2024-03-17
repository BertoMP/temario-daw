<!-- 
    Realiza un programa que pida la temperatura media que ha hecho en cada mes de un
    determinado año y que muestre a continuación un diagrama de barras horizontales con esos datos.
    Las barras del diagrama se pueden dibujar a base de la concatenación de una imagen.
-->
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1 - Temperaturas</title>
    <style>
        table {
            font-family: Arial, Helvetica, sans-serif;
        }

        td {
            text-align: center;
        }
    </style>
</head>

<body>
    <?php
    //VARIABLES
    $strArrMeses = [ //Array que guarda los nombres de los meses.
        "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
    ];
    $intArrTemperatura = array(); //Array que guarda las temperaturas de los meses.
    $intCuadrosRojos = 0; //Contador de cuadros rojos para el gráfico.
    $intCuadrosGrises = 0; //Contador de cuadros grises para el gráfico.
    $blnCompletado = true; //Variable que funciona como bandera.

    echo "<p>Introduce los datos para crear una gráfica de temperaturas.</p>";
    echo "<form action='index.php' method='get'>" . PHP_EOL;

    for ($intCont = 0; $intCont < count($strArrMeses); $intCont++) {
        echo "<label for = '$strArrMeses[$intCont]'>Temperatura en $strArrMeses[$intCont]</label>" . PHP_EOL;
        echo "<input type='number' name='$strArrMeses[$intCont]' id='$strArrMeses[$intCont]' min='0' max='50'>" . PHP_EOL;
        echo "<br /><br />" . PHP_EOL;
    }
    echo "<input type='submit' value='Enviar datos'>" . PHP_EOL;
    echo "</form>" . PHP_EOL;
    
    for ($intCont = 0; $intCont < count($strArrMeses) && $blnCompletado; $intCont++) {
        if (!isset($_GET[$strArrMeses[$intCont]])) {
            $blnCompletado = false;
        }
    }
    if ($blnCompletado) {
        for ($intCont = 0; $intCont < count($strArrMeses); $intCont++) {
            $intArrTemperatura[$intCont] = (int) ($_GET[$strArrMeses[$intCont]]);
        }

        echo "<table>" . PHP_EOL;
        echo "<thead>" . PHP_EOL;
        echo "<caption>TABLA DE TEMPERATURAS</caption>" . PHP_EOL;
        echo "              <tr>" . PHP_EOL;
        echo "                  <th>MES</th>" . PHP_EOL;
        echo "                  <th>TEMPERATURA</th>". PHP_EOL;
        echo "                  <th>LEYENDA</th>". PHP_EOL;
        echo "              </tr>" . PHP_EOL;
        echo "          </thead>" . PHP_EOL;
        echo "          <tbody>" . PHP_EOL;
        
        for ($intCont = 0; $intCont < count($intArrTemperatura); $intCont++) {
            echo "              <tr>" . PHP_EOL;
            echo "                  <td>" . strtoupper($strArrMeses[$intCont]) . "</td>" . PHP_EOL;
            $intCuadrosGrises = 50 - $intArrTemperatura[$intCont];
            echo "                  <td>" . PHP_EOL;
            for ($intContRojo = 0; $intContRojo < $intArrTemperatura[$intCont]; $intContRojo++) {
                echo "<img src='./source/images/rojo.png' alt='cuadrado de color rojo' width='10px' />";
            }

            for ($intContGris = 0; $intContGris < $intCuadrosGrises; $intContGris++) {
                echo "<img src='./source/images/gris.png' alt='cuadrado de color gris' width='10px' />";
            }
            echo "                  </td>" . PHP_EOL;
            echo "                  <td>$intArrTemperatura[$intCont] ºC</td>" . PHP_EOL;
            echo "              </tr>" . PHP_EOL;
        }
        echo "          </tbody>" . PHP_EOL;
        echo "      </table>";
    }
    ?>
    
</body>

</html>
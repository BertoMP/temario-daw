<!-- 
    Realiza un programa que escoja al azar 10 cartas de la baraja española y que diga cuántos puntos suman 
    según el juego de la brisca. Emplea un array asociativo para obtener los puntos a partir del nombre de 
    la figura de la carta. Asegúrate de que no se repite ninguna carta, igual que si las hubieras cogido 
    de una baraja de verdad.
-->
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 3 - Brisca</title>
    <style>
        img {
            width: 40px;
        }

        th {
            text-align: center;
            border-bottom: 1px solid black;
        }

        td {
            text-align: center;
            border-bottom: 1px solid black;
            width: 120px;
        }

        table {
            border-collapse: collapse;
        }

        .puntTotal {
            text-align: center;
        }
    </style>
</head>

<body>
    <h1>JUEGO DE LA BRISCA</h1>
    <h2>Puntuaciones</h2>
    <?php
    //VARIABLES
    $arrValores = [ //Array que funciona como mapa para guardar una clave (nombre de la carta) y un valor (su valor en el juego)
        "As" => 11, "Dos" => 0, "Tres" => 10, "Cuatro" => 0, "Cinco" => 0,
        "Seis" => 0, "Siete" => 0, "Sota" => 2, "Caballo" => 3, "Rey" => 4
    ];
    $arrPalos = ["oros", "copas", "espadas", "bastos"]; //Array que guarda los palos de la baraja.
    $arrCartasNumero = array_keys($arrValores); //Array que guarda las keys de $arrValores.
    $arrManoUsuario = array(); //Array que guardará la mano del usuario.
    $arrCartaPalo = array(); //Array que guarda una pareja número de carta y palo.
    $intIndiceCarta = 0; //Array que guardará un número aleatorio que funcionará como índice en el array $arrCartasNumero.
    $intIndicePalo = 0; //Array que guardará un número aleatorio que funcionará como índice en el array $arrCartasPalo.
    $intPuntos = 0; //Variable que guarda el valor de la carta obtenida.
    $intPuntosTotales = 0; //Variable que guarda la puntuación total del jugador.

    for ($intCantidadCartasMano = 0; $intCantidadCartasMano < 10;) {
        $intIndiceCarta = rand(0, count($arrCartasNumero) - 1);
        $intIndicePalo = rand(0, count($arrPalos) - 1);
        $arrCartaPalo = [$arrCartasNumero[$intIndiceCarta], $arrPalos[$intIndicePalo]];

        if (!in_array($arrCartaPalo, $arrManoUsuario)) {
            $arrManoUsuario[] = $arrCartaPalo;
            $intCantidadCartasMano++;
        }
    }
    echo "<table >";

    foreach ($arrValores as $carta => $puntos) {
        if ($puntos != 0) {
            echo "<tr><td>$carta</td><td>$puntos</td></tr>";
        }
    }
    echo "</table>";
    echo "<p>El resto de las cartas dan 0 puntos.</p>";
    
    echo "<table>";
    echo "<caption>MANO DEL USUARIO</caption>";
    echo "<thead><th>Imagen</th><th>Nombre</th><th>Valor</th></thead>";
    foreach ($arrManoUsuario as $carta) {
        $intPuntos = $arrValores[$carta[0]];
        $intPuntosTotales += $intPuntos;

        echo "<tr>";
        echo "<td>$carta[0] de $carta[1]</td>";
        echo "<td><img src='./source/images/$carta[1]$carta[0].png' alt='$carta[0] de $carta[1]'></td>";
        echo "<td>$intPuntos puntos</td>";
        echo "</tr>";
    }

    echo "<tr><td colspan='2' class='puntTotal'>Puntos totales</td>";
    echo "<td>$intPuntosTotales puntos</td></tr>";
    echo "</table>";
    ?>
</body>

</html>
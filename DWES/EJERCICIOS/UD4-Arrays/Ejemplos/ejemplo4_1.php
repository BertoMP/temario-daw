<html>
    <head></head>
    <body>
        <?php
            $strArrNotas = [9, 6, 5, 8];
            $strArrVariado = [9, 'Hola', 5.5, true];

            echo $strArrNotas[0] . "<br />";
            echo $strArrNotas[1] . "<br />";
            echo $strArrNotas[2] . "<br />";
            echo $strArrNotas[3] . "<br />";
            echo $strArrNotas[4] . "<br />"; //da error de fuera de rango

            var_dump($strArrNotas);
            var_dump($strArrVariado);

        ?>
    </body>
</html>

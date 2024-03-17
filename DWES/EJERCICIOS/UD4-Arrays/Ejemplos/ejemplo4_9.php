<html>
    <head></head>
    <body>
        <?php
            $strArray = ['uno', 'dos', 'tres'];
            echo '<br /> array desordenado: ';
            print_r($strArray);
            sort($strArray);
            echo '<br /> array ordenado: ';
            print_r($strArray);
            rsort($strArray);
            echo '<br /> array ordenado alreves: ';
            print_r($strArray);
            shuffle($strArray);
            echo '<br /> array desordenado de forma aleatoria: ';
            print_r($strArray);
            echo '<br />';


            $strCadena = 'uno|dos|tres|cuatro';
            print_r(explode('|', $strCadena));
            echo '<br />';
            print_r(explode('|', $strCadena, 3));//coge solo los tres primeros elementos

            $array = ['Luis', 'Ana', 'Pepe'];
            list($strUno, , $strTres) = $array;
            echo "<br />primer valor $strUno, tercer valor $strTres";
        ?>
    </body>
</html>

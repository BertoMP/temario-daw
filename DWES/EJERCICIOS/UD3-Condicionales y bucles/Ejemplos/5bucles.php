<html>

    <head></head>

    <body>
        <?php
            $intCont = 1;
            echo "While <br />";
            while ($intCont <= 10) {
                echo "Línea " . $intCont . "<br />";
                $intCont++;
            }
            
            $intCont = 1;
            echo "<br /> Do-While <br />";
            do {
                echo "Línea " . $intCont . "<br />";
                $intCont++;
            } while ($intCont <= 10);
            
            echo "<br /> For <br />";
            for($intCont=0; $intCont<=10; $intCont++)
                echo "Línea " . $intCont . "<br />";
        ?>
    </body>

</html>
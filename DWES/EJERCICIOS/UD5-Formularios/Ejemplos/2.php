<html>
    <body>
            <?php

                $strArrLenguajes = $_REQUEST["lenguajes"];
                $strArrAsignaturas = $_REQUEST["asignaturas"];

                echo "Lenguajes <br />";
                foreach ($strArrLenguajes as $strLenguaje)
                    echo "$strLenguaje <br />";
                
                echo "<br /> Asignaturas <br />";
                foreach ($strArrAsignaturas as $strAsignatura)
                    echo "$strAsignatura <br />";
            ?>
    </body>
</html>
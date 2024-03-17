<!-- 
    Diseñar la misma aplicación del ejercicio anterior pero en un único archivo PHP. Además, al enviar el formulario, debe quedarse
    la fecha introducida como seleccionada en los select. Mostrar una opción 0 con Dia-Mes-Año, en lugar de con label.
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 02 - Repetición del ejercicio anterior</title>
</head>

<body>
    <form action="index.php" method="get">
        <select name="dia" id="dia">
            <option value="0">Día</option>
            <?php
            $intDia = isset($_GET["dia"]) ? $_GET["dia"] : 0;

            for ($intCont = 1; $intCont <= 31; $intCont++) {
                echo "          <option value=" . $intCont;

                if ($intDia != 0 && $intCont == $intDia) {
                    echo " selected";
                }

                echo "> $intCont </option>" . PHP_EOL;
            }
            ?>
        </select>
        <select name="mes" id="mes">
            <option value="0">Mes</option>
            <?php
            $intMes = isset($_GET["mes"]) ? $_GET["mes"] : 0;

            for ($intCont = 1; $intCont <= 12; $intCont++) {
                echo "          <option value=" . $intCont;

                if ($intMes != 0 && $intCont == $intMes) {
                    echo " selected";
                }

                echo "> $intCont </option>" . PHP_EOL;
            }
            ?>
        </select>
        <select name="anyo" id="anyo">
            <option value="0">Año</option>
            <?php
            $intAnyo = isset($_GET["anyo"]) ? $_GET["anyo"] : 0;

            for ($intCont = 2000; $intCont <= 2023; $intCont++) {
                echo "          <option value=" . $intCont;

                if ($intAnyo != 0 && $intCont == $intAnyo) {
                    echo " selected";
                }

                echo "> $intCont </option>" . PHP_EOL;
            }
            ?>
        </select>

        <br><br>
        
        <input type="submit" value="Enviar fecha">

        <?php 
            if (isset($_GET["dia"]) && isset($_GET["mes"]) && isset($_GET["anyo"])) {
                $intDia = $_GET["dia"];
                $intMes = $_GET["mes"];
                $intAnyo = $_GET["anyo"];
                $intMaxDias = 31;

                if ($intDia != 0 && $intMes != 0 && $intAnyo != 0) {
                    switch($intMes) {
                        case 2:
                            if ($intAnyo % 400 == 0 || ($intAnyo % 4 == 0) && ($intAnyo % 100 != 0)) {
                                $intMaxDias = 29;
                            } else {
                                $intMaxDias = 28;
                            }
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            $intMaxDias = 30;
                            break;
                        default:
                            $intMaxDias = 31;
                    }
    
                    echo "<p>Has introducido la fecha $intDia/$intMes/$intAnyo.</p>";
    
                    if ($intDia <= $intMaxDias) {
                        echo "<p>Es una fecha válida.</p>";
                    } else {
                        echo "<p>No es una fecha válida.</p>";
                    }
                } else {
                    echo "<p>Debes seleccionar día, mes y año.</p>";
                }
            } else {
                echo "<p>Debes introducir una fecha.</p>";
            }
        ?>
    </form>
</body>

</html>
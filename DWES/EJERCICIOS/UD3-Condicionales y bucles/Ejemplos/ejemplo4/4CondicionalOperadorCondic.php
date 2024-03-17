<html>

    <head></head>

    <body>
        <?php
            $intHora = 14; // La hora en formato de 24 horas
            
            $intFormato = ($intHora > 12) ? 24 : 12;
            echo "El formato es de $intFormato horas";
            $strNombre = $_GET['nombre'] ?: "desconocido";
            echo "<br />  $strNombre";
        ?>
    </body>

</html>
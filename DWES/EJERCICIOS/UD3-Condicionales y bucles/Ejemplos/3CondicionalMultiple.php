<html>

    <head></head>

    <body>
        <?php
            $hora = 14; // La hora en formato de 24 horas
            
            switch ($hora) {
                case 9:
                    echo "Es la hora de desayunar.";
                    break;
                case 14:
                    echo "Es la hora de la comida.";
                    break;
                case 21:
                    echo "Es la hora de la cena.";
                    break;
                default:
                    echo "Ahora no toca comer";
            }
            

        ?>
    </body>

</html>
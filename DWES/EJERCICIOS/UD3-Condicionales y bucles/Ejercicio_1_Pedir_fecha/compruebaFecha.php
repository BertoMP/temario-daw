<?php 
    //VARIABLES
    $intDiaElegido = $_GET["day"]; //Variable que almacena el día elegido en el formulario enviado.
    $intMesElegido = $_GET["month"]; //Variable que almacena el mes elegido en el formulario enviado.
    $intAnyoElegido = $_GET["year"]; //Variable que almacena el año elegido en el formulario enviado.
    $intDiasMaximos = 31; //Variable que almacena el día máximo posible del mes elegido.
    
    echo "<p>La fecha elegida es: $intDiaElegido/$intMesElegido/$intAnyoElegido.</p>";

    switch($intMesElegido) {
        case 2:

            if ($intAnyoElegido % 400 == 0 || ($intAnyoElegido % 4 == 0) && ($intAnyoElegido % 100 != 0)) {
                $intDiasMaximos = 29;
            } else {
                $intDiasMaximos = 28;
            }
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            $intDiasMaximos = 30;
            break;
    }

    if ($intDiaElegido > $intDiasMaximos) {
        echo "<p>No es una fecha válida.</p>";
    } else {
        echo "<p>Es una fecha válida.</p>";
    }
?>
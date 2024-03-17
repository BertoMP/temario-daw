<?php
    $strFrase = "Quien busca encuentra, eso dicen, a veces";
    echo "Frase a array con separador ,  ";
    print_r(explode(",", $strFrase));
    echo "<br />";

    $strArrCiudades = ["Elche", "Aspe", "Alicante"];
    echo "Array a frase con separador > " .implode(">", $strArrCiudades) . "<br />";

    echo "Frase a cadena de 3 en 3 posiciones  ";
    print_r(chunk_split($strFrase, 3));
    echo "<br />";

    echo "Frase a array de 3 en 3 posiciones  ";
    print_r(str_split($strFrase, 3));
    echo "<br />";

?>
<?php 
function mayor(...$numeros): int {
    $max = $numeros[0];

    for ($intCont = 1; $intCont < count($numeros); $intCont++) {
        if ($numeros[$intCont] > $max) {
            $max = $numeros[$intCont];
        }
    }

    return $max;
}

function concatenar(...$palabras): string {
    $stringReturn = $palabras[0];

    for ($intCont = 1; $intCont < count($palabras); $intCont++) {
        $stringReturn .= " $palabras[$intCont]";
    }

    return $stringReturn;
}
?>
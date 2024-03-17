<?php
function esPar(int $num): bool {
    if ($num % 2 === 0) {
        return true;
    } else {
        return false;
    }
}

function arrayAleatorio(int $tam, int $min, int $max): array {
    $arrayNumeros = array();

    for ($intCont = 0; $intCont < $tam; $intCont++) {
        $arrayNumeros[] = rand($min, $max);
    }

    // SIN REPETIDOS
    /* for ($intCont = 0; $intCont < $tam;) {
        $intNumero = rand($min, $max);

        if (!in_array($intNumero, $arrayNumeros)) {
            $arrayNumeros[] = $intNumero;
            $intCont++;
        }
    } */

    return $arrayNumeros;
}

function arrayPares(array &$array): int {
    $intContPares = 0;
    
    foreach($array as $numero) {
        if (esPar($numero)) {
            $intContPares++;
        }
    }

    return $intContPares;
}
?>
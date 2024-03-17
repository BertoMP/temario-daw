<?php
function digitos(int $num): int {
    $contadorNumeros = 0;
    while ($num != 0) {
        $num = (int)($num / 10);
        $contadorNumeros++;
    }
    return $contadorNumeros;
}

function digitoN(int $num, int $pos): int {
    $cantidadDigitos = digitos($num);
    if ($pos < 0 || $pos > $cantidadDigitos) {
        return -1;
    }
    
    if ($pos < $cantidadDigitos) {
        while ($pos < $cantidadDigitos - 1) {
            $num /= 10;
            $cantidadDigitos--;
        }
        return $num % 10;
    }
}

function quitaPorDetras(int $num, int $cant): int {
    for ($intCont = 0; $intCont < $cant; $intCont++) {
        $num = (int)($num / 10);
    }
    return $num;
}

function quitaPorDelante(int $num, int $cant): int {
    $cantidadDigitos = digitos($num);
    if ($cant >= $cantidadDigitos) {
        return 0;
    }
    
    $divisor = 1;
    for ($intCont = 0; $intCont < $cantidadDigitos - $cant; $intCont++) {
        $divisor *= 10;
    }
    
    return $num % $divisor;
}
?>
<?php
function digitos(int $num): int {
    $strNum = (string) $num;
    return strlen($strNum);
}

function digitoN(int $num, int $pos): int {
    $strNum = (string) $num;

    return $strNum[$pos];
}

function quitaPorDetras(int $num, int $cant): int {
    $strNum = (string) $num;

    return substr($strNum, 0, strlen($strNum) - $cant);
}

function quitaPorDelante(int $num, int $cant): int {
    $strNum = (string) $num;

    return substr($strNum, $cant, strlen($strNum) - 1);
}
?>
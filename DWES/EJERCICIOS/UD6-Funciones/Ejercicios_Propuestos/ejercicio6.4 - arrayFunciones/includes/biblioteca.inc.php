<?php
function suma(int $num1, int $num2): int {
    return $num1 + $num2;
}

function resta(int $num1, int $num2): int {
    return $num1 - $num2;
}

function multiplicacion(int $num1, int $num2): int {
    return $num1 * $num2;
}

function division(int $num1, int $num2) {
    if ($num2 === 0) {
        echo "<p>El divisor no puede ser 0.</p>";
        return null;
    } else {
        return (float) ($num1 / $num2);
    }
}
?>
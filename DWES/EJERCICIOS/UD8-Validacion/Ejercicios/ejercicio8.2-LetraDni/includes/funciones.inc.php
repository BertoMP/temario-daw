<?php 
/**
 * Función que comprueba y muestra la letra asignada a un número de DNI.
 *
 * @param int       $intNumDni  El número de DNI a verificar y calcular la letra.
 * @return void
 */
function compruebaDni(int $intNumDni): void {
    if(filter_var($intNumDni, FILTER_VALIDATE_INT, ["options" => ["min_range" => 1, "max_range" => 99999999]])) {
        // Llamada a la función letraDni(int): string.
        $letra = letraDni($intNumDni); // Letra del DNI.
        echo "<p>La letra asignada al DNI <span>$intNumDni</span> es la: <span>$letra</span>.</p>";
    } else {
        echo "<p>El número <span>$intNumDni</span> no es un número de DNI válido.</p>";
    }
}

/**
 * Función que calcula la letra del DNI basada en el número.
 *
 * @param int       $intDniUsuario  El número de DNI para el cálculo de la letra.
 * @return string                   La letra del DNI calculada.
 */
function letraDni(int $intDniUsuario): string {
    $strLetrasPosibles = "TRWAGMYFPDXBNJZSQVHLCKE"; // String con las letras del DNI posibles.
    return $strLetrasPosibles[$intDniUsuario % 23];
}
?>
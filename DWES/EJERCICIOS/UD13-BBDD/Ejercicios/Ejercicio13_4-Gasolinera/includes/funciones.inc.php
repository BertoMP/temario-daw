<?php
/**
 * Comprueba los datos del formulario relacionados con un ticket.
 *
 * @param   array   $datosFormulario Datos del formulario a comprobar.
 * @return  bool    Devuelve true si el importe pasado en el formulario es un número válido,
 *                  false en caso contrario.
 */
function compruebaDatosTicket(array $datosFormulario): bool {
    return compruebaNumero($datosFormulario['importe']);
}

/**
 * Comprueba los datos del formulario relacionados con una factura y los asigna a variables de sesión.
 *
 * @param   array   $datosFormulario Datos del formulario a comprobar y asignar a variables de sesión.
 * @return  bool    Devuelve true si todos los datos son válidos (importe, DNI y matrícula),
 *                  false en caso contrario.
 */
function compruebaDatosFactura(array $datosFormulario): bool {
    $_SESSION['importe'] = $datosFormulario['importe'];
    $_SESSION['dni'] = $datosFormulario['dni'];
    $_SESSION['matricula'] = $datosFormulario['matricula'];

    return compruebaNumero($_SESSION['importe'])
        && compruebaDni($_SESSION['dni'])
        && compruebaMatricula($_SESSION['matricula']);
}

/**
 * Comprueba los datos del formulario relacionados con el llenado de un depósito y los asigna a variables de sesión.
 *
 * @param   array   $datosFormulario Datos del formulario a comprobar y asignar a variables de sesión.
 * @return  bool    Devuelve true si todos los datos son válidos (litros, tipo de gasolina e importe),
 *                  false en caso contrario.
 */
function compruebaDatosDeposito(array $datosFormulario): bool {
    $_SESSION['litros'] = $datosFormulario['litros'];
    $_SESSION['tipo-gasolina'] = $datosFormulario['tipo-gasolina'];
    $_SESSION['importe'] = $datosFormulario['importe'];

    return compruebaNumero($_SESSION['litros'])
        && compruebaGasolina($_SESSION['tipo-gasolina'])
        && compruebaNumero($_SESSION['importe']);
}

/**
 * Comprueba si el valor proporcionado es un número válido (hasta 4 dígitos y 2 decimales) y mayor que cero.
 *
 * @param   float   $rlnComprueba El valor a comprobar.
 * @return  bool    Devuelve true si el valor es un número válido y mayor que cero,
 *                  false en caso contrario.
 */
function compruebaNumero(float $rlnComprueba): bool {
    return (preg_match('/^\d{1,4}(\.\d{2})?$/', $rlnComprueba)) && ($rlnComprueba > 0);
}

/**
 * Comprueba si el formato del DNI es válido (Formato: 12345678-A).
 *
 * @param   string  $strDni El número de DNI a comprobar.
 * @return  bool    Devuelve true si el formato del DNI es válido,
 *                  false en caso contrario.
 */
function compruebaDni(string $strDni): bool {
    $strDni = strtoupper($strDni);

    if (strlen($strDni) !== 10 || !preg_match('/^[0-9]{8}-[A-Z]$/', $strDni)) {
        return false;
    }

    return true;
}

/**
 * Comprueba si el formato de la matrícula es válido (Formato: 1234-ABC).
 *
 * @param   string  $strMatricula La matrícula a comprobar.
 * @return  bool    Devuelve true si el formato de la matrícula es válido,
 *                  false en caso contrario.
 */
function compruebaMatricula(string $strMatricula): bool {
    $strMatricula = strtoupper($strMatricula);

    if (strlen($strMatricula) !== 8 ||!preg_match('/^[0-9]{4}-[A-Z]{3}$/', $strMatricula)) {
        return false;
    }

    return true;
}

/**
 * Comprueba si el tipo de gasolina proporcionado es válido.
 *
 * @param   string  $strTipoGasolina El tipo de gasolina a comprobar.
 * @return  bool    Devuelve true si el tipo de gasolina es válido,
 *                  false en caso contrario.
 */
function compruebaGasolina(string $strTipoGasolina): bool {
    $arrTipos = array('gasoil', 'gasolina-95', 'gasolina-98', 'gasoil-agricola');

    return in_array($strTipoGasolina, $arrTipos);
}

/**
 * Elimina los valores de sesión, excepto 'ultima-opcion'.
 *
 * @param   array   &$arraySession El array de sesión a modificar.
 * @return  void
 */
function eliminaValoresSession(array &$arraySession): void {
    foreach ($arraySession as $key => $campo) {
        if ($key !== 'ultima-opcion') {
            $arraySession[$key] = null;
        }
    }
}
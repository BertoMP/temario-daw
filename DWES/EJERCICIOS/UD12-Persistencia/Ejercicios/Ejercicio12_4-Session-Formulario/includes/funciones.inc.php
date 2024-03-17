<?php

/**
 * Comprueba si los campos en un arreglo de sesión están vacíos.
 *
 * @param {array} arrSesion - El arreglo de sesión a verificar.
 * @param {array} arrCamposAComprobar - Un arreglo de nombres de campos a verificar.
 * @return {boolean} True si al menos un campo está vacío, de lo contrario, false.
 */
function tieneCamposVacios(array $arrSesion, array $arrCamposAComprobar): bool {
    foreach ($arrCamposAComprobar as $campo) {
        if (empty($arrSesion[$campo])) {
            return true;
        }
    }
    return false;
}

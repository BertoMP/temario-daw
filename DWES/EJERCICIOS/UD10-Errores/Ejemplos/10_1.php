<?php
//error_reporting(E_DEPRECATED);
//se establece una función para el manejo de los errores
set_error_handler("miManejadorErrores");
$resultado = $divisor;
restore_error_handler(); // vuelve al anterior

error_reporting(E_ALL); //& ~E_WARNING

$prueba = $var; //la segunda variable no está definida

$arrValores['uno'] = 'hola'; 

$arrValores = ['dos' => 'mundo'];
$prueba = $arrValores['dos']; // ok

$prueba = $arrValores['noDefinido']; // el índice no está definido
function miManejadorErrores($intNivel, $strMensaje) {
    switch($intNivel) {
        case E_WARNING:
            echo "<strong>Aviso</strong>: $strMensaje<br/>";
            break;
        default:
            echo "Error de tipo no especificado: $strMensaje, de nivel $intNivel <br/>";
    }
}
?>
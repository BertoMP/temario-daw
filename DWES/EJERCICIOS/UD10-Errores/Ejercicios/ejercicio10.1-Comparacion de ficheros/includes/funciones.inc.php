<?php 
// Incluye el archivo que contiene la definición de la clase 'existenciaFicheros'.
include('excepciones.inc.php');

/**
 * Función que comprueba la existencia y comparación de dos archivos.
 *
 * @return string Mensaje que indica el resultado de la comparación de archivos.
 */
function compruebaFicheros(): string {
    $strMensajeReturn = "";

    if (isset($_REQUEST['archivos'])) {
        try {
            $strFich1 = $_REQUEST['archivos'][0];
            $strFich2 = $_REQUEST['archivos'][1];

            if (!file_exists($strFich1)) {
                throw new existenciaFicheros($strFich1);
            }

            if (!file_exists($strFich2)) {
                throw new existenciaFicheros($strFich2);
            }
            
            if (filesize($strFich1) === filesize($strFich2)) {
                if (file_get_contents($strFich1) === file_get_contents($strFich2)) {
                    $strMensajeReturn = "<p class=\"valida\">Los archivos son idénticos.</p>";
                } else {
                    $strMensajeReturn = "<p class=\"noValida\">El tamaño de los archivos es el mismo pero el contenido es diferente.</p>";
                }
            } else {
                $strMensajeReturn = "<p class=\"noValida\">Los archivos son distintos en tamaño.</p>";
            }
        } catch (existenciaFicheros $excep) {
            echo $excep->mensajeError($excep->getMessage());
        }       
    }
    return $strMensajeReturn;
}
?>
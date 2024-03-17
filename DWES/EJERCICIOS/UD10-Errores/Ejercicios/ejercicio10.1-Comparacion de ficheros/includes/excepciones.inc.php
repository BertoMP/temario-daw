<?php
/**
 * Clase 'existenciaFicheros' que hereda de la clase 'Exception'.
 */
class existenciaFicheros extends Exception {
    
    /**
     * Método que genera un mensaje de error para la inexistencia de un fichero.
     *
     * @param   string      $strFichero     El nombre del fichero que no se encuentra.
     * @return  string                      El mensaje de error formateado.
     */
    public function mensajeError(string $strFichero): string {
        return "<p class=\"noValida\">No existe el fichero: $strFichero</p>";
    }
}
?>
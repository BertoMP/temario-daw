<?php 
function compruebaFicheros(): string {
    $strMensajeReturn = "";

    if (isset($_FILES['archivos'])) {
        $fichero1 = $_FILES['archivos']['tmp_name'][0];
        $fichero2 = $_FILES['archivos']['tmp_name'][1];
        if (file_exists($fichero1) && file_exists($fichero2)) {
            if (filesize($fichero1) === filesize($fichero2)) {
                if (file_get_contents($fichero1) === file_get_contents($fichero2)) {
                    $strMensajeReturn = "<p class=\"valida\">Los archivos son idénticos.</p>";
                } else {
                    $strMensajeReturn = "<p class=\"noValida\">El tamaño de los archivos es el mismo pero el contenido es diferente.</p>";
                }
            } else {
                $strMensajeReturn = "<p class=\"noValida\">Los archivos son distintos en tamaño.</p>";
            }
        } else {
            $strMensajeReturn = "<p class=\"noValida\">Debes subir dos archivos.</p>";
        }
    }
    return $strMensajeReturn;
}
    
?>
<?php 
$fichero = "$_SERVER[DOCUMENT_ROOT]/Entorno_Servidor/UD9-Ficheros/Pruebas/files/ficheroPrueba";

$flujoLectura = fopen($fichero, 'rb');

// while (!feof($flujoLectura)) {
//     $letra = fgetc($flujoLectura);
//     echo "$letra <br />";
// }

while (!feof($flujoLectura)) {
    $strFrase = fgets($flujoLectura);
    echo "$strFrase <br />";
}

fclose($flujoLectura);

$ficheroCSV = "$_SERVER[DOCUMENT_ROOT]/Entorno_Servidor/UD9-Ficheros/Pruebas/files/Libro1.csv";
$chrDelimitador = ";";

if (!($flujo = fopen($ficheroCSV, "rb"))) {
    echo "No se pudo abrir el archivo CSV.";
} else {
    echo "<table border='1'>";
    $intFila = 0;

    while (($arrFila = fgetcsv($flujo, 0, $chrDelimitador)) !== false) {
        echo "<tr>";
        $strEtiqueta = $intFila === 0 ? "th" : "td";

        foreach ($arrFila as $strColumna) {
            echo "<$strEtiqueta>$strColumna</$strEtiqueta>";
        }

        echo "</tr>";
        $intFila++;
    }

    echo "</table>";

    fclose($flujo);
}
?>
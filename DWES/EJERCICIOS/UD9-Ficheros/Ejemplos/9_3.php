<?php
    $chrDelimitador = ";"; // Separador de columnas
    $strArchivo = "Libro1.csv"; // ruta del archivo, en este caso está junto a este script
    
    // Abrir el archivo
    if (!($fichero = fopen($strArchivo, "rb")))
    exit("No se puede abrir el archivo $nombreArchivo");

    //  Comenzar a leer, $numeroDeFila es para llevar un índice
    echo "<table border='1'>";
    for ($intFila = 1; ($arrFila = fgetcsv($fichero, 0, $chrDelimitador)); $intFila++) {
        echo "<tr>";
        $strEtiqueta =$intFila === 1?"th":"td";
        // Ahora $fila es un array. Podríamos acceder al precio de compra en $fila[1]
        foreach ($arrFila as $strColumna)
            echo "<$strEtiqueta> $strColumna </$strEtiqueta>";
        
        echo "</tr>";
    }
    // Al finar cerrar el fichero
    fclose($fichero);
?>
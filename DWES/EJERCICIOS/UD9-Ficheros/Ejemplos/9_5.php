<?php
    $fichero = fopen('salida.txt', 'r+');

    fwrite($fichero, 'Hola Mundo, esto es una prueba'); // escribo al principiopor ser de lectura primero
    rewind($fichero); // tras escribir vuelvo a colocarme al principio
    fwrite($fichero, '12345678');
    fseek($fichero, 0);
    
    echo fread($fichero, filesize('salida.txt')); // leo todo el contenido del fichero
    
    fclose($fichero);
?>
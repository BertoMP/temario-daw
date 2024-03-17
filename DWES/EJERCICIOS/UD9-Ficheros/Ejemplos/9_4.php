<?php
    echo 'Con readfile:';
    echo '<pre>';
    readfile('Libro1.csv');
    echo '</pre>';

    
    echo 'Con file:<br />';
    $strArrFichero = file('Libro1.csv');
    print_r($strArrFichero);

    echo '<br /><br />Con file_get_contents:';
    $strFichero = file_get_contents('Libro1.csv');
    echo '<pre>';
    echo $strFichero;
    echo '</pre>';
?>
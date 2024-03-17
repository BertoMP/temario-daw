<?php
    $strFrase = 'En un lugar de la mancha';
    $strArrDeFrase = preg_split("/ /", $strFrase);
    echo $strArrDeFrase[2]; 
?>
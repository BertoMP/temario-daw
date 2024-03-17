<?php
    function listar(int $intA, int $intB, int $intC){
        echo "intA: $intA intB: $intB intC: $intC";
    }

    $funcAnonima = function(int $intA, int $intB) :int{
        return $intA + $intB;
    };
    
    $miFuncion = "listar";
    $miFuncion(1,2,3);
    echo "<br />" . $funcAnonima(3,4);
?>
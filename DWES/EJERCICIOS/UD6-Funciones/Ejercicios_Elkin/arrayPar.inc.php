<?php
    function esPar(int $intNum): bool{
        return $intNum%2==0?true:false;
    }

    function arrayAleatorio(int $intTam, int $intMin, int $intMax) : array{
        $intArray =[];

        for($intCont=0; $intCont<$intTam; ){
            $intNumero=rand($intMin, $intMax);
            if(!in_array($intNumero, $intArray)){
                $intArray[]=$intNumero;
                $intCont++;
            }
        }

        return $intArray;
    }

    function arrayPares(array &$intArray): int{
        $intPares=0;
        for($intCont=0; $intCont<count($intArray); $intCont++)
            if(esPar($intArray[$intCont]))
                $intPares++;

        return $intPares;
    }
?>
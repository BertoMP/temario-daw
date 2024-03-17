<?php
    // devuelve la cantidad de dígitos de un número.
    function digitos(int $num): int{
        return strlen((string)$num);
    } 
    
    // devuelve el dígito que ocupa, empezando por la izquierda, la posición $pos.
    function digitoN(int $num, int $pos): int {
        $intArray=str_split($num);
        return($intArray[$pos-1]);
    } 
   
   // le quita por detrás (derecha) $cant dígitos.
    function quitaPorDetras(int $intNum, int $intCant): int {
        $intDivisor = 1;
        for($intCont=0; $intCont<$intCant; $intCont++)
            $intDivisor *= 10;

        return $intNum/ $intDivisor;
    } 
   
   // le quita por delante (izquierda) $cant dígitos.
    function quitaPorDelante(int $intNum, int $intCant): int {
        $intDivisor = 1;
        for($intCont=0; $intCont<$intCant; $intCont++)
            $intDivisor *= 10;

        return $intNum % $intDivisor;
    } 
    
?>
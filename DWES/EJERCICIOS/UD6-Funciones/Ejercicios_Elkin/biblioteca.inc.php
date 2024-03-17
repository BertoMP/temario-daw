<?php
    function suma(int $intNum1, int $intNum2): int{
        return $intNum1 + $intNum2;
    } 
    
    
    function resta(int $intNum1, int $intNum2): int{
        return $intNum1 - $intNum2;
    } 

    function multiplica(int $intNum1, int $intNum2): int{
        return $intNum1 * $intNum2;
    } 

    function divide(int $intNum1, int $intNum2): int{
        if($intNum1 > $intNum2)
            return $intNum1 / $intNum2;
        else
        return $intNum2 / $intNum1;
    } 
    
?>
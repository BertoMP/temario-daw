<?php
    function suma(...$intArrNumeros): int {
        if (count($intArrNumeros) == 0)
            return false;
        else {
            $intSuma = 0;
            foreach ($intArrNumeros as $intNum)
                $intSuma += $intNum;

            return $intSuma;
        }
    }

    echo suma(1, 3, 5); 
    echo "<br />";
    echo suma(2, 4, 6, 8, 10);
?>
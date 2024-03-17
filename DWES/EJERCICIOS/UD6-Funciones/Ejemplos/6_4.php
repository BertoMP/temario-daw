<?php
    function media(...$intArrNumeros): int {
        if (count($intArrNumeros) == 0)
            return false;
        else {
            $intSuma = 0;
            foreach ($intArrNumeros as $strNombre=>$intNota){
                $intSuma += $intNota;
                echo "$strNombre $intNota<br />";
            }
            return $intSuma/count($intArrNumeros);
        }
    }

    echo "Media: ". media(Pepe:1, Maria:3, Juan:5); 
?>
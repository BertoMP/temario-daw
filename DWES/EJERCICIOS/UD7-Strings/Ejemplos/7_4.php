<?php
    function despues(string $chrLetra): string{
        $intAsciiLetra = ord($chrLetra);
        return chr($intAsciiLetra + 1);
    }
    echo despues("B"); 
?>
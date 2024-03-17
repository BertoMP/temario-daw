<?php
    function letraAleatoria():string{
        $chrLetra = chr(rand(ord('a'),ord('z')));
        if(rand(0,1))
            $chrLetra = strtoupper($chrLetra);
        return $chrLetra;
    }
    echo letraAleatoria();
?>
    
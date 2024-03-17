<?php
    $strFrase = "Quien busca encuentra, eso dicen, a veces";
    echo substr_count($strFrase, "n") . "<br />";
    echo substr_replace($strFrase, " exito", 21) . "<br />";
    echo substr_replace($strFrase, "los exitosos", -7) . "<br />"; 
    echo substr_replace($strFrase, "Ahora ", 0, 16) . "<br />";
    
?>
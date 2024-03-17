<?php 
function generaLetra(): string {
    $letra = chr(rand(ord('A'), ord('Z')));
    $mayusMinus = rand(0,1);

    return $mayusMinus === 0 ? strtolower($letra) : $letra;
}
?>

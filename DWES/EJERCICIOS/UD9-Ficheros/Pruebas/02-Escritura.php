<?php 
$fichero = './files/ficheroPrueba';
$strFrase = 'Hola mundo';

$flujo = fopen($fichero, 'w+');
fwrite($flujo, $strFrase, strlen($strFrase));
fclose($flujo);
?>
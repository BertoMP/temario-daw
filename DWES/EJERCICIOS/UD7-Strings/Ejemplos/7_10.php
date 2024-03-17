<?php
$strFrase = "   Quien busca encuentra, eso dicen, a veces   ";
echo "sin espacios al principio o al final: \"" . trim($strFrase) . "\"<br />";
echo "sin espacios al principio: \"" . ltrim($strFrase) . "\"<br />";
echo "sin espacios al final: \"" . rtrim($strFrase) . "\"<br />";
echo "rellena espacios al final: \"" . str_pad($strFrase, 60, ".") . "\"<br />";
?>
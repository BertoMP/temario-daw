<?php
    $strFrase = "Quien busca encuentra, eso dicen, a veces";
    echo strpos($strFrase, ",") . "<br />"; // encuentra 1º coma
    echo strrpos($strFrase, ",") . "<br />"; // encuentra última coma
    echo strstr($strFrase, ", eso") . "<br />"; // ", eso dicen, a veces"
    echo strchr($strFrase, ",") . "<br />"; // ", eso dicen, a veces"
    echo stristr($strFrase, "EnCuEnTrA") . "<br />"; // ", eso dicen, a veces"
?>
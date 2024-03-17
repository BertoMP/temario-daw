<?php
    $rlnNum = 7.7;
    echo " Del númro 7.7 floor() " . floor($rlnNum) . " ceil: " . ceil($rlnNum) . "<br />";

    $rlnNum = 7.5368;
    echo " Del númro 7.7 floor() " . (floor($rlnNum*1000))/1000 . " ceil: <br />";

    $rlnNum = 54.49;
    echo " Del númro 54.49 round() " . round($rlnNum) . "round(,1) " .  round($rlnNum, 1). "round(,-1) " .  round($rlnNum, -1);
?>
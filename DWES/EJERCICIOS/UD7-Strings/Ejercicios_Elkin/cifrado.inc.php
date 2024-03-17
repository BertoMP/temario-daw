<?php
    function strCifra(string $strCadena, int $intDesplazamiento):string{
        $strArrCadena = str_split($strCadena);
        $strDevolver='';

        for($intCont=0; $intCont<strlen($strCadena); $intCont++){
            $chrCar=$strCadena[$intCont];
            if(ctype_alpha($chrCar)){
                $chrCar=chr(ord($chrCar)+$intDesplazamiento);
                if($chrCar>'Z' && $chrCar<'a')
                        $chrCar = chr(ord($chrCar)-(ord('Z')-ord('A')+1));
                else if($chrCar>'z')
                    $chrCar = chr(ord($chrCar)-(ord('z')-ord('a')+1));
            }
            $strDevolver .= $chrCar;
        }
        return ($strDevolver);
    }
    echo strCifra("Zola ,. z", 1);
?>
    
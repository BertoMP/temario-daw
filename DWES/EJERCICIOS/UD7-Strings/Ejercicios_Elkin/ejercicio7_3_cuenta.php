<?php
    function cuentaSin(string $strCadena, int &$intLetras, int &$intPalabras){
        $strArrCadena = explode(' ', $strCadena);
        $intPalabras=count($strArrCadena);
        $intLetras=0;

        foreach($strArrCadena as $strPalabra){
            $intAux = cuentaPalabra($strPalabra);
            echo "La palabra $strPalabra tiene $intAux caracteres<br/>";
            $intLetras+=$intAux;
        }
    }

    function cuentaPalabra(string &$strPalabra):int{
        $strArrCadena = str_split($strPalabra);
        $strPalabra='';
        $intCaracteres=0;

        foreach($strArrCadena as $chrCar)
            if(ctype_alpha($chrCar)){
                $strPalabra .= $chrCar;
                $intCaracteres++;
            }
       
        return ($intCaracteres);
    }

    function cuentaCon(string $strCadena, int &$intLetras, int &$intPalabras){
        $strArrPalabras = str_word_count($strCadena, 1);
        $intPalabras=count($strArrPalabras);
        $intLetras=0;

        foreach($strArrPalabras as $strPalabra){
            $intAux = strlen($strPalabra);
            echo "La palabra $strPalabra tiene $intAux caracteres<br/>";
            $intLetras+=$intAux;
        }
    }

    $intLetras=0; 
    $intPalabras=0;
    cuentaSin("Hola esto$ es un@a prueba", $intLetras, $intPalabras);
    echo "El texto sin tiene $intPalabras palabras y $intLetras letras<br/><br/>";

    $intLetras=0; 
    $intPalabras=0;
    cuentaCon("Hola esto$ es un@a prueba", $intLetras, $intPalabras);
    echo "El texto con tiene $intPalabras palabras y $intLetras letras";
?>
    
<html>
    <head></head>
    <body>
            <?php
                $strPalo = ['Copas', 'Oros', 'Bastos', 'Espadas'];
                $strNobre = ['','As', 'Dos', 'Tres', 'Cuatro', 'Cinco', 'Seis', 'Siete', 'Sota', 'Caballo', 'Rey'];
                $strIntValores = ['As'=>11, 'Tres'=>10, 'Rey'=>4, 'Caballo'=>3, 'Sota'=>2];
                $arrCartas = [];
                
                while(count($arrCartas)<10){
                    $intArrAux = [rand(1,10), rand(0,3)];//saco una carta

                    if(!in_array($intArrAux,$arrCartas)){//si no está lo inserta
                        $arrCartas[]=$intArrAux;
                    }
                }
                
                $intTotal = 0;
                echo "Cartas que han tocado: <br />";
                foreach($arrCartas as $arrCarta){
                    echo "&nbsp;&nbsp;&nbsp;" . $strNobre[$arrCarta[0]] . " " . $strPalo[$arrCarta[1]] . "<br />";
                    $intTotal += isset($strIntValores[$strNobre[$arrCarta[0]]])?$strIntValores[$strNobre[$arrCarta[0]]]:0;
                }
                echo "Total puntos $intTotal";
            ?>
    </body>
</html>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 01 - Suma de arrays</title>
</head>
<body>
    <?php 
        $arrNumerosUno = array();
        $arrNumerosDos = [4, 5, 6, 7];

        $arrNumerosUno[1] = 1;
        $arrNumerosUno[7] = 2;
        $arrNumerosUno[3] = 3;

        for ($intCont = 0, $intElementos = 0; $intElementos < count($arrNumerosUno); $intCont++) {
            if (isset($arrNumerosUno[$intCont])) {
                if (isset($arrNumerosDos[$intCont])) {
                    $arrNumerosDos[] = $arrNumerosDos[$intCont];
                    unset($arrNumerosDos[$intCont]);
                }
                $intElementos++;
            }
        }
        
        var_dump($arrNumerosUno + $arrNumerosDos);
    ?>
</body>
</html>
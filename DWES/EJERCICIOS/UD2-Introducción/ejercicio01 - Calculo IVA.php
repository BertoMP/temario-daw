<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1 - Cálculo de precio con IVA</title>
</head>
<body>
    <?php
        //CONSTANTES
        const IVA_APLICADO = 21; //Constante que guarda el IVA a aplicar en los productos.

        //VARIABLES
        $floatPrecioArticulo = 20.12; //Variable que guarda el precio del artículo.
        $floatPrecioFinal; //Variable que guarda el precio final del artículo tras aplicar el IVA.

        //DESARROLLO PRINCIPAL
        $floatPrecioFinal = $floatPrecioArticulo * (1 + (IVA_APLICADO / 100));

        echo "Precio base del artículo: $floatPrecioArticulo €<br>";
        echo "IVA: " . IVA_APLICADO . "%<br>";
        echo "Precio final: $floatPrecioFinal" . "€";
    ?>
</body>
</html>
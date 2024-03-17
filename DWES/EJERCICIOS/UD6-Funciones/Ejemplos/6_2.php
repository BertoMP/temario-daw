<?php
    function precio_con_iva($intPrecio="22") {
        return $intPrecio * 1.18;
    }

    function precio_descuento(int $intPrecio, int $intDescuento):float{
        return $intPrecio - ($intPrecio * $intDescuento / 100);
    }

    function precio_cambia_descuento(int &$intPrecio, int $intDescuento){
        $intPrecio = precio_descuento($intPrecio, $intDescuento);
    }

    $intPrecio = 10;
    $intPrecio_iva = precio_con_iva($intPrecio);
    echo "El precio con IVA es " . $intPrecio_iva . "<br />";
    echo "El precio con IVA es " . precio_con_iva() . "<br />";
    echo "El precio con 10% de descuento es " . precio_descuento($intPrecio, 10) . " sin descuento $intPrecio<br />";
    precio_cambia_descuento($intPrecio, 10);
    echo "El precio en paso por referenciacon 10% de descuento es $intPrecio<br />";

?>
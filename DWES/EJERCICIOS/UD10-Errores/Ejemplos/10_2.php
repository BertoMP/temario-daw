<?php
    $dividendo = 10;
    $divisor = 0;
    try {
        if ($divisor == 0)
            throw new Exception("División por cero.");
        $resultado = $dividendo / $divisor;
    } catch (OtraExcepcion | MiExcepcion $e) { echo $e->miFuncion();
    } catch (Exception $e) { echo "Se ha producido el siguiente error: ".$e->getMessage(). " en el fichero " . $e->getFile() . " en la línea " . $e->getLine();}

    class MiExcepcion extends Exception {
        public function miFuncion() {
            echo "Una función personalizada para este tipo de excepción\n";
        }
    }
    class OtraExcepcion extends Exception {}

?>
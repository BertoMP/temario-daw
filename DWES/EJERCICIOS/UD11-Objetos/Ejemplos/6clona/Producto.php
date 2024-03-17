<?php
    include('Persona.php'); 
    class Producto {
        private static $intNumProductos = 0; 
        private string $strCodigo;
        private array $intArrPrecio=[];
        private Persona $objPers;
    
        public function __construct(string $strCodigo) {
            self::$intNumProductos++;
            $this->strCodigo = $strCodigo;
            $this->objPers = new Persona('Pepe','Perez',24);
        }
        
        public function __toString( ){
            return "strCodigo=" . $this->strCodigo . 
                   ", productos=" . Producto::$intNumProductos . 
                   ", Precios=" . implode(' : ' ,$this->intArrPrecio) .
                   ", Persona[" . $this->objPers . ']';
        }
        
        public function aniade(int $intValor) {
            $this->intArrPrecio[]=$intValor;
        }
        
        public function cambiaNombre(string $strNombre) {
            $this->objPers->setNombre($strNombre);
        }

        public function __clone() {
            $this->strCodigo='loQueMeDa la gana';
            $this->objPers = clone($this->objPers);
        }

    }
?>
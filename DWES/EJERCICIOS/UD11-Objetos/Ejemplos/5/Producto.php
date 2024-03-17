<?php
    class Producto {
        public const IVA = 0.23;
        public static $intNumProductos = 0; 
        private string $strCodigo;
    
        public function __construct(string $strCodigo) {
            self::$intNumProductos++;
            $this->strCodigo = $strCodigo;
        }
    
        public function mostrarResumen() : string {
            return "El producto " . $this->strCodigo . " y se han creado un total de " . self::$intNumProductos;
        }

        public static function getNumProductos(): int {
            return self::$intNumProductos;
        }
    }
?>
<?php
    class Producto {
        protected string $strCodigo;
        protected string $strnombre;
        protected string $strnombreCorto;
        protected int $intPVP;
        
      /*
        public function __construct(string $strCod) {
            $this->strCodigo = $strCod;
        }
      */      
        public function mostrarResumen() {
            echo "<p>Prod:" . $this->strCodigo . "</p>";
        }

        public function setCodigo(string $strCod) {
            $this->strCodigo = $strCod;
        }
    }
?>
<?php
    class Tv extends Producto {
        private int $intPulgadas = 50;
        private string $strTecnologia = 'OLED';
        
    /*    public function __construct(string $strCodigo, int $intPul, string $strTec) {
            parent::__construct($strCodigo);
            $this->intPulgadas = $intPul;
            $this->strTecnologia = $strTec;
        }
    */
        public function mostrarResumen() {
            parent::mostrarResumen();
            echo "<p>TV " . $this->strTecnologia . " de " . $this->intPulgadas . "</p>";
        }

        public function setPulgadas(int $intPul) {
            $this->intPulgadas = $intPul;
        }

        public function setTecnologia(string $strTec) {
            $this->strTecnologia = $strTec;
        }
    }
?>
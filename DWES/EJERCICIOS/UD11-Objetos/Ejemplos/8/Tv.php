<?php
    class Tv extends Producto {
        private int $intPulgadas = 83;
        private string $strTecnologia = 'OLED';
        
        public function mostrarResumen() {
            echo "<p>Codigo " . $this->getCodigo() . " TV " . $this->strTecnologia . " de " . $this->intPulgadas . "</p>";
        }

        public function setPulgadas(int $intPul) {
            $this->intPulgadas = $intPul;
        }

        public function setTecnologia(string $strTec) {
            $this->strTecnologia = $strTec;
        }
    }
?>
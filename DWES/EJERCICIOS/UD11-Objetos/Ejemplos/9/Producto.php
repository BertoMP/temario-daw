<?php
    abstract class Producto {
        private string $strCodigo='OLED83C34LA';
           
        abstract protected function mostrarResumen();

        protected function setCodigo(string $strCod) {
            $this->strCodigo = $strCod;
        }

        protected function getCodigo():string {
            return $this->strCodigo;
        }
    }
?>
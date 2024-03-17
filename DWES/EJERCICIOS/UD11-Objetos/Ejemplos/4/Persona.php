<?php
    class Persona {
        //private string $strNombre;
       
        //public function __construct(string $strNom) {
        public function __construct(private string $strNom) {
                $this->strNombre = $strNom;
        }

        public function setNombre(string $strNom) {
            $this->strNombre=$strNom;
        }
    
        public function imprimir(){
            echo $this->strNombre . '<br>';
        }
    }
?>
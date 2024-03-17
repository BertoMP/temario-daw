<?php
    class Persona {
        private string $strNombre;
    
        public function setNombre(string $strNom) {
            $this->strNombre=$strNom;
        }
    
        public function imprimir(){
            echo $this->strNombre . '<br>';
        }
    }
?>
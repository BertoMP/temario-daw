<?php
    class Persona {
        
       public int $intTalla = 43;
       
        public function __construct(private ?string $strNombre, 
                                    private ?string $strApellido, 
                                    public ?int $intEdad) {
            $this->strApellido="prueba";
            echo "****" . (is_string($this->strApellido)?'true':'false');
        }

        public function setNombre(string $strNom) {
            $this->strNombre=$strNom;
        }
        public function __toString( ){
            return "Nombre=" . $this->strNombre . 
                   ", apellido=" . $this->strApellido . 
                   ", Edad=" . $this->intEdad .
                   ", Talla=" . $this->intTalla;
        }
    }
?>
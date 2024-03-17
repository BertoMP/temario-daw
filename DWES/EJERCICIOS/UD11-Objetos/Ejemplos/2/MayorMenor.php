<?php
    class MayorMenor {
        private int $intMayor;
        private int $intMenor;
    
        public function setMayor(int $intMay) {
            $this->intMayor = $intMay;
        }
    
        public function setMenor(int $intMen) {
            $this->intMenor = $intMen;
        }
    
        public function getMayor() : int {
            return $this->intMayor;
        }
    
        public function getMenor() : int {
            return $this->intMenor;
        }
    }
?>
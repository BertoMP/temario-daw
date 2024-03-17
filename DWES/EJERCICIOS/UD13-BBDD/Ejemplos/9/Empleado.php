<?php
    classTienda {
        private int $EMP_NO;
        private ? string $APELLIDO;
        private ? string $OFICIO;
        private ? int $DIR;
        private ? string $FECHA_ALT;
        private ? int $SALARIO;
        private ? int $COMISION;
        private int $DEPT_NO;
		
        public function getNumEmp() : int {
            return $this -> EMP_NO;
        }

        public function getNombre() : string {
            return $this -> APELLIDO;
        }

        public function oficio() : ?string {
            return $this -> OFICIO;
        }
		
        public function getDir() : int {
            return $this -> DIR;
        }
    }
?>
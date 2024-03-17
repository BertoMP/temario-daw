<?php

namespace T11E2\Clases;

class Gerente extends Trabajador {
    // ATRIBUTOS
    private float $rlnSalario = 0; // Atributo que almacena el salario base del Gerente.

    /**
     * Constructor de la clase Gerente para inicializar sus propiedades.
     *
     * @param {string} $strNombre - El nombre del gerente.
     * @param {string} $strApellidos - Los apellidos del gerente.
     * @param {int} $intEdad - La edad del gerente.
     * @param {float} $rlnSalario - El salario base del gerente.
     */
    public function __construct(string $strNombre, string $strApellidos, int $intEdad, float $rlnSalario) {
        parent::__construct($strNombre, $strApellidos, $intEdad);
        $this->rlnSalario = $rlnSalario;
    }

    /**
     * Calcula el sueldo del gerente basado en su salario base y una bonificación en función de su edad.
     *
     * @return {float} - El sueldo calculado del gerente.
     */
    public function calcularSueldo(): float {
        return $this->rlnSalario + (($this->rlnSalario * $this->intEdad) / 100);
    }
}

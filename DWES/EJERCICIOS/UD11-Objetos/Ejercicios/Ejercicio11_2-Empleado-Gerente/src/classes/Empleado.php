<?php

namespace T11E2\Clases;

/**
 * Clase Empleado que hereda de Trabajador.
 */
class Empleado extends Trabajador {
    // ATRIBUTOS
    private int $intHorasTrabajadas = 0; // Atributo que almacena el número de horas trabajadas.
    private float $rlnPrecioPorHora = 0; // Atributo que almacena el precio por hora trabajada.

    /**
     * Constructor de la clase Empleado para inicializar sus propiedades.
     *
     * @param {string} $strNombre - El nombre del empleado.
     * @param {string} $strApellidos - Los apellidos del empleado.
     * @param {int} $intEdad - La edad del empleado.
     * @param {int} $intHorasTrabajadas - La cantidad de horas trabajadas por el empleado.
     * @param {float} $rlnPrecioPorHora - El precio por hora de trabajo del empleado.
     */
    public function __construct(string $strNombre, string $strApellidos, int $intEdad, int $intHorasTrabajadas, float $rlnPrecioPorHora) {
        parent::__construct($strNombre, $strApellidos, $intEdad);
        $this->intHorasTrabajadas = $intHorasTrabajadas;
        $this->rlnPrecioPorHora = $rlnPrecioPorHora;
    }

    /**
     * Calcula el sueldo del empleado multiplicando las horas trabajadas por el precio por hora.
     *
     * @return {float} - El sueldo del empleado.
     */
    public function calcularSueldo(): float {
        return $this->intHorasTrabajadas * $this->rlnPrecioPorHora;
    }
}

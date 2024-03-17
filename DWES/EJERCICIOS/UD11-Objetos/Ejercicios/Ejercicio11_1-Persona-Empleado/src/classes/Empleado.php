<?php

namespace T11E1\Clases;

/**
 * Clase Empleado que hereda de Persona.
 */
class Empleado extends Persona {
    // ATRIBUTOS
    public static float $rlnSueldoTope = 5000; // Atributo estático que almacenará el sueldo tope de todos los Empleados.
    private float $rlnSalario = 0; // Atributo que almacena el salario del empleado.
    private array $arrTelefonos = array(); // Atributo que almacena el array de teléfonos.

    /**
     * Constructor de la clase Empleado.
     *
     * @param {string} $strNombre - El nombre del empleado.
     * @param {string} $strApellido - El apellido del empleado.
     * @param {int} $intEdad - La edad del empleado.
     * @param {float} $rlnSalario - (Opcional) El salario del empleado, con un valor predeterminado de 1000 si no se especifica.
     */
    public function __construct(string $strNombre, string $strApellido, int $intEdad, float $rlnSalario = 1000) {
        // Llama al constructor de la clase base "Persona" para establecer el nombre, apellido y edad.
        Persona::__construct($strNombre, $strApellido, $intEdad);
        $this->rlnSalario = ($rlnSalario > Empleado::$rlnSueldoTope)
            ? Empleado::$rlnSueldoTope
            : $rlnSalario;
        // Inicializa un array vacío para almacenar los números de teléfono del empleado.
        $this->arrTelefonos = array();
    }

    /**
     * Establece el salario tope para todos los empleados.
     *
     * @param {float} $rlnSueldoTope - El salario tope que se desea establecer.
     * @return {void}
     */
    public static function setSueldoTope(float $rlnSueldoTope): void {
        Empleado::$rlnSueldoTope = $rlnSueldoTope;
    }

    /**
     * Obtiene el salario tope establecido para todos los empleados.
     *
     * @return {float} - El salario tope actual.
     */
    public static function getSueldoTope(): float {
        return Empleado::$rlnSueldoTope;
    }

    /**
     * Obtiene el salario del empleado.
     *
     * @return {float} - El salario del empleado.
     */
    public function getSalario(): float {
        return $this->rlnSalario;
    }

    /**
     * Obtiene los números de teléfono del empleado.
     *
     * @return {array} - Un array que contiene los números de teléfono del empleado.
     */
    public function getTelefonos(): array {
        return $this->arrTelefonos;
    }

    /**
     * Determina si el empleado debe pagar impuestos basándose en su edad y salario.
     *
     * @return {bool} - Verdadero si el empleado debe pagar impuestos, falso en caso contrario.
     */
    public function debePagarImpuestos(): bool {
        return ($this->intEdad >= 18 and $this->rlnSalario > 3333);
    }

    /**
     * Añade un número de teléfono al listado de números del empleado.
     *
     * @param {int} $intTelefono - El número de teléfono que se desea añadir.
     * @return {void}
     */
    public function anyadirTelefono(int $intTelefono): void {
        if ($this->esTelefonoValido($intTelefono)) {
            $this->arrTelefonos[] = $intTelefono;
        } else {
            echo '<p>El teléfono ' . $intTelefono . ' no es un teléfono válido.</p>';
        }
    }

    /**
     * Comprueba si un número de teléfono es válido.
     *
     * @param {int} $intTelefono - El número de teléfono a verificar.
     * @return {bool} - Devuelve true si el número es válido, de lo contrario, devuelve false.
     */
    private static function esTelefonoValido(int $intTelefono): bool {
        return preg_match("/(6|7|9)\d{8}/", $intTelefono);
    }

    /**
     * Obtiene una representación en formato de cadena de los números de teléfono del empleado.
     *
     * @return {string} - Una cadena que contiene los números de teléfono separados por comas, o "Listín vacío" si no hay números.
     */
    public function listarTelefonos(): string {
        return (empty($this->arrTelefonos)) ? 'Listín vacío.' : implode(', ', $this->arrTelefonos) . '.';
    }

    /**
     * Elimina todos los números de teléfono del empleado, vaciando el listado.
     *
     * @return {void}
     */
    public function vaciarTelefonos(): void {
        $this->arrTelefonos = array();
    }
}

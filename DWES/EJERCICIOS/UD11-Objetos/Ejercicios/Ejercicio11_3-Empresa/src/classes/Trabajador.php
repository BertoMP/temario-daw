<?php

namespace T11E3\Clases;

/**
 * Clase Trabajador que hereda de Persona.
 */
abstract class Trabajador extends Persona {
    // ATRIBUTOS
    protected array $arrTelefonos = array(); // Atributo que almacenará el listín de teléfonos.

    /**
     * Constructor de la clase Trabajador para inicializar sus propiedades.
     *
     * @param {string} $strNombre - El nombre de la persona.
     * @param {string} $strApellidos - Los apellidos de la persona.
     * @param {int} $intEdad - La edad de la persona.
     */
    public function __construct(string $strNombre, string $strApellidos, int $intEdad) {
        parent::__construct($strNombre, $strApellidos, $intEdad);
        $this->arrTelefonos = array();
    }

    /**
     * Método abstracto (sin implementación) para calcular el sueldo de un trabajador.
     * Debe ser implementado por las subclases.
     *
     * @return {float} - El sueldo calculado del trabajador.
     */
    public abstract function calcularSueldo(): float;

    /**
     * Determina si el trabajador debe pagar impuestos basándose en su edad y salario.
     *
     * @return {bool} - Verdadero si el trabajador debe pagar impuestos, falso en caso contrario.
     */
    public function debePagarImpuestos(): bool {
        return ($this->intEdad >= 18 and $this->calcularSueldo() > 3333);
    }

    /**
     * Obtiene los números de teléfono del trabajador.
     *
     * @return {array} - Un array que contiene los números de teléfono del trabajador.
     */
    public function getTelefonos(): array {
        return $this->arrTelefonos;
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
            echo '<p>El teléfono $intTelefono no es un teléfono válido.</p>';
        }
    }

    /**
     * Comprueba si un número de teléfono es válido.
     *
     * @param {int} $intTelefono - El número de teléfono a verificar.
     * @return {bool} - Devuelve true si el número es válido, de lo contrario, devuelve false.
     */
    private static function esTelefonoValido(int $intTelefono): bool {
        return preg_match('/(6|7|9)\d{8}/', $intTelefono);
    }

    /**
     * Obtiene una representación en formato de cadena de los números de teléfono del empleado.
     *
     * @return {string} - Una cadena que contiene los números de teléfono separados por comas, o 'Listín vacío' si no hay números.
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

    /**
     * Convierte un objeto de tipo Persona de subclase Trabajador en una representación HTML.
     *
     * @param {Persona} $objPersona - El objeto Persona que se desea convertir a HTML.
     * @return {string} - Una cadena HTML que representa la información del objeto Persona.
     */
    public static function toHTML(Persona $objPersona): string {
        $strHTMLReturn = '';
        if ($objPersona instanceof Trabajador) {
            $strHTMLReturn .=
                '<p><span>Nombre</span>: ' . $objPersona->getNombreCompleto() . (($objPersona instanceof Empleado) ? ' (Empleado)' : ' (Gerente)') . '</p>' .
                '<p><span>Edad</span>: ' . $objPersona->getEdad() . ' años</p>' .
                '<p><span>Salario</span>: ' . $objPersona->calcularSueldo() . '€</p>' .
                '<p><span>¿Debe pagar impuestos?</span> ' . ($objPersona->debePagarImpuestos() ? 'Sí' : 'No') . '</p>';
            $arrayTelefonos = $objPersona->getTelefonos();

            if (!empty($arrayTelefonos)) {
                $strHTMLReturn .= '<p>Listado de números</p><ol>';
                foreach ($arrayTelefonos as $strTelefono) {
                    $strHTMLReturn .= '<li>' . $strTelefono . '</li>';
                }
                $strHTMLReturn .= '</ol>';
            } else {
                $strHTMLReturn .= '<p>Este trabajador no tiene un listado de números.</p>';
            }

            return $strHTMLReturn;
        } else {
            return 'El objeto pasado por parámeto no es de tipo Empleado.';
        }
    }
}

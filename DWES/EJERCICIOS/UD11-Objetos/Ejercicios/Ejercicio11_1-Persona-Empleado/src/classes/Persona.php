<?php

namespace T11E1\Clases;

/**
 * Clase Persona.
 */
class Persona {
    // ATRIBUTOS
    protected string $strNombre = ''; // Atributo que almacena el nombre de la Persona.
    protected string $strApellidos = ''; // Atributo que almacena los apellidos de la Persona.
    protected int $intEdad = 0; // Atributo que almacena la edad de la Persona.

    /**
     * Constructor de la clase Persona para inicializar sus propiedades.
     *
     * @param {string} $strNombre - El nombre de la persona.
     * @param {string} $strApellidos - Los apellidos de la persona.
     * @param {int} $intEdad - La edad de la persona.
     */
    public function __construct(string $strNombre, string $strApellidos, int $intEdad) {
        $this->strNombre = $strNombre;
        $this->strApellidos = $strApellidos;
        $this->intEdad = $intEdad;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return {string} - El nombre de la persona.
     */
    public function getNombre(): string {
        return $this->strNombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return {string} - Los apellidos de la persona.
     */
    public function getApellidos(): string {
        return $this->strApellidos;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return {int} - La edad de la persona.
     */
    public function getEdad(): int {
        return $this->intEdad;
    }

    /**
     * Obtiene el nombre completo de la persona, que es la concatenación del nombre y los apellidos.
     *
     * @return {string} - El nombre completo de la persona.
     */
    protected function getNombreCompleto(): string {
        return $this->getNombre() . ' ' . $this->getApellidos();
    }

    /**
     * Convierte un objeto de tipo Persona de subclase Empleado en una representación HTML.
     *
     * @param {Persona} $objPersona - El objeto Persona que se desea convertir a HTML.
     * @return {string} - Una cadena HTML que representa la información del objeto Persona.
     */
    public static function toHTML(Persona $objPersona): string {
        $strHTMLReturn = '';
        if ($objPersona instanceof Empleado) {
            $strHTMLReturn .=
                '<p><span>Nombre</span>: ' . $objPersona->getNombreCompleto() . '</p>' .
                '<p><span>Edad</span>: ' . $objPersona->getEdad() . ' años</p>' .
                '<p><span>Salario</span>: ' . $objPersona->getSalario() . '€</p>' .
                '<p><span>¿Debe pagar impuestos?</span> ' . ($objPersona->debePagarImpuestos() ? 'Sí' : 'No') . '</p>';
            $arrayTelefonos = $objPersona->getTelefonos();

            if (!empty($arrayTelefonos)) {
                $strHTMLReturn .= '<p><span>Listado de números</span></p><ol>';
                foreach ($arrayTelefonos as $strTelefono) {
                    $strHTMLReturn .= '<li>' . $strTelefono . '</li>';
                }
                $strHTMLReturn .= '</ol>';
            } else {
                $strHTMLReturn .= '<p>Este empleado no tiene un listado de números.</p>';
            }
        } else {
            $strHTMLReturn .= '<p>El objeto pasado por parámetro no es de tipo Empleado.</p>';
        }
        return $strHTMLReturn;
    }
}

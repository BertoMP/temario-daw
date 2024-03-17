<?php

namespace T11E3\Clases;

/**
 * Clase Empresa
 */
class Empresa {
    // ATRIBUTOS
    private string $strNombre = ""; // Atributo que almacena el nombre de la Empresa.
    private string $strDireccion = ""; // Atributo que almacena la dirección de la Empresa.
    private array $arrTrabajadores = array(); // Atributo que almacena un array de trabajadores.

    /**
     * Constructor de la clase Empresa para inicializar sus propiedades.
     *
     * @param {string} $strNombre - El nombre de la empresa.
     * @param {string} $strDireccion - La dirección de la empresa.
     */
    public function __construct(string $strNombre, string $strDireccion) {
        $this->strNombre = $strNombre;
        $this->strDireccion = $strDireccion;
        $this->arrTrabajadores = array();
    }

    /**
     * Obtiene el nombre de la empresa.
     *
     * @return {string} - El nombre de la empresa.
     */
    public function getNombre(): string {
        return $this->strNombre;
    }

    /**
     * Obtiene la dirección de la empresa.
     *
     * @return {string} - La dirección de la empresa.
     */
    public function getDireccion(): string {
        return $this->strDireccion;
    }

    /**
     * Añade un trabajador a la lista de trabajadores de la empresa.
     *
     * @param {Trabajador} $objTrabajador - El objeto Trabajador que se desea añadir a la empresa.
     * @return {void}
     */
    public function anyadirTrabajador(Trabajador $objTrabajador): void {
        $this->arrTrabajadores[] = $objTrabajador;
    }

    /**
     * Genera una lista HTML de los trabajadores de la empresa.
     *
     * @return {string} - Una cadena HTML que representa la lista de trabajadores.
     */
    public function listaTrabajadoresHtml(): string {
        $strReturn = ""; // Variable que almacenará la cadena HTML a devolver.
        $intCont = 1; // Variable contador para enumerar cada trabajador.

        foreach ($this->arrTrabajadores as $trabajador) {
            $strReturn .= "<article><h5>Trabajador $intCont</h5>" . Trabajador::toHTML($trabajador) . '</article>';
            $intCont++;
        }

        return $strReturn;
    }

    /**
     * Calcula el costo total de las nóminas de los trabajadores de la empresa.
     *
     * @return {float} - El costo total de las nóminas de los trabajadores.
     */
    public function getCosteNominas(): float {
        $rlnTotalNominas = 0; // Variable contadora para la suma de los salarios.

        foreach ($this->arrTrabajadores as $trabajador) {
            if ($trabajador instanceof Trabajador) {
                $rlnTotalNominas += $trabajador->calcularSueldo();
            }
        }

        return $rlnTotalNominas;
    }
}

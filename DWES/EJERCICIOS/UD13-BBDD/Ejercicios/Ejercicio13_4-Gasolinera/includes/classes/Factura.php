<?php
// Clase Factura que hereda de Ticket.
class Factura extends Ticket {
    // ATRIBUTOS
    private string $strDNICliente; // String que almacena el DNI del cliente.
    private string $strMatricula; // String que almacena la matrícula del cliente.

    /**
     * Constructor de la clase.
     *
     * @param mixed $rlnImporte Importe a establecer.
     * @param string $strDNICliente Número de DNI del cliente.
     * @param string $strMatricula Número de matrícula del vehículo.
     */
    public function __construct($rlnImporte, $strDNICliente, $strMatricula) {
        parent::__construct($rlnImporte);
        $this->strDNICliente = $strDNICliente;
        $this->strMatricula = $strMatricula;
    }

    /**
     * Obtiene el número de DNI del cliente.
     *
     * @return string Número de DNI del cliente.
     */
    public function getDni(): string {
        return $this->strDNICliente;
    }

    /**
     * Obtiene el número de matrícula del vehículo.
     *
     * @return string Número de matrícula del vehículo.
     */
    public function getMatricula(): string {
        return $this->strMatricula;
    }
}
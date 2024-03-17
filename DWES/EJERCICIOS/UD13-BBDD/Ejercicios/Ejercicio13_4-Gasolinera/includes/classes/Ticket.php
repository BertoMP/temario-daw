<?php
// Clase Ticket.
class Ticket {
    protected string $strFecha; // String que almacena la fecha en formato YYYY-MM-DD.
    protected string $strHora; // String que almacena la hora en formato HH:MM:SS.
    protected float $rlnImporte; // Float que almacena el importe del ticket.

    /**
     * Constructor de la clase.
     *
     * @param float $rlnImporte El importe del ticket.
     */
    public function __construct($rlnImporte) {
        $this->strFecha = date('Y-m-d');
        $this->strHora = date('H:i:s');
        $this->rlnImporte = $rlnImporte;
    }

    /**
     * Obtiene la fecha del ticket.
     *
     * @return string Fecha del ticket en formato YYYY-MM-DD.
     */
    public function getFecha(): string {
        return $this->strFecha;
    }

    /**
     * Obtiene la hora del ticket.
     *
     * @return string Hora del ticket en formato HH:MM:SS.
     */
    public function getHora(): string {
        return $this->strHora;
    }

    /**
     * Obtiene el importe del ticket.
     *
     * @return float Importe del ticket.
     */
    public function getImporte(): float {
        return $this->rlnImporte;
    }
}
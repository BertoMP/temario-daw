<?php

class Ticket{
    private string $fecha;
    private float $dblImporte;

    /**
     * @param int $fecha
     * @param float $dblImporte
     */
    public function __construct(float $importe){
        $this->fecha = date('d/m/y-H:i:s');
        $this->dblImporte = $importe;
    }

    public function getFecha(): string{
        return $this->fecha;
    }

    public function getdblImporte(): float{
        return $this->dblImporte;
    }

    public function __toString(): string{
        return 'Ticket: Importe->' . $this->getdblImporte() . ', Fecha->' . $this->getFecha();
    }


}
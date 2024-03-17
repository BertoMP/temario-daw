<?php
class Factura extends Ticket{
    private string $strDNI;
    private string $strMatricula;

    /**
     * @param string $strDNI
     * @param string $strMatricula
     */
    public function __construct(float $importe, string $strDNI, string $strMatricula){
        Ticket::__construct($importe);
        $this->strDNI = $strDNI;
        $this->strMatricula = $strMatricula;
    }

    public function getStrDNI(): string{
        return $this->strDNI;
    }

    public function getStrMatricula(): string{
        return $this->strMatricula;
    }

    public function __toString(): string{
       return 'Factura: DNI->' . $this->getStrDNI() . ', Matricula->' . $this->getStrMatricula()
            . ', Importe->' . parent::getdblImporte() . ', fecha_>' . parent::getFecha();
    }


}
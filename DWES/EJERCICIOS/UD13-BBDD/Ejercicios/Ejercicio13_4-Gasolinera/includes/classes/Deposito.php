<?php
// Clase Deposito.
class Deposito {
    // ATRIBUTOS
    private float $rlnLitrosSuministrados; // Float que almacena los litros suministrados.
    private string $strCombustible; // String que almacena el tipo de combustible.
    private float $rlnImporteTotal; // Float que almacena el importe

    /**
     * Constructor de la clase que inicializa los valores del suministro de combustible.
     *
     * @param   float   $rlnLitrosSuministrados   Cantidad de litros suministrados.
     * @param   string  $strCombustible           Tipo de combustible suministrado.
     * @param   float   $rlnImporteTotal          Importe total del suministro.
     */
    public function __construct(float $rlnLitrosSuministrados, string $strCombustible, float $rlnImporteTotal) {
        $this->rlnLitrosSuministrados = $rlnLitrosSuministrados;
        $this->strCombustible = Deposito::traduceCombustible($strCombustible);
        $this->rlnImporteTotal = $rlnImporteTotal;
    }

    /**
     * Obtiene la cantidad de litros suministrados.
     *
     * @return  float   Cantidad de litros suministrados.
     */
    public function getLitrosSuministrados(): float {
        return $this->rlnLitrosSuministrados;
    }

    /**
     * Obtiene el tipo de combustible suministrado.
     *
     * @return  string  Tipo de combustible suministrado.
     */
    public function getCombustible(): string {
        return $this->strCombustible;
    }

    /**
     * Obtiene el importe total del suministro.
     *
     * @return  float   Importe total del suministro.
     */
    public function getImporteTotal(): float {
        return $this->rlnImporteTotal;
    }

    /**
     * Traduce el tipo de combustible recibido a un formato legible.
     *
     * @param   string  $strCombustible Tipo de combustible a traducir.
     * @return  string  Tipo de combustible traducido.
     */
    private static function traduceCombustible($strCombustible): string {
        return match($strCombustible) {
            'gasoil' => 'Gasoil',
            'gasolina-95' => 'Gasolina 95',
            'gasolina-98' => 'Gasolina 98',
            'gasoil-agricola' => 'Gasoil agrícola',
        };
    }
}
package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto28_Brisca.clases;

import tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto28_Brisca.enumerados.NumeroCarta;
import tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto28_Brisca.enumerados.PaloBaraja;

/***********************************************************************************************************************
 * Clase carta.                                                                                                        *
 ***********************************************************************************************************************/

public class Carta {
    //DECLARACIÓN DE ATRIBUTOS
    private PaloBaraja paloBaraja; //Palo de la baraja al que corresponde la carta.
    private NumeroCarta numeroCarta; //Número de la carta.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param paloBaraja Palo de la baraja.                                                                            *
     * @param numeroCarta Número de la carta.                                                                          *
     *******************************************************************************************************************/
    public Carta(PaloBaraja paloBaraja, NumeroCarta numeroCarta) {
        this.paloBaraja = paloBaraja;
        this.numeroCarta = numeroCarta;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el número de la carta.                                               *
     *                                                                                                                 *
     * @return Devuelve un String con el número de la carta.                                                           *
     *******************************************************************************************************************/
    public String getStrNumeroCarta() {
        return String.valueOf(this.numeroCarta);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los valores de los atributos de la carta.                            *
     *                                                                                                                 *
     * @return Devuelve un String con los datos de la carta.                                                           *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return this.numeroCarta + " de " + this.paloBaraja;
    }
}

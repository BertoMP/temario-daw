package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.clases.instrumento;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.enumerados.NotaMusical;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Campana.                                                                 *
 ***********************************************************************************************************************/
public class Campana extends Instrumento {
    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Campana() {
        super();
    }

    /*******************************************************************************************************************
     * Método encargado de interpretar la melodía.                                                                     *
     *******************************************************************************************************************/
    public void interpretar() {
        for (NotaMusical notaMusical : melodia) {
            switch (notaMusical) {
                case DO -> System.out.print("dong ");
                case RE -> System.out.print("reng ");
                case MI -> System.out.print("ming ");
                case FA -> System.out.print("fang ");
                case SOL -> System.out.print("solng ");
                case LA -> System.out.print("lang ");
                case SI -> System.out.print("sing ");
            }
        }
        System.out.println();
    }
}

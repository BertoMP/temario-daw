package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.clases.instrumento;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.enumerados.NotaMusical;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Piano.                                                                   *
 ***********************************************************************************************************************/
public class Piano extends Instrumento {
    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Piano() {
        super();
    }

    /*******************************************************************************************************************
     * Método encargado de interpretar la melodía.                                                                     *
     *******************************************************************************************************************/
    public void interpretar() {
        for (NotaMusical notaMusical : melodia) {
            switch (notaMusical) {
                case DO -> System.out.print("do ");
                case RE -> System.out.print("re ");
                case MI -> System.out.print("mi ");
                case FA -> System.out.print("fa ");
                case SOL -> System.out.print("sol ");
                case LA -> System.out.print("la ");
                case SI -> System.out.print("si ");
            }
        }
        System.out.println();
    }
}
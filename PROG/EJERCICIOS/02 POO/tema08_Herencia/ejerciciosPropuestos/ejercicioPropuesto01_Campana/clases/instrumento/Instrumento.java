package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.clases.instrumento;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.enumerados.NotaMusical;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase abstracta de tipo Instrumento.                                                                                *
 ***********************************************************************************************************************/
public abstract class Instrumento {
    //DECLARACIÓN DE VARIABLES
    protected NotaMusical[] melodia; //Array de tipo NotaMusical que guardará las notas.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Instrumento() {
        melodia = new NotaMusical[0];
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la longitud de la melodía.                                                         *
     *******************************************************************************************************************/
    public int dimeLongitudMelodia() {
        return this.melodia.length;
    }

    /*******************************************************************************************************************
     * Método encargado de introducir la notaMusical que se pasa por parámetro en el array melodia.                    *
     *                                                                                                                 *
     * @param notaMusical Nota musical a introducir.                                                                   *
     *******************************************************************************************************************/
    public void add(NotaMusical notaMusical) {
        melodia = Arrays.copyOf(melodia, melodia.length + 1);
        melodia[melodia.length - 1] = notaMusical;
    }

    /*******************************************************************************************************************
     * Método abstracto utilizado para interpretar el array melodia en las clases que hereden.                         *
     *******************************************************************************************************************/
    protected abstract void interpretar();
}
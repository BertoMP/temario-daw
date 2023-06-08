package tema08_Herencia.ejerciciosResueltos.ejercicioResuelto04_Instrumento.clases;

import java.util.Arrays;

/***********************************************************************************************************************
 * Crear la clase abstracta Instrumento, que almacena en una tabla las notas musicales de una melodía (dentro de una   *
 * misma octava). El método add() añade nuevas notas musicales. La clase también dispone del método abstracto          *
 * interpretar() que, en cada subclase que herede de Instrumento, mostrará por consola las notas musicales según las   *
 * interprete. Utilizar enumerados para definir las notas musicales.                                                   *
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


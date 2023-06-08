package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto10_colaLista.clases;
import java.util.Arrays;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Lista y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE VARIABLES
    private Integer[] integerNumeros; //Array de Integers

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Lista() {
        this.integerNumeros = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método que insertaFinal un número al final de la lista.                                                              *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void inserta(int intNum) {
        this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length + 1);
        this.integerNumeros[integerNumeros.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el número del índice que se pasa como parámetro.                                   *
     *                                                                                                                 *
     * @param intIndice Siguiente índice a eliminar (en este caso siempre será el índice 0, el primero de la cola).    *
     * @return Se devuelve el Integer que se encontraba en esa posición. Si ya no existen números en el array,         *
     *         se devuelve un null.                                                                                    *
     *******************************************************************************************************************/
    public Integer elimina(int intIndice) {
        Integer numeroReturn = null;

        if (this.integerNumeros.length != intIndice) {
            numeroReturn = this.integerNumeros[intIndice];
            System.arraycopy(this.integerNumeros, intIndice + 1, this.integerNumeros, intIndice,
                    this.integerNumeros.length - (intIndice + 1));
            this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length - 1);
        }

        return numeroReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los elementos de la Lista.                                           *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la lista.                                                       *
     *******************************************************************************************************************/
    public String muestraElementos() {
        return Arrays.toString(this.integerNumeros);
    }
}

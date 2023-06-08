package tema07_Clases.ejerciciosResueltos.ejercicioResuelto13_pila.clases;
import java.util.Arrays;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Lista y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE VARIABLES
    private Integer[] integerArray; //Array que guardará los int de la lista.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Lista() {
        this.integerArray = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método get para devolver el array de Intergers.                                                                 *
     *                                                                                                                 *
     * @return Devuelve el array de Integers.                                                                          *
     *******************************************************************************************************************/
    public Integer[] getIntegerArray() {
        return integerArray;
    }

    /*******************************************************************************************************************
     * Método que insertaFinal un Integer al final de la lista.                                                             *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void insertarFinal(int intNum) {
        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length + 1);
        this.integerArray[integerArray.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el Integer del índice que se pasa como parámetro.                                  *
     *                                                                                                                 *
     * @param intIndice Índice del array que contiene el Integer a eliminar.                                           *
     * @return Se devuelve el Integer que se encontraba en esa posición. Si se introduce una posición no válida,       *
     *         se devuelve el valor null.                                                                              *
     *******************************************************************************************************************/
    public Integer elimina(int intIndice) {
        Integer numero = null;

        if (intIndice >= 0 && intIndice < integerArray.length) {
            numero = integerArray[intIndice];
            integerArray[intIndice] = integerArray[integerArray.length - 1];
            integerArray = Arrays.copyOf(integerArray, integerArray.length - 1);
        }

        return numero;
    }
}

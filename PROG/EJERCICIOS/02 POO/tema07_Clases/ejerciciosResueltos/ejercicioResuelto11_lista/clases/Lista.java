package tema07_Clases.ejerciciosResueltos.ejercicioResuelto11_lista.clases;
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
     * Método que devuelve el número de elementos de la lista.                                                         *
     *                                                                                                                 *
     * @return Número de elementos de la lista.                                                                        *
     *******************************************************************************************************************/
    public int numeroElementos() {
        return integerArray.length;
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
     * Método que insertaFinal un Integer al inicio de la lista.                                                            *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void insertarInicio(int intNum) {
        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length + 1);
        System.arraycopy(this.integerArray, 0, this.integerArray, 1, this.integerArray.length - 1);
        integerArray[0] = intNum;
    }

    /*******************************************************************************************************************
     * Método que insertaFinal un Integer en una posición de la lista.                                                      *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     * @param intPosicion Posición donde se debe añadir el nuevo número.                                               *
     *******************************************************************************************************************/
    public void insertarEnLugar(int intNum, int intPosicion) {
        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length + 1);
        System.arraycopy(this.integerArray, intPosicion, this.integerArray, intPosicion + 1,
                this.integerArray.length - (intPosicion + 1));
        this.integerArray[intPosicion] = intNum;
    }

    /*******************************************************************************************************************
     * Método que insertaFinal al final de la lista otra lista que se pase por parámetro.                                   *
     *                                                                                                                 *
     * @param otraLista Lista que se debe añadir.                                                                      *
     *******************************************************************************************************************/
    public void anadeOtraLista(Lista otraLista) {
        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length
                + otraLista.integerArray.length);
        System.arraycopy(otraLista.integerArray, 0, this.integerArray,
                this.integerArray.length - otraLista.integerArray.length,
                otraLista.integerArray.length);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el Integer del índice que se pasa como parámetro.                                  *
     *                                                                                                                 *
     * @param intIndice Índice del array que contiene el Integer a eliminar.                                           *
     *******************************************************************************************************************/
    public void elimina(int intIndice) {
        if (intIndice >= 0 && intIndice < integerArray.length) {
            integerArray[intIndice] = integerArray[integerArray.length - 1];
            integerArray = Arrays.copyOf(integerArray, integerArray.length - 1);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de buscar el Integer del índice que se pasa como parámetro.                                    *
     *                                                                                                                 *
     * @param intIndice Índice del array que contiene el Integer a buscar.                                             *
     * @return Se devuelve el Integer que se encontraba en esa posición. Si se introduce una posición no válida,       *
     *         se devuelve el valor null.                                                                              *
     ******************************************************************************************************************/
    public int dimeElemento(int intIndice) {
        if (intIndice >= 0 && intIndice < integerArray.length) {
            return integerArray[intIndice];
        } else {
            return -1;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de buscar el índice del Integer que se pasa como parámetro.                                    *
     *                                                                                                                 *
     * @param intNum Integer a buscar.                                                                                 *
     * @return Se devuelve la posición del Integer (en caso de no existir se devuelve -1).                             *
     *******************************************************************************************************************/
    public int buscaElemento(int intNum) {
        for (int intCont = 0; intCont < integerArray.length; intCont++) {
            if (integerArray[intCont] == (intNum)) {
                return intCont;
            }
        }
        return -1;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos de la lista.                                                          *
     *******************************************************************************************************************/
    public void muestraLista() {
        System.out.println("Los elementos de la lista son: " + Arrays.toString(integerArray));
    }
}

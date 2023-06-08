package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto10_ConjuntoExtendsListaEquals.clases.lista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Lista y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE VARIABLES
    protected Integer[] integerArray; //Array que guardará los int de la lista.

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
        return this.integerArray.length;
    }

    /*******************************************************************************************************************
     * Método que insertaFinal un Integer al final de la lista.                                                        *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void insertarFinal(int intNum) {
        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length + 1);
        this.integerArray[this.integerArray.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método que insertaFinal un Integer al inicio de la lista.                                                       *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void insertarInicio(int intNum) {
        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length + 1);
        System.arraycopy(this.integerArray, 0, this.integerArray, 1, this.integerArray.length - 1);
        this.integerArray[0] = intNum;
    }

    /*******************************************************************************************************************
     * Método que inserta un Integer en una posición de la lista.                                                      *
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
     * Método que inserta al final de la lista otra lista que se pase por parámetro.                                   *
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
        if (intIndice >= 0 && intIndice < this.integerArray.length) {
            System.arraycopy(this.integerArray, intIndice + 1, this.integerArray, intIndice,
                    this.integerArray.length - (intIndice + 1));
            this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length - 1);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de buscar el Integer del índice que se pasa como parámetro.                                    *
     *                                                                                                                 *
     * @param intIndice Índice del array que contiene el Integer a buscar.                                             *
     * @return Se devuelve el Integer que se encontraba en esa posición. Si se introduce una posición no válida,       *
     *         se devuelve el valor null.                                                                              *
     ******************************************************************************************************************/
    public Integer dimeElemento(int intIndice) {
        if (intIndice >= 0 && intIndice < this.integerArray.length) {
            return this.integerArray[intIndice];
        } else {
            return null;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de buscar el índice del Integer que se pasa como parámetro.                                    *
     *                                                                                                                 *
     * @param intNum Integer a buscar.                                                                                 *
     * @return Se devuelve la posición del Integer (en caso de no existir se devuelve -1).                             *
     *******************************************************************************************************************/
    public int buscaElemento(int intNum) {
        for (int intCont = 0; intCont < this.integerArray.length; intCont++) {
            if (this.integerArray[intCont] == (intNum)) {
                return intCont;
            }
        }
        return -1;
    }

    /*******************************************************************************************************************
     * Método encargado de comparar dos listas.                                                                        *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un booleano en función de si son listas idénticas (true) o no (false).                         *
     *******************************************************************************************************************/
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || this.getClass() != objeto.getClass()) {
            return false;
        }

        Lista otraLista = (Lista) objeto;

        if (this.integerArray.length != otraLista.integerArray.length) {
            return false;
        }

        for (int intCont = 0; intCont < this.integerArray.length; intCont++) {
            if (!this.integerArray[intCont].equals(otraLista.integerArray[intCont])) {
                return false;
            }
        }
        return true;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos de la lista.                                                          *
     *******************************************************************************************************************/
    @Override
    public String toString() {
       return "Los elementos de la lista son: " + Arrays.toString(this.integerArray);
    }
}

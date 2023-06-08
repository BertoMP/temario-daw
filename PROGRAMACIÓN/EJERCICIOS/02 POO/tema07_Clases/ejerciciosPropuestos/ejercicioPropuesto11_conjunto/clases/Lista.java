package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto11_conjunto.clases;
import java.util.Arrays;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Lista y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE VARIABLES
    private Integer[] integerArray; //Array de integers donde se guardarán los elementos de la lista.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.integerArray = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el número de elementos de un conjunto.                                             *
     *                                                                                                                 *
     * @return Devuelve un int con el número de elementos.                                                             *
     *******************************************************************************************************************/
    public int numeroElementos() {
        return this.integerArray.length;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar un número en la lista si no existe en ella y de devolver un booleano en            *
     * función de si se ha insertado (true) o no (false).                                                              *
     *                                                                                                                 *
     * @return Devuelve un booleano en función de si se ha insertado o no.                                             *
     *******************************************************************************************************************/

     public boolean inserta(int intNum) {
        for (Integer integerValor : this.integerArray) {
            if (integerValor.equals(intNum)) {
                return false;
            }
        }

        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length + 1);
        this.integerArray[integerArray.length - 1] = intNum;
        return true;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar otra lista en la lista de devolver un booleano en función de si se ha modificado   *
     * (true) o no (false).                                                                                            *
     *                                                                                                                 *
     * @param otraLista Objeto de tipo lista.                                                                          *
     * @param intNum Opción seleccionada por el usuario.                                                               *
     * @return Devuelve un booleano en función de si se ha modificado o no.                                            *
     *******************************************************************************************************************/
    public boolean anadeOtraLista(Lista otraLista, int intNum) {
        boolean blnModificado = false;

        if (intNum == 1) {
            for (Integer integerValorOtra : otraLista.integerArray) {
                for (Integer integerValorThis : this.integerArray) {
                    if (integerValorOtra.equals(integerValorThis)) {
                        return false;
                    }
                }
            }

            this.integerArray = Arrays.copyOf(this.integerArray,
                    this.integerArray.length + otraLista.integerArray.length);
            System.arraycopy(otraLista.integerArray, 0, this.integerArray,
                    this.integerArray.length - otraLista.integerArray.length, otraLista.integerArray.length);
            return true;
        } else {
            for (int intCont = 0; intCont < otraLista.integerArray.length; intCont++) {
                for (Integer integerValorThis : this.integerArray) {
                    if (integerValorThis.equals(otraLista.integerArray[intCont])) {
                        this.inserta(otraLista.integerArray[intCont]);
                        blnModificado = true;
                    }
                }
            }
            return blnModificado;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar un elemento en la lista si existe en ella y de devolver un booleano en             *
     * función de si se ha eliminado (true) o no (false).                                                              *
     *                                                                                                                 *
     * @param intNum Número a eliminar.                                                                                *
     * @return Devuelve un booleano en función de si se ha eliminado o no.                                             *
     *******************************************************************************************************************/
    public boolean elimina(int intNum) {
        for (int intCont = 0; intCont < this.integerArray.length; intCont++) {
            if (this.integerArray[intCont].equals(intNum)) {
                this.integerArray[intCont] = this.integerArray[this.integerArray.length - 1];
                this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length - 1);
                return true;
            }
        }
        return false;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar otra lista en la lista de devolver un booleano en función de si se ha modificado   *
     * (true) o no (false).                                                                                            *
     *                                                                                                                 *
     * @param otraLista Objeto de tipo lista.                                                                          *
     * @param intNum Opción seleccionada por el usuario.                                                               *
     * @return Devuelve un booleano en función de si se ha modificado o no.                                            *
     *******************************************************************************************************************/
    public boolean eliminaOtraLista(Lista otraLista, int intNum) {
        boolean blnModificado = false;
        int intContador = 0;

        if (intNum == 1) {
            for (Integer integer : otraLista.integerArray) {
                if (this.buscaElemento(integer)) {
                    intContador++;
                }
            }

            if (intContador == otraLista.integerArray.length) {
                for (int intCont = 0; intCont < otraLista.integerArray.length; intCont++) {
                    this.elimina(otraLista.integerArray[intCont]);
                }
                return true;
            }

        } else {
            for (int intCont = 0; intCont < otraLista.integerArray.length; intCont++) {
                if (this.buscaElemento(otraLista.integerArray[intCont])) {
                    this.elimina(otraLista.integerArray[intCont]);
                    blnModificado = true;
                }
            }
        }
        return blnModificado;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos de una lista.                                                         *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la lista.                                                       *
     *******************************************************************************************************************/
    public String muestraLista() {
        return Arrays.toString(this.integerArray);
    }

    /*******************************************************************************************************************
     * Método encargado de buscar un elemento en la lista y de devolver un booleano en función de si se existe         *
     * (true) o no (false).                                                                                            *
     *                                                                                                                 *
     * @param intNum Número a buscar.                                                                                  *
     * @return Devuelve un booleano en función de si existe o no el número en la lista.                                *
     *******************************************************************************************************************/
    public boolean buscaElemento(int intNum) {
        for (Integer integerValor : this.integerArray) {
            if (integerValor.equals(intNum)) {
                return true;
            }
        }
        return false;
    }
}

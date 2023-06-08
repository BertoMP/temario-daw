package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto01_ListaString.clases;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase de tipo Lista para elementos de tipo String.                                                                  *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE ATRIBUTOS
    private String[] strArrCadena; //Array que guardará los elementos String.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.strArrCadena = new String[0];
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el número de elementos que forman el array.                                        *
     *                                                                                                                 *
     * @return Devuelve un int con el número de elementos.                                                             *
     *******************************************************************************************************************/
    public int numeroElementos() {
        return this.strArrCadena.length;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al inicio del array un nuevo elemento.                                             *
     *                                                                                                                 *
     * @param strNuevo String a insertar.                                                                              *
     *******************************************************************************************************************/
    public void insertaPrincipio(String strNuevo) {
        this.strArrCadena = Arrays.copyOf(this.strArrCadena, this.strArrCadena.length + 1);
        System.arraycopy(this.strArrCadena, 0, this.strArrCadena, 1, this.strArrCadena.length - 1);
        this.strArrCadena[0] = strNuevo;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al final del array un nuevo elemento.                                              *
     *                                                                                                                 *
     * @param strNuevo String a insertar.                                                                              *
     *******************************************************************************************************************/
    public void insertaFinal(String strNuevo) {
        this.strArrCadena = Arrays.copyOf(this.strArrCadena, this.strArrCadena.length + 1);
        this.strArrCadena[this.strArrCadena.length - 1] = strNuevo;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al final del array una nueva lista.                                                *
     *                                                                                                                 *
     * @param otraLista Lista de String a insertar.                                                                    *
     *******************************************************************************************************************/
    public void insertaFinal(Lista otraLista) {
        this.strArrCadena = Arrays.copyOf(this.strArrCadena, this.strArrCadena.length
                + otraLista.strArrCadena.length);
        System.arraycopy(otraLista.strArrCadena, 0, this.strArrCadena,
                this.strArrCadena.length - otraLista.strArrCadena.length, otraLista.strArrCadena.length);
    }

    /*******************************************************************************************************************
     * Método encargado de insertar en una posición n del array un nuevo elemento.                                     *
     *                                                                                                                 *
     * @param intPosicion Índice de inserción.                                                                         *
     * @param strNuevo String a insertar.                                                                              *
     *******************************************************************************************************************/
    public void insertaLugar(int intPosicion, String strNuevo) {
        this.strArrCadena = Arrays.copyOf(this.strArrCadena, this.strArrCadena.length + 1);
        System.arraycopy(this.strArrCadena, intPosicion, this.strArrCadena, intPosicion + 1,
                this.strArrCadena.length - intPosicion - 1);
        this.strArrCadena[intPosicion] = strNuevo;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el elemento del array de la posición que se pasa como parámetro.                   *
     *                                                                                                                 *
     * @param intPosicion Índice de eliminación.                                                                       *
     * @return Se devuelve el String eliminado, en caso de que se haya insertado una posición no válida,               *
     *         se devuelve un null.                                                                                    *
     *******************************************************************************************************************/
    public String elimina(int intPosicion) {
        String strReturn = null;

        if (intPosicion >= 0 && intPosicion < this.strArrCadena.length) {
            strReturn = this.strArrCadena[intPosicion];
            System.arraycopy(this.strArrCadena, intPosicion + 1, this.strArrCadena, intPosicion,
                    this.strArrCadena.length - intPosicion - 1);
            this.strArrCadena = Arrays.copyOf(this.strArrCadena, this.strArrCadena.length - 1);
        }

        return strReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el String que se encuentra en la posición que se pasa como parámetro.              *
     *                                                                                                                 *
     * @param intPosicion Índice de búsqueda.                                                                          *
     * @return Se devuelve el String de la posición indicada, en caso de que se haya insertado una posición            *
     *         no válida, se devuelve un null.                                                                         *
     *******************************************************************************************************************/
    public String dimeString(int intPosicion) {
        String strReturn = null;

        if (intPosicion >= 0 && intPosicion < this.strArrCadena.length) {
            strReturn = this.strArrCadena[intPosicion];
        }

        return strReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la posición en la que se encuentra un String pasado por parámetro.                 *
     *                                                                                                                 *
     * @param strBusqueda String a buscar.                                                                             *
     * @return Se devuelve la posición en la que se encuentra el String. En caso de no encontrarlo, se devuelve -1.    *
     *******************************************************************************************************************/
    public int buscar(String strBusqueda) {
        int intReturn = -1;

        for (int intCont = 0; intCont < this.strArrCadena.length; intCont++) {
            if (this.strArrCadena[intCont].equals(strBusqueda)) {
                return intCont;
            }
        }
        return intReturn;
    }

    /*******************************************************************************************************************
     * Método que devuelve un String con los elementos de la lista.                                                    *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la lista.                                                       *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Los elementos de la lista son: " + Arrays.deepToString(this.strArrCadena);
    }
}

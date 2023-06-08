package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto17_ListaSocioOrdenAlfabetico.clases;

import java.util.Arrays;
import java.util.Comparator;

/***********************************************************************************************************************
 * Clase Lista.                                                                                                        *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE ATRIBUTOS
    private Socio[] arrSocios; //Array de Socio.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.arrSocios = new Socio[0];
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un int con el número de elementos del array.                                       *
     *                                                                                                                 *
     * @return Devuelve un int con el número de elementos del array.                                                   *
     *******************************************************************************************************************/
    public int numeroElementos() {
        return this.arrSocios.length;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al inicio del array un nuevo elemento.                                             *
     *                                                                                                                 *
     * @param socio Socio a insertar.                                                                                  *
     *******************************************************************************************************************/
    public void insertarPrincipio(Socio socio) {
        this.arrSocios = Arrays.copyOf(this.arrSocios, this.arrSocios.length + 1);
        System.arraycopy(this.arrSocios, 0, this.arrSocios, 1, this.arrSocios.length - 1);
        this.arrSocios[0] = socio;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al final del array un nuevo elemento.                                              *
     *                                                                                                                 *
     * @param socio Socio a insertar.                                                                                  *
     *******************************************************************************************************************/
    public void insertarFinal(Socio socio) {
        this.arrSocios = Arrays.copyOf(this.arrSocios, this.arrSocios.length + 1);
        this.arrSocios[this.arrSocios.length - 1] = socio;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al final del array una nueva lista.                                                *
     *                                                                                                                 *
     * @param otraLista Lista de String a insertar.                                                                    *
     *******************************************************************************************************************/
    public void insertarFinal(Lista otraLista) {
        this.arrSocios = Arrays.copyOf(this.arrSocios, this.arrSocios.length + otraLista.arrSocios.length);
        System.arraycopy(otraLista.arrSocios, 0, this.arrSocios,
                this.arrSocios.length - otraLista.arrSocios.length, otraLista.arrSocios.length);
    }

    /*******************************************************************************************************************
     * Método encargado de insertar en una posición n del array un nuevo elemento.                                     *
     *                                                                                                                 *
     * @param intPosicion Índice de inserción.                                                                         *
     * @param socio Socio a insertar.                                                                                  *
     *******************************************************************************************************************/
    public void insertarPosicion(int intPosicion, Socio socio) {
        this.arrSocios = Arrays.copyOf(this.arrSocios, arrSocios.length + 1);
        System.arraycopy(this.arrSocios, intPosicion, this.arrSocios, intPosicion + 1,
                this.arrSocios.length - intPosicion - 1);
        this.arrSocios[intPosicion] = socio;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el elemento del array de la posición que se pasa como parámetro.                   *
     *                                                                                                                 *
     * @param intPosicion Índice de eliminación.                                                                       *
     * @return Se devuelve el Socio eliminado, en caso de que se haya insertado una posición no válida,                *
     *         se devuelve un null.                                                                                    *
     *******************************************************************************************************************/
    public Socio eliminar(int intPosicion) {
        Socio socioEliminado = null;

        if (intPosicion >= 0 && intPosicion < this.arrSocios.length) {
            socioEliminado = this.arrSocios[intPosicion];
            System.arraycopy(this.arrSocios, intPosicion + 1, this.arrSocios, intPosicion,
                    this.arrSocios.length - intPosicion - 1);
            this.arrSocios = Arrays.copyOf(arrSocios, arrSocios.length - 1);
        }
        return socioEliminado;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el elemento que se encuentra en la posición que se pasa como parámetro.            *
     *                                                                                                                 *
     * @param intPosicion Índice de búsqueda.                                                                          *
     * @return Se devuelve el Socio de la posición indicada, en caso de que se haya insertado una posición             *
     *         no válida, se devuelve un null.                                                                         *
     *******************************************************************************************************************/
    public Socio dimeObjeto(int intPosicion) {
        Socio socioReturn = null;

        if (intPosicion >= 0 && intPosicion < this.arrSocios.length) {
            socioReturn = this.arrSocios[intPosicion];
        }
        return socioReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la posición en la que se encuentra un Object pasado por parámetro.                 *
     *                                                                                                                 *
     * @param socioBusqueda Socio a buscar.                                                                            *
     * @return Se devuelve la posición en la que se encuentra el Object. En caso de no encontrarlo, se devuelve -1.    *
     *******************************************************************************************************************/
    public int buscaObjeto(Socio socioBusqueda) {
        int intIndice = -1;

        for (int intCont = 0; intCont < this.arrSocios.length; intCont++) {
            if (arrSocios[intCont].equals(socioBusqueda)) {
                return intCont;
            }
        }
        return intIndice;
    }

    /*******************************************************************************************************************
     * Método encargado de ordenar el array.                                                                           *
     *******************************************************************************************************************/
    public void ordenar() {
        Arrays.sort(this.arrSocios);
    }

    /*******************************************************************************************************************
     * Método encargado de ordenar el array en base al Comparator pasado por parámetro.                                *
     *                                                                                                                 *
     * @param comparador Comparator con orden de ordenamiento.                                                         *
     *******************************************************************************************************************/
    public void ordenar(Comparator comparador) {
        Arrays.sort(this.arrSocios, comparador);
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir por pantalla los elementos del array.                                              *
     *******************************************************************************************************************/
    public void imprimeArray() {
        for (int intCont = 0; intCont < this.arrSocios.length; intCont++) {
            System.out.println("[" + (intCont + 1) + "] " + this.arrSocios[intCont]);
        }
    }
}

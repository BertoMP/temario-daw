package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaArrayBidimensional.clases;

import java.util.Arrays;
import java.util.Comparator;

/***********************************************************************************************************************
 * Clase Lista.                                                                                                        *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE ATRIBUTOS
    private Object[] arrObjetos; //Array de Object.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.arrObjetos = new Object[0];
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un int con el número de elementos del array.                                       *
     *                                                                                                                 *
     * @return Devuelve un int con el número de elementos del array.                                                   *
     *******************************************************************************************************************/
    public int numeroElementos() {
        return this.arrObjetos.length;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al inicio del array un nuevo elemento.                                             *
     *                                                                                                                 *
     * @param objeto Object a insertar.                                                                                *
     *******************************************************************************************************************/
    public void insertarPrincipio(Object objeto) {
        this.arrObjetos = Arrays.copyOf(this.arrObjetos, this.arrObjetos.length + 1);
        System.arraycopy(this.arrObjetos, 0, this.arrObjetos, 1, this.arrObjetos.length - 1);
        this.arrObjetos[0] = objeto;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al final del array un nuevo elemento.                                              *
     *                                                                                                                 *
     * @param objeto Object a insertar.                                                                                *
     *******************************************************************************************************************/
    public void insertarFinal(Object objeto) {
        this.arrObjetos = Arrays.copyOf(this.arrObjetos, this.arrObjetos.length + 1);
        this.arrObjetos[this.arrObjetos.length - 1] = objeto;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al final del array una nueva lista.                                                *
     *                                                                                                                 *
     * @param otraLista Lista de String a insertar.                                                                    *
     *******************************************************************************************************************/
    public void insertarFinal(Lista otraLista) {
        this.arrObjetos = Arrays.copyOf(this.arrObjetos,
                this.arrObjetos.length + otraLista.arrObjetos.length);
        System.arraycopy(otraLista.arrObjetos, 0, this.arrObjetos,
                this.arrObjetos.length - otraLista.arrObjetos.length, otraLista.arrObjetos.length);
    }

    /*******************************************************************************************************************
     * Método encargado de insertar en una posición n del array un nuevo elemento.                                     *
     *                                                                                                                 *
     * @param intPosicion Índice de inserción.                                                                         *
     * @param objeto Object a insertar.                                                                                *
     *******************************************************************************************************************/
    public void insertarPosicion(int intPosicion, Object objeto) {
        this.arrObjetos = Arrays.copyOf(this.arrObjetos, arrObjetos.length + 1);
        System.arraycopy(this.arrObjetos, intPosicion, this.arrObjetos, intPosicion + 1,
                this.arrObjetos.length - intPosicion - 1);
        this.arrObjetos[intPosicion] = objeto;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el elemento del array de la posición que se pasa como parámetro.                   *
     *                                                                                                                 *
     * @param intPosicion Índice de eliminación.                                                                       *
     * @return Se devuelve el Object eliminado, en caso de que se haya insertado una posición no válida,               *
     *         se devuelve un null.                                                                                    *
     *******************************************************************************************************************/
    public Object eliminar(int intPosicion) {
        Object objetoEliminado = null;

        if (intPosicion >= 0 && intPosicion < this.arrObjetos.length) {
            objetoEliminado = this.arrObjetos[intPosicion];
            System.arraycopy(this.arrObjetos, intPosicion + 1, this.arrObjetos, intPosicion,
                    this.arrObjetos.length - intPosicion - 1);
            this.arrObjetos = Arrays.copyOf(arrObjetos, arrObjetos.length - 1);
        }
        return objetoEliminado;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el elemento que se encuentra en la posición que se pasa como parámetro.            *
     *                                                                                                                 *
     * @param intPosicion Índice de búsqueda.                                                                          *
     * @return Se devuelve el Object de la posición indicada, en caso de que se haya insertado una posición            *
     *         no válida, se devuelve un null.                                                                         *
     *******************************************************************************************************************/
    public Object dimeObjeto(int intPosicion) {
        Object objetoReturn = null;

        if (intPosicion >= 0 && intPosicion < this.arrObjetos.length) {
            objetoReturn = this.arrObjetos[intPosicion];
        }
        return objetoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la posición en la que se encuentra un Object pasado por parámetro.                 *
     *                                                                                                                 *
     * @param objetoBusqueda Object a buscar.                                                                          *
     * @return Se devuelve la posición en la que se encuentra el Object. En caso de no encontrarlo, se devuelve -1.    *
     *******************************************************************************************************************/
    public int buscaObjeto(Object objetoBusqueda) {
        int intIndice = -1;

        for (int intCont = 0; intCont < this.arrObjetos.length; intCont++) {
            if (arrObjetos[intCont].equals(objetoBusqueda)) {
                return intCont;
            }
        }
        return intIndice;
    }

    /*******************************************************************************************************************
     * Método encargado de ordenar el array por orden natural.                                                         *
     *******************************************************************************************************************/
    public void ordenar() {
        //DECLARACIÓN DE VARIABLES
        String[] strArrAux; //Array de String para conseguir el nombre exacto de la clase (se utilizará en la impresión).
        boolean blnEncontrado; //Boolean que actuará como bandera.
        int intPosicion = 0; //Int que guardará el valor del subarray donde se debe almacenar el nuevo elemento.

        Object[][] objetos = { //Array bidimensional de objetos donde se guardarán los objetos.
                {this.arrObjetos[0].getClass().getName()},
                {this.arrObjetos[0]}
        };

        for (int intCont = 1; intCont < this.arrObjetos.length; intCont++) {
            blnEncontrado = false;
            for (int intCont2 = 0; intCont2 < objetos[0].length && !blnEncontrado; intCont2++) {
                if (this.arrObjetos[intCont].getClass().getName().equals(objetos[0][intCont2])) {
                    blnEncontrado = true;
                    intPosicion = intCont2 + 1;
                }
            }

            if (!blnEncontrado) {
                objetos[0] = Arrays.copyOf(objetos[0], objetos[0].length + 1);
                objetos[0][objetos[0].length - 1] = this.arrObjetos[intCont].getClass().getName();
                objetos = Arrays.copyOf(objetos, objetos.length + 1);
                objetos[objetos.length - 1] = new Object[1];
                objetos[objetos.length - 1][0] = this.arrObjetos[intCont];
            } else {
                objetos[intPosicion] = Arrays.copyOf(objetos[intPosicion], objetos[intPosicion].length + 1);
                objetos[intPosicion][objetos[intPosicion].length -1] = this.arrObjetos[intCont];
            }
        }

        Arrays.sort(objetos, new Comparator() {
            @Override
            public int compare(Object objeto, Object otroObjeto) {
                Object[] subarray = (Object[]) objeto;
                Object[] otroSubarray = (Object[]) otroObjeto;

                return subarray[0].getClass().getName().compareTo(otroSubarray[0].getClass().getName());
            }
        });

        for (Object[] array : objetos) {
            Arrays.sort(array);
        }

        System.out.println("Elementos ordenados según tipo de objeto y por orden natural de cada tipo de objeto:");
        for (int intCont = 0, intListado = 1; intCont < objetos.length - 1; intCont++) {
            strArrAux = objetos[0][intCont].toString().split("\\.");
            System.out.println("\t\t--------------- OBJETOS DE TIPO " + strArrAux[strArrAux.length - 1].toUpperCase()
                    + " ---------------");
            for(int intCont2 = 0; intCont2 < objetos[intCont + 1].length; intCont2++, intListado++) {
                System.out.println("[" + intListado + "] -> " + objetos[intCont + 1][intCont2]);
            }
        }
    }

    /*******************************************************************************************************************
     * Método encargado de ordenar el array en base al Comparator pasado por parámetro.                                *
     *                                                                                                                 *
     * @param comparador Comparator con orden de ordenamiento.                                                         *
     *******************************************************************************************************************/
    public void ordenar(Comparator comparador) {
        Arrays.sort(this.arrObjetos, comparador);
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir la información de los objetos.                                                     *
     *******************************************************************************************************************/
    public void imprimeArray() {
        for (int intCont = 0; intCont < this.arrObjetos.length; intCont++) {
            System.out.println("[" + (intCont + 1) + "] " + this.arrObjetos[intCont]);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar que los tipos de objetos de la Lista son iguales.                                 *
     *                                                                                                                 *
     * @return Devuelve un booleano en función de si todos los elementos de la lista son del mismo tipo (true)         *
     *         o no (false).                                                                                           *
     *******************************************************************************************************************/
    public boolean compruebaTipo() {
        String strClase = String.valueOf(this.arrObjetos[0].getClass());

        for (int intCont = 1; intCont < this.arrObjetos.length; intCont++) {
            if (!String.valueOf(this.arrObjetos[intCont].getClass()).equals(strClase)){
                System.out.println("No se pueden ordenar objetos de diferente tipo.");
                return false;
            }
        }
        return true;
    }
}

package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto07_ListaImplementsColaObject.clases;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto07_ListaImplementsColaObject.interfaces.Cola;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase Lista que implementa la interfaz Cola.                                                                        *
 ***********************************************************************************************************************/
public class Lista implements Cola {
    //DECLARACIÓN DE ATRIBUTOS
    private Object[] objArrTabla; //Array de Object.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/

    public Lista() {
        this.objArrTabla = new Object[0];
    }

    /*******************************************************************************************************************
     * Método encargado de insertar un Object al final del array.                                                      *
     *                                                                                                                 *
     * @param objeto Object a insertar.                                                                                *
     *******************************************************************************************************************/
    public void insertaFinal(Object objeto) {
        this.objArrTabla = Arrays.copyOf(this.objArrTabla, this.objArrTabla.length + 1);
        this.objArrTabla[this.objArrTabla.length - 1] = objeto;
    }

    /*******************************************************************************************************************
     * Método encargo de eliminar un Object en una posición determinada.                                               *
     *                                                                                                                 *
     * @param intPosicion Posición a eliminar.                                                                         *
     * @return Devuelve el Object eliminado si la posición no es válida devuelve un null.                              *
     *******************************************************************************************************************/
    public Object elimina(int intPosicion) {
        Object objeto = null;

        if (intPosicion >= 0 && intPosicion < this.objArrTabla.length) {
            objeto = this.objArrTabla[intPosicion];
            System.arraycopy(this.objArrTabla, intPosicion + 1, this.objArrTabla, intPosicion,
                    this.objArrTabla.length - intPosicion - 1);
            this.objArrTabla = Arrays.copyOf(this.objArrTabla, this.objArrTabla.length - 1);
        }

        return objeto;
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir por pantalla los objetos del array.                                                *
     *******************************************************************************************************************/
    public void muestraLista() {
        for(Object objeto : this.objArrTabla) {
            System.out.println(objeto);
        }
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto push de la interfaz Cola.                                                   *
     *                                                                                                                 *
     * @param objeto Object a encolar/apilar.                                                                          *
     *******************************************************************************************************************/
    @Override
    public void push(Object objeto) {
        this.insertaFinal(objeto);
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto pop de la interfaz Cola.                                                    *
     *                                                                                                                 *
     * @return Devuelve el Object desencolado.                                                                         *
     *******************************************************************************************************************/
    @Override
    public Object pop() {
        Object objReturn = null;
        if (this.objArrTabla.length > 0) {
            objReturn = this.objArrTabla[0];
            this.elimina(0);
        }
        return objReturn;
    }
}

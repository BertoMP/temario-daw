package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto06_ListaImplementsColaPilaObject.clases;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto06_ListaImplementsColaPilaObject.interfaces.*;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase Lista que implementa las interfaces Cola y Pila.                                                              *
 ***********************************************************************************************************************/
public class Lista implements Cola, Pila {
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
        for (int intCont = 0; intCont < this.objArrTabla.length; intCont++) {
            System.out.println("[" + intCont + "]" + this.objArrTabla[intCont]);
        }
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto push de las interfaces Cola y Pila.                                         *
     *                                                                                                                 *
     * @param objeto Object a encolar/apilar.                                                                          *
     *******************************************************************************************************************/
    @Override
    public void push(Object objeto) {
        insertaFinal(objeto);
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto popPila de la interfaz Pila.                                                *
     *                                                                                                                 *
     * @return Devuelve el Object desapilado.                                                                          *
     *******************************************************************************************************************/
    @Override
    public Object popCola() {
        Object objeto = null;
        if (this.objArrTabla.length > 0) {
            objeto = this.objArrTabla[0];
            elimina(0);
        }
        return objeto;
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto popCola de la interfaz Cola.                                                *
     *                                                                                                                 *
     * @return Devuelve el Object desencolado.                                                                         *
     *******************************************************************************************************************/
    @Override
    public Object popPila() {
        Object objReturn = null;
        if (this.objArrTabla.length > 0) {
            objReturn = this.objArrTabla[this.objArrTabla.length - 1];
            elimina(this.objArrTabla.length - 1);
        }
        return objReturn;
    }
}

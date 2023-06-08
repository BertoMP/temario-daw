package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto02_ListaImplementsColaPila.clases;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto02_ListaImplementsColaPila.interfaces.*;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase Lista que implementa las interfaces Cola y Pila.                                                              *
 ***********************************************************************************************************************/
public class Lista implements Cola, Pila {
    //DECLARACIÓN DE ATRIBUTOS
    private String[] strArrCadena; //Array de Strings.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.strArrCadena = new String[0];
    }

    /*******************************************************************************************************************
     * Método encargado de insertar un String al final del array.                                                      *
     *                                                                                                                 *
     * @param strNuevo String a insertar.                                                                              *
     *******************************************************************************************************************/
    public void insertaFinal(String strNuevo) {
        this.strArrCadena = Arrays.copyOf(this.strArrCadena, this.strArrCadena.length + 1);
        this.strArrCadena[this.strArrCadena.length - 1] = strNuevo;
    }

    /*******************************************************************************************************************
     * Método encargo de eliminar un String en una posición determinada.                                               *
     *                                                                                                                 *
     * @param intPosicion Posición a eliminar.                                                                         *
     * @return Devuelve el String eliminado si la posición no es válida devuelve un null.                              *
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
     * Método encargado de devolver un String con los elementos de la lista.                                           *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la lista.                                                       *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return Arrays.deepToString(this.strArrCadena);
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto push de las interfaces Cola y Pila.                                         *
     *                                                                                                                 *
     * @param strCadena String a encolar/apilar.                                                                       *
     *******************************************************************************************************************/
    @Override
    public void push(String strCadena) {
        this.insertaFinal(strCadena);
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto popPila de la interfaz Pila.                                                *
     *                                                                                                                 *
     * @return Devuelve el String desapilado.                                                                          *
     *******************************************************************************************************************/
    @Override
    public String popPila() {
        String strReturn = null;

        if (this.strArrCadena.length > 0) {
            strReturn = this.strArrCadena[this.strArrCadena.length - 1];
            this.elimina(this.strArrCadena.length - 1);
        }
        return strReturn;
    }

    /*******************************************************************************************************************
     * Implementación del método abstracto popCola de la interfaz Cola.                                                *
     *                                                                                                                 *
     * @return Devuelve el String desencolado.                                                                         *
     *******************************************************************************************************************/
    @Override
    public String popCola() {
        String strReturn = null;

        if (this.strArrCadena.length > 0) {
            strReturn = this.strArrCadena[0];
            this.elimina(0);
        }
        return strReturn;
    }
}

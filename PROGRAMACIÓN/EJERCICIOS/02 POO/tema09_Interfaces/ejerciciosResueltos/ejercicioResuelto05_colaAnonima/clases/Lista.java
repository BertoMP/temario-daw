package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto05_colaAnonima.clases;
import tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto05_colaAnonima.clases.interfaces.Cola;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase Pila que implementa las interfaces Cola.                                                                      *
 ***********************************************************************************************************************/
public class Lista implements Cola {

    private Integer[] numeros;

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Lista() {
        this.numeros = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método encargado de insertar números al final del array.                                                        *
     *                                                                                                                 *
     * @param intNum Número a insertar.                                                                                *
     *******************************************************************************************************************/
    public void insertarFinal(Integer intNum) {
        this.numeros = Arrays.copyOf(this.numeros, this.numeros.length + 1);
        this.numeros[this.numeros.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los números del array.                                               *
     *                                                                                                                 *
     * @return Devuelve un String con los números del array.                                                           *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return Arrays.toString(this.numeros);
    }

    /*******************************************************************************************************************
     * Override del método push de la Interfaz Cola.                                                                *
     *                                                                                                                 *
     * @param numero Número a push.                                                                                 *
     *******************************************************************************************************************/
    @Override
    public void encolar(Integer numero) {
        this.insertarFinal(numero);
    }

    /*******************************************************************************************************************
     * Override del método popPila de la Interfaz Cola.                                                             *
     *                                                                                                                 *
     * @return Devuelve el Integer resultado del método.                                                               *
     *******************************************************************************************************************/
    @Override
    public Integer desencolar() {
        Integer numeroReturn = null;

        if (this.numeros.length > 0) {
            numeroReturn = this.numeros[0];
            System.arraycopy(this.numeros, 1, this.numeros, 0, this.numeros.length - 1);
            this.numeros = Arrays.copyOf(this.numeros, this.numeros.length - 1);
        }
        return numeroReturn;
    }
}

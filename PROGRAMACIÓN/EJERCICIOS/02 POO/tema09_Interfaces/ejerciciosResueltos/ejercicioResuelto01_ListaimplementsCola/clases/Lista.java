package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto01_ListaimplementsCola.clases;
import tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto01_ListaimplementsCola.clases.interfaces.Cola;
import java.util.Arrays;
/***********************************************************************************************************************
 * Clase Lista que implementa a Cola.                                                                                  *
 ***********************************************************************************************************************/
public class Lista implements Cola {
    //DECLARACIÓN DE VARIABLES
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
     * Override del método push de la Interface Cola.                                                               *
     *                                                                                                                 *
     * @param numero Número a push.                                                                                 *
     *******************************************************************************************************************/
    @Override
    public void encolar(Integer numero) {
        this.insertarFinal(numero);
    }

    /*******************************************************************************************************************
     * Override del método popPila de la Interface Cola.                                                            *
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

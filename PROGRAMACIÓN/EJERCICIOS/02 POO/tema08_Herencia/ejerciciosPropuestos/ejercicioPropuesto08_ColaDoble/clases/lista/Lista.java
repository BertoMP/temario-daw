package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto08_ColaDoble.clases.lista;

import java.util.Arrays;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Lista y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE VARIABLES
    protected Integer[] integerNumeros; //Array de Integers

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Lista() {
        this.integerNumeros = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método que inserta un número al final de la lista.                                                              *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void insertaFinal(int intNum) {
        this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length + 1);
        this.integerNumeros[this.integerNumeros.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método que inserta un Integer al inicio de la lista.                                                            *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void insertaInicio(int intNum) {
        this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length + 1);
        System.arraycopy(this.integerNumeros, 0, this.integerNumeros, 
                1, this.integerNumeros.length - 1);
        this.integerNumeros[0] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el número del primer índice.                                                       *
     *                                                                                                                 *
     * @return Se devuelve el Integer que se encontraba en la primera posición. Si ya no existen números en el array,  *
     *         se devuelve un null.                                                                                    *
     *******************************************************************************************************************/
    public Integer eliminaInicio() {
        Integer numeroReturn = null;

        if (this.integerNumeros.length > 0) {
            numeroReturn = this.integerNumeros[0];
            System.arraycopy(this.integerNumeros,  1, this.integerNumeros, 0,
                    this.integerNumeros.length - 1);
            this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length - 1);
        }

        return numeroReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el último elemento de la Lista.                                                    *
     *******************************************************************************************************************/
    public Integer eliminaFinal() {
        Integer numeroReturn = null;

        if (this.integerNumeros.length > 0) {
            numeroReturn = this.integerNumeros[this.integerNumeros.length - 1];
            this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length - 1);
        }

        return numeroReturn;
    }
}

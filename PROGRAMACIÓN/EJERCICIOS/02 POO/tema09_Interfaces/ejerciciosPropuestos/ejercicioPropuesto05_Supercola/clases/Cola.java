package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto05_Supercola.clases;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase para la generación de objetos de tipo Cola.                                                                   *
 ***********************************************************************************************************************/
public class Cola {
    //DECLARACIÓN DE ATRIBUTOS
    private Integer[] integerNumeros; //Array que guardará los Integers.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Cola() {
        this.integerNumeros = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el número de elementos del array.                                                  *
     *                                                                                                                 *
     * @return Devuelve un int con el número de elementos.                                                             *
     *******************************************************************************************************************/
    public int getNumeroElementos() {
        return this.integerNumeros.length;
    }

    /*******************************************************************************************************************
     * Método encargado de guardar elementos en el array.                                                              *
     *                                                                                                                 *
     * @param intNum Siguiente número a push.                                                                          *
     *******************************************************************************************************************/
    public void push(int intNum) {
        this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length + 1);
        this.integerNumeros[this.integerNumeros.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar elementos en el array.                                                             *
     *                                                                                                                 *
     * @param intIndice Indice a eliminar.                                                                             *
     *******************************************************************************************************************/
    public Integer pop(int intIndice) {
        Integer integerReturn = null;

        if (this.integerNumeros.length != intIndice) {
            integerReturn = this.integerNumeros[intIndice];
            System.arraycopy(this.integerNumeros, intIndice + 1, this.integerNumeros, intIndice,
                    this.integerNumeros.length - (intIndice + 1));
            this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length - 1);
        }

        return integerReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos de la cola.                                                           *
     *                                                                                                                 *
     * @return Devuelve un String del array de Integers.                                                               *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return Arrays.toString(this.integerNumeros);
    }

}
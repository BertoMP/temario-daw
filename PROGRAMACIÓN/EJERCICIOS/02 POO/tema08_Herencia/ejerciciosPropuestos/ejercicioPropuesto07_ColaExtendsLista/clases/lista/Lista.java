package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto07_ColaExtendsLista.clases.lista;
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
    public void inserta(int intNum) {
        this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length + 1);
        this.integerNumeros[this.integerNumeros.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el primer número de la lista.                                                      *
     *                                                                                                                 *
     * @return Se devuelve el Integer que se encontraba en esa posición. Si ya no existen números en el array,         *
     *         se devuelve un null.                                                                                    *
     *******************************************************************************************************************/
    public Integer elimina() {
        Integer numeroReturn = null;

        if (this.integerNumeros.length > 0) {
            numeroReturn = this.integerNumeros[0];
            System.arraycopy(this.integerNumeros, 1, this.integerNumeros, 0,
                    this.integerNumeros.length - 1);
            this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length - 1);
        }
        return numeroReturn;
    }
}

package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto08_cola.clases;
import java.util.Arrays;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cola y de manejar sus atributos y métodos correspondientes.              *
 ***********************************************************************************************************************/
public class Cola {
    //DECLARACIÓN DE VARIABLES
    private Integer[] integerNumeros; //Array que guardará los Integers.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Cola() {
        this.integerNumeros = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método encargado de push (guardar) elementos en el array.                                                    *
     *                                                                                                                 *
     * @param intNum Siguiente número a push.                                                                       *
     *******************************************************************************************************************/
    public void encola(int intNum) {
        this.integerNumeros = Arrays.copyOf(this.integerNumeros, this.integerNumeros.length + 1);
        this.integerNumeros[this.integerNumeros.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de popPila (eliminar) elementos en el array.                                                *
     *                                                                                                                 *
     * @param intIndice Siguiente indice a popPila (siempre será 0).                                                *
     *******************************************************************************************************************/
    public Integer desencola(int intIndice) {
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
    public String muestraCola() {
        return Arrays.toString(this.integerNumeros);
    }

}

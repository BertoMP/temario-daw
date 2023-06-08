package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto09_pilaTabla.clases;
import java.util.Arrays;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Pila y de manejar sus atributos y métodos correspondientes.              *
 ***********************************************************************************************************************/
public class Pila {
    //DECLARACIÓN DE ATRIBUTOS
    private Integer[] integerTabla; //Array de tipo Integer

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Pila() {
        this.integerTabla = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método encargado de apilar elementos.                                                                           *
     *                                                                                                                 *
     * @param numero Número a apilar.                                                                                  *
     *******************************************************************************************************************/
    public void apila(int numero) {
        this.integerTabla = Arrays.copyOf(this.integerTabla, this.integerTabla.length + 1);
        this.integerTabla[this.integerTabla.length - 1] = numero;
    }

    /*******************************************************************************************************************
     * Método encargado de popPila elementos.                                                                        *
     *                                                                                                                 *
     * @param intIndice Índice a popPila.                                                                            *
     * @return El método devuelve el Integer desapilado.                                                               *
     *******************************************************************************************************************/
    public Integer desapila(int intIndice) {
        Integer integerReturn = null;

        if (intIndice < this.integerTabla.length) {
            integerReturn = this.integerTabla[intIndice];
            this.integerTabla = Arrays.copyOf(this.integerTabla, this.integerTabla.length - 1);
        }

        return integerReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el contenido de la pila.                                                            *
     *                                                                                                                 *
     * @return Devuelve un String del array del objeto.                                                                *
     *******************************************************************************************************************/
    public String muestraPila() {
        return Arrays.toString(this.integerTabla);
    }
}

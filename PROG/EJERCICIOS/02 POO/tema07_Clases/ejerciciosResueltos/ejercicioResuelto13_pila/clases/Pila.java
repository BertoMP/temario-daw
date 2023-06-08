package tema07_Clases.ejerciciosResueltos.ejercicioResuelto13_pila.clases;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Pila y de manejar sus atributos y métodos correspondientes.              *
 ***********************************************************************************************************************/
public class Pila {
    //DECLARACIÓN DE ATRIBUTOS
    private final Lista LISTA; //Objeto de tipo Lista.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Pila() {
        LISTA = new Lista();
    }

    /*******************************************************************************************************************
     * Método encargado de apilar elementos.                                                                           *
     *                                                                                                                 *
     * @param intNum Número a apilar.                                                                                  *
     *******************************************************************************************************************/
    public void apilar(int intNum) {
        this.LISTA.insertarFinal(intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de popPila elementos.                                                                        *
     *******************************************************************************************************************/
    public Integer desapilar() {
        return this.LISTA.elimina(this.LISTA.getIntegerArray().length - 1);
    }

    public String muestraPila() {
        return Arrays.toString(this.LISTA.getIntegerArray());
    }
}

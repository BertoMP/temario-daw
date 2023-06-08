package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto06_PilaExtendsLista.clases.lista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Pila que heredan de Lista.                                               *
 ***********************************************************************************************************************/
public class Pila extends Lista {
    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Pila() {
        super();
    }

    /*******************************************************************************************************************
     * Método encargado de apilar elementos.                                                                           *
     *                                                                                                                 *
     * @param intNum Número a apilar.                                                                                  *
     *******************************************************************************************************************/
    public void apila(int intNum) {
        this.insertar(intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar elementos.                                                                         *
     *******************************************************************************************************************/
    public Integer desapila() {
        return this.elimina(this.integerArray.length - 1);
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos de la lista.                                                          *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos del array.                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return Arrays.toString(this.integerArray);
    }
}

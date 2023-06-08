package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto07_ColaExtendsLista.clases.lista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cola y de manejar sus atributos y métodos correspondientes.              *
 ***********************************************************************************************************************/
public class Cola extends Lista {
    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Cola() {
        super();
    }

    /*******************************************************************************************************************
     * Método encargado de push (guardar) elementos en el array.                                                    *
     *                                                                                                                 *
     * @param intNum Siguiente número a push.                                                                       *
     *******************************************************************************************************************/
    public void encola(int intNum) {
        this.inserta(intNum);
    }

    /*******************************************************************************************************************
     * Método encargado de popPila (eliminar) elementos en el array.                                                *
     *                                                                                                                 *
     * @return El método devuelve el Integer eliminado.                                                                *
     *******************************************************************************************************************/
    public Integer desencola() {
        return this.elimina();
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

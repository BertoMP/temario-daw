package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto20_Supercola.clases;

import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************************
 * Clase cola de tipo genérico.                                                                                        *
 *                                                                                                                     *
 * @param <T> Tipo genérico.                                                                                           *
 ***********************************************************************************************************************/

public class Cola<T> {
    //DECLARACIÓN DE ATRIBUTOS
    private List<T> listadoCola; //List que se utilizará con un ArrayList para almacenar los elementos.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Cola() {
        this.listadoCola = new ArrayList<>();
    }

    /*******************************************************************************************************************
     * Método encargado de almacenar un nuevo elemento en la cola (al final de la misma).                              *
     *                                                                                                                 *
     * @param elemento Elemento a almacenar.                                                                           *
     *******************************************************************************************************************/
    public void push(T elemento) {
        this.listadoCola.add(elemento);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el primer elemento de la cola.                                                     *
     *                                                                                                                 *
     * @return Devuelve el elemento eliminado, es decir, el primero de la cola. En caso de que no queden más elementos *
     *         devuelve un null.                                                                                       *
     *******************************************************************************************************************/
    public T pop() {
        //DECLARACIÓN DE VARIABLES
        T elementoReturn = null; //Variable genérica del elemento a devolver como resultado de la función.

        if (listadoCola.size() > 0) {
            elementoReturn = listadoCola.remove(0);
        }

        return elementoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor de la longitud de la cola.                                                *
     *                                                                                                                 *
     * @return Devuelve un int con la longitud de la cola.                                                             *
     *******************************************************************************************************************/
    public int dimeTamanyo() {
        return this.listadoCola.size();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver los elementos de la cola convertidos en un String.                                 *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la cola.                                                        *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return listadoCola.toString();
    }
}

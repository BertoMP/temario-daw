package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto17_ColaArrayList.clases;

import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************************
 * Clase Cola genérica.                                                                                                *
 *                                                                                                                     *
 * @param <T> Tipo genérico.                                                                                           *
 ***********************************************************************************************************************/

public class Cola<T> {
    //DECLARACIÓN DE ATRIBUTOS
    private List<T> listado; //ArrayList que guardará los elementos.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Cola () {
        this.listado = new ArrayList<>();
    }

    /*******************************************************************************************************************
     * Método encargado de añadir un elemento al final de la Cola.                                                     *
     *                                                                                                                 *
     * @param elemento Elemento a encolar.                                                                             *
     *******************************************************************************************************************/
    public void push(T elemento) {
        this.listado.add(elemento);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar un elemento al inicio de la Cola.                                                  *
     *                                                                                                                 *
     * @return Devuelve el elemento del índice 0. En caso de que la cola esté vacía, devuelve un null.                 *
     *******************************************************************************************************************/
    public T pop() {
        //DECLARACIÓN DE VARIABLES
        T elementoReturn = null; //Elemento T a devolver.

        if (!listado.isEmpty()) {
            elementoReturn = listado.remove(0);
        }

        return elementoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de generar un String con los elementos de la Cola.                                             *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la Cola.                                                        *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return this.listado.toString();
    }
}

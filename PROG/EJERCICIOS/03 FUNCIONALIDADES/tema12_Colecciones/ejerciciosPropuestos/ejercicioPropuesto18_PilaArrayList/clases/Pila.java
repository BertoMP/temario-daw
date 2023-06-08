package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto18_PilaArrayList.clases;

import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************************
 * Clase Pila genérica.                                                                                                *
 *                                                                                                                     *
 * @param <T> Tipo genérico.                                                                                           *
 ***********************************************************************************************************************/
public class Pila<T> {
    //DECLARACIÓN DE ATRIBUTOS
    private List<T> listado; //ArrayList que guardará los elementos.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Pila() {
        this.listado = new ArrayList<>();
    }

    /*******************************************************************************************************************
     * Método encargado de añadir un elemento al inicio de la Pila.                                                    *
     *                                                                                                                 *
     * @param elemento Elemento a apilar.                                                                              *
     *******************************************************************************************************************/
    public void push(T elemento) {
        this.listado.add(0, elemento);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar un elemento al inicio de la Pila.                                                  *
     *                                                                                                                 *
     * @return Devuelve el elemento del índice 0. En caso de que la pila esté vacía, devuelve un null.                 *
     *******************************************************************************************************************/
    public T pop() {
        T elementoReturn = null;

        if (!listado.isEmpty()) {
            elementoReturn = this.listado.remove(0);
        }

        return elementoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de generar un String con los elementos de la Pila.                                             *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos de la Pila.                                                        *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return this.listado.toString();
    }
}

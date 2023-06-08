package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto14_DevuelveIndice.clases;

import java.util.Arrays;
import java.util.Comparator;

/***********************************************************************************************************************
 * Clase Contenedor.                                                                                                   *
 *                                                                                                                     *
 * @param <T> Tipo genérico.                                                                                           *
 ***********************************************************************************************************************/

public class Contenedor<T extends Comparable<T>> {
    //DECLARACIÓN DE ATRIBUTOS
    private T[] arrayObjetos; //Array de tipo genérico T.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param arrayObjetos Array de objetos inicializado a 0 en la llamada al objeto.                                  *
     *******************************************************************************************************************/
    public Contenedor(T[] arrayObjetos) {
        this.arrayObjetos = arrayObjetos;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar al final un nuevo objeto en el array.                                              *
     *                                                                                                                 *
     * @param nuevo Objeto a insertar.                                                                                 *
     *******************************************************************************************************************/
    public void insertarAlFinal (T nuevo) {
        this.arrayObjetos = Arrays.copyOf(this.arrayObjetos, this.arrayObjetos.length + 1);
        this.arrayObjetos[this.arrayObjetos.length - 1] = nuevo;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el elemento que se encuentra en el índice que se pasa por parámetro.               *
     *                                                                                                                 *
     * @param intIndice Índice a conocer.                                                                              *
     * @return Devuelve el elemento que se encuentra en la posición intIndice. Si la posición es negativa o superior   *
     *         al length del array, devuelve un null.                                                                  *
     *******************************************************************************************************************/
    public T get(int intIndice) {
        T elemReturn = null;

        if (intIndice > 0 && intIndice < arrayObjetos.length) {
            elemReturn = arrayObjetos[intIndice];
        }

        return elemReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String del array.                                                               *
     *                                                                                                                 *
     * @return Devuelve un String con los elementos del array.                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return Arrays.toString(this.arrayObjetos);
    }
}

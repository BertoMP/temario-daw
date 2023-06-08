package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto12_MetodoOrdenarComparator.clases;

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
     * Método encargado de ordenar el array.                                                                           *
     *******************************************************************************************************************/
    public void ordenar() {
        Arrays.sort(this.arrayObjetos);
    }

    /*******************************************************************************************************************
     * Método encargado de ordenar el array a partir de un Comparator que se le pasa por parámetro.                    *
     *                                                                                                                 *
     * @param c Comparator que se utilizará en la ordenación.                                                          *
     *******************************************************************************************************************/
    public void ordenar(Comparator<T> c) {
        Arrays.sort(this.arrayObjetos, c);
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

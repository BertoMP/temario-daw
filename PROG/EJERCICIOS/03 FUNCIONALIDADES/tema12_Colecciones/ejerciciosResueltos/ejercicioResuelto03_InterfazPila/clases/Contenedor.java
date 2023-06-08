package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto03_InterfazPila.clases;

import tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto03_InterfazPila.interfaces.Pila;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase Contenedor.                                                                                                   *
 *                                                                                                                     *
 * @param <T> Tipo genérico.                                                                                           *
 ***********************************************************************************************************************/

public class Contenedor <T extends Comparable<T>> implements Pila<T> {
    //DECLARACIÓN DE ATRIBUTOS
    private T[] arrayObjetos; //Array de tipo genérico T.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param arrayObjetos Array de objetos inicializado a 0 en la llamada al objeto.                                  *
     *******************************************************************************************************************/
    public Contenedor (T[] arrayObjetos) {
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
     * Método encargado de insertar al principio un nuevo objeto en el array.                                          *
     *                                                                                                                 *
     * @param nuevo Objeto a insertar.                                                                                 *
     *******************************************************************************************************************/
    public void insertarAlInicio(T nuevo) {
        this.arrayObjetos = Arrays.copyOf(this.arrayObjetos, this.arrayObjetos.length + 1);
        System.arraycopy(this.arrayObjetos, 0, this.arrayObjetos, 1, this.arrayObjetos.length - 1);
        this.arrayObjetos[0] = nuevo;
    }

    /*******************************************************************************************************************
     * Método encargado de extraer el último objeto del array.                                                         *
     *                                                                                                                 *
     * @return Devuelve el elemento.                                                                                   *
     *******************************************************************************************************************/
    public T extraerDelFinal() {
        T elemReturn = null;

        if (this.arrayObjetos.length > 0) {
            elemReturn = this.arrayObjetos[this.arrayObjetos.length - 1];
            this.arrayObjetos = Arrays.copyOf(this.arrayObjetos, this.arrayObjetos.length - 1);
        }

        return elemReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de extraer el primer objeto del array.                                                         *
     *                                                                                                                 *
     * @return Devuelve el elemento.                                                                                   *
     *******************************************************************************************************************/
    public T extraerDelPrincipio() {
        T elemReturn = null;

        if (this.arrayObjetos.length > 0) {
            elemReturn = this.arrayObjetos[0];
            this.arrayObjetos = Arrays.copyOfRange(this.arrayObjetos, 1, this.arrayObjetos.length);
        }

        return elemReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de ordenar el array.                                                                           *
     *******************************************************************************************************************/
    public void ordenar() {
        Arrays.sort(this.arrayObjetos);
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

    /*******************************************************************************************************************
     * Implementación del método apilar de la interfaz Pila.                                                           *
     *                                                                                                                 *
     * @param nuevo Elemento a apilar.                                                                                 *
     *******************************************************************************************************************/
    @Override
    public void push(T nuevo) {
        this.insertarAlInicio(nuevo);
    }

    /*******************************************************************************************************************
     * Implementación del método desapilar de la interfaz Pila.                                                        *
     *                                                                                                                 *
     * @return Devuele el elemento desapilado.                                                                         *
     *******************************************************************************************************************/
    @Override
    public T pop() {
        return this.extraerDelPrincipio();
    }
}

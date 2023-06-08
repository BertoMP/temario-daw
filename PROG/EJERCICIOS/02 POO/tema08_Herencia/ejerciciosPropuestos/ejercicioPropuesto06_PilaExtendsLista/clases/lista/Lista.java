package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto06_PilaExtendsLista.clases.lista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Lista y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
public class Lista {
    //DECLARACIÓN DE VARIABLES
    protected Integer[] integerArray; //Array que guardará los int de la lista.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Lista() {
        this.integerArray = new Integer[0];
    }

    /*******************************************************************************************************************
     * Método que inserta un Integer al final de la lista.                                                             *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     *******************************************************************************************************************/
    public void insertar(int intNum) {
        this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length + 1);
        this.integerArray[this.integerArray.length - 1] = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el Integer del índice que se pasa como parámetro.                                  *
     *                                                                                                                 *
     * @return Se devuelve el Integer que se encontraba en esa posición. Si se introduce una posición no válida,       *
     *         se devuelve el valor null.                                                                              *
     *******************************************************************************************************************/
    public Integer elimina(int intNum) {
        Integer numero = null;

        if (intNum >= 0) {
            numero = this.integerArray[this.integerArray.length - 1];
            this.integerArray = Arrays.copyOf(this.integerArray, this.integerArray.length - 1);
        }

        return numero;
    }
}

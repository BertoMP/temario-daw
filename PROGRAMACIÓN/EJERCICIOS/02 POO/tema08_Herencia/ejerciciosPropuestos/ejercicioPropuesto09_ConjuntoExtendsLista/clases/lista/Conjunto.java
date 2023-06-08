package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto09_ConjuntoExtendsLista.clases.lista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Conjunto que heredan de Lista.                                           *
 ***********************************************************************************************************************/
public class Conjunto extends Lista {
    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Conjunto() {
        super();
    }

    /*******************************************************************************************************************
     * Método que inserta un Integer al inicio del conjunto.                                                           *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir al conjunto.                                                            *
     *******************************************************************************************************************/
    @Override
    public void insertarInicio(int intNum) {
        if (this.sePuedeInsertar(intNum)) {
            super.insertarInicio(intNum);
        }
    }

    /*******************************************************************************************************************
     * Método que inserta un Integer al final del conjunto.                                                            *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir al conjunto.                                                            *
     *******************************************************************************************************************/
    @Override
    public void insertarFinal(int intNum) {
        if (this.sePuedeInsertar(intNum)) {
            super.insertarFinal(intNum);
        }
    }

    /*******************************************************************************************************************
     * Método que inserta un Integer en una posición del conjunto.                                                     *
     *                                                                                                                 *
     * @param intNum Número que se debe añadir a la lista.                                                             *
     * @param intIndice Posición donde se debe añadir el nuevo número.                                                 *
     *******************************************************************************************************************/
    @Override
    public void insertarEnLugar(int intNum, int intIndice) {
        if (this.sePuedeInsertar(intNum)) {
            super.insertarEnLugar(intNum, intIndice);
        }
    }

    /*******************************************************************************************************************
     * Método que inserta al final del Conjunto otra lista que se pase por parámetro.                                  *
     *                                                                                                                 *
     * @param otraLista Lista que se debe añadir.                                                                      *
     *******************************************************************************************************************/
    @Override
    public void anadeOtraLista(Lista otraLista) {
        for (int intCont = 0; intCont < otraLista.integerArray.length; intCont++) {
            if (this.sePuedeInsertar(otraLista.integerArray[intCont])) {
                this.insertarFinal(otraLista.integerArray[intCont]);
            }
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos del conjunto.                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Los elementos del conjunto son: " + Arrays.toString(this.integerArray);
    }

    /*******************************************************************************************************************
     * Método en cargado de buscar un elemento en el conjunto y devolver un booleano indicando si la inserción es      *
     * posible o no.                                                                                                   *
     *                                                                                                                 *
     * @param intNum Número a buscar.                                                                                  *
     * @return Devuelve un booleano en función de si puede realizar una inserción en el conjunto (true) o no (false).  *
     *******************************************************************************************************************/
    private boolean sePuedeInsertar(int intNum) {
        for (Integer integerValor : this.integerArray) {
            if (integerValor.equals(intNum)) {
                System.out.println("El elemento " + intNum + " ya existe en el conjunto, no se añadirá.");
                return false;
            }
        }
        return true;
    }
}

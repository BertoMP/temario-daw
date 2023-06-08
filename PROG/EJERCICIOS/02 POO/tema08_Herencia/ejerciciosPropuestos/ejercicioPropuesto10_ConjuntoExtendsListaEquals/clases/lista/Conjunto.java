package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto10_ConjuntoExtendsListaEquals.clases.lista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Conjunto y de manejar sus atributos y métodos correspondientes.          *
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
    public void anadeOtraLista(Lista otraLista) {
        for (int intCont = 0; intCont < otraLista.integerArray.length; intCont++) {
            if (this.sePuedeInsertar(otraLista.integerArray[intCont])) {
                this.insertarFinal(otraLista.integerArray[intCont]);
            }
        }
    }

    /*******************************************************************************************************************
     * Método encargado de comparar dos conjuntos.                                                                     *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @return Devuelve un booleano en función de si son el mismo conjunto (true) o no (false).                        *
     *******************************************************************************************************************/
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || this.getClass() != objeto.getClass()) {
            return false;
        }

        Conjunto otroConjunto = (Conjunto) objeto;

        if (this.integerArray.length != otroConjunto.integerArray.length) {
            return false;
        }

        for (int intContThis = 0, intContadorComparacion = 0; intContThis < this.integerArray.length;
             intContThis++, intContadorComparacion = 0) {
            for (int intContOtro = 0; intContOtro < otroConjunto.integerArray.length ; intContOtro++) {
                if(!this.integerArray[intContThis].equals(otroConjunto.integerArray[intContOtro])) {
                    intContadorComparacion++;
                }
            }
            if (intContadorComparacion == otroConjunto.integerArray.length) {
                return false;
            }
        }
        return true;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos del conjunto.                                                         *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Los elementos del conjunto son: " + Arrays.toString(super.integerArray);
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

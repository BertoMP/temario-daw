package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto13_Sorteo.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase sorteo.                                                                                                       *
 *                                                                                                                     *
 * @param <E> Tipo genérico.                                                                                           *
 ***********************************************************************************************************************/

public class Sorteo<E extends Comparable<E>> {
    //DECLARACIÓN DE ATRIBUTOS
    private Set<E> elementos; //Conjunto de tipo genérico.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public Sorteo() {
        this.elementos = new TreeSet<>();
    }

    /*******************************************************************************************************************
     * Método encargado añadir un nuevo elemento al conjunto del atributo.                                             *
     *                                                                                                                 *
     * @param elemento Elemento a añadir.                                                                              *
     * @return Devuelve un booleano en función de si el elemento se ha podido añadir o no.                             *
     *******************************************************************************************************************/
    public boolean add(E elemento) {
        return this.elementos.add(elemento);
    }

    /*******************************************************************************************************************
     * Método encargado de seleccionar los ganadores del sorteo.                                                       *
     *                                                                                                                 *
     * @param intNumPremiados Cantidad de premiados.                                                                   *
     * @return Devuelve un conjunto con los ganadores.                                                                 *
     *******************************************************************************************************************/
    public Set<E> premiados(int intNumPremiados) {
        Set<E> conjuntoReturn;
        List<E> listadoAuxiliar = new ArrayList<>(this.elementos);

        Collections.shuffle(listadoAuxiliar);

        if (intNumPremiados < this.elementos.size()) {
            conjuntoReturn = new TreeSet<>();
            for (int intCont = 0; intCont < intNumPremiados; intCont++) {
                conjuntoReturn.add(listadoAuxiliar.get(intCont));
            }
        } else {
            conjuntoReturn = new TreeSet<>(listadoAuxiliar);
        }

        return conjuntoReturn;
    }
}

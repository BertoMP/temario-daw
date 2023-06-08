package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto12_UnionIntersect.clases;

import java.util.Set;
import java.util.TreeSet;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal de la aplicación.                                                          *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Set<Integer> conjuntoUno = new TreeSet<>(generaConjunto()); //TreeSet que guarda los elementos del conjunto 1;
        Set<Integer> conjuntoDos = new TreeSet<>(generaConjunto()); //TreeSet que guarda los elementos del conjunto 2;
        Set<Integer> conjuntoUnion; //Set que se utilizará para la unión de ambos conjuntos.
        Set<Integer> conjuntoInterseccion; //Set que se utilizará para la intersección.

        conjuntoUnion = union(conjuntoUno, conjuntoDos);
        conjuntoInterseccion = interseccion(conjuntoUno, conjuntoDos);

        System.out.println("Conjunto 1 -> " + conjuntoUno);
        System.out.println("Conjunto 2 -> " + conjuntoDos);
        System.out.println("Conjunto unión -> " + conjuntoUnion);
        System.out.println("Conjunto intersección -> " + conjuntoInterseccion);
    }

    /*******************************************************************************************************************
     * Método encargado de generar un conjunto de Integer y devolverlo.                                                *
     *                                                                                                                 *
     * @return Devuelve un conjunto de integers.                                                                       *
     *******************************************************************************************************************/
    public static Set<Integer> generaConjunto() {
        Set<Integer> conjuntoReturn = new TreeSet<>();

        for (int intCont = 0; intCont < 20;) {
            if (conjuntoReturn.add((int) (Math.random() * 100) + 1)) {
                intCont++;
            }
        }

        return conjuntoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de fusionar dos conjuntos pasados por parámetro.                                               *
     *                                                                                                                 *
     * @param conjuntoUno Primer conjunto.                                                                             *
     * @param conjuntoDos Segundo conjunto.                                                                            *
     * @return Devuelve un conjunto resultado de la fusión de conjuntoUno y conjuntoDos.                               *
     * @param <E> Tipo genérico.                                                                                       *
     *******************************************************************************************************************/
    public static <E> Set<E> union(Set<E> conjuntoUno, Set<E> conjuntoDos) {
        Set<E> conjuntoReturn = new TreeSet<>(conjuntoUno);

        conjuntoReturn.addAll(conjuntoDos);

        return conjuntoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de generar un conjunto con los elementos que se encuentran en ambos conjuntos.                 *
     *                                                                                                                 *
     * @param conjuntoUno Primer conjunto.                                                                             *
     * @param conjuntoDos Segundo conjunto.                                                                            *
     * @return Devuelve un conjunto con los elementos que están en conjuntoUno y conjuntoDos.                          *
     * @param <E> Tipo genérico.                                                                                       *
     *******************************************************************************************************************/
    public static <E> Set<E> interseccion(Set<E> conjuntoUno, Set<E> conjuntoDos) {
        Set<E> conjuntoReturn = new TreeSet<>(conjuntoUno);

        conjuntoReturn.retainAll(conjuntoDos);

        return conjuntoReturn;
    }
}

package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto10_Conjuntos.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        List<Integer> listado = new ArrayList<>(); //ArrayList que se comporta como un listado.
        Set<Integer> listadoSinRepeticiones; //Listado que guardará los números sin repeticiones.
        Set<Integer> listadoRepetidos; //Listado que guardara los números repetidos.
        Set<Integer> listadoUnicos; //Listado que guardará los números que aparecen una única vez.

        for (int intCont = 0; intCont < 20; intCont++) {
            listado.add((int) (Math.random() * 10) + 1);
        }

        listado.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return Integer.compare(integer1, integer2);
            }
        });

        System.out.println("Lista original: " + listado);

        listadoSinRepeticiones = new TreeSet<>(listado);
        System.out.println("Listado sin repeticiones: " + listadoSinRepeticiones);

        for (Integer integerValor : listadoSinRepeticiones) {
            listado.remove(integerValor);
        }

        listadoRepetidos = new TreeSet<>(listado);
        System.out.println("Listado repetidos: " + listadoRepetidos);

        listadoUnicos = new TreeSet<>(listadoSinRepeticiones);
        listadoUnicos.removeAll(listadoRepetidos);
        System.out.println("Listado únicos: " + listadoUnicos);
    }
}

package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto08_ColeccionOrdenamiento.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Collection<Integer> listadoNumeros = new ArrayList<>(); //ArrayList que se comporta como colección y que guardará todos los números.
        Collection<Integer> listadoCreciente; //Colección que se utilizará para guardar los números en orden creciente.
        Collection<Integer> listadoDecreciente; //Colección que se utilizará para guardar los números en orden decreciente.
        Comparator<Integer> comparadorDecreciente; //Comparator para la ordenación decreciente.

        //DECLARACIÓN DE VARIABLES
        Integer[] intArray; //Array de Integers.

        for (int intCont = 0; intCont < 20; intCont++) {
            listadoNumeros.add((int) (Math.random() * 100) + 1);
        }

        System.out.println(listadoNumeros);

        intArray = listadoNumeros.toArray(new Integer[0]);
        Arrays.sort(intArray);
        listadoCreciente = new ArrayList<>(Arrays.asList(intArray));
        System.out.println(listadoCreciente);

        comparadorDecreciente = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return Integer.compare(integer2, integer1);
            }
        };

        Arrays.sort(intArray, comparadorDecreciente);
        listadoDecreciente = new ArrayList<>(Arrays.asList(intArray));
        System.out.println(listadoDecreciente);
    }
}

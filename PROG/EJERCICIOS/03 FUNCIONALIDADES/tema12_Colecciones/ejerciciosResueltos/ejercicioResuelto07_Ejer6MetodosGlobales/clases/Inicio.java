package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto07_Ejer6MetodosGlobales.clases;

import java.util.ArrayList;
import java.util.Collection;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Collection<Integer> listadoNumeros = new ArrayList<>(); //ArraList que se comporta como una colección.
        Collection<Integer> listadoNumerosAEliminar = new ArrayList<>(); //ArraList que se comporta como una colección.

        for(int intCont = 0; intCont < 100; intCont++) {
            listadoNumeros.add((int) (Math.random() * 10) + 1);
        }

        System.out.println(listadoNumeros);

        listadoNumerosAEliminar.add(5);
        listadoNumeros.removeAll(listadoNumerosAEliminar);

        System.out.println(listadoNumeros);
    }
}

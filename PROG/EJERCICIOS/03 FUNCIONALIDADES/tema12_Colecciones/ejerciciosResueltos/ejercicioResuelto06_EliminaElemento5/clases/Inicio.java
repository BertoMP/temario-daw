package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto06_EliminaElemento5.clases;

import java.util.ArrayList;
import java.util.Collection;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Collection<Integer> listadoNumeros = new ArrayList<>(); //ArraList que se comporta como una colección.

        for(int intCont = 0; intCont < 100; intCont++) {
            listadoNumeros.add((int) (Math.random() * 10) + 1);
        }

        System.out.println(listadoNumeros);

        while(listadoNumeros.remove(5));

        System.out.println(listadoNumeros);
    }
}

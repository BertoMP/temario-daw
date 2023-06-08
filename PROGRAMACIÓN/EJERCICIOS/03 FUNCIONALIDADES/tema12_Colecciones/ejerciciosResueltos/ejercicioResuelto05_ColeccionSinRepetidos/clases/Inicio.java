package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto05_ColeccionSinRepetidos.clases;

import java.util.ArrayList;
import java.util.Collection;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Collection<Integer> listadoNumeros = new ArrayList<>(); //ArrayList que se comporta como una colección.
        Collection<Integer> listadoSinRepetidos = new ArrayList<>(); //ArrayList que se comporta como una colección y que guardará los números del listado pero sin repetidos.

        for (int intCont = 0; intCont < 20; intCont++) {
            listadoNumeros.add((int) (Math.random() * 10) + 1);
        }

        System.out.println(listadoNumeros);

        for (Integer integerValor : listadoNumeros) {
            if (!listadoSinRepetidos.contains(integerValor)) {
                listadoSinRepetidos.add(integerValor);
            }
        }

        System.out.println(listadoSinRepetidos);
    }
}

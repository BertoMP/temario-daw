package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto21_NumerosDecreciente.clases;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Collection<Integer> coleccionNumeros = new TreeSet<>(new Comparator<>() { //TreeSet que se comporta como colección para almacenar los números.
            @Override
            public int compare(Integer integer, Integer otroInteger) {
                return Integer.compare(otroInteger, integer);
            }
        });

        for (int intCont = 0; intCont < 20;) {
            if (coleccionNumeros.add((int) (Math.random() * 99 + 1))) {
                intCont++;
            }
        }

        System.out.println("Listado completo (ordenado decreciente) -> " + coleccionNumeros);
    }
}

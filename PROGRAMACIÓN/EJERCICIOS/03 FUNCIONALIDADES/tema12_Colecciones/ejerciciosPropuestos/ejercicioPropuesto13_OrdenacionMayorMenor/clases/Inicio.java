package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto13_OrdenacionMayorMenor.clases;

import java.util.Comparator;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Contenedor<Integer> contenedor = new Contenedor<>(new Integer[0]); //Objeto de tipo Contenedor que contendrá los números.

        for (int intCont = 0; intCont < 30; intCont++) {
            contenedor.insertarAlFinal((int) (Math.random() * 10) + 1);
        }

        System.out.println(contenedor);

        contenedor.ordenar(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer otroInteger) {
                return Integer.compare(otroInteger, integer);
            }
        });

        System.out.println(contenedor);


    }
}

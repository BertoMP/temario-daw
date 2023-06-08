package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto15_MetodoGenericoEliminacion.clases;

import java.util.*;

/***********************************************************************************************************************
 * Método encargado del control principal del programa.                                                                *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        List<Integer> listadoNumeros = new ArrayList<>(); //ArrayList que se comporta como lista y que guardará todos los números.
        List<Integer> listadoSinRepetidos; //ArrayList que se comporta como lista y que guardará los números sin repeticiones.

        for (int intCont = 0; intCont < 20; intCont++) {
            listadoNumeros.add((int) (Math.random() * 10) + 1);
        }

        System.out.println(listadoNumeros);

        listadoSinRepetidos = eliminaRepetidos(listadoNumeros);
        System.out.println(listadoSinRepetidos);
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar los elementos duplicados de una lista pasada por parámetro y de devolver una lista *
     * sin repetidos.                                                                                                  *
     *                                                                                                                 *
     * @param listadoOriginal Listado que contiene todos los números.                                                  *
     * @return Devuelve una lista que contiene sólo elementos únicos.                                                  *
     * @param <T> Tipo genérico.                                                                                       *
     *******************************************************************************************************************/
    private static <T> List<T> eliminaRepetidos(List<T> listadoOriginal) {
        List<T> listadoUnicos = new ArrayList<>();

        for (T tValor : listadoOriginal) {
            if (!listadoUnicos.contains(tValor)) {
                listadoUnicos.add(tValor);
            }
        }

        return listadoUnicos;
    }
}

package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto24_FusionListas.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        List<Integer> listadoUno = new ArrayList<>(generaLista(1)); //List que guardará los números del primer listado.
        List<Integer> listadoDos = new ArrayList<>(generaLista(2)); //List que guardará los números del segundo listado.
        List<Integer> listadoFusionado; //List que guardará la fusión de los números.
        
        listadoFusionado = fusionaListas(listadoUno, listadoDos);

        System.out.println("Listado 1 -> " + listadoUno);
        System.out.println("Listado 2 -> " + listadoDos);
        System.out.println("Listado fusionado -> " + listadoFusionado);
    }

    /*******************************************************************************************************************
     * Método encargado de generar una lista y devolverla como resultado de la función.                                *
     *                                                                                                                 *
     * @return Devuelve una lista ordenada de elementos Integer.                                                       *
     *******************************************************************************************************************/
    private static List<Integer> generaLista(int intNumLista) {
        List<Integer> listadoReturn = new ArrayList<>();
        Integer integerCantidad = null;

        do {
            System.out.print("Dime cantidad de elementos para la lista " + intNumLista + ": ");
            try {
                integerCantidad = Integer.parseInt(new Scanner(System.in).nextLine());
                if (integerCantidad < 0) {
                    System.out.println("La cantidad no puede ser menor de 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un número.");
            }
        } while (integerCantidad == null || integerCantidad < 0);

        for (int intCont = 0; intCont < integerCantidad; intCont++) {
            listadoReturn.add((int) (Math.random() * 100) + 1);
        }

        Collections.sort(listadoReturn);

        return listadoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de fusionar dos listas en una única lista y devolverla como resultado del método.              *
     *                                                                                                                 *
     * @param listadoUno Primer listado de números.                                                                    *
     * @param listadoDos Segundo listado de números.                                                                   *
     * @return Devuelve una lista de enteros resultado de la fusión de dos listas.                                     *
     *******************************************************************************************************************/
    private static List<Integer> fusionaListas(List<Integer> listadoUno, List<Integer> listadoDos) {
        //DECLARACIÓN DE OBJETOS
        List<Integer> listadoFusion = new ArrayList<>(); //ArrayList que se comporta como lista y contiene la fusión de las dos listas.
        Iterator<Integer> iteratorUno = listadoUno.iterator(); //Iterator para el primer listado.
        Iterator<Integer> iteratorDos = listadoDos.iterator(); //Iterator para el segundo listado.
        Integer integerListadoUno; //Integer que guarda el siguiente número del iteradorUno.
        Integer integerListadoDos; //Integer que guarda el siguiente número del iteradorDos.

        integerListadoUno = (iteratorUno.hasNext()) ? iteratorUno.next() : null;
        integerListadoDos = (iteratorDos.hasNext()) ? iteratorDos.next() : null;

        if (integerListadoUno == null) {
            listadoFusion.addAll(listadoDos);
        } else if (integerListadoDos == null) {
            listadoFusion.addAll(listadoUno);
            } else {
                while (integerListadoUno != null && integerListadoDos != null) {
                    if (integerListadoUno < integerListadoDos) {
                        listadoFusion.add(integerListadoUno);
                        integerListadoUno = (iteratorUno.hasNext()) ? iteratorUno.next() : null;
                    } else {
                        listadoFusion.add(integerListadoDos);
                        integerListadoDos = (iteratorDos.hasNext()) ? iteratorDos.next() : null;
                    }
                }

                if (integerListadoUno != null) {
                    while (integerListadoUno != null) {
                        listadoFusion.add(integerListadoUno);
                        integerListadoUno = (iteratorUno.hasNext()) ? iteratorUno.next() : null;
                    }
                } else {
                    while (integerListadoDos != null) {
                        listadoFusion.add(integerListadoDos);
                        integerListadoDos = (iteratorDos.hasNext()) ? iteratorDos.next() : null;
                    }
                }
            }

        return listadoFusion;
    }
}

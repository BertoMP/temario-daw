package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto26_AlumnosGrupos.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        List<String> listadoAlumnos = new ArrayList<>(); //ArrayList que se comporta como lista y que guarda el listado de alumnos.
        List<List<String>> listadoAlumnosGrupos; //Lista de listas que guardará los grupos y los alumnos.
        Integer intNumGrupos = null; //Integer que almacena el número de grupos.

        generaListadoAlumnos(listadoAlumnos);

        do {
            System.out.print("Dime el número de grupos: ");
            try {
                intNumGrupos = Integer.parseInt(new Scanner(System.in).nextLine());
                if (intNumGrupos <= 0) {
                    System.out.println("El número de grupos no puede ser 0 o negativo.");
                    intNumGrupos = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un valor.");
            }
        } while (intNumGrupos == null);

        listadoAlumnosGrupos = repartoAlumnos(listadoAlumnos, intNumGrupos);

        for (int intCont = 0; intCont < listadoAlumnosGrupos.size(); intCont++) {
            System.out.println("Grupo " + (intCont + 1) + " -> " + listadoAlumnosGrupos.get(intCont));
        }
    }

    /*******************************************************************************************************************
     * Método encargado de rellenar un listado que se pasa por parámetro.                                              *
     *                                                                                                                 *
     * @param listado Listado a rellenar.                                                                              *
     *******************************************************************************************************************/
    private static void generaListadoAlumnos (List<String> listado) {
        listado.add("Sofía");
        listado.add("Julio");
        listado.add("Claudia");
        listado.add("Yolanda");
        listado.add("Juan");
        listado.add("Pedro");
        listado.add("Lucía");
        listado.add("Pablo");
        listado.add("Laura");
        listado.add("Jaime");
        listado.add("Argia");
        listado.add("Abraham");
        listado.add("Mónica");
        listado.add("Carmen");
        listado.add("Fernando");
        listado.add("Gabriel");
        listado.add("Luisa");
        listado.add("Óscar");
        listado.add("Natalia");
        listado.add("Carlos");
        listado.add("Esther");
        listado.add("María");
        listado.add("Ana");
        listado.add("Carolina");
    }

    /*******************************************************************************************************************
     * Método encargado de generar una lista de listas, rellenarla y devolverla como resultado de la función.          *
     *                                                                                                                 *
     * @param lista Listado de alumnos a repartir en los grupos.                                                       *
     * @param intNumGrupos Número de grupos (será el número de listas que contendrá la lista de listas).               *
     * @return Devuelve una lista de listas con los alumnos repartidos en los grupos.                                  *
     *******************************************************************************************************************/
    private static List<List<String>> repartoAlumnos(List<String> lista, int intNumGrupos) {
        //DECLARACIÓN DE OBJETOS
        List<List<String>> listadoReturn = new ArrayList<>(); //ArrayList que se comporta como lista de listas y que se devolverá como resultado de la función.
        int intGrupoAsignado; //Int que guarda un número aleatorio correspondiente al grupo asignado.

        for (int intCont = 0; intCont < intNumGrupos; intCont++) {
            listadoReturn.add(new ArrayList<>());
        }

        for (String strValor : lista) {
            intGrupoAsignado = (int) (Math.random() * intNumGrupos);
            listadoReturn.get(intGrupoAsignado).add(strValor);
        }

        return listadoReturn;
    }
}

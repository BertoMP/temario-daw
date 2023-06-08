package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto22_NombresOrdenInsercion.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Collection<String> coleccionNombres = new LinkedHashSet<>();  //ArrayList que se comporta como colección para almacenar los nombres.

        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que almacenará el siguiente nombre a introducir.

        do {
            System.out.print("Dime nombre a añadir en el listado: ");
            strNombre = scEntrada.nextLine().toLowerCase();
            if (strNombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (strNombre.isEmpty());

        while (!strNombre.equals("fin")) {
            if (coleccionNombres.add(strNombre)) {
                System.out.println("Nombre añadido con éxito.");
            } else {
                System.out.println("El nombre ya existe en el listado.");
            }

            do {
                System.out.println();
                System.out.print("Dime otro nombre a añadir en el listado (o introduce \"fin\" para finalizar): ");
                strNombre = scEntrada.nextLine().toLowerCase();
                if (strNombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            } while (strNombre.isEmpty());
        }

        scEntrada.close();

        System.out.println("El listado de nombres es: " + coleccionNombres);
    }
}

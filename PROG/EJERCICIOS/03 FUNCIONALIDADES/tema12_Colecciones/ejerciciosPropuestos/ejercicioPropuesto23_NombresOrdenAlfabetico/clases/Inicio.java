package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto23_NombresOrdenAlfabetico.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal de la aplicación.                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Collection<String> listadoNombres = new TreeSet<>(); //TreeSet que se comporta como colección para almacenar los nombre.

        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que almacena el nombre que hay que guardar.

        do {
            System.out.print("Dime nombre a añadir en el listado: ");
            strNombre = scEntrada.nextLine().toLowerCase();
            if (strNombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (strNombre.isEmpty());

        while (!strNombre.equals("fin")) {
            if (listadoNombres.add(strNombre)) {
                System.out.println("Nombre añadido con éxito.");
            } else {
                System.out.println("El nombre ya se encontraba en el listado.");
            }

            do {
                System.out.print("Dime otro nombre a añadir en el listado (o introduce \"fin\" para finalizar): ");
                strNombre = scEntrada.nextLine().toLowerCase();
                if (strNombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            } while (strNombre.isEmpty());
        }

        scEntrada.close();

        System.out.println("El listado de nombres es: " + listadoNombres);
    }
}

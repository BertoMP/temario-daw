package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto22_ListadoOficinasNumOficina.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto21_ListadoOficinas.clases.Oficina;
import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto22_ListadoOficinasNumOficina.clases.OficinaDAO;

import java.util.List;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        List<Oficina> listadoOficinas;

        //DECLARACIÓN DE VARIABLES
        Integer intOficina = null; //Double que almacenará la superficie a buscar.

        do {
            System.out.print("Dime número de oficina: ");
            try {
                intOficina = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("El número debe ser un número entero.");
            }
        } while (intOficina == null);

        listadoOficinas = OficinaDAO.read(intOficina);

        if (!listadoOficinas.isEmpty()) {
            System.out.println("LISTADO DE OFICINAS CON NÚMERO DE ID SUPERIOR A " + intOficina);
            for (Oficina oficinaValor : listadoOficinas) {
                System.out.println(oficinaValor);
            }
        } else {
            System.out.println("No existen oficinas con las características especificadas.");
        }
    }
}

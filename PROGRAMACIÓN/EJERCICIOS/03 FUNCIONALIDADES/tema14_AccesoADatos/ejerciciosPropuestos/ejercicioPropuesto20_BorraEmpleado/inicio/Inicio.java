package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto20_BorraEmpleado.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto20_BorraEmpleado.clases.EmpleadoDAO;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Integer intIdEmpleado = null; //Integer que almacenará el id del empleado.

        do {
            System.out.print("Dime ID del empleado: ");
            try {
                intIdEmpleado = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("El ID debe ser un número entero.");
            }
        } while (intIdEmpleado == null);

        EmpleadoDAO.delete(intIdEmpleado);
    }
}

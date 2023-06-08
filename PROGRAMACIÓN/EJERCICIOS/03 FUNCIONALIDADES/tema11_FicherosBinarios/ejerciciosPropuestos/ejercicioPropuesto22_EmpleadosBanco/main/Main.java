package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto22_EmpleadosBanco.main;

import tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto22_EmpleadosBanco.clases.Inicio;

/***********************************************************************************************************************
 * Implementa una aplicación que gestione los empleados de un banco. Para ello se definirá la clase Empleado con los   *
 * atributos dni, nombre y sueldo. Los empleados se guardarán en un objeto de la clase Lista para objetos de la clase  *
 * Object. La aplicación cargará en la memoria, al arrancar, la lista de empleados desde el archivo binario            *
 * empleados.dat y mostrará un menú con las siguientes opciones:                                                       *
 *      1. Alta empleado.                                                                                              *
 *      2. Baja empleado.                                                                                              *
 *      3. Mostrar datos empleado.                                                                                     *
 *      4. Listar empleados.                                                                                           *
 *      5. Salir.                                                                                                      *
 * Al pulsar 5, se grabará en el disco la lista actualizada y terminará el programa.                                   *
 ***********************************************************************************************************************/

public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

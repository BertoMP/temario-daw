package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto17_BuscaEmpleadoInsercion.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto17_BuscaEmpleadoInsercion.clases.Empleado;
import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto17_BuscaEmpleadoInsercion.clases.EmpleadoDAO;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Empleado nuevoEmpleado; //Empleado a insertar.
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(); //EmpleadoDAO para las conexiones a la base de datos.

        if (empleadoDAO.existeConexion()) {
            nuevoEmpleado = generaEmpleado(scEntrada, empleadoDAO);

            scEntrada.close();

            empleadoDAO.create(nuevoEmpleado);
            empleadoDAO.cierraConexion();
        }
    }

    /*******************************************************************************************************************
     * Método encargado de generar un objeto de la clase Empleado.                                                     *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un objeto de tipo Empleado.                                                                    *
     *******************************************************************************************************************/
    private static Empleado generaEmpleado(Scanner scEntrada, EmpleadoDAO empleadoDAO) {
        //DECLARACIÓN DE VARIABLES
        Integer intNumEmple = null; //Integer que almacenará el número del empleado.
        String strApellidoEmple; //String que almacenará el apellido del empleado.
        String strOficioEmple; //String que almacenará el oficio del empleado.
        int intNumDirector; //Int que almacenará el número del director del empleado.
        int intSalarioEmple; //Int que almacena el salario del empleado.
        int intComisionEmple; //Int que almacena la comisión del empleado.
        int intDepartamento; //Int que almacena el número de departamento del empleado.

        do {
            if (intNumEmple != null) {
                System.out.println("Ese número de empleado ya está siendo usado por otro empleado.");
            }
            intNumEmple = getInt(scEntrada, "empleado", 1, 9999);
        } while (empleadoDAO.read(intNumEmple));

        strApellidoEmple = getString(scEntrada, "apellido", 10);
        strOficioEmple = getString(scEntrada, "oficio", 10);
        intNumDirector = getInt(scEntrada, "director", 1, 9999);
        intSalarioEmple = getInt(scEntrada, "salario", 1, 9999999);
        intComisionEmple = getInt(scEntrada, "comisión", 0, 9999999);
        intDepartamento = getInt(scEntrada, "departamento", 1, 99);

        return new Empleado(intNumEmple, strApellidoEmple, strOficioEmple, intNumDirector, intSalarioEmple,
                intComisionEmple, intDepartamento);
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar al usuario los diferentes campos VARCHAR de la tabla.                             *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param strOpcion Campo a insertar.                                                                              *
     * @param intMaxLength Longitud máxima del campo.                                                                  *
     * @return Devuelve un String con el valor insertado por el usuario.                                               *
     *******************************************************************************************************************/
    private static String getString(Scanner scEntrada, String strOpcion, int intMaxLength) {
        //DECLARACIÓN DE VARIABLES
        String strReturn; //String que se devuelve como resultado del método.

        do {
            System.out.print("Dime " + strOpcion + ": ");
            strReturn = scEntrada.nextLine().toUpperCase();
            if (strReturn.isEmpty()) {
                System.out.println("El campo del " + strOpcion + " no puede estar vacío");
            } else if (strReturn.length() > intMaxLength){
                System.out.println("El campo del " + strOpcion + " no puede tener más de " + intMaxLength
                        + " caracteres.");
                strReturn = "";
            }
        } while (strReturn.isEmpty());
        return strReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar al usuario los diferentes campos INT de la tabla.                                 *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param strOpcion Campo a insertar.                                                                              *
     * @param intMin Valor mínimo del campo.                                                                           *
     * @param intMax Valor máximo del campo.                                                                           *
     * @return Devuelve un int con el valor insertado por el usuario.                                                  *
     *******************************************************************************************************************/
    private static Integer getInt(Scanner scEntrada, String strOpcion, int intMin, int intMax) {
        //DECLARACIÓN DE VARIABLES
        Integer intReturn = null; //Integer que se devuelve como resultado del método.

        do {
            System.out.print("Dime el número del " + strOpcion + ": ");
            try {
                intReturn = Integer.parseInt(scEntrada.nextLine());
                if (intReturn < intMin || intReturn > intMax) {
                    System.out.println("El campo " + strOpcion + " debe estar entre "
                            + intMin + " y " + intMax + ".");
                    intReturn = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("El campo " + strOpcion + " debe ser un valor entero.");
            }
        } while (intReturn == null);
        return intReturn;
    }
}

package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto18_CompruebaOficina.inicio;


import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto18_CompruebaOficina.clases.Empleado;
import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto18_CompruebaOficina.clases.EmpleadoDAO;
import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto18_CompruebaOficina.clases.OficinaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Connection conexion; //Conexion a la base de datos.
        Empleado nuevoEmpleado; //Empleado a insertar.
        EmpleadoDAO empleadoDAO; //EmpleadoDAO para acceso a la BD.
        OficinaDAO oficinaDAO; //OficinaDAO para acceso a la BD.

        conexion = generaConexion();

        if (conexion != null) {
            empleadoDAO = new EmpleadoDAO(conexion);
            oficinaDAO = new OficinaDAO(conexion);
            nuevoEmpleado = generaEmpleado(scEntrada, empleadoDAO, oficinaDAO);
            empleadoDAO.create(nuevoEmpleado);
            cierraConexion(conexion);
        }

        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar un objeto de la clase Empleado.                                                     *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param empleadoDAO EmpleadoDAO para el acceso a la base de datos.                                               *
     * @param oficinaDAO OficinaDAO para el acceso a la base de datos.                                                 *
     * @return Devuelve un objeto de tipo Empleado.                                                                    *
     *******************************************************************************************************************/
    private static Empleado generaEmpleado(Scanner scEntrada, EmpleadoDAO empleadoDAO, OficinaDAO oficinaDAO) {
        //DECLARACIÓN DE VARIABLES
        Integer intNumEmple = null; //Integer que almacenará el número del empleado.
        String strApellidoEmple; //String que almacenará el apellido del empleado.
        String strOficioEmple; //String que almacenará el oficio del empleado.
        int intNumDirector; //Int que almacenará el número del director del empleado.
        int intSalarioEmple; //Int que almacena el salario del empleado.
        int intComisionEmple; //Int que almacena la comisión del empleado.
        Integer intDepartamento = null; //Integer que almacena el número de departamento del empleado.

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

        do {
            if (intDepartamento != null) {
                System.out.println("Ese número de departamento no existe. Vuelve a intentarlo.");
            }
            intDepartamento = getInt(scEntrada, "departamento", 1, 99);
        } while (!oficinaDAO.read(intDepartamento));

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

    /*******************************************************************************************************************
     * Método encargado de generar una conexión a la base de datos.                                                    *
     *                                                                                                                 *
     * @return Devuelve un objeto Connection con la conexión establecida o un null si ha ocurrido algún problema.      *
     *******************************************************************************************************************/
    private static Connection generaConexion() {
        //DATOS DE ACCESO A BASE DE DATOS
        final String STR_URL = "jdbc:mysql://localhost:3306/JAVA"; //Dirección URL de la base de datos.
        final String STR_USER = "root"; //Usuario de la base de datos.
        final String STR_PASSWORD = ""; //Contraseña de la base de datos.

        Connection conexionReturn = null;

        try {
            conexionReturn = DriverManager.getConnection(STR_URL, STR_USER, STR_PASSWORD);
        } catch (SQLTimeoutException e) {
            System.out.println("Time Out con la conexión a la BD.");
        } catch (SQLException e) {
            System.out.println("Se produjo un error en la conexión a la BD.");
        }

        return conexionReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de cerrar la conexión a la base de datos.                                                      *
     *******************************************************************************************************************/
    private static void cierraConexion(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Se produjo un error durante el cierre de la conexión a la BD.");
        }
    }
}

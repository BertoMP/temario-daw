package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto19_CambiaOficina.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto19_CambiaOficina.clases.EmpleadoDAO;
import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto19_CambiaOficina.clases.OficinaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        List<Integer> listadoID = new ArrayList<>(); //ArrayList que almacenará los IDs de los empleados.
        Connection conexion; //Conexión a la BBDD.
        EmpleadoDAO empleadoDAO; //EmpleadoDAO para realizar consultas en BBDD.
        OficinaDAO oficinaDAO; //OficinaDAO para realizar consultas en BBDD.

        //DECLARACIÓN DE VARIABLES
        int intOficinaEmpleOriginal; //Int que almacenará la oficina del empleado.
        int intOficinaEmpleDestino; //Int que almacenará la oficina de destino del empleado.

        conexion = generaConexion();

        if (conexion != null) {
            empleadoDAO = new EmpleadoDAO(conexion);
            oficinaDAO = new OficinaDAO(conexion);

            intOficinaEmpleOriginal = dimeOficina(scEntrada, "origen", oficinaDAO);
            intOficinaEmpleDestino = dimeOficina(scEntrada, "destino", oficinaDAO);

            empleadoDAO.listaEmpleadosId(intOficinaEmpleOriginal, listadoID);

            if (!listadoID.isEmpty()) {
                System.out.println("\nLISTADO ANTES DEL CAMBIO");
                for (Integer intValor : listadoID) {
                    empleadoDAO.read(intValor);
                }

                empleadoDAO.update(intOficinaEmpleOriginal, intOficinaEmpleDestino);

                System.out.println("\nLISTADO DESPUÉS DEL CAMBIO");
                for (Integer inValor : listadoID) {
                    empleadoDAO.read(inValor);
                }
            } else {
                System.out.println("No se han producido cambios, no existían empleados en la oficina con ID "
                        + intOficinaEmpleOriginal + ".");
            }

            scEntrada.close();
            cierraConexion(conexion);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar al usuario un número de identificación de oficina.                                *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param oficinaDAO Objeto para la conexión a la BD.                                                              *
     * @return Devuelve un Int con el ID de la oficina.                                                                *
     *******************************************************************************************************************/
    private static int dimeOficina(Scanner scEntrada, String strOpcion, OficinaDAO oficinaDAO) {
        Integer intOficinaEmple = null;

        do {
            System.out.print("Dime ID de la oficina de " + strOpcion + ": ");
            try {
                intOficinaEmple = Integer.parseInt(scEntrada.nextLine());
                if (!oficinaDAO.read(intOficinaEmple)) {
                    System.out.println("No existe la oficina. Vuelve a intentarlo.");
                    intOficinaEmple = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("El número de oficina debe ser un número entero.");
            }
        } while (intOficinaEmple == null);

        return intOficinaEmple;
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
            System.out.println("Se produjo un error.");
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

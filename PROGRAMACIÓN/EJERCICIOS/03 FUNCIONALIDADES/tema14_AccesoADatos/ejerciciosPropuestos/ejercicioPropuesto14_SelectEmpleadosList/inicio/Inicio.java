package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto14_SelectEmpleadosList.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto14_SelectEmpleadosList.clases.Empleado;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        List<Empleado> listadoEmpleados; //Listado que almacena los empleados.
        Scanner scEntrada = new Scanner(System.in);

        //DECLARACIÓN DE VARIABLES
        LocalDate dFechaMinima; //Date que almacena la fecha mínima a buscar.
        LocalDate dFechaMaxima; //Date que almacena la fecha máxima a buscar.

        dFechaMinima = getDate(scEntrada, "mínima");
        dFechaMaxima = getDate(scEntrada, "maxima");

        scEntrada.close();

        listadoEmpleados = getList(dFechaMinima, dFechaMaxima);

        if (!listadoEmpleados.isEmpty()) {
            System.out.println("LISTADO DE EMPLEADOS CONTRATADOS ENTRE " + dFechaMinima + " Y " + dFechaMaxima);
            for (Empleado empleadoValor : listadoEmpleados) {
                System.out.println(empleadoValor);
            }
        } else {
            System.out.println("No existen empleados con los parámetros establecidos.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar al usuario los diferentes campos DATE de la tabla.                                *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param strOpcion Campo a insertar.                                                                              *
     * @return Devuelve un String con el valor insertado por el usuario.                                               *
     *******************************************************************************************************************/
    private static LocalDate getDate(Scanner scEntrada, String strOpcion) {
        //DECLARACIÓN DE VARIABLES
        LocalDate ldReturn = null; //LocalDate que se devuelve como resultado del método.

        do {
            System.out.print("Dime la fecha " + strOpcion + " (formato aaaa-MM-dd): ");
            try {
                ldReturn = LocalDate.parse(scEntrada.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Debes introducir una fecha válida.");
            }
        } while (ldReturn == null);
        return ldReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de buscar en la base de datos los empleados y devolver un listado de objetos empleado.         *
     *                                                                                                                 *
     * @param dFechaMinima Fecha mínima de los empleados a buscar.                                                     *
     * @param dFechaMaxima Fecha máxima de los empleados a buscar.                                                     *
     * @return Devuelve un listado con los empleados encontrados.                                                      *
     *******************************************************************************************************************/
    private static List<Empleado> getList(LocalDate dFechaMinima, LocalDate dFechaMaxima) {
        //DECLARACIÓN DE OBJETOS
        List<Empleado> listadoReturn = null; //Listado a devolver.
        Empleado nuevoEmpleado; //Objeto de tipo empleado

        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.
        String strApellidoEmple; //String que almacenará el apellido del empleado.
        LocalDate dFechaContratacion; //LocalDate que almacenará la fecha de contratación del empleado.

        try (Connection conexion = generaConexion()) {
            listadoReturn = new ArrayList<>();
            strComandoSql = "SELECT APELLIDO, FECHA_ALT " +
                            "FROM EMPLE " +
                            "WHERE FECHA_ALT BETWEEN ? AND ?";

            PreparedStatement stSentenciaSql = conexion.prepareStatement(strComandoSql);
            stSentenciaSql.setDate(1, Date.valueOf(dFechaMinima));
            stSentenciaSql.setDate(2, Date.valueOf(dFechaMaxima));

            ResultSet rsResultadoConsulta = stSentenciaSql.executeQuery();

            while (rsResultadoConsulta.next()) {
                strApellidoEmple = rsResultadoConsulta.getString("APELLIDO");
                dFechaContratacion = LocalDate.parse(rsResultadoConsulta.getString("FECHA_ALT"));
                nuevoEmpleado = new Empleado(strApellidoEmple, dFechaContratacion);
                listadoReturn.add(nuevoEmpleado);
            }

            if (listadoReturn.isEmpty()) {
                listadoReturn = null;
                System.out.println("No existen empleados con los datos indicados.");
            }
        } catch (NullPointerException ignored) {
        } catch (SQLException e) {
            System.out.println("Se produjo un error al intentar acceder a los datos.");
        }

        return listadoReturn;
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
}

package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto16_ModificacionEj5.clases;

import java.sql.*;

public class EmpleadoDAO {
    /*******************************************************************************************************************
     * Método encargado de insertar en la base de datos el objeto empleado pasado por parámetro.                       *
     *                                                                                                                 *
     * @param nuevoEmpleado Empleado a insertar.                                                                       *
     *******************************************************************************************************************/
    public static void create (Empleado nuevoEmpleado) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.

        try (Connection conexion = generaConexion()) {
            strComandoSql = "INSERT INTO EMPLE (EMP_NO, APELLIDO, OFICIO, DIR, FECHA_ALT, SALARIO, COMISION, DEPT_NO) " +
                                "VALUES (?, ?, ?, ?, CURDATE(), ?, ?, ?)";

            PreparedStatement stSentenciaSql = conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, nuevoEmpleado.getIntNum());
            stSentenciaSql.setString(2, nuevoEmpleado.getStrApellido());
            stSentenciaSql.setString(3, nuevoEmpleado.getStrOficio());
            stSentenciaSql.setInt(4, nuevoEmpleado.getIntDirector());
            stSentenciaSql.setInt(5, nuevoEmpleado.getIntSalario());
            stSentenciaSql.setInt(6, nuevoEmpleado.getIntComision());
            stSentenciaSql.setInt(7, nuevoEmpleado.getIntDepartamento());

            stSentenciaSql.executeUpdate();

            System.out.println("Inserción realizada con éxito.");
        } catch (NullPointerException ignored) {
        } catch (SQLException e) {
            System.out.println("Se ha producido un error durante la inserción.");
        }
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
            System.out.println("Se produjo un error durante la conexión a la base de datos.");
        }

        return conexionReturn;
    }
}

package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto20_BorraEmpleado.clases;

import java.sql.*;

/***********************************************************************************************************************
 * Clase EmpleadoDAO.                                                                                                  *
 ***********************************************************************************************************************/

public class EmpleadoDAO {
    /*******************************************************************************************************************
     * Método encargado de eliminar un empleado.                                                                       *
     *                                                                                                                 *
     * @param intIdEmpleado Id del empleado a eliminar.                                                                *
     *******************************************************************************************************************/
    public static void delete(int intIdEmpleado) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacena el comando SQL.
        int intCantidadCambios; //Int que almacena la cantidad de empleados cambiados.

        try (Connection conexion = generaConexion()){
            strComandoSql = "DELETE " +
                                "FROM EMPLE " +
                                "WHERE EMP_NO = ?";

            PreparedStatement stSentenciaSql = conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, intIdEmpleado);

            intCantidadCambios = stSentenciaSql.executeUpdate();

            if (intCantidadCambios > 0) {
                System.out.println("Empleado eliminado.");
            } else {
                System.out.println("No existe el empleado en la base de datos.");
            }
        } catch (NullPointerException ignored) {
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al intentar borrar al empleado.");
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
            System.out.println("Se produjo un error.");
        }

        return conexionReturn;
    }
}

package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto11_SelectEmpleados.inicio;

import java.sql.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.
        String strNumEmple; //String que almacenará el número del empleado.
        String strApellidoEmple; //String que almacenará el apellido del empleado.
        String strOficioEmple; //String que almacenará el oficio del empleado.
        String strNumDirector; //String que almacenará el número del director del empleado.
        String strFechaContrato; //String que almacenará la fecha del contrato del empleado.
        String strSalarioEmple; //String que almacena el salario del empleado.
        String strComisionEmple; //String que almacena la comisión del empleado.
        String strDepartamento; //String que almacena el número de departamento del empleado.

        try (Connection conexion = generaConexion();
             Statement stSentenciaSql = conexion.createStatement()) {

            strComandoSql = "SELECT * " +
                            "FROM EMPLE";

            ResultSet rsResultadoConsulta = stSentenciaSql.executeQuery(strComandoSql);
            System.out.println("\t\tLISTADO DE EMPLEADOS");
            while (rsResultadoConsulta.next()) {
                strNumEmple = rsResultadoConsulta.getString("EMP_NO");
                strApellidoEmple = rsResultadoConsulta.getString("APELLIDO");
                strOficioEmple = rsResultadoConsulta.getString("OFICIO");
                strNumDirector = rsResultadoConsulta.getString("DIR");
                if (strNumDirector == null) {
                    strNumDirector = "Sin director asociado";
                }
                strFechaContrato = rsResultadoConsulta.getString("FECHA_ALT");
                strSalarioEmple = rsResultadoConsulta.getString("SALARIO");
                strComisionEmple = rsResultadoConsulta.getString("COMISION");
                if (strComisionEmple == null) {
                    strComisionEmple = "Sin comisión";
                }
                strDepartamento = rsResultadoConsulta.getString("DEPT_NO");

                System.out.println("\nEMPLEADO NÚMERO " + strNumEmple
                        + "\n\t - Apellido: " + strApellidoEmple
                        + "\n\t - Oficio: " + strOficioEmple
                        + "\n\t - Director: " + strNumDirector
                        + "\n\t - Fecha contrato: " + strFechaContrato
                        + "\n\t - Salario: " + strSalarioEmple
                        + "\n\t - Comisión: " + strComisionEmple
                        + "\n\t - Departamento: " + strDepartamento);
            }
        } catch (NullPointerException ignored) {
        } catch (SQLException e) {
            System.out.println("Se produjo un error al intentar acceder a los datos.");
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
            System.out.println("Se produjo un error de conexión a la base de datos.");
        }

        return conexionReturn;
    }
}

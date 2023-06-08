package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto17_BuscaEmpleadoInsercion.clases;

import java.sql.*;

/***********************************************************************************************************************
 * Clase EmpleadoDAO.                                                                                                  *
 ***********************************************************************************************************************/

public class EmpleadoDAO {
    //DECLARACIÓN DE ATRIBUTOS
    private Connection conexion; //Connection para la conexión a la base de datos.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public EmpleadoDAO() {
        this.conexion = generaConexion();
    }


    /*******************************************************************************************************************
     * Método encargado de comprobar si se ha podido establecer conexión.                                              *
     *                                                                                                                 *
     * @return Devuelve un booleano true (si hay conexión) o false (si no existe conexión).                            *
     *******************************************************************************************************************/
    public boolean existeConexion() {
        return this.conexion != null;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar en la base de datos el objeto empleado pasado por parámetro.                       *
     *                                                                                                                 *
     * @param nuevoEmpleado Empleado a insertar.                                                                       *
     *******************************************************************************************************************/
    public void create (Empleado nuevoEmpleado) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.

        try {
            strComandoSql = "INSERT INTO EMPLE (EMP_NO, APELLIDO, OFICIO, DIR, FECHA_ALT, SALARIO, COMISION, DEPT_NO) " +
                                "VALUES (?, ?, ?, ?, CURDATE(), ?, ?, ?)";

            PreparedStatement stSentenciaSql = this.conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, nuevoEmpleado.getIntNum());
            stSentenciaSql.setString(2, nuevoEmpleado.getStrApellido());
            stSentenciaSql.setString(3, nuevoEmpleado.getStrOficio());
            stSentenciaSql.setInt(4, nuevoEmpleado.getIntDirector());
            stSentenciaSql.setInt(5, nuevoEmpleado.getIntSalario());
            stSentenciaSql.setInt(6, nuevoEmpleado.getIntComision());
            stSentenciaSql.setInt(7, nuevoEmpleado.getIntDepartamento());

            stSentenciaSql.executeUpdate();

            System.out.println("Inserción realizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error durante la inserción.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar si en la base de datos existe un empleado con el número de ID pasado por          *
     * parámetro.                                                                                                      *
     *                                                                                                                 *
     * @param intNumEmple Número de ID del empleado.                                                                   *
     * @return Devuelve un booleano en función de si existe el empleado en la BD (true) o no (false).                  *
     *******************************************************************************************************************/
    public boolean read(int intNumEmple) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacena el comando SQL a realizar.

        try {
            strComandoSql = "SELECT * " +
                            "FROM EMPLE " +
                            "WHERE EMP_NO = ?";

            PreparedStatement stSentenciaSql = this.conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, intNumEmple);

            ResultSet rsResultadoConsulta = stSentenciaSql.executeQuery();

            if (rsResultadoConsulta.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Se produjo un error durante la lectura de datos.");
        }
        return false;
    }

    /*******************************************************************************************************************
     * Método encargado de cerrar la conexión a la base de datos.                                                      *
     *******************************************************************************************************************/
    public void cierraConexion() {
        try {
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Se produjo un error durante el cierre de la conexión a la BD.");
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

package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto23_ModificaCiudadNombre.clases;

import java.sql.*;

/***********************************************************************************************************************
 * Clase OficinaDAO.                                                                                                   *
 ***********************************************************************************************************************/

public class OficinaDAO {
    //DECLARACIÓN DE ATRIBUTOS
    private Connection conexion; //Connection para la conexión a la base de datos.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *******************************************************************************************************************/
    public OficinaDAO() {
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
     * Método encargado de modificar la ciudad del registro cuya ID coincide con el pasado por parámetro.              *
     *                                                                                                                 *
     * @param intIdOficina ID de la oficina a modificar.                                                               *
     * @param strCambio Cambio a realizar.                                                                             *
     *******************************************************************************************************************/
    public void update(int intIdOficina, int intOpcionCambio, String strCambio) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacena el comando SQL a realizar.
        String strSetCambio; //String que almacena el campo a cambiar.

        strSetCambio = (intOpcionCambio == 1) ? "LOC" : "DNOMBRE";

        try {
            strComandoSql = "UPDATE DEPART " +
                                "SET " + strSetCambio + " = ? " +
                                "WHERE DEPT_NO = ?";

            PreparedStatement stSentenciaSql = this.conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setString(1, strCambio);
            stSentenciaSql.setInt(2, intIdOficina);

            stSentenciaSql.executeUpdate();

            System.out.println("Modificación realizada.");
        } catch (SQLException e) {
            System.out.println("Se produjo un error durante la modificación.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar si en la base de datos existe una oficina con el número de ID pasado por          *
     * parámetro.                                                                                                      *
     *                                                                                                                 *
     * @param intNumOficina Número de ID de la oficina.                                                                *
     * @return Devuelve un booleano en función de si existe el empleado en la BD (true) o no (false).                  *
     *******************************************************************************************************************/
    public boolean existeOficina(int intNumOficina) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacena el comando SQL a realizar.

        try {
            strComandoSql = "SELECT * " +
                            "FROM DEPART " +
                            "WHERE DEPT_NO = ?";

            PreparedStatement stSentenciaSql = this.conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, intNumOficina);

            ResultSet rsResultadoConsulta = stSentenciaSql.executeQuery();

            if (rsResultadoConsulta.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Se produjo un error al comprobar la existencia de la oficina en la BD.");
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
            System.out.println("Se produjo un error al intentar la conexión a la BD.");
        }

        return conexionReturn;
    }
}

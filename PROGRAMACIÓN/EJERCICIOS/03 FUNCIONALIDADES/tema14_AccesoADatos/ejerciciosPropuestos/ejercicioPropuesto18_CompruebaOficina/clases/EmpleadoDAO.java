package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto18_CompruebaOficina.clases;

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
    public EmpleadoDAO(Connection conexion) {
        this.conexion = conexion;
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
            System.out.println("Se produjo un error al comprobar si el empleado existe.");
        }
        return false;
    }
}

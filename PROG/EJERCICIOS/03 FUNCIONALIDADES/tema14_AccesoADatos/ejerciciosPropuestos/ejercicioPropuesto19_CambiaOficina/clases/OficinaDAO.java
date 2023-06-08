package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto19_CambiaOficina.clases;

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
    public OficinaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /*******************************************************************************************************************
     * Método encargado de comprobar si en la base de datos existe una oficina con el número de ID pasado por          *
     * parámetro.                                                                                                      *
     *                                                                                                                 *
     * @param intNumOficina Número de ID de la oficina.                                                                *
     * @return Devuelve un booleano en función de si existe el empleado en la BD (true) o no (false).                  *
     *******************************************************************************************************************/
    public boolean read(int intNumOficina) {
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
            System.out.println("Se produjo un error al comprobar si la oficina existe en la base de datos.");
        }
        return false;
    }
}

package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto19_CambiaOficina.clases;

import java.sql.*;
import java.util.List;

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
     * Método encargado de comprobar si en la base de datos existe un empleado con el número de ID pasado por          *
     * parámetro.                                                                                                      *
     *                                                                                                                 *
     * @param intNumEmple Número de ID del empleado.                                                                   *
     * @return Devuelve un booleano en función de si existe el empleado en la BD (true) o no (false).                  *
     *******************************************************************************************************************/
    public boolean read(int intNumEmple) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacena el comando SQL a realizar.
        String strNombreEmple; //String que almacenará el nombre del empleado.
        int intOficinaEmple; //Int que almacenará la oficina del empleado.

        try {
            strComandoSql = "SELECT APELLIDO, DEPT_NO " +
                            "FROM EMPLE " +
                            "WHERE EMP_NO = ?";

            PreparedStatement stSentenciaSql = this.conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, intNumEmple);

            ResultSet rsResultadoConsulta = stSentenciaSql.executeQuery();

            while (rsResultadoConsulta.next()) {
                strNombreEmple = rsResultadoConsulta.getString("APELLIDO");

                try {
                    intOficinaEmple = Integer.parseInt(rsResultadoConsulta.getString("DEPT_NO"));
                } catch (NumberFormatException e) {
                    System.out.println("El número de oficina no es un valor entero. Se fija a 0.");
                    intOficinaEmple = 0;
                }

                System.out.println("EMPLEADO NÚMERO " + intNumEmple + " -> Nombre: " + strNombreEmple
                        + " (Oficina " + intOficinaEmple + ").");
            }
        } catch (SQLException e) {
            System.out.println("Se produjo un error.");
        }
        return false;
    }

    /*******************************************************************************************************************
     * Método encargado de actualizar los registros de los empleados.                                                  *
     *                                                                                                                 *
     * @param intNumOficinaOrigen ID de la oficina original.                                                           *
     * @param intNumOficinaDestino ID de la oficina de destino.                                                        *
     *******************************************************************************************************************/
    public void update(int intNumOficinaOrigen, int intNumOficinaDestino) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.
        int intNumCambios; //Int que almacena la cantidad de registros cambiados.

        try {
            strComandoSql = "UPDATE EMPLE " +
                                "SET DEPT_NO = ? " +
                                "WHERE DEPT_NO = ?";

            PreparedStatement stSentenciaSql = this.conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, intNumOficinaDestino);
            stSentenciaSql.setInt(2, intNumOficinaOrigen);

            intNumCambios = stSentenciaSql.executeUpdate();
            System.out.println("\nActualización realizada. Se han actualizado " + intNumCambios + " registros.");
        } catch (SQLException e) {
            System.out.println("Se produjo un error. No se pudo llevar a cabo la actualización.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de rellenar una lista con los IDs de los empleados de una determinada oficina.                 *
     *                                                                                                                 *
     * @param intOficina Oficina a la que pertenecen los empleados.                                                    *
     * @param listado Listado a rellenar.                                                                              *
     *******************************************************************************************************************/
    public void listaEmpleadosId (int intOficina, List<Integer> listado) {
        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.
        int intID; //Int que almacena el ID del usuario.

        try {
            strComandoSql = "SELECT EMP_NO " +
                            "FROM EMPLE " +
                            "WHERE DEPT_NO = ?";

            PreparedStatement stSentenciaSql = this.conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, intOficina);

            ResultSet rsResultadoConsulta = stSentenciaSql.executeQuery();

            while (rsResultadoConsulta.next()) {
                try {
                    intID = Integer.parseInt(rsResultadoConsulta.getString("EMP_NO"));
                } catch (NumberFormatException e) {
                    System.out.println("El número de empleado no es un número válido. Se fija a 0.");
                    intID = 0;
                }
                listado.add(intID);
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un error durante la recogida de datos inicial.");
        }
    }
}

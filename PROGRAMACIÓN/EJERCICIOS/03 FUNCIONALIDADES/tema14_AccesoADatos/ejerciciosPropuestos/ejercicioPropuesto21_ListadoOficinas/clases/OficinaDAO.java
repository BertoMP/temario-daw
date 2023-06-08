package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto21_ListadoOficinas.clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************************
 * Clase OficinaDAO.                                                                                                   *
 ***********************************************************************************************************************/

public class OficinaDAO {
    /*******************************************************************************************************************
     * Método encargado de realizar una búsqueda en la base de datos de todas las oficinas.                            *
     *******************************************************************************************************************/
    public static List<Oficina> listadoOficinas() {
        //DECLARACIÓN DE OBJETOS
        Oficina nuevaOficina; //Objeto de tipo oficina.
        List<Oficina> listado = null; //Listado que guardará todas las oficinas de la BD.

        //DECLARACION DE VARIABLES
        String strComandoSql; //String que almacena el comando SQL a ejecutar.
        Integer intOficina; //Int que almacenará el número de identificación de la oficina.
        String strNombreOficina; //String que almacenará el nombre de la oficina.
        String strCiudadOficina; //String que almacenará la ciudad de la oficina.

        try (Connection conexion = generaConexion()) {
            listado = new ArrayList<>();

            strComandoSql = "SELECT * " +
                            "FROM DEPART";

            PreparedStatement stSentenciaSql = conexion.prepareStatement(strComandoSql);

            ResultSet rsResultadoConsulta = stSentenciaSql.executeQuery();

            while (rsResultadoConsulta.next()) {
                try {
                    intOficina = Integer.parseInt(rsResultadoConsulta.getString("DEPT_NO"));
                } catch (NumberFormatException e) {
                    System.out.println("El número de la oficina no es un valor entero. Se sustituye por valor null.");
                    intOficina = null;
                }

                strCiudadOficina = rsResultadoConsulta.getString("LOC");
                strNombreOficina = rsResultadoConsulta.getString("DNOMBRE");

                nuevaOficina = new Oficina(intOficina, strNombreOficina, strCiudadOficina);
                listado.add(nuevaOficina);
            }
        } catch (NullPointerException ignored) {
        } catch (SQLException e) {
            System.out.println("Se produjo un error durante el acceso a los datos.");
        }

        return listado;
    }

    /*******************************************************************************************************************
     * Método encargado de generar una conexión a la base de datos.                                                    *
     *                                                                                                                 *
     * @return Devuelve un objeto Connection con la conexión establecida o un null si ha ocurrido algún problema.      *
     *******************************************************************************************************************/
    private static Connection generaConexion() {
        final String STR_URL = "jdbc:mysql://localhost:3306/JAVA"; //Dirección URL de la base de datos.
        final String STR_USER = "root"; //Usuario de la base de datos.
        final String STR_PASSWORD = ""; //Contraseña de la base de datos.

        Connection conexionReturn = null;

        try {
            conexionReturn = DriverManager.getConnection(STR_URL, STR_USER, STR_PASSWORD);
        } catch (SQLTimeoutException e) {
            System.out.println("Time Out con la conexión a la BD.");
        } catch (SQLException e) {
            System.out.println("Se produjo un error al intentar acceder a la base de datos.");
        }

        return conexionReturn;
    }
}

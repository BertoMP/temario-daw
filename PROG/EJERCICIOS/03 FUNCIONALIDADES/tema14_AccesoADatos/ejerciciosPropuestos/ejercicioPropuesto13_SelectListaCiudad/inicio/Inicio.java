package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto13_SelectListaCiudad.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto12_SelectLista.clases.Oficina;

import java.sql.*;
import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        List<Oficina> listadoOficinas; //Listado que almacena las oficinas.

        //DECLARACIÓN DE VARIABLES
        String strCiudadBusqueda; //String que almacenará la ciudad a buscar.

        do {
            System.out.print("Dime ciudad a buscar: ");
            strCiudadBusqueda = new Scanner(System.in).nextLine().toUpperCase();
            if (strCiudadBusqueda.isEmpty()) {
                System.out.println("El campo ciudad no puede estar vacío.");
            }
        } while (strCiudadBusqueda.isEmpty());

        listadoOficinas = getList(strCiudadBusqueda);

        if (listadoOficinas != null) {
            System.out.println("\t\tLISTADO DE OFICINAS EN " + strCiudadBusqueda);
            for (Oficina oficinaValor : listadoOficinas) {
                System.out.println(oficinaValor);
            }
        }
    }

    /*******************************************************************************************************************
     * Método encargado de buscar en la base de datos las oficinas y devolver un listado de objetos oficina.           *
     *                                                                                                                 *
     * @param strCiudad Ciudad en la que buscar oficinas.                                                              *
     *******************************************************************************************************************/
    private static List<Oficina> getList (String strCiudad) {
        //DECLARACIÓN DE OBJETOS
        List<Oficina> listadoReturn = null; //Listado a devolver.
        Oficina nuevaOficina; //Objeto de tipo oficina

        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.
        Integer intOficina; //Int que almacenará el número de identificación de la oficina.
        String strNombreOficina; //String que almacenará el nombre de la oficina.
        String strCiudadOficina; //String que almacenará la ciudad de la oficina.

        try (Connection conexion = generaConexion()) {
            listadoReturn = new ArrayList<>();

            strComandoSql = "SELECT * " +
                            "FROM DEPART " +
                            "WHERE LOC = ?";

            PreparedStatement stSentenciaSql = conexion.prepareStatement(strComandoSql);
            stSentenciaSql.setString(1, strCiudad);

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
                listadoReturn.add(nuevaOficina);
            }

            if (listadoReturn.isEmpty()) {
                listadoReturn = null;
                System.out.println("No existen oficinas en la ciudad indicada.");
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
            System.out.println("Se produjo un error de conexión a la base de datos.");
        }

        return conexionReturn;
    }
}

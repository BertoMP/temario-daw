package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto15_InsertEmpleado.inicio;

import java.sql.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.

        //DECLARACIÓN DE VARIABLES
        String strComandoSql; //String que almacenará el comando SQL a realizar.
        int intNumEmple; //Int que almacenará el número del empleado.
        String strApellidoEmple; //String que almacenará el apellido del empleado.
        String strOficioEmple; //String que almacenará el oficio del empleado.
        int intNumDirector; //Int que almacenará el número del director del empleado.
        int intSalarioEmple; //Int que almacena el salario del empleado.
        int intComisionEmple; //Int que almacena la comisión del empleado.
        int intDepartamento; //Int que almacena el número de departamento del empleado.

        intNumEmple = getInt(scEntrada, "empleado", 1, 9999);
        strApellidoEmple = getString(scEntrada, "apellido");
        strOficioEmple = getString(scEntrada, "oficio");
        intNumDirector = getInt(scEntrada, "director", 1, 9999);
        intSalarioEmple = getInt(scEntrada, "salario", 1, 9999999);
        intComisionEmple = getInt(scEntrada, "comisión", 0, 9999999);
        intDepartamento = getInt(scEntrada, "departamento", 1, 99);

        scEntrada.close();

        try (Connection conexion = generaConexion()) {
            strComandoSql = "INSERT INTO EMPLE (EMP_NO, APELLIDO, OFICIO, DIR, FECHA_ALT, SALARIO, COMISION, DEPT_NO) "
                                + "VALUES (?, ?, ?, ?, CURDATE(), ?, ?, ?)";

            PreparedStatement stSentenciaSql = conexion.prepareStatement(strComandoSql);

            stSentenciaSql.setInt(1, intNumEmple);
            stSentenciaSql.setString(2, strApellidoEmple);
            stSentenciaSql.setString(3, strOficioEmple);
            stSentenciaSql.setInt(4, intNumDirector);
            stSentenciaSql.setInt(5, intSalarioEmple);
            stSentenciaSql.setInt(6, intComisionEmple);
            stSentenciaSql.setInt(7, intDepartamento);

            stSentenciaSql.executeUpdate();
            System.out.println("Inserción del empleado realizada con éxito.");
        } catch (NullPointerException ignored) {
        } catch (SQLException e) {
            System.out.println("Se produjo un error al intentar insertar los datos.");
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

    /*******************************************************************************************************************
     * Método encargado de solicitar al usuario los diferentes campos VARCHAR de la tabla.                             *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param strOpcion Campo a insertar.                                                                              *
     * @return Devuelve un String con el valor insertado por el usuario.                                               *
     *******************************************************************************************************************/
    private static String getString(Scanner scEntrada, String strOpcion) {
        //DECLARACIÓN DE VARIABLES
        String strReturn; //String que se devuelve como resultado del método.

        do {
            System.out.print("Dime " + strOpcion + ": ");
            strReturn = scEntrada.nextLine().toUpperCase();
            if (strReturn.isEmpty()) {
                System.out.println("El campo del " + strOpcion + " no puede estar vacío");
            } else if (strReturn.length() > 10){
                System.out.println("El campo del " + strOpcion + " no puede tener más de 10 caracteres.");
                strReturn = "";
            }
        } while (strReturn.isEmpty());
        return strReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar al usuario los diferentes campos INT de la tabla.                                 *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param strOpcion Campo a insertar.                                                                              *
     * @param intMin Valor mínimo del campo.                                                                           *
     * @param intMax Valor máximo del campo.                                                                           *
     * @return Devuelve un int con el valor insertado por el usuario.                                                  *
     *******************************************************************************************************************/
    private static Integer getInt(Scanner scEntrada, String strOpcion, int intMin, int intMax) {
        //DECLARACIÓN DE VARIABLES
        Integer intReturn = null; //Integer que se devuelve como resultado del método.

        do {
            System.out.print("Dime el número del " + strOpcion + ": ");
            try {
                intReturn = Integer.parseInt(scEntrada.nextLine());
                if (intReturn < intMin || intReturn > intMax) {
                    System.out.println("El campo " + strOpcion + " debe estar entre "
                            + intMin + " y " + intMax + ".");
                    intReturn = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("El campo " + strOpcion + " debe ser un valor entero.");
            }
        } while (intReturn == null);
        return intReturn;
    }
}

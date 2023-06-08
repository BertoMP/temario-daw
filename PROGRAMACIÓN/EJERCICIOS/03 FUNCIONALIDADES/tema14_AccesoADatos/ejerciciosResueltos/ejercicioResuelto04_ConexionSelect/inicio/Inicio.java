package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto04_ConexionSelect.inicio;

import java.sql.*;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        Statement stSentencia;
        ResultSet rsResultadoConsulta;
        String strComandoSql;
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";
        String strGrupo;
        String strNombre;
        String strFechaNacimiento;

        try (Connection conexion = DriverManager.getConnection(strUrl,strUser,strPass)) {
            System.out.println("Conexión establecida.");
            stSentencia = conexion.createStatement();

            do {
                System.out.print("Dime curso: ");
                strGrupo = new Scanner(System.in).nextLine().toUpperCase();
                if (strGrupo.isEmpty()) {
                    System.out.println("El curso no puede estar vacío.");
                }
            } while (strGrupo.isEmpty());

            strComandoSql = "SELECT NOMBRE, F_NAC " +
                            "FROM ALUMNOS " +
                            "WHERE CURSO = '" + strGrupo + "'";

            rsResultadoConsulta = stSentencia.executeQuery(strComandoSql);
            System.out.println("LISTADO DE ALUMNOS");
            while (rsResultadoConsulta.next()) {
                strNombre = rsResultadoConsulta.getString("NOMBRE");
                strFechaNacimiento = rsResultadoConsulta.getString("F_NAC");
                System.out.println("Nombre: " + strNombre + " -> F. nacimiento: " + strFechaNacimiento);
            }

        } catch (SQLException e) {
            System.out.println("Se ha producido un error.");
        }
    }
}

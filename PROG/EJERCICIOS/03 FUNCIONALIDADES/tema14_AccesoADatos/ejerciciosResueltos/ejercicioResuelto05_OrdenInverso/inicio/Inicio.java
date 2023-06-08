package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto05_OrdenInverso.inicio;

import java.sql.*;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        Statement stSentenciaSql;
        ResultSet rsResultadoConsulta;

        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";

        String strComandoSql;
        String strGrupo;
        String strNombre;
        Date dFechaNacimiento;

        try (Connection conexion = DriverManager.getConnection(strUrl,strUser,strPass)) {
            do {
                System.out.print("Dime curso: ");
                strGrupo = new Scanner(System.in).nextLine().toUpperCase();
                if (strGrupo.isEmpty()) {
                    System.out.println("El curso no puede estar vacío.");
                }
            } while (strGrupo.isEmpty());

            stSentenciaSql = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

            strComandoSql = "SELECT NOMBRE, F_NAC " +
                    "FROM ALUMNOS " +
                    "WHERE CURSO = '" + strGrupo + "'";

            rsResultadoConsulta = stSentenciaSql.executeQuery(strComandoSql);
            rsResultadoConsulta.afterLast();

            if (!rsResultadoConsulta.previous()) {
                System.out.println("No hay alumnos en ese grupo.");
            } else {
                do {
                    strNombre = rsResultadoConsulta.getString("NOMBRE");
                    dFechaNacimiento = rsResultadoConsulta.getDate("F_NAC");
                    System.out.println("Alumno: " + strNombre + " -> Fecha de nacimiento: " + dFechaNacimiento);
                } while (rsResultadoConsulta.previous());
            }
        } catch (SQLException e) {
            System.out.println("Se produjo un error.");
        }
    }
}

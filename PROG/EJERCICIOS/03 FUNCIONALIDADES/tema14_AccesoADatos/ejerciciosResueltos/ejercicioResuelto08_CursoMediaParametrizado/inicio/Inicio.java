package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto08_CursoMediaParametrizado.inicio;

import java.sql.*;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";

        PreparedStatement stSentenciaSql;
        ResultSet rsResultadoConsulta;
        String strConsultaSql;

        Scanner scEntrada = new Scanner(System.in);

        String strCurso;
        Double rlnNotaCorte = null;

        try (Connection conexion = DriverManager.getConnection(strUrl,strUser,strPass)) {
            do {
                System.out.print("Dime el curso: ");
                strCurso = scEntrada.nextLine();
                if (strCurso.isEmpty()) {
                    System.out.println("El curso no puede estar vacío.");
                }
            } while (strCurso.isEmpty());

            do {
                System.out.println("Dime la nota de corte: ");
                try {
                    rlnNotaCorte = Double.parseDouble(scEntrada.nextLine().replace(',', '.'));
                } catch (NumberFormatException e) {
                    System.out.println("La nota debe ser un número decimal.");
                }
                if (rlnNotaCorte < 0) {
                    System.out.println("La nota no puede ser negativa.");
                    rlnNotaCorte = null;
                }
            } while (rlnNotaCorte == null);

            strConsultaSql = "SELECT NOMBRE, MEDIA " +
                             "FROM ALUMNOS " +
                             "WHERE CURSO = ? " +
                                "AND MEDIA > ?";

            stSentenciaSql = conexion.prepareStatement(strConsultaSql);

            stSentenciaSql.setString(1, strCurso);
            stSentenciaSql.setDouble(2, rlnNotaCorte);

            rsResultadoConsulta = stSentenciaSql.executeQuery();

            System.out.println("LISTADO DE ALUMNOS");
            while (rsResultadoConsulta.next()) {
                System.out.println("Alumno: " + rsResultadoConsulta.getString("NOMBRE") + " -> "
                        + rsResultadoConsulta.getDouble("MEDIA"));
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un error.");
        }
    }
}

package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto09_NotaBienNotable;

import java.sql.*;

public class Inicio {
    public static void inicio() {
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";

        try (Connection conexion = DriverManager.getConnection(strUrl, strUser, strPass)) {
            System.out.println("ALUMNOS CON NOTA DE BIEN");
            muestraAlumnos(conexion, 6, 7);
            System.out.println("\nALUMNOS CON NOTA DE NOTABLE");
            muestraAlumnos(conexion, 7, 9);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error.");
        }
    }

    private static void muestraAlumnos (Connection conexion, double rlnNotaMin, double rlnNotaMax) throws SQLException {
        String strComandoSql;
        PreparedStatement stSentenciaSql;
        ResultSet rsResultadoConsulta;

        strComandoSql = "SELECT NOMBRE, MEDIA " +
                        "FROM ALUMNOS " +
                        "WHERE MEDIA >= ? " +
                            "AND MEDIA < ? " +
                        "ORDER BY MEDIA ASC";

        stSentenciaSql = conexion.prepareStatement(strComandoSql);
        stSentenciaSql.setDouble(1, rlnNotaMin);
        stSentenciaSql.setDouble(2, rlnNotaMax);

        rsResultadoConsulta = stSentenciaSql.executeQuery();

        while (rsResultadoConsulta.next()) {
            System.out.println("Alumno: " + rsResultadoConsulta.getString("NOMBRE") + " -> "
                    + rsResultadoConsulta.getDouble("MEDIA"));
        }
    }
}

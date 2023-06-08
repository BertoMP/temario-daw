package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto01_ConexionActualizacion.inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inicio {
    public static void inicio() {
        Statement stSentenciaSql;
        String strComando;
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";

        try (Connection conexion = DriverManager.getConnection(strUrl, strUser, strPass)) {
            System.out.println("Conexión establecida con base de datos.");
            stSentenciaSql = conexion.createStatement();
            strComando = "UPDATE ALUMNOS " +
                            "SET MEDIA = MEDIA + 1 " +
                            "WHERE CURSO = '1B'";
            stSentenciaSql.executeUpdate(strComando);
            System.out.println("Se ha modificado la media de los alumnos.");
        } catch (SQLException e) {
            System.out.println("Se produjo un error.");
        }
    }
}
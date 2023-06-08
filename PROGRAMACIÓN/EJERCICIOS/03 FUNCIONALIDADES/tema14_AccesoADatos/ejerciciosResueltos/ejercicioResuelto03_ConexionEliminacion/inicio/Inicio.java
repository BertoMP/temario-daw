package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto03_ConexionEliminacion.inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        Statement stSentencia;
        String strComandoSql;
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";
        Integer intNia = null;

        try (Connection conexion = DriverManager.getConnection(strUrl,strUser,strPass)) {
            System.out.println("Conexión establecida.");

            stSentencia = conexion.createStatement();

            do {
                System.out.print("Dime NIA: ");
                try {
                    intNia = Integer.parseInt(new Scanner(System.in).nextLine());
                    if (intNia < 0) {
                        System.out.println("El NIA no puede ser negativo.");
                        intNia = null;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un valor numérico entero.");
                }
            } while (intNia == null);

            strComandoSql = "DELETE " +
                                "FROM ALUMNOS " +
                                "WHERE NIA = " + intNia;

            stSentencia.executeUpdate(strComandoSql);

            System.out.println("Eliminación realizada.");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error.");
        }
    }
}

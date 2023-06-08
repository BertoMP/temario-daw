package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto07_SQLInjection.inicio;

import java.sql.*;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";

        Statement stSetenciaSql;
        String strConsultaSql;

        String strNombreAlumno;

        try (Connection conexion = DriverManager.getConnection(strUrl,strUser,strPass)) {
            stSetenciaSql = conexion.createStatement();

            do {
                System.out.print("Nombre del alumno: ");
                strNombreAlumno = new Scanner(System.in).nextLine();
                if (strNombreAlumno.isEmpty()) {
                    System.out.println("El nombre del alumno no puede ser un campo vacío.");
                }
            } while (strNombreAlumno.isEmpty());

            strConsultaSql = "DELETE " +
                                "FROM ALUMNOS " +
                                "WHERE NOMBRE = '" + strNombreAlumno + "'";

            stSetenciaSql.executeUpdate(strConsultaSql);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error.");
        }
    }
}

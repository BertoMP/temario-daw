package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto02_ConexionInsercion.inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        Scanner scEntrada = new Scanner(System.in);
        Statement stSentencia;
        String strComandoSql;
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";
        Integer intNia = null;
        String strNombre;
        String strFechaNac;
        Double rlnMedia = null;
        String strCurso;

        try (Connection conexion = DriverManager.getConnection(strUrl,strUser,strPass)) {
            System.out.println("Conexión establecida.");

            stSentencia = conexion.createStatement();

            do {
                System.out.print("Dime NIA: ");
                try {
                    intNia = Integer.parseInt(scEntrada.nextLine());
                    if (intNia < 0) {
                        System.out.println("El NIA no puede ser negativo.");
                        intNia = null;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un valor numérico entero.");
                }
            } while (intNia == null);

            do {
                System.out.print("Dime nombre: ");
                strNombre = scEntrada.nextLine();
                if (strNombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío");
                }
            } while (strNombre.isEmpty());

            do {
                System.out.print("Dime fecha de nacimiento (formato aaaa-MM-dd): ");
                strFechaNac = scEntrada.nextLine();
                if (strFechaNac.isEmpty()) {
                    System.out.println("La fecha de nacimiento no puede estar vacía.");
                }
            } while (strFechaNac.isEmpty());

            do {
                System.out.print("Dime media: ");
                try {
                    rlnMedia = Double.parseDouble(scEntrada.nextLine().replace(',','.'));
                    if (rlnMedia < 0) {
                        System.out.println("La media no puede ser negativa.");
                        rlnMedia = null;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("La media debe ser un campo decimal.");
                }
            } while (rlnMedia == null);

            do {
                System.out.print("Dime curso: ");
                strCurso = scEntrada.nextLine();
                if (strCurso.isEmpty()) {
                    System.out.println("El curso no puede estar vacío.");
                }
            } while (strCurso.isEmpty());

            strComandoSql = "INSERT INTO ALUMNOS " +
                                "VALUES (" + intNia + ", '" + strNombre + "', '" + strFechaNac + "', "
                                    + rlnMedia + ", '" + strCurso + "')";
            stSentencia.executeUpdate(strComandoSql);
            System.out.println("Se ha insertado un nuevo alumno.");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error.");
        }
    }
}

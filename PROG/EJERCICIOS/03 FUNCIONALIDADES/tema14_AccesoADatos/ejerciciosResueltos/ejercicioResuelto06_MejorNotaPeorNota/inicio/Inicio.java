package tema14_AccesoADatos.ejerciciosResueltos.ejercicioResuelto06_MejorNotaPeorNota.inicio;

import java.sql.*;

public class Inicio {
    public static void inicio() {
        String strUrl = "jdbc:mysql://localhost:3306/instituto";
        String strUser = "alumno";
        String strPass = "alumno";

        Statement stSetenciaSql;
        ResultSet rsResultadoConsulta;
        String strConsultaSql;

        String strNombre;
        double rlnMedia;

        try (Connection conexion = DriverManager.getConnection(strUrl,strUser,strPass)) {
            stSetenciaSql = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                     ResultSet.CONCUR_READ_ONLY);

            strConsultaSql = "SELECT NOMBRE, MEDIA " +
                             "FROM ALUMNOS " +
                             "ORDER BY MEDIA DESC";

            rsResultadoConsulta = stSetenciaSql.executeQuery(strConsultaSql);

            System.out.println("LISTADO DE ALUMNOS Y MEDIAS");
            while (rsResultadoConsulta.next()) {
                strNombre = rsResultadoConsulta.getString("NOMBRE");
                rlnMedia = rsResultadoConsulta.getDouble("MEDIA");
                System.out.println("Alumno: " + strNombre + " -> " + rlnMedia);
            }

            System.out.print("Mejor nota -> ");
            rsResultadoConsulta.first();
            System.out.println("Alumno: " + rsResultadoConsulta.getString("NOMBRE") + " -> "
                    + rsResultadoConsulta.getDouble("MEDIA"));

            System.out.print("Peor nota -> ");
            rsResultadoConsulta.last();
            System.out.println("Alumno: " + rsResultadoConsulta.getString("NOMBRE") + " -> "
                    + rsResultadoConsulta.getDouble("MEDIA"));
        } catch (SQLException e) {
            System.out.println("Se produjo un error.");
        }
    }
}

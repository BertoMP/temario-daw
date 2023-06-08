package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto02_CancionPirata.clases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE = "cancionPirata.dat"; //Constante String que guarda el nombre del fichero.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
                ("src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto02_CancionPirata/documentos/"
                        + STR_NOMBRE))) {
            oos.writeObject("Con diez cañones por banda" + Character.LINE_SEPARATOR
                    + "viento en popa a toda vela," + Character.LINE_SEPARATOR
                    + "no corta el mar, sino vuela" + Character.LINE_SEPARATOR
                    + "un velero bergantín.");
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se encontró el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de fallo en la escritura del fichero.
            System.out.println("Se produjo un error en la escritura del fichero " + STR_NOMBRE);
        }
    }
}

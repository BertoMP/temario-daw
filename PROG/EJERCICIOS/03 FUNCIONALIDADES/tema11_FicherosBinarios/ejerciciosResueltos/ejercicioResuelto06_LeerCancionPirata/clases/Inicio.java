package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto06_LeerCancionPirata.clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE = "cancionPirata.dat"; //Constante String que guarda el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        String strCancion = null; //String que guardará la canción.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto06_LeerCancionPirata/documentos/"
                        + STR_NOMBRE))) {
            strCancion = (String) inputStream.readObject();
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se ha encontrado el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Fallo en la lectura del fichero " + STR_NOMBRE);
        } catch (ClassNotFoundException e) { //En caso de que no se encuentre la clase del objeto seleccionado.
            System.out.println("No se encontró un String en el fichero " + STR_NOMBRE);
        }

        System.out.println(strCancion);
    }
}

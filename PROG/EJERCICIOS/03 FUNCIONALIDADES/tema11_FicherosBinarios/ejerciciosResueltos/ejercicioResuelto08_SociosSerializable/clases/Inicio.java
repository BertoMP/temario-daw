package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto08_SociosSerializable.clases;

import java.io.*;
import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE = "socios.dat"; //Constante String que guarda el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        Socio[] arraySocios = { //Array de socios.
                new Socio("1", "pepe"),
                new Socio("11", "ana"),
                new Socio("7", "pepa"),
                new Socio("23", "cris"),
        };

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto08_SociosSerializable/documentos/"
                        + STR_NOMBRE))) {
            outputStream.writeObject(arraySocios);
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se ha encontrado el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Error de escritura en el fichero " + STR_NOMBRE);
        }

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto08_SociosSerializable/documentos/"
                        + STR_NOMBRE))) {
            arraySocios = (Socio[]) inputStream.readObject();
        } catch (EOFException ignored) { //En caso de alcanzar el final del fichero.
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se ha encontrado el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Error de lectura en el fichero " + STR_NOMBRE);
        } catch (ClassNotFoundException e) { //En caso de que el fichero no contenga la clase indicada.
            System.out.println("El archivo no contiene un array de socios.");
        }

        System.out.println(Arrays.deepToString(arraySocios));
    }
}

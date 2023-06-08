package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto12_MostrarDouble.clases;

import java.io.*;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File archivo = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto12_MostrarDouble/documentos/double.dat"); //Objeto File que guarda la ruta del fichero.

        if (archivo.exists()) {
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo))) {
                while (true) {
                    System.out.println(lectura.readDouble());
                }
            } catch (EOFException e) { //En caso de alcanzar el fin del fichero.
                System.out.println("Fin del fichero double.dat.");
            } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
                System.out.println("No se ha encontrado el fichero double.dat.");
            } catch (IOException e) { //En caso de que se produzca un error de lectura.
                System.out.println("Se produjo un error de lectura en el fichero double.dat.");
            }
        }
    }
}

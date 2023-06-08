package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto27_Copy.clases;

import java.io.*;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File directorioOriginal = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto27_Copy/directorios/directorioOriginal"); //File que guarda el directorio original.
        File directorioCopia = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto27_Copy/directorios/directorioCopia"); //File que guarda el directorio donde se copiará el directorio original.

        copiarDirectorio(directorioOriginal, directorioCopia);
    }

    /*******************************************************************************************************************
     * Copia un directorio completo y su contenido (subdirectorios y archivos) a un nuevo directorio de destino.       *
     *                                                                                                                 *
     * @param ficheroOrigen El directorio que se desea copiar.                                                         *
     * @param ficheroDestino El directorio de destino donde se copiará el contenido de ficheroOrigen.                  *
     *******************************************************************************************************************/
    public static void copiarDirectorio(File ficheroOrigen, File ficheroDestino) {
        //DECLARACIÓN DE OBJETOS
        File archivoOrigen; //File del archivo fuente.
        File archivoDestino; //File del archivo destino.

        //DECLARACIÓN DE VARIABLES
        String[] strArrAchivos; //Array de String que almacenará los ficheros.
        int byteLectura; // Variable que almacena el siguiente byte que se va a leer

        if (ficheroOrigen.isDirectory()) {
            if (!ficheroDestino.exists()) {
                ficheroDestino.mkdir();
            }

            strArrAchivos = ficheroOrigen.list();
            if (strArrAchivos != null) {
                for (String archivoValor : strArrAchivos) {
                    archivoOrigen = new File(ficheroOrigen, archivoValor);
                    archivoDestino = new File(ficheroDestino, archivoValor);
                    copiarDirectorio(archivoOrigen, archivoDestino);
                }
            }
        } else {
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (InputStream in = new FileInputStream(ficheroOrigen);
                 OutputStream out = new FileOutputStream(ficheroDestino)) {
                while ((byteLectura = in.read()) >= 0) {
                    out.write(byteLectura);
                }
            } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
                System.out.println("No se encontró el fichero.");
            } catch (IOException e) { //En caso de que se produzca un error en el copiado.
                System.out.println("No se pudo copiar el fichero.");
            }
        }
    }

}

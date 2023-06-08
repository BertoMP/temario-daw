package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto01_BusquedaArchivoImpresion.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE VARIABLES
        String strArchivo; //String que guardará el nombre del fichero al que se quiere acceder.
        String strLinea; //String que guardará cada una de las líneas leídas en el fichero.

        System.out.print("Dime nombre del archivo. En blanco para abrir \"prueba.txt\": ");
        strArchivo = new Scanner(System.in).nextLine().toLowerCase();

        if (strArchivo.isEmpty()) {
            strArchivo = "prueba.txt";
        } else if (!strArchivo.contains(".txt")) {
            strArchivo += ".txt";
        }

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto01_BusquedaArchivoImpresion/documentos/" + strArchivo))) {
            System.out.println("\nAbriendo el fichero \"" + strArchivo + "\".\n");
            strLinea = br.readLine();
            while (strLinea != null) {
                System.out.println(strLinea);
                strLinea = br.readLine();
            }
        } catch (FileNotFoundException e) { //En caso de no encontrar el archivo
            System.out.println("No se encontró el fichero \"" + strArchivo + "\".");
        } catch (IOException e) { //En caso de que se produzca un error I/O
            System.out.println("Se produjo un error en la lectura del fichero \"" + strArchivo + "\".");
        }
    }
}

package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto02_LecturaMain.clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Inicio {
    public static void inicio() {
        int intCaracter;
        FileReader fr;

        try {
            fr = new FileReader("src/tema10_FicherosDeTexto/ejerciciosResueltos" +
                    "/ejercicioResuelto01_ExceptionScannerInteger/main/Main.java");
            intCaracter = fr.read();

            while (intCaracter != -1) {
                System.out.print((char)intCaracter);
                intCaracter = fr.read();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error de apertura de fichero. No existe el archivo.");
        } catch (IOException e) {
            System.out.println("Se ha producido un error de entrada salida.");
        }
    }
}

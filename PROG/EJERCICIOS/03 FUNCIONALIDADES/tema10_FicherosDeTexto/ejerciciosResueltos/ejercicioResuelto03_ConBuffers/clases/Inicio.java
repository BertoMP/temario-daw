package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto03_ConBuffers.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inicio {
    public static void inicio() throws IOException {
        String strFrase;

        BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/ejerciciosResueltos" +
                "/ejercicioResuelto01_ExceptionScannerInteger/main/Main.java"));
        strFrase = br.readLine();
        while (strFrase != null) {
            System.out.println(strFrase);
            strFrase = br.readLine();
        }
        br.close();
    }
}

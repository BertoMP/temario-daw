package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto04_SinArray.clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Inicio {
    public static void inicio() throws IOException {
        String strCadena = "";
        int intCaracter;
        int intContador = 0;
        FileReader fr = new FileReader("src/tema10_FicherosDeTexto/ejerciciosResueltos/" +
                "ejercicioResuelto04_SinArray/documentos/numerosReales.txt");
        double rlnSuma = 0;

        do {
            intCaracter = fr.read();
            if (intCaracter == ' ' || intCaracter == -1) {
                intContador++;
                if (strCadena.length() > 0) {
                    rlnSuma += Double.parseDouble(strCadena);
                }
                strCadena = "";
            } else {
                strCadena += (char) intCaracter;
            }
        } while (intCaracter != -1);
        fr.close();

        System.out.println("La suma de los números es: " + rlnSuma + " y la media es: " + rlnSuma / intContador + ".");
    }
}

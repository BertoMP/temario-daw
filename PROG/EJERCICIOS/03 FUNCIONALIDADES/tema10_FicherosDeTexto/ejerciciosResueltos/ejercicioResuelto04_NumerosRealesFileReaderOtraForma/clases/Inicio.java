package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto04_NumerosRealesFileReaderOtraForma.clases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Inicio {
    public static void inicio() throws IOException {
        String[] strArrNumeros = new String[0];
        String strCadena = "";
        int intCaracter;
        FileReader fr = new FileReader("src/tema10_FicherosDeTexto/ejerciciosResueltos/" +
                "ejercicioResuelto04_NumerosRealesFileReaderOtraForma/documentos/numerosReales.txt");
        double rlnSuma = 0;

        do {
            intCaracter = fr.read();
            if (intCaracter == ' ' || intCaracter == -1) {
                strArrNumeros = Arrays.copyOf(strArrNumeros, strArrNumeros.length + 1);
                strArrNumeros[strArrNumeros.length - 1] = strCadena;
                strCadena = "";
            } else {
                strCadena += (char) intCaracter;
            }
        } while (intCaracter != -1);
        fr.close();

        for (String strValor : strArrNumeros) {
            rlnSuma += Double.parseDouble(strValor);
        }

        System.out.println("La suma de los números es: " + rlnSuma + " y la media es: " +
                rlnSuma / strArrNumeros.length + ".");
    }
}

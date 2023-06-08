package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto04_NumerosRealesFileReader.clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Inicio {
    public static void inicio() {
        String[] strArrNumeros = new String[0];
        String strCadena = "";
        int intCaracter = 0;
        FileReader fr = null;
        try {
            fr = new FileReader("src/tema10_FicherosDeTexto/ejerciciosResueltos/" +
                    "ejercicioResuelto04_NumerosRealesFileReader/documentos/numerosReales.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        }
        double rlnSuma = 0;

        do {
            try {
                if (fr != null) {
                    intCaracter = fr.read();
                }
            } catch (IOException e) {
                System.out.println("No se ha podido leer el archivo.");
            }
            if (intCaracter == ' ' || intCaracter == -1) {
                strArrNumeros = Arrays.copyOf(strArrNumeros, strArrNumeros.length + 1);
                strArrNumeros[strArrNumeros.length - 1] = strCadena;
                strCadena = "";
            } else {
                strCadena += (char) intCaracter;
            }
        } while (intCaracter != -1);

        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("No se ha podido cerrar el lector.");
        }

        for (String strValor : strArrNumeros) {
            rlnSuma += Double.parseDouble(strValor);
        }

        System.out.println("La suma de los números es: " + rlnSuma + " y la media es: "
                + rlnSuma / strArrNumeros.length + ".");
    }
}

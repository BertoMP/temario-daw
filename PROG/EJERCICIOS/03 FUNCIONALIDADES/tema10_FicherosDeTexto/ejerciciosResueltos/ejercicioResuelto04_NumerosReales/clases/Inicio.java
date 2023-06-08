package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto04_NumerosReales.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inicio {
    public static void inicio() throws IOException {
        String[] strArrNumeros;
        double rlnSuma = 0;

        BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/ejerciciosResueltos/" +
                "ejercicioResuelto04_NumerosReales/documentos/numerosReales.txt"));
        strArrNumeros = br.readLine().split(" ");

        for (String strValor : strArrNumeros) {
            rlnSuma += Double.parseDouble(strValor);
        }

        System.out.println("La suma de los números es: " + rlnSuma + " y la media es: " + rlnSuma / strArrNumeros.length + ".");
    }
}

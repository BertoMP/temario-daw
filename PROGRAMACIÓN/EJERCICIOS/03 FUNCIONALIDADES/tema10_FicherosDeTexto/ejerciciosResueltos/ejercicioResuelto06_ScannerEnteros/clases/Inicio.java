package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto06_ScannerEnteros.clases;

import java.io.*;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        String strCadena;
        int intContadorNumeros = 0;
        int intSuma = 0;
        double rlnMedia;

        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosResueltos/ejercicioResuelto06_ScannerEnteros/documentos/enteros.txt"))) {
            strCadena = br.readLine();
            while (strCadena != null) {
                try (Scanner scLectura = new Scanner(strCadena)) {
                    while (scLectura.hasNextDouble()) {
                        intContadorNumeros++;
                        intSuma += scLectura.nextDouble();
                    }
                }
                strCadena = br.readLine();
            }
            rlnMedia = (double) intSuma / intContadorNumeros;
            System.out.println("La suma de los números es: " + intSuma + " y su media es: " + rlnMedia);
        } catch (FileNotFoundException e) {
            System.out.println("El fichero \"enteros.txt\" no existe.");
        } catch (IOException e) {
            System.out.println("Se produjo un error durante la lectura del fichero \"enteros.txt\".");
        }
    }
}

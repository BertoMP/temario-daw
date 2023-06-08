package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto05_ScannerNumerosLineaALinea.clases;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {
        String strCadena;
        double rlnSuma = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosResueltos/ejercicioResuelto05_ScannerNumerosLineaALinea/documentos/reales.txt"))) {
            strCadena = br.readLine();
            while (strCadena != null) {
                try (Scanner scLectura = new Scanner(strCadena)) {
                    while (scLectura.hasNext()) {
                        if (scLectura.hasNextDouble()) {
                            rlnSuma += scLectura.nextDouble();
                        } else {
                            scLectura.next();
                        }
                    }
                }
                strCadena = br.readLine();
            }
            System.out.println("La suma es: " + rlnSuma);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero \"reales.txt\".");
        } catch (IOException e) {
            System.out.println("Se ha producido un error durante la lectura \"reales.txt\".");
        }
    }
}

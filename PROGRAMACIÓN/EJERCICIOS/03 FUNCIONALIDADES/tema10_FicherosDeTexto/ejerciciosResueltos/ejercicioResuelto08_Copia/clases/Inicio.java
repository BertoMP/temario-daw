package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto08_Copia.clases;

import java.io.*;
import java.util.Scanner;

public class Inicio {
    public static void inicio() {

        String strFichero;
        String strFicheroCopia;
        String strLinea;

        System.out.print("Dime el nombre del fichero: ");
        strFichero = new Scanner(System.in).nextLine();

        if (!strFichero.contains(".txt")) {
            strFichero += ".txt";
        }

        strFicheroCopia = "copia_de_" + strFichero;

        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosResueltos/ejercicioResuelto08_Copia/documentos/" + strFichero));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                     "ejerciciosResueltos/ejercicioResuelto08_Copia/documentos/" + strFicheroCopia))) {
            strLinea = br.readLine();
            while (strLinea != null) {
                bw.write(strLinea);
                bw.newLine();
                strLinea = br.readLine();
            }
            System.out.println("Copia realizada con éxito.");
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero \"" + strFichero + "\" no existe.");
        } catch (IOException ex) {
            System.out.println("Se produjo un error durante la lectura del fichero \"" + strFichero + "\" o" +
                    "en la escritura del fichero \"" + strFicheroCopia + "\".");
        }
    }
}
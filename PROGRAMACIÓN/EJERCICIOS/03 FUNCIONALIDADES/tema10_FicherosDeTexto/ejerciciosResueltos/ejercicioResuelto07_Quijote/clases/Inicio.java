package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto07_Quijote.clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Inicio {
    public static void inicio() {

        String strCadena1 = "En un lugar de la mancha,";
        String strCadena2 = "de cuyo nombre no quiero acordarme";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                "ejerciciosResueltos/ejercicioResuelto07_Quijote/documentos/quijote.txt"))) {
            for (int intCont = 0; intCont < strCadena1.length(); intCont++) {
                bw.write(strCadena1.charAt(intCont));
            }
            bw.newLine();
            bw.write(strCadena2);
        } catch (IOException e) {
            System.out.println("Se produjo un error durante la lectura del archivo \"quijote.txt\".");
        }
    }
}
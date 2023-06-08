package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto12_Deportistas.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        String STR_NOMBRE_FICHERO = "deportistas.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        String strCadena; //String que almacenará cada una de las líneas del archivo a leer.
        int intContadorDeportistas = 0; //Int que funcionará como contador de deportistas.
        int intEdadTotal = 0; //Int que funcionará como sumatorio para la edad de los deportistas.
        double rlnPesoTotal = 0; //Double que funcionará como sumatorio para el peso de los deportistas.
        double rlnEstaturaTotal = 0; //Double que funcionará como sumatorio para la estatura de los deportistas.

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto12_Deportistas/documentos/" + STR_NOMBRE_FICHERO))) {

            strCadena = br.readLine();

            if (strCadena != null) {
                System.out.println(strCadena);
                strCadena = br.readLine();

                while (strCadena != null) {
                    intContadorDeportistas++;
                    System.out.println(strCadena);

                    //BLOQUE TRY-WITH-RESOURCES PARA UN SCANNER
                    try (Scanner scLectura = new Scanner(strCadena)) {
                        while (!scLectura.hasNextInt()) {
                            scLectura.next();
                        }
                        intEdadTotal += scLectura.nextInt();
                        rlnPesoTotal += scLectura.nextDouble();
                        rlnEstaturaTotal += scLectura.nextDouble();
                    }
                    strCadena = br.readLine();
                }

                if (intContadorDeportistas != 0) {
                    System.out.println("\nDATOS ESTADÍSTICOS");
                    System.out.println("Hay datos de " + intContadorDeportistas + " deportistas");
                    System.out.println("\t - Edad media: " + (double) intEdadTotal / intContadorDeportistas + " años.");
                    System.out.println("\t - Peso medio: " + rlnPesoTotal / intContadorDeportistas + " kg.");
                    System.out.println("\t - Estatura media: " + rlnEstaturaTotal / intContadorDeportistas + " m.");
                }
            }
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se ha encontrado el fichero \"" + STR_NOMBRE_FICHERO + "\".");
        } catch (IOException e) { //En caso de que se produzca un error en el fichero.
            System.out.println("Se ha producido un error durante la lectura del fichero \"" + STR_NOMBRE_FICHERO + "\".");
        }
    }
}

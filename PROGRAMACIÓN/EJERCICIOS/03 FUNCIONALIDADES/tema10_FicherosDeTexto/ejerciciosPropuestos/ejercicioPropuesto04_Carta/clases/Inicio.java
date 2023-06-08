package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto04_Carta.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_FICHERO = "carta.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        String strLinea; //String que almacena la siguiente línea que se ha leído.
        String strPalabra; //String que guarda cada palabra de la línea.
        int intCantidadCaracteres = 0; //Int que actúa como contador del número de caracteres.
        int intCantidadLineas = 0; //Int que actúa como contador de líneas.
        int intCantidadPalabras = 0; //Int que actúa como contador de palabras.
        int intCantidadCatacteresSinEspacios = 0; //Int que actúa como contador de caraceres (sin contar los espacios blancos).

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto04_Carta/documentos/" + STR_FICHERO))) {
            strLinea = br.readLine();
            while (strLinea != null) {
                intCantidadCaracteres += strLinea.length();
                intCantidadLineas++;
                //BLOQUE TRY-WITH-RESOURCES PARA UN SCANNER
                try (Scanner scLectura = new Scanner(strLinea)) {
                    while (scLectura.hasNext()) {
                        strPalabra = scLectura.next();
                        intCantidadPalabras++;
                        intCantidadCatacteresSinEspacios += strPalabra.length();
                    }
                }
                strLinea = br.readLine();
            }
            System.out.println("El fichero \"" + STR_FICHERO + "\" contiene: ");
            System.out.println("\t - Líneas: " + intCantidadLineas);
            System.out.println("\t - Caracteres: " + intCantidadCaracteres);
            System.out.println("\t - Palabras: " + intCantidadPalabras);
            System.out.println("\t - Caracteres (sin espacios): " + intCantidadCatacteresSinEspacios);
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se encontró el fichero \"" + STR_FICHERO + "\"");
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error durante la lectura del fichero \"" + STR_FICHERO + "\".");
        }
    }
}

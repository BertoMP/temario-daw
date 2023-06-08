package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Diseñar un programa que solicite al usuario una frase y una palabra. A continuación buscará cuantas veces aparece   *
 * la palabra en la frase.                                                                                             *
 ***********************************************************************************************************************/
public class Ejercicio07_BuscarPalabra {
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strFrase; //Variable String que guardará la frase del usuario
        String strPalabra; //Variable String que guardará la palabra a buscar
        int intVecesEncontrada = 0; //Variable int que guardará el número de veces que se ha encontrado la palabra
        int intIndiceEncontrado; //Variable int que guardará el índice donde se haya encontrado la palabra

        //SOLICITUD DE DATOS
        System.out.print("Introduzca una frase: ");
        strFrase = scEntrada.nextLine();
        System.out.print("Introduzca una palabra: ");
        strPalabra = scEntrada.next();
        scEntrada.close();

        //MÉTODO indexOf(String);
        intIndiceEncontrado = strFrase.indexOf(strPalabra);

        //BUCLE WHILE
        while (intIndiceEncontrado != -1) {
            /* El bucle se mantendrá hasta que el intIndiceEncontrado sea -1, es decir, hasta que la palabra no se
             * en la frase introducida.
             * En cada iteración se aumentará primero en uno la cantidad de veces que se ha encontrado la palabra
             * y a continuación se realizará una nueva búsqueda a partir del índice siguiente al de la última letra
             * de la palabra anterior. */
            intVecesEncontrada++;
            intIndiceEncontrado = strFrase.indexOf(strPalabra, intIndiceEncontrado + 1);
        }

        //IMPRESIÓN DE RESULTADOS
        System.out.println(intVecesEncontrada == 0 ? "La palabra " + strPalabra + " no aparece en la frase."
                                                   : "La palabra " + strPalabra + " se encuentra "
                                                     + intVecesEncontrada + " veces en la frase.");

    }
    public static void main(String[] args) {
        inicio();
    }
}

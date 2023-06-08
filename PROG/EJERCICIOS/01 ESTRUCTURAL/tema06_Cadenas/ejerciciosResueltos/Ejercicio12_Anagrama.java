package tema06_Cadenas.ejerciciosResueltos;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Un anagrama es una palabra que resulta del cambio del orden de los caracteres de otra. Ejemplos de anagramas        *
 * para la palabra roma son: amor, ramo o mora. Construir un programa que solicite al usuario dos palabras             *
 * e indique si son anagramas una de la otra.                                                                          *
 ***********************************************************************************************************************/
public class Ejercicio12_Anagrama {
    /*******************************************************************************************************************
     * Funci�n encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACI�N DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strPalabra1;//String que guardar� la primera palabra del usuario
        String strPalabra2;//String que guardar� la segunda palabra del usuario
        char[] chrArrPalabra1;//Array de tipo char que guardar� los caracteres de la primera palabra del usuario
        char[] chrArrPalabra2;//Array de tipo char que guardara los caracteres de la segunda palabra del usuario

        //SOLICITUD DE DATOS
        System.out.print("Introduzca la primera palabra: ");
        strPalabra1 = scEntrada.next().toLowerCase();//Con esto conseguimos que ambas palabras est�n en min�sculas
        System.out.print("Introduzca la segunda palabra: ");
        strPalabra2 = scEntrada.next().toLowerCase();
        scEntrada.close();

        //CONVERSION DE LAS PALABRAS EN DOS ARRAYS
        /* Se convierten las palabras en arrays porque va a ser necesario ordenar de mayor a menor (de 'a' a 'z') cada
         * array para a continuaci�n compararlos y ver si son id�nticos. */
        chrArrPalabra1 = strPalabra1.toCharArray();
        chrArrPalabra2 = strPalabra2.toCharArray();

        //ORDENACI�N DE LOS ARRAYS
        Arrays.sort(chrArrPalabra1);
        Arrays.sort(chrArrPalabra2);

        //IMPRESI�N DE RESULTADOS
        if (strPalabra1.length() == strPalabra2.length() && Arrays.equals(chrArrPalabra1,chrArrPalabra2)) {
            /* Las palabras s�lo podr�n ser anagramas si tienen la misma longitud (mismo n�mero de letras) y si ambos
             * arrays son id�nticos, es decir, si introducimos como palabras 'roma' y 'ramo':
             * 1. Ambas palabras tienen 4 letras.
             * 2. Ordenadas alfab�ticamente ambas son 'amor'.*/
            System.out.print("Las palabras " + "\'" + strPalabra1 + "\' y \'" + strPalabra2 + "\' son anagramas.");
        } else {
            System.out.print("Las palabras " + "\'" + strPalabra1 + "\' y \'" + strPalabra2 + "\' no son anagramas.");
        }
    }
    public static void main(String[] args) {
        inicio();
    }
}

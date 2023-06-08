package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Diseñar un algoritmo que lea del teclado una frase e indique, para cada letra que aparece en la frase, cuántas      *
 * veces se repite. Se consideran iguales las letras mayúsculas y las minúsculas para realizar la cuenta.              *
 * Un ejemplo seria:                                                                                                   *
 *     "En un lugar de la Mancha."                                                                                     *
 *         a: 4 veces.                                                                                                 *
 *         c: 1 vez.                                                                                                   *
 *         d: 1 vez.                                                                                                   *
 *         e: 2 veces.                                                                                                 *
 *         ...                                                                                                         *
 ***********************************************************************************************************************/
public class Ejercicio13_NumeroDeVecesRepetida {
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strFraseUsuario;//String que guardará la frase del usuario
        /* Array de tipo int que guardará el número de veces que se repite cada letra del abecedario, este array
         * tendrá una longitud de ('ñ' (valor Unicode 241) - 'a' (valor Unicode 97)) + 1 */
        int[] intNumeroVecesRepetida = new int[('ñ' - 'a') + 1];

        //SOLICITUD DE DATOS
        System.out.print("Introduzca frase: ");
        strFraseUsuario = scEntrada.nextLine();
        scEntrada.close();

        //IMPRESIÓN DE RESULTADOS 1
        System.out.println("Frase: " + "\"" + strFraseUsuario + "\"");
        System.out.println("Resultado:");

        strFraseUsuario = strFraseUsuario.toLowerCase();

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for (int intCont = 0; intCont < strFraseUsuario.length(); intCont++) {
            /* En cada iteración del bucle lo que se hará es comprobar si el siguiente carácter de la frase del usuario
             * es una letra para descartar espacios en blanco, números, signos de puntuación... Si el siguiente
             * carácter es una letra se incrementará en 1 el índice correspondiente a esa letra, que será 'letra
             * de la frase' - 'a', por ejemplo, para la 'b' sería 98 - 97 = 1.
             * El bucle se repetirá hasta completar la frase del usuario. */
            if (Character.isLetter(strFraseUsuario.charAt(intCont))) {
                switch (strFraseUsuario.charAt(intCont)) {
                    case 'á' -> intNumeroVecesRepetida[0]++;
                    case 'é' -> intNumeroVecesRepetida['e' - 'a']++;
                    case 'í' -> intNumeroVecesRepetida['i' - 'a']++;
                    case 'ó' -> intNumeroVecesRepetida['o' - 'a']++;
                    case 'ú','ü' -> intNumeroVecesRepetida['u' - 'a']++;
                    default -> intNumeroVecesRepetida[strFraseUsuario.charAt(intCont) - 'a']++;
                }
            }
        }

        //IMPRESIÓN DE RESULTADOS 2
        for (int intCont = 0; intCont < intNumeroVecesRepetida.length; intCont++) {
            /* En cada iteración del bucle se comprobará que el número guardado en el índice del array es diferente
             * de 0, si lo es se imprimirá por consola la letra correspondiente y el número de veces que se ha
             * repetido. */
            if (intNumeroVecesRepetida[intCont] != 0) {
                System.out.println("\t" + (char) (intCont + 'a') + ": " + intNumeroVecesRepetida[intCont] + " veces");
            }
        }
    }
    public static void main(String[] args) {
        inicio();
    }
}

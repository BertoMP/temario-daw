package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Se dispone de la siguiente relación de letras:                                                                      *
 *    conjunto 1: e i k m p q r s t u v                                                                                *
 *    conjunto 2: p v i u m t e r k q s                                                                                *
 * Con ella es posible codificar un texto, convirtiendo cada letra del conjunto 1 en su correspondiente del conjunto 2.*
 * El resto de las letras no se modifican. Los cojuntos se utilizan para codificar mayúsculas como minúsculas,         *
 * mostrando siempre la codificación en minúsculas.                                                                    *
 * Un ejemplo: la palabra "PaquiTo" se codifica como "matqvko".                                                        *
 * Realizar un programa que codifique un texto. Para ello implementar la siguiente función:                            *
 *    char codifica(char conjunto1[], char conjunto2[], char c)                                                        *
 * que devuelve el carácter c codificado según los conjuntos 1 y 2 que se le pasan.                                    *
 **********************************************************************************************************************/
public class Ejercicio11_Codificacion {
    /*******************************************************************************************************************
     * Función encargada de la codificación de caracteres a la cual se le pasan 3 parámetros, 2 conjuntos de           *
     * caracteres y el carácter a codificar.                                                                           *
     *                                                                                                                 *
     * @param chrArrConjunto1 -> Primer conjunto de caracteres.                                                        *
     * @param chrArrConjunto2 -> Segundo conjunto de caracteres.                                                       *
     * @param chrC -> Caracter que se ha de codificar.                                                                 *
     * @return La función devolverá el carácter pasado por parámetro codificado, siempre y cuando se encuentre en      *
     *         el primer conjunto, en caso de no estar se devolverá el mismo carácter que se introdujo por             *
     *         parámetro.                                                                                              *
     *******************************************************************************************************************/
    public static char codifica (char[] chrArrConjunto1, char[] chrArrConjunto2, char chrC) {
        //DECLARACIÓN DE VARIABLES
        String strConjunto1; //String con las letras que forman el conjunto 1 de caracteres
        int intIndiceBusqueda; //Variable que guardará el índice de búsqueda del carácter
        char chrReturn = chrC; //Variable que guardará el caracter a devolver

        strConjunto1 = String.valueOf(chrArrConjunto1); //Conversión del array de caracteres en un String.
        intIndiceBusqueda = strConjunto1.indexOf(chrC); //Búsqueda del carácter a codificar en el String.

        if (intIndiceBusqueda != -1) {
            /* En el caso de que el carácter se encuentre en el String, es decir, cuando el intIndiceBusqueda sea
             * diferente de -1, el char que se devolverá será el caracter de la tabla 2 que se encuentre en el mismo
             * índice de búsqueda.
             * Si el índice de búsqueda es -1, este if no se produce y se devuelve el mismo carácter que se ha
             * pasado por parámetro. */
            chrReturn = chrArrConjunto2[intIndiceBusqueda];
        }

        //RETURN
        return chrReturn;
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        char[] srtArrConjunto1 = {'e','i','k','m','p','q','r','s','t','u','v'}; //Variable array de tipo char con los caracteres del conjunto 1.
        char[] srtArrConjunto2 = {'p','v','i','u','m','t','e','r','k','q','s'}; //Variable array de tipo char con los caracteres del conjunto 2.
        char[] chrArrCodificado; //Variable array de tipo char que guardará los caracteres codificados
        String strTextoACodificar; //String que guardara el texto que se ha de codificar

        //SOLICITUD DE DATOS
        System.out.print("Introduzca texto a codificar: ");
        strTextoACodificar = scEntrada.nextLine().toLowerCase();//Convertimos la cadena en minúsculas
        scEntrada.close();

        chrArrCodificado = new char[strTextoACodificar.length()];//Inicialización del array

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for (int intCont = 0; intCont < strTextoACodificar.length(); intCont++) {
            /* En cada iteración del bucle se llamará a la función codifica(char[],char[],char) pasándole por
             * parámetros ambas tablas de codificación y el carácter a codificar. El resultado que produce la
             * función se guarda en el array de caracteres. */
            chrArrCodificado[intCont] =
                    codifica(srtArrConjunto1, srtArrConjunto2, strTextoACodificar.charAt(intCont));
        }

        //IMPRESIÓN DE RESULTADOS
        /* Se imprime el resultado final de la codificación convirtiendo el array de caracteres en un String a través
         * del método String.valueof(char[]). */
        System.out.println("El mensaje " + "\'" + strTextoACodificar + "\'"
                + "es igual a " + "\'" + String.valueOf(chrArrCodificado) + "\'.");
    }
    public static void main(String[] args) {
        inicio();
    }
}

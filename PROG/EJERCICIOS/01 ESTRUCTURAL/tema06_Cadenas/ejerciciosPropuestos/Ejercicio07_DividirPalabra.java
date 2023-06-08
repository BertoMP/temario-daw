package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Construir un programa que convierta una palabra en secuencias de n letras. Por ejemplo, la palabra                  *
 * «destornillador», dividida en secuencias de 4 letras, se mostrará de la siguiente forma:                            *
 *      dest                                                                                                           *
 *      orni                                                                                                           *
 *      llad                                                                                                           *
 *      or                                                                                                             *
 ***********************************************************************************************************************/
public class Ejercicio07_DividirPalabra {
    /*******************************************************************************************************************
     * Función encargada de dividir una palabra introducida por teclado en divisiones de n letras (n es pasado por     *
     * parámetro) e imprimirlas por consola.                                                                           *
     *                                                                                                                 *
     * @param strPalabra → String que contiene una palabra.                                                            *
     * @param intNumeroLetras → Int que guarda el número de letras que tendrá cada sílaba.                             *
     *******************************************************************************************************************/
    public static void dividePalabra(String strPalabra, int intNumeroLetras) {
        //DECLARACIÓN DE VARIABLES
        String strDivisionPalabra; //String que guardara la división de la palabra que se debe imprimir por consola.
        int intLetraSiguiente; //Variable int que guarda el índice de la letra siguiente a la última de la división.

        //IMPRESIÓN DE RESULTADOS
        System.out.println("\nLa palabra " + strPalabra + " dividida en partes de " + intNumeroLetras + " es: ");

        //BUCLE FOR PARA LA IMPRESIÓN DE LAS DIVISIONES DE LA PALABRA
        for (int intContador = 0; intContador < strPalabra.length(); intContador += intNumeroLetras) {
            /* En cada iteración del bucle se va a calcular el índice de la letra siguiente a la última letra de la
             * división, el cual será igual al contador del bucle más el número de letras de la división.
             * A continuación se comprobará si este índice es mayor a la longitud de la palabra, si lo es (última
             * división de la palabra) entonces el índice pasará a ser la longitud de la palabra.
             * En tercer lugar, se hará una división con un substring que empezará desde el índice del contador
             * (incluido) e irá hasta el índice de la letra siguiente a la letra final (excluido).
             * Por último se imprimirá la división.
             * El contador del bucle aumenta en el valor de intNumeroLetras en cada turno. */
            intLetraSiguiente = intContador + intNumeroLetras;

            if (intLetraSiguiente > strPalabra.length()) {
                intLetraSiguiente = strPalabra.length();
            }

            strDivisionPalabra = strPalabra.substring(intContador, intLetraSiguiente);
            System.out.println(strDivisionPalabra);
        }
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strPalabra; //String que guarda la palabra del usuario.
        int intNumeroLetras; //Variable int que guarda el número de letras en el que habrá que dividir la palabra.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca palabra a dividir: ");
        strPalabra = scEntrada.next();
        System.out.print("Introduzca numero de letras de cada división: ");
        intNumeroLetras = scEntrada.nextInt();
        scEntrada.close();

        //LLAMADA AL MÉTODO dividePalabra(String, int);
        dividePalabra(strPalabra, intNumeroLetras);
    }

    public static void main(String[] args) {
        inicio();
    }
}

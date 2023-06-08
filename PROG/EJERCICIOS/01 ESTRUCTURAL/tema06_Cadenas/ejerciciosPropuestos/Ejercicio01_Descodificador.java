package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Escribe un programa descodificador que muestre un texto codificado con el programa realizado en la actividad        *
 * resuelta 6.11.                                                                                                      *
 ***********************************************************************************************************************/
public class Ejercicio01_Descodificador {
    /*******************************************************************************************************************
     * Función encargada de descodificar el texto que se le haya pasado por parámetro usando dos Strings de caracteres.*
     *                                                                                                                 *
     * @param strLetras1 → String con letras que será el que se use para codificar.                                    *
     * @param strLetras2 → String con letras que será el que se use para buscar cada letra del texto                   *
     *                     pasado por parámetro.                                                                       *
     * @param strFrase → String que contiene un texto que se debe codificar.                                           *
     * @return La función devolverá un String que contendrá el texto codificado.                                       *
     *******************************************************************************************************************/
    public static String descodifica (String strLetras1, String strLetras2, String strFrase) {
        //DECLARACIÓN DE VARIABLES
        String strDescodificado = ""; //String que almacenará los caracteres resultantes de la codificación
        int intIndiceBusqueda; //Variable int que guardará un indice de búsqueda

        //BUCLE FOR PARA LA CODIFICACIÓN
        for (int intContador = 0; intContador < strFrase.length(); intContador++) {
            /* El bucle recorrerá toda la frase que se debe descodificar e irá comprobando si se encuentra en
             * strLetras2 a través del método String.indexOf(char), si lo está, es decir, si el índice es
             * distinto de -1, lo que se hará es guardar en strDescodificado la letra de strLetras1 correspondiente
             * al índice de búsqueda. En caso de que la letra no esté en strLetras1 lo que se hará es guardar el mismo
             * caracter en strDescodificado.
             *
             * El bucle se mantendrá hasta que el contador del bucle alcance a la longitud del texto introducido. */
            intIndiceBusqueda = strLetras2.indexOf(strFrase.charAt(intContador));

            if (intIndiceBusqueda != -1) {
                strDescodificado += strLetras1.charAt(intIndiceBusqueda);
            } else {
                strDescodificado += strFrase.charAt(intContador);
            }
        }

        //RETURN
        return strDescodificado;
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);

        String strTextoCodificado; //String que guardará el texto codificado.
        String strTextoDescodificado; //String que guardará el texto descodificado.
        final String STR_CONJUNTO_1 = "eikmpqrstuv"; //Constante String que guarda los caracteres del primer conjunto de letras.
        final String STR_CONJUNTO_2 = "pviumterkqs"; //Constante String que guarda los caracteres del segundo conjunto de letras.

        //SOLICITUD DE DATOS
        System.out.print("Introduce texto a descodificar: ");
        strTextoCodificado = scEntrada.nextLine().toLowerCase();
        scEntrada.close();

        //LLAMADA A LA FUNCIÓN codifica(String, String, String)
        strTextoDescodificado = descodifica(STR_CONJUNTO_1, STR_CONJUNTO_2,strTextoCodificado);

        //IMPRESIÓN DE LOS RESULTADOS
        System.out.println("Texto codificado: " + strTextoCodificado);
        System.out.println("Texto descodificado: " + strTextoDescodificado);
    }

    public static void main(String[] args) {
        inicio();
    }
}

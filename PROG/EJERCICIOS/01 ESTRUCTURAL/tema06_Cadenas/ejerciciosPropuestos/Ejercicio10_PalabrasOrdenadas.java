package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Implementa un programa que lea una frase y muestre todas sus palabras ordenadas de forma alfabética.                *
 * Suponemos que cada palabra de la frase se separa de otra por un único espacio.                                      *
 ***********************************************************************************************************************/
public class Ejercicio10_PalabrasOrdenadas {
    /*******************************************************************************************************************
     * Función encargada de dividir una frase en palabras y ordenarlas alfabéticamente.                                *
     *                                                                                                                 *
     * @param strFrase → Frase introducida por el usuario.                                                             *
     * @return La función devuelve un array de String que contiene las palabras ordenadas de forma alfabética.         *
     *******************************************************************************************************************/
    public static String[] ordenaPalabras(String strFrase) {
        //DECLARACIÓN DE VARIABLES
        String[] strArrReturn; //Array de String que se devolverá (contendrá las palabras de la frase pasada por parámetro).

        //RELLENADO DEL ARRAY HACIENDO USO DEL MÉTODO String.split(String);
        strArrReturn = strFrase.split(" ");

        //ORDENAMIENTO DEL ARRAY HACIENDO USO DEL MÉTODO Arrays.sort(String[]);
        Arrays.sort(strArrReturn);

        //RETURN
        return strArrReturn;
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strFrase; //String que guarda la frase del usuario.
        String[] strArrPalabras; //Array de String que guardará cada una de las palabras de la frase.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca frase: ");
        strFrase = scEntrada.nextLine().toLowerCase();
        scEntrada.close();

        //LLAMADA A LA FUNCIÓN ordenaPalabras(String);
        strArrPalabras = ordenaPalabras(strFrase);

        //IMPRESIÓN DE RESULTADOS
        System.out.println("El orden alfabético de las palabras es el siguiente: " + Arrays.toString(strArrPalabras));

    }

    public static void main(String[] args) {
        inicio();
    }
}

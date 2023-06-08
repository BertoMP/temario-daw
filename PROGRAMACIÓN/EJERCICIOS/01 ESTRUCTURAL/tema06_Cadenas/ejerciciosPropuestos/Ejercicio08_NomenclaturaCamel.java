package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Escribe una aplicación que convierte una frase (que puede estar escrita con cualquier combinación de mayúsculas     *
 * y minúsculas) en el nombre de una variable que utilice la nomenclatura Camel. Por ejemplo, la frase «Me GUsta       *
 * merenDAR gaLLEtas», se convertirá en «meGustaMerendarGalletas».                                                     *
 * Supondremos que cada palabra que compone la frase está separada por un único espacio en blanco                      *
 ***********************************************************************************************************************/
public class Ejercicio08_NomenclaturaCamel {
    /*******************************************************************************************************************
     * Función encargada de convertir el texto del usuario en escritura con nomenclatura camel.                        *
     *                                                                                                                 *
     * @param strFrase → String que contiene la frase del usuario.                                                     *
     * @return La función devolverá un String que contiene la frase del usuario con nomenclatura camel.                *
     *******************************************************************************************************************/
    public static String conversionCamel(String strFrase) {
        String[] strArrPalabras; //Array de String que guardará cada una de las palabras de la frase del usuario.
        String strFraseReturn = ""; //String que guardará la frase que se devolverá como resultado de la función.

        //RELLENADO DEL ARRAY
        /* A través del método String.split(String) se guarda en cada índice del array una de las palabras de
         * la frase del usuario */
        strArrPalabras = strFrase.split(" ");

        /* Como la nomenclatura Camel Case empieza siempre con la primera palabra en minúsculas, se guarda el
         * índice 0 del array en strFraseReturn como primera palabra de la frase. */
        strFraseReturn += strArrPalabras[0];

        //BUCLE FOR PARA COMPLETAR LA NOMENCLATURA
        for (int intCont = 1; intCont < strArrPalabras.length; intCont++) {
            /* El bucle se va a encargar de convertir la primera letra de cada palabra del array (a partir del
             * índice 1) en mayúscula, para ello lo que se hará es ir sumando a strFraseReturn 2 substrings en cada
             * iteración: el primer substring(0,1) corresponderá a esa primera letra de la palabra, la cual se
             * convertirá en mayúscula; el segundo substring(1) corresponderá al resto de caracteres que forman la
             * palabra del índice.
             * El bucle se mantiene hasta completar el array de palabras. */
            strFraseReturn += strArrPalabras[intCont].substring(0,1).toUpperCase()
                    + strArrPalabras[intCont].substring(1);
        }

        //RETURN
        return strFraseReturn;
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strFraseUsuario; //String que guarda la frase introducida por el usuario

        //SOLICITUD DE DATOS
        System.out.print("Introduzca la frase: ");
        strFraseUsuario = scEntrada.nextLine().toLowerCase(); //Guardamos la frase automáticamente en minúsculas
        scEntrada.close();

        //LLAMADA A LA FUNCIÓN conversionCamel(String)
        strFraseUsuario = conversionCamel(strFraseUsuario);

        //IMPRESIÓN DE RESULTADOS
        System.out.println("La frase introducida pasada a nomenclatura Camel es: " + "\"" + strFraseUsuario + "\".");
    }

    public static void main(String[] args) {
        inicio();
    }
}

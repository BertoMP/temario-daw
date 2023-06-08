package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Lee una palabra o frase y muestra el proceso en el que cada letra se sustituye por otro símbolo no alfabético. Por  *
 * ejemplo, el carácter ‘a’ se podría sustituir por el carácter '@', la ‘e’ por `€’, la ‘i’ por ‘1’, etcétera.         *
 ***********************************************************************************************************************/
public class Ejercicio06_CambiarLetraPorCaracterNoAlfabetico {
    /*******************************************************************************************************************
     * Función encargada de cambiar los caracteres de una palabra o frase.                                             *
     * @param strFrase → String que contiene la frase a la que se han de cambiar los caracteres.                       *
     * @return La función devolverá un String con los caracteres cambiados.                                            *
     *******************************************************************************************************************/
    public static String cambiaFrase (String strFrase) {
        //DECLARACIÓN DE VARIABLES
        String strFraseReturn = ""; //String que guardará la palabra o frase que se debe de devolver.
        char chrLetra; //Char que guardará los caracteres que se deben almacenar en strFraseReturn.
        final int INT_CAMBIO_CARACTERES = 12466; //Constante de tipo int que guarda el número que habrá que añadir a cada letra para cambiarlo (en este caso se cambiarán por caracteres del alfabeto japonés).

        //BUCLE FOR
        for (int intCont = 0; intCont < strFrase.length(); intCont++) {
            /* En cada iteración del bucle se comprobará primero si el caracter de la palabra se trata de un espacio
             * en blanco, una coma o un punto, en ese caso se mantendrá igual; en caso contrario se le sumará al
             * caracter el valor de INT_CAMBIO_CARACTERES para convertirlo en uno no alfabético (latino).
             * A continuación el caracter se guardará en la frase que se debe devolver al final de la función.
             * El bucle se mantendrá hasta completar toda la palabra o frase del usuario. */
            if (strFrase.charAt(intCont) == ' ' || strFrase.charAt(intCont) == ',' || strFrase.charAt(intCont) == '.') {
                chrLetra = strFrase.charAt(intCont);
            } else {
                chrLetra = (char) (strFrase.charAt(intCont) + INT_CAMBIO_CARACTERES);
            }
            strFraseReturn += chrLetra;
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
        String strFrase; //String que guardará la palabra o frase del usuario.
        String strFraseCambiada; //String que guardará la palabra o frase con los caracteres cambiados.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca una palabra o frase: ");
        strFrase = scEntrada.nextLine();
        scEntrada.close();

        //LLAMADA A LA FUNCIÓN cambiaFrase(String);
        strFraseCambiada = cambiaFrase(strFrase);

        //IMPRESIÓN DE LA FRASE
        System.out.println("Resultado final tras cambiar los caracteres: " + strFraseCambiada);
    }

    public static void main(String[] args) {
        inicio();
    }
}

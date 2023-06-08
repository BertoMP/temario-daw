package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Diseñar una función a la que se le pase una cadena de caracteres y la devuelva invertida. Un ejemplo, la cadena     *
 * "Hola mundo" quedaría "onum aloH".                                                                                  *
 ***********************************************************************************************************************/
public class Ejercicio05_FraseInvertida {
    /*******************************************************************************************************************
     * Función encargada de dar la vuelta a una frase introducida por parámetro.                                       *
     *                                                                                                                 *
     * @param strFrase -> Frase a la que se le debe dar la vuelta.                                                     *
     * @return strFraseReturn -> Frase dada la vuelta.                                                                 *
     ******************************************************************************************************************/
    public static String fraseAlReves (String strFrase) {
        //DECLARACIÓN DE VARIABLES
        String strFraseReturn = "";//Variable String que guardará la frase dada del revés.

        //BUCLE FOR
        for (int intContador = 0; intContador < strFrase.length(); intContador++) {
            /* El bucle se mantendrá hasta que el contador alcance la longitud de la palabra, en cada iteración
             * lo que se hará es copiar el caracter del contador en la variable strFraseReturn al inicio del String.
             * Por ejemplo, con la palabra "Hola":
             *   - intContador = 0 -> strFraseReturn ("") = strFrase.chartAt(0) (H) + strFraseReturn ("");
             *   - intContador = 1 -> strFraseReturn ("H") = strFrase.chartAt(1) (o) + strFraseReturn ("H");
             *   - intContador = 2 -> strFraseReturn ("oH") = strFrase.chartAt(2) (l) + strFraseReturn ("oH");
             *   - intContador = 3 -> strFraseReturn ("loH") = strFrase.chartAt(0) (a) + strFraseReturn ("loH");
             * strFraseReturn guardaría un valor "aloH" al final del bucle. */
            strFraseReturn = strFrase.charAt(intContador) + strFraseReturn;
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
        String strFraseUsuarioNormal; //Variable String que guardará la frase del usuario
        String strFraseUsuarioAlReves; //Variable String que guardará la frase del usuario puesta del revés

        //SOLICITUD DE DATOS
        System.out.print("Escriba una frase: ");
        strFraseUsuarioNormal = scEntrada.nextLine();
        scEntrada.close();

        //LLAMADA A LA FUNCIÓN fraseAlReves(String);
        strFraseUsuarioAlReves = fraseAlReves(strFraseUsuarioNormal);

        //IMPRESIÓN DE RESULTADOS
        System.out.println("La frase normal es: " + strFraseUsuarioNormal);
        System.out.println("La frase al revés es: " + strFraseUsuarioAlReves);
    }
    public static void main(String[] args) {
        inicio();
    }
}

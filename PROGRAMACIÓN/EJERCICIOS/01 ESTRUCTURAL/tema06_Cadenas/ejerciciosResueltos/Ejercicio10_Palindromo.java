package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Realizar un programa que lea una frase del teclado y nos indique si es palíndroma, es decir, que la frase sea igual *
 * leyendo de izquierda a derecha que de derecha a izquierda, sin tener en cuenta los espacio. Un ejemplo de frase     *
 * palíndroma es: "Dábale arroz a la zorra el abad".                                                                   *
 *                                                                                                                     *
 * Las vocales con tilde hacen que los algoritmos consideren una frase palíndroma como si no lo fuese. Por esto,       *
 * supondremos que el usuario introduce la frase sin tildes.                                                           *
 ***********************************************************************************************************************/
public class Ejercicio10_Palindromo {
    /*******************************************************************************************************************
     * Función encargada de dar la vuelta a un String pasado por parámetro.                                            *
     *                                                                                                                 *
     * @param strFrase -> String al que habrá que darle la vuelta.                                                     *
     * @return La función devolverá el String pasado por parametro pero dado la vuelta a través de la variable         *
     *         strFraseReturn.                                                                                         *
     *******************************************************************************************************************/
    public static String fraseDelReves(String strFrase) {
        //DECLARACIÓN DE VARIABLES
        String strFraseReturn = "";//String que guardará la frase que se devolverá como resultado de la función

        //BUCLE FOR
        for (int intCont = 0; intCont < strFrase.length(); intCont++) {
            /* En cada ciclo del bucle lo que se hará es copiar el carácter del String pasado por parámetro y que
             * ocupa el lugar del contador en la frase a devolver (strFraseReturn) seguido del propio contenido de
             * la frase return.
             * El bucle se mantendrá mientras el contador sea menor a la longitud de la cadena que se ha pasado
             * por parámetro. */
            strFraseReturn = strFrase.charAt(intCont) + strFraseReturn;
        }

        //RETURN
        return strFraseReturn;
    }
    /*******************************************************************************************************************
     * Función encargada de eliminar los espacios en un String pasado por parámetro.                                   *
     *                                                                                                                 *
     * @param strFrase -> String con espacios en blanco.                                                               *
     * @return La función devolverá un String (strFraseReturn) que no contendrá ningún espacio entre los caracteres    *
     *         que la forman.                                                                                          *
     *******************************************************************************************************************/
    public static String fraseSinEspacios(String strFrase) {
        //DECLARACIÓN DE VARIABLES
        String strFraseReturn = "";//String que guardará la frase que se devolverá como resultado de la función

        //BUCLE FOR
        for (int intCont = 0; intCont < strFrase.length(); intCont++) {
            /* En cada iteración del bucle se comprobará si el carácter del String pasado por parámetro y que
             * ocupa el lugar del contador es un espacio en blanco, es decir, el carácter ' '. Si no lo es, el
             * carácter se guarda en la cadena que se devolverá como resultado de la función.
             * El bucle se mantendrá mientras el contador sea menor a la longitud de la cadena que se ha pasado
             * por parámetro. */
            if (strFrase.charAt(intCont) != ' ') {
                strFraseReturn += strFrase.charAt(intCont);
            }
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
        String strFraseUsuario;//String que guarda la frase del usuario
        String strFraseSinEspacios;//String que guarda la frase del usuario sin espacios en blanco
        String strFraseInvertida;//String que guarda la frase del usuario dada la vuelta

        //SOLICITUD DE DATOS
        System.out.println("Introduzca una frase: ");
        strFraseUsuario = scEntrada.nextLine();
        scEntrada.close();

        //PASO DE LA FRASE DEL USUARIO A MINÚSCULAS
        strFraseUsuario = strFraseUsuario.toLowerCase();

        //LLAMADA A LA FUNCIÓN fraseSinEspacios(String);
        strFraseSinEspacios = fraseSinEspacios(strFraseUsuario);

        //LLAMADA A LA FUNCIÓN fraseSinEspacios(String);
        strFraseInvertida = fraseDelReves(strFraseSinEspacios);

        //IMPRESIÓN DE LOS RESULTADOS
        /* A través del resultado del método String.equals obtendremos un resultado true (la frase es palíndroma), o
         * false (la frase no es palíndroma) el cual será impreso por pantalla como resultado del programa. */
        System.out.println(strFraseSinEspacios.equals(strFraseInvertida) ? "La frase es palíndroma."
                                                                         : "La frase no es palíndroma.");
    }
    public static void main(String[] args) {
        inicio();
    }
}

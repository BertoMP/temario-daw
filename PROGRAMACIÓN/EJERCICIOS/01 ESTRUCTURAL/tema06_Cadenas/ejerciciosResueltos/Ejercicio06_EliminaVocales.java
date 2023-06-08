package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Escribir un programa que pida el nombre completo al usuario y lo muestre sin vocales (mayúsculas, minúsculas y      *
 * acentuadas). Por ejemplo, "Álvaro Pérez" se mostrará "lvr Prz".                                                     *
 ***********************************************************************************************************************/
public class Ejercicio06_EliminaVocales {
    /*******************************************************************************************************************
     * Función encargada de comprobar si el caracter pasado por paramétro es una vocal o una consonante.               *
     *                                                                                                                 *
     * @param chrLetra -> Carácter que comprobar.                                                                      *
     * @return La función devolverá un true o false en función del resultado obtenido en el metodo indexOf(char),      *
     *         si el resultado es -1 devolverá un false (no es vocal) debido a que la letra no se encontrará en el     *
     *         String de vocales. Si se obtiene cualquier otro valor, se tratará de una vocal contenida en el String   *
     *         y, por tanto, se devolverá un true.                                                                     *
     *******************************************************************************************************************/
    public static boolean esVocal(char chrLetra) {
        //DECLARACIÓN DE VARIABLES
        String strVocalesPosibles = "aeiouáéíóú"; //Variable String que contiene las vocales minúsculas sin acento y con él

        //MÉTODO toLoweCase(char)
        chrLetra = Character.toLowerCase(chrLetra); //En caso de ser una letra mayúscula se convertirá en minúscula

        //RETURN
        return strVocalesPosibles.indexOf(chrLetra) != -1;
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strNombreCompleto; //Variable String que guardará el nombre del usuario.
        String strNombreSinVocales = ""; //Variable String que guardará el nombre sin vocales.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca nombre y apellidos: ");
        strNombreCompleto = scEntrada.nextLine();
        scEntrada.close();

        //BUCLE FOR
        for (int intContador = 0; intContador < strNombreCompleto.length(); intContador++) {
            /* El bucle se mantendrá hasta que el contador alcance la longitud del nombre introducido por el usuario.
             * En cada iteración lo que se hará es una llamada a la función esVocal para comprobar si el caracter del
             * nombre introducido correspondiente al contador del bucle es una vocal o una consonante, si la función
             * devuelve un false (es consonante) se guardará la letra en la variable strNombreSinVocales; en caso de
             * que devuelva un true (es vocal) simplemente se pasará al siguiente turno del contador. */
            if (!esVocal(strNombreCompleto.charAt(intContador))) { //LLAMADA A LA FUNCIÓN esVocal(char);
                strNombreSinVocales += strNombreCompleto.charAt(intContador);
            }
        }

        //IMPRESIÓN DE LOS RESULTADOS FINALES
        System.out.println("El nombre completo es: " + strNombreCompleto);
        System.out.println("El nombre sin vocales es: " + strNombreSinVocales);
    }
    public static void main(String[] args) {
        inicio();
    }
}

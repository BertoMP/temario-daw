package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Diseñar una aplicación que pida al usuario que introduzca una frase por teclado, e indique cuántos espacios en      *
 * en blanco tiene.                                                                                                    *
 ***********************************************************************************************************************/
public class Ejercicio04_NumeroEspaciosEnBlanco {
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strFraseUsuario; //Variable String para la frase del usuario
        int intNumeroEspacios = 0; //Variable int que almacenará el número de espacios

        //SOLICITUD DE DATOS
        System.out.print("Escriba una frase: ");
        strFraseUsuario = scEntrada.nextLine();
        scEntrada.close();

        //BUCLE FOR
        for (int intContador = 0; intContador < strFraseUsuario.length(); intContador++) {
            /* El bucle se mantendrá hasta que el contador llegue a la longitud de la frase que haya introducido
             * el usuario por consola.
             * En cada iteración se comprobará que el carácter correspondiente al contador es un espacio, en caso
             * de serlo se aumentará intNumeroEspacios en 1. */
            if (strFraseUsuario.charAt(intContador) == ' ') {
                intNumeroEspacios++;
            }
        }

        //IMPRESIÓN DE RESULTADOS
        System.out.println("La frase tiene " + intNumeroEspacios + " espacios en blanco.");
    }
    public static void main(String[] args) {
        inicio();
    }
}

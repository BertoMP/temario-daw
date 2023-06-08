package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Introducir por teclado una frase palabra a palabra, y mostrar la frase completa separando las palabras introducidas *
 * con espacios en blanco. Terminar de leer la frase cuando alguna de las palabras introducidas sea la cadena "fin"    *
 * escrita con cualquier combinación de mayúsculas y minúsculas. La cadena "fin" no aparecerá en la palabra.           *
 ***********************************************************************************************************************/
public class Ejercicio09_CrearFrase {
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        final String STR_FIN = "fin";
        String strFraseACrear = ""; //Variable String que guardará la frase a crear
        String strPalabra; //Variable String que guardará las palabras introducidas por el usuario

        //SOLICITUD DE DATOS AL USUARIO
        System.out.print("Introduzca una palabra: ");
        strPalabra = scEntrada.next();

        //BUCLE WHILE PARA CREAR LA FRASE
        while (!strPalabra.toLowerCase().equals(STR_FIN)) {
            /* El bucle se mantendrá mientras el usuario no introduzca la palabra "fin" en cualquier variación de
             * mayus/minus posible.
             * Cada vez que introduzca una palabra se añadirá al String strFraseACrear precedido por un espacio.
             * Tras eso se solicitará una nueva palabra al usuario. */
            strFraseACrear += " " + strPalabra;
            System.out.print("Introduzca una palabra: ");
            strPalabra = scEntrada.next();
        }
        scEntrada.close();

        //CAMBIOS EN EL STRING
        strFraseACrear = strFraseACrear.strip(); //Eliminación del espacio inicial que se crea en la primera iteración del bucle
        strFraseACrear = strFraseACrear.substring(0,1).toUpperCase() + strFraseACrear.substring(1); //Conversión de la primera letra en mayúscula
        if (strFraseACrear.charAt(strFraseACrear.length() - 1) != '.') { //En caso de que el último carácter no sea un '.' se añade
            strFraseACrear = strFraseACrear + '.';
        }

        //IMPRESIÓN DE RESULTADOS
        System.out.println("La frase introducida es: " + strFraseACrear);
    }
    public static void main(String[] args) {
        inicio();
    }
}

package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Introducir por teclado dos frases e indicar cuál de ellas es más corta, es decir, la que contiene menos caracteres. *
 ***********************************************************************************************************************/
public class Ejercicio02_FraseMasCorta {
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strFraseUno; //Variable String para guardar la primera frase del usuario.
        String strFraseDos; //Variable String para guardar la segunda frase del usuario.
        int intLongitudFraseUno; //Variable int para guardar la longitud de la primera frase.
        int intLongitudFraseDos; //Variable int para guardar la longitud de la segunda frase.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca la primera frase: ");
        strFraseUno = scEntrada.nextLine();
        intLongitudFraseUno = strFraseUno.length();

        System.out.print("Introduzca la segunda frase: ");
        strFraseDos = scEntrada.nextLine();
        intLongitudFraseDos = strFraseDos.length();

        scEntrada.close();

        //CONDICIONAL PARA LA IMPRESIÓN DE LA SOLUCIÓN
        if (intLongitudFraseUno == intLongitudFraseDos) {
            System.out.println("Son de la misma longitud");
        } else if (intLongitudFraseUno < intLongitudFraseDos) {
            System.out.println("La frase 1 es la frase mas corta.");
                } else {
                    System.out.println("La frase 2 es la frase mas corta.");
                }
    }
    public static void main(String[] args) {
        inicio();
    }
}

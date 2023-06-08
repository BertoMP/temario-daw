package tema10_FicherosDeTexto.ejerciciosResueltos.ejercicioResuelto01_ExceptionScannerInteger.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        Integer integer;

        integer = leerEntero();

        System.out.println("El número introducido es: " + integer);
    }

    /*******************************************************************************************************************
     * Método encargado de pedir un entero por consola y devolverlo.                                                   *
     *                                                                                                                 *
     * @return Devuelve el Integer introducido por consola.                                                            *
     *******************************************************************************************************************/
    public static Integer leerEntero() {
        Integer integerReturn = null;
        boolean blnNumeroValido = false;

        while (!blnNumeroValido) {
            try {
                System.out.print("Dime un número entero: ");
                integerReturn = new Scanner(System.in).nextInt();
                blnNumeroValido = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un número entero.");
            }
        }
        return integerReturn;
    }
}

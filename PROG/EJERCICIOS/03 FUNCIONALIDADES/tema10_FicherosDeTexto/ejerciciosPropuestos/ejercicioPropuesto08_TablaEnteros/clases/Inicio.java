package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto08_TablaEnteros.clases;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE VARIABLES
        int[] intNumeros; //Array de enteros que guardará los números.
        String strTexto; //String con la cada que introduzca el usuario por consola.

        do {
            System.out.print("Dime un texto (debe contener números): ");
            strTexto = new Scanner(System.in).nextLine();

            if (strTexto.isEmpty()) {
                System.out.println("El texto no puede estar vacío.");
            }
        } while(strTexto.isEmpty());

        intNumeros = leerEnteros(strTexto);

        if (intNumeros.length == 0) {
            System.out.println("El texto que introdujiste no tenía números enteros.");
        } else {
            System.out.println("Estos son los enteros que introdujiste.");
            System.out.println(Arrays.toString(intNumeros));
        }
    }

    /*******************************************************************************************************************
     * Método encargado de leer los elementos de un string que se pasa por parámetro y devolver un array de enteros    *
     * que contenga los enteros que en ella se encuentren.                                                             *
     *                                                                                                                 *
     * @param strTexto String que se pasa por parámetro.                                                               *
     * @return El método devuelve un array de enteros.                                                                 *
     *******************************************************************************************************************/
    private static int[] leerEnteros(String strTexto) {
        //DECLARACIÓN DE OBJETOS
        Scanner scLectura = new Scanner(strTexto);

        //DECLARACIÓN DE VARIALES
        int[] intArrReturn = new int[0]; //Array que se devolverá como resultado del método.

        while (scLectura.hasNext()) {
            if (scLectura.hasNextInt()) {
                intArrReturn = Arrays.copyOf(intArrReturn, intArrReturn.length + 1);
                intArrReturn[intArrReturn.length - 1] = scLectura.nextInt();
            } else {
                scLectura.next();
            }
        }

        scLectura.close();

        return intArrReturn;
    }
}

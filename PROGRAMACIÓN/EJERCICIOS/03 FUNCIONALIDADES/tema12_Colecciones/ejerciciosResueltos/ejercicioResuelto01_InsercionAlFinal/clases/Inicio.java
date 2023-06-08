package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto01_InsercionAlFinal.clases;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Método encargado del control principal del programa.                                                                *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos por teclado.

        //DECLARACIÓN DE VARIABLES
        String[] strNombres = new String[0]; //Array de String que almacenará los nombres.
        String strCadena; //String que almacenará el nombre introducido por el usuario.

        System.out.println(Arrays.toString(strNombres));

        System.out.print("Dime un nombre a añadir (introduce una cadena vacía para terminar): ");
        strCadena = scEntrada.nextLine();

        while (!strCadena.isEmpty()) {
            strNombres = Inicio.addFinal(strCadena, strNombres);

            System.out.print("Dime un nombre a añadir (introduce una cadena vacía para terminar): ");
            strCadena = scEntrada.nextLine();

        }
        scEntrada.close();

        System.out.println(Arrays.toString(strNombres));
    }

    /*******************************************************************************************************************
     * Método encargado de añadir un objeto al final de un array que se pasa como parámetro.                           *
     *                                                                                                                 *
     * @param nuevoObjeto Objeto a añadir al final del array.                                                          *
     * @param arrayObjetos Array al que se le debe añadir el objeto.                                                   *
     * @return Devuelve un array con los elementos del array original más el nuevo elemento.                           *
     * @param <E> Tipo genérico para el objeto que se va a añadir al array para el array en sí.                        *
     *******************************************************************************************************************/
    private static <E> E[] addFinal(E nuevoObjeto, E[] arrayObjetos) {
        //DECLARACIÓN DE VARIABLES
        E[] arrayReturn; //Array de tipo genérico E que se devolverá como resultado del método.

        arrayReturn = Arrays.copyOf(arrayObjetos, arrayObjetos.length + 1);
        arrayReturn[arrayReturn.length - 1] = nuevoObjeto;

        return arrayReturn;
    }
}

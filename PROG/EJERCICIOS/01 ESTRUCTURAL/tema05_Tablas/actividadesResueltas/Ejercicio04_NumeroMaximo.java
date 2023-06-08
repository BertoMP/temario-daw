package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que contenga una funcion maximo (int t[]) que devuelva el numero mayor de un array de dimension   *
 * fijada por el usuario                                                                                               *
 ***********************************************************************************************************************/
public class Ejercicio04_NumeroMaximo {
    /*******************************************************************************************************************
     *                                                                                                                 *
     * Funcion creada para encontrar el numero maximo de un array entregado como parametro                             *
     *                                                                                                                 *
     * @param t --> Array de numeros enteros que sera recorrido en su totalidad para buscar el numero mas alto de la   *
     *          serie                                                                                                  *
     * @return La funcion devolvera el valor maximo del array                                                          *
     *                                                                                                                 *
     *******************************************************************************************************************/
    public static int maximo (int t[]){ //Funcion de tipo int porque vamos a devolver un valor de ese mismo tipo
        //DECLARACION DE VARIABLES
        int intNumMaximo = t[0]; /* Declaramos una variable intNumMaximo que nos va a servir para guardar el numero
                                    mas alto del array el cual habra que devolver. Se inicaliza con el primer valor
                                    del array t[].*/

        //BUCLE FOR EACH
        for (int intNuevoMaximo : t) { //Como vamos a recorrer el array en su totalidad utilizamos un for each
            if(intNuevoMaximo > intNumMaximo){ /* Condicional simple. Si el numero que se guarde en intNuevoMaximo es
                                                  mayor intNumMaximo, ese numero sera el nuevo maximo. */
                intNumMaximo = intNuevoMaximo;
            }
        }
        return intNumMaximo; //Devolvemos la variable intNumMaximo que contendra el numero mas alto del array.
    }
    public static void main(String[] args) {
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int intCantidad; //Variable que nos servira para guardar la dimension del array que quiere el usuario
        int[] intArrNumeros; //Declaramos una variable de tipo array entero que posteriormente inicializaremos
        int intNumMaximo; //Variable que nos servira para guardar el numero maximo del array

        //SOLICITUD DE DATOS AL USUARIO
        System.out.print("Introduzca cantidad: ");
        intCantidad = scEntrada.nextInt();

        intArrNumeros = new int[intCantidad];//Iniciamos el array ya que conocemos la dimension que tendra

        System.out.println();
        //RELLENADO DEL ARRAY
        for(int i = 0; i < intArrNumeros.length; i++){
            System.out.print("Introduzca el " + (i + 1) + "º numero de la serie: ");
            intArrNumeros[i] = scEntrada.nextInt();
        }
        scEntrada.close();

        //LLAMAMIENTO A LA FUNCION
        intNumMaximo = maximo(intArrNumeros); /* Llamamos a la funcion maximo() y le introducimos el
                                                 array creado como parametro de entrada */

        //IMPRESION DE LOS RESULTADOS
        System.out.println("\nEn el array " + Arrays.toString(intArrNumeros)
                + " el numero maximo es el: " + intNumMaximo);
    }
}

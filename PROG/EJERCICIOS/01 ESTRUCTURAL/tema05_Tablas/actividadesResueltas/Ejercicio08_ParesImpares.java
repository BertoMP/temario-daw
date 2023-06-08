package tema05_Tablas.actividadesResueltas;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Diseñar una funcion a la que se le pase por parametro un array de numeros enteros. Debe generar e imprimir dos      *
 * arrays, uno para numeros pares y otro para impares. A la hora de imprimir los arrays estos deben estar ordenados    *
 ***********************************************************************************************************************/
public class Ejercicio08_ParesImpares {
    /*******************************************************************************************************************
     * Funcion a la que se le pasa por parametro un array de numeros enteros. Dentro de la funcion se va a dividir el  *
     * array en 2 arrays, uno para numeros pares y otro para numeros impares.                                          *
     * Posteriormente se imprimirá cada array.                                                                         *
     *                                                                                                                 *
     * @param intArrNumeros --> Array de numeros enteros                                                               *
     *******************************************************************************************************************/
    public static void arraysParImpar(int[] intArrNumeros){
        //DECLARACION DE VARIABLES
        int[] intArrPares = new int[0]; //Variable array donde se guardaran los pares
        int[] intArrImpares = new int[0]; //Variable array donde se guardaran los impares

        //BUCLE FOR EACH
        for (int intValor : intArrNumeros){
            /* Se va a recorrer el array intArrNumeros en su totalidad y se va a guardar el valor de cada indice en
            *  la variable intValor. Si el numero de intValor es par se introducira en el array intArrPares, si es
            *  impar lo hara en el array intArrImpares.
            *  Para las introducciones lo que se hara es crear una copia del array original pero con un indice mas
            *  y sera en ese indice, que sera el ultimo donde se introducira el valor par o impar */
            if(intValor % 2 == 0){
                intArrPares = Arrays.copyOf(intArrPares, intArrPares.length + 1);
                intArrPares[intArrPares.length - 1] = intValor;
            }else{
                intArrImpares = Arrays.copyOf(intArrImpares, intArrImpares.length + 1);
                intArrImpares[intArrImpares.length - 1] = intValor;
            }
        }

        //ORDENAMIENTO DE LOS DOS ARRAYS
        Arrays.sort(intArrPares);
        Arrays.sort(intArrImpares);

        //IMPRESION DE LOS DOS ARRAYS
        System.out.println("Pares ordenados: " + Arrays.toString(intArrPares));
        System.out.println("Impares ordenados: " + Arrays.toString(intArrImpares));
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrNumeros; //Declaracion de una variable array donde se guardaran los numeros
        int intLongitud; //Variable int donde el usuario guardara la longitud del array de numeros aleatorios.

        //SOLICITUD DE DATOS
        System.out.print("Defina longitud: ");
        intLongitud = scEntrada.nextInt();
        intArrNumeros = new int[intLongitud]; //Inicializacion del array con la longitud decidida por el usuario

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for(int i = 0; i < intArrNumeros.length; i++){
            intArrNumeros[i] = (int) (Math.random() * 10 + 1); /* Se va a rellenar el array con numeros
                                                                  aleatorios entre 1 y 10. */
        }

        //IMPRESION DEL ARRAY
        System.out.println("\nEl array creado es: " + Arrays.toString(intArrNumeros));

        //LLAMADA A LA FUNCION
        arraysParImpar(intArrNumeros);
    }
}

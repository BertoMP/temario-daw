package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Algoritmo de fusion de dos arrays.                                                                                  *
 ***********************************************************************************************************************/
public class Ejercicio10_AlgoritmoFusion {
    /*******************************************************************************************************************
     * Funcion encargada de fusionar (de forma ordenada) dos arrays.                                                   *
     *                                                                                                                 *
     * @param intArray1 -> Primer array a fusionar.                                                                    *
     * @param intArray2 -> Segundo array a fusionar.                                                                   *
     *******************************************************************************************************************/
    public static void fusionaArrays(int[] intArray1, int[] intArray2){
        //DECLARACION DE VARIABLES
        int[] intArrayFusionado = new int[intArray1.length + intArray2.length]; //Array fusion donde se van a introducir todos los valores de los otros dos arrays
        int intContArray1 = 0; //Contador para el array 1
        int intContArray2 = 0; //Contador para el array 2
        int intContArrayFusionado; //Contador para el array fusionado

        //FOR PARA RELLENAR EL ARRAY FUSIONADO
        for (intContArrayFusionado = 0; intContArray1 < intArray1.length &&
                                        intContArray2 < intArray2.length; intContArrayFusionado++){ /* El bucle lo que va a realizar es una comprobacion en cada
                                                                                                       iteracion del primer valor no introducido de cada array, por ejemplo
                                                                                                       en la primera iteracion comprobara el indice 0 de ambos arrays, en
                                                                                                       la siguiente la 1 (del que haya introducido) y la 0 del otro...
                                                                                                       Lo que se hara en cada iteracion es realizar esa comprobacion, de
                                                                                                       manera que el valor mas bajo de ambos se introducira en el array fusionado
                                                                                                       y el contador de ese array se aumentara en 1.
                                                                                                       El bucle se mantendra hasta que uno de los dos arrays se haya
                                                                                                       copiado en el array fusionado. */
            if (intArray1[intContArray1] <= intArray2[intContArray2]){
                intArrayFusionado[intContArrayFusionado] = intArray1[intContArray1];
                intContArray1++;
            } else {
                intArrayFusionado[intContArrayFusionado] = intArray2[intContArray2];
                intContArray2++;
            }
        }
        //COMPLETADO DEL ARRAY FUSIONADO
        if (intContArray1 < intArray1.length){ /* Una vez que se haya completado uno de los dos arrays y fuera del for anterior
                                                  lo que se hara es averiguar cual de los dos se ha terminado, si el contador del
                                                  array 1 es menor a su longitud significa que es el que todavia no ha terminado
                                                  (condicion if), en caso contrario el array que habra no finalizado su copia en
                                                  el fusionado es el array 2 (condicion else). */
            System.arraycopy(intArray1, intContArray1, intArrayFusionado, intContArrayFusionado,
                    intArray1.length - intContArray1);
            } else {
            System.arraycopy(intArray2, intContArray2, intArrayFusionado, intContArrayFusionado,
                    intArray2.length - intContArray2);
            }
        //IMPRESION DE RESULTADOS
        System.out.println();
        System.out.println("ARRAY FUSIONADO: " + Arrays.toString(intArrayFusionado));
    }
    /*******************************************************************************************************************
     * Funcion encargada de devolver un array con valores aleatorios.                                                  *
     *                                                                                                                 *
     * @param scEntrada -> Objeto Scanner para la introduccion de datos por consola.                                   *
     *******************************************************************************************************************/
    public static int[] rellenaArray (Scanner scEntrada){
        //DECLARACION DE VARIABLES
        int[] intArr; //Variable array en la que se introduciran los datos y que sera devuelto al finalizar
        int intLongitud; //Variable para decididr la longitud del array
        int intMaximo; //Variable para decidir el numero maximo del array

        //SOLICITUD DE DATOS
        System.out.print("Defina longitud del array: ");
        intLongitud = scEntrada.nextInt();

        System.out.print("Defina valor maximo del array: ");
        intMaximo = scEntrada.nextInt();

        intArr = new int[intLongitud]; //Inicializacion del array

        //BUCLE FOR PARA EL RELLENADO DEL ARRAY
        for (int intCont = 0; intCont < intArr.length; intCont++){
            intArr[intCont] = (int) (Math.random() * intMaximo + 1);
        }

        //ORDENACION DEL ARRAY
        Arrays.sort(intArr);

        //RETURN
        return intArr;
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    public static void inicio() {
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrayPrimero; //Variable array para el primer array
        int[] intArraySegundo; //Variable array para el segundo array

        //LLAMADAS A LA FUNCION rellenaArray(Scanner);
        System.out.println("PRIMER ARRAY");
        intArrayPrimero = rellenaArray(scEntrada);
        System.out.println("SEGUNDO ARRAY");
        intArraySegundo = rellenaArray(scEntrada);

        scEntrada.close();

        //IMPRESION DE LOS ARRAYS
        System.out.println("ARRAY 1: " + Arrays.toString(intArrayPrimero));
        System.out.println("ARRAY 2: " + Arrays.toString(intArraySegundo));

        //LLAMADA A LA FUNCION fusionaArrays(int[],int[],int[]);
        fusionaArrays(intArrayPrimero,intArraySegundo);
    }
    /*******************************************************************************************************************
     * Metodo Main. Contiene la funcion iniciadora del programa.                                                       *
     *******************************************************************************************************************/
    public static void main(String[] args) {
        inicio();
    }
}

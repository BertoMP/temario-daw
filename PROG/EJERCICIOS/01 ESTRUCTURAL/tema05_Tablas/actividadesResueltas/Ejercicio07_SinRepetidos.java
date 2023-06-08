package tema05_Tablas.actividadesResueltas;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Desarrollar una funcion que reciba como parametro un array de enteros. La funcion debe devolver el array sin        *
 * numeros repetidos y con una longitud acorde a la cantidad de numeros.                                               *
 ***********************************************************************************************************************/
public class Ejercicio07_SinRepetidos {
    /*******************************************************************************************************************
     * Funcion que recibira por parametro un array de numeros enteros (ordenado) y que creara un nuevo array de        *
     * una longitud N igual al numero de digitos NO repetidos que haya en el array.                                    *
     * Se devolvera un nuevo array que no contenga ningun numero repetido.                                             *
     * @param t --> Array de numeros aleatorios                                                                        *
     * @return --> Array sin numeros repetidos                                                                         *
     *******************************************************************************************************************/
    public static int[] sinRepetidos(int[] t){
        //DECLARACION VARIABLES
        int[] intArrAuxiliar = new int[0]; //Variable array donde se guardará el nuevo array
        /*OTRA OPCION DE INICIO SERÍA:
         *  int[] intArrAuxiliar = new int[1];
         *  intArrAuxiliar[0] = t[0];
         * De esa forma se inicia el primer indice del nuevo array con el valor del primer indice del
         * array original.
         */

        //BUCLE FOR EACH
        for(int intValor : t){
            /* Se va a recorrer el array original en su totalidad y se va a guardar en la variable intValor el valor
            *  de cada índice del array. A continuacion, se va a buscar si ese valor existe ya en el nuevo array,
            *  si no existe (es decir si el resultado de Arrays.binarySearch(intArrAuxiliar, intValor) es negativo),
            *  se va a crear una copia del array con un espacio más y en el último espacio se va a introducir
            *  el nuevo valor. */
            if(Arrays.binarySearch(intArrAuxiliar, intValor) < 0){
                intArrAuxiliar = Arrays.copyOf(intArrAuxiliar, intArrAuxiliar.length + 1);
                intArrAuxiliar[intArrAuxiliar.length - 1] = intValor;
            }
        }
        //RETURN DE LA FUNCION
        return intArrAuxiliar;
    }
    public static void main(String[] args) {
        //DECLARACION VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrNumeros; //Variable array donde se introduciran N numeros aleatorios elegidos por el usuario.
        int[] intArrSinRepetidos; //Variable array donde guardaremos el resultado de la funcion.
        int intLongitud; //Variable int donde el usuario guardara la longitud del array de numeros aleatorios.

        //SOLICITUD DE DATOS
        System.out.print("Defina longitud: ");
        intLongitud = scEntrada.nextInt();
        intArrNumeros = new int[intLongitud];
        scEntrada.close();

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for(int i = 0; i < intArrNumeros.length; i++){
            intArrNumeros[i] = (int) (Math.random() * 10 + 1); /* Se va a rellenar el array con numeros
                                                                  aleatorios entre 1 y 10. */
        }

        //ORDENACION DEL ARRAY
        Arrays.sort(intArrNumeros);

        //LLAMADA A LA FUNCION
        intArrSinRepetidos = sinRepetidos(intArrNumeros);

        //IMPRESION
        System.out.println("ARRAY ORIGINAL: " + Arrays.toString(intArrNumeros));
        System.out.println("ARRAY SIN REPETIDOS: " + Arrays.toString(intArrSinRepetidos));
    }
}

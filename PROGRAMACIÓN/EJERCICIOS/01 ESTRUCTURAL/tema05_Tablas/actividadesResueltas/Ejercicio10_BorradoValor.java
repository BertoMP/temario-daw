package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que permita crear un array de N numeros. A continuacion el usuario decidira a partir de que       *
 * valor quiere que otra funcion elimine valores.                                                                      *
 ***********************************************************************************************************************/
public class Ejercicio10_BorradoValor {
    /*******************************************************************************************************************
     * Funcion encargada de eliminar valores mayores a intValor (decidido por el usuario).                             *
     *                                                                                                                 *
     * @param intArrT --> Array de numeros enteros (no ordenado).                                                      *
     * @param intValor --> Variable int definida por el usuario con un valor a partir del cual hay que borrar          *
     *                     todos los numeros mayores.                                                                  *
     * @return intArrT --> Array sin los valores mayores a intValor.                                                   *
     *******************************************************************************************************************/
    public static int[] eliminaMayores(int[] intArrT, int intValor){
        //BUCLE FOR PARA ELIMINAR VALORES
        for (int intCont = 0; intCont < intArrT.length;){/* Comparamos cada valor del array con el valor que ha decidido el usuario.
                                                          *        - Si el valor es mayor, se sobrescribe el valor del índice 0 con el valor del último
                                                          *          índice del array. A continuacion, se hará una copia del array con longitud - 1.
                                                          *        - Si el valor es menor, se incrementara el contador en uno.*/
            if (intArrT[intCont] > intValor){
                intArrT[intCont] = intArrT[intArrT.length - 1];
                intArrT = Arrays.copyOf(intArrT, intArrT.length - 1);
            } else {
                intCont++;
            }
        }
        //RETURN
        return intArrT;
    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar un array con N numeros aleatorios.                                                *
     *                                                                                                                 *
     * @param intLongitud --> Longitud del array                                                                       *
     * @return intArr --> Array de numeros aleatorios                                                                  *
     *******************************************************************************************************************/
    public static int[] rellenaArray(int intLongitud){
        //DECLARACION DE VARIABLES
        int[] intArr = new int[intLongitud];

        //BUCLE FOR PARA RELLENAR EL ARRAY CON VALORES ALEATORIOS
        for (int intCont = 0; intCont < intArr.length; intCont++){
            intArr[intCont] = (int) (Math.random() * 100 + 1);
        }
        //RETURN
        return intArr;
    }
    /*******************************************************************************************************************
     * Funcion que desarrollara las instrucciones principales del programa                                             *
     *******************************************************************************************************************/
    private static void inicio(){
        Scanner scEntrada = new Scanner(System.in);
        //DECLARACION DE VARIABLES
        int intNum; //Variable donde se guardara el numero a partir del cual se borraran los datos
        int intLongitud; //Variable para la longitud de numeros
        int[] intArrNumeros; //Variable array donde se guardaran los diferentes valores

        //SOLICITUD DE DATOS AL USUARIO
        System.out.print("Defina longitud del array: ");
        intLongitud = scEntrada.nextInt();

        //LLAMADA A LA FUNCION rellenaArray()
        intArrNumeros = rellenaArray(intLongitud);

        //IMPRESION DE RESULTADO
        System.out.println("El array generado es: " + Arrays.toString(intArrNumeros));

        //SOLICITUD DE DATOS AL USUARIO
        System.out.print("\nSeleccione a partir de que valor quiere borrar: ");
        intNum = scEntrada.nextInt();

        //LLAMADA A LA FUNCION eliminaMayores (int[], int)
        intArrNumeros = eliminaMayores(intArrNumeros, intNum);

        //IMPRESION DE RESULTADOS FINALES
        System.out.println("El array con el borrado solicitado es: " + Arrays.toString(intArrNumeros));
    }
    public static void main(String[] args) {
        inicio();
    }
}

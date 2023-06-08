package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que genere un array de N posiciones con valores desde 1 a N y, a continuación, desde una funcion  *
 * devolver todos los indices que contienen X valor.                                                                   *
 ***********************************************************************************************************************/
public class Ejercicio01_DevuelveIndices {
    /*******************************************************************************************************************
     * Funcion encargada de rellenar el array de indices. Cada vez que el valor numerico se encuentre en el array      *
     * se realizara una copia del array con uno mas de longitud y se insertara el indice en la ultima posicion del     *
     * array.                                                                                                          *
     *                                                                                                                 *
     * @param intArrT -> Array con valores numericos                                                                   *
     * @param intClave -> Valor a buscar decidido por el usuario                                                       *
     * @return intArray -> Array con los indices                                                                       *
     *******************************************************************************************************************/
    public static int[] buscarTodos (int[] intArrT, int intClave){
        //DECLARACION DE VARIABLES
        int[] intArray = new int[0];

        //BUCLE FOR PARA EL RELLENADO DEL ARRAY
        for(int intCont = 0; intCont < intArrT.length; intCont++){
            if(intArrT[intCont] == intClave){
                intArray = Arrays.copyOf(intArray, intArray.length + 1);
                intArray[intArray.length - 1] = intCont;
            }
        }
        //RETURN
        return intArray;
    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar el array numerico.                                                                *
     *                                                                                                                 *
     * @param intArr -> Variable array donde se introduciran los numeros aleatorios                                    *
     * @param intMax -> Valor numerico maximo decidido por el usuario                                                  *
     *******************************************************************************************************************/
    public static void rellenaArray (int[] intArr, int intMax){
        //BUCLE FOR PARA EL RELLENADO DEL ARRAY
        for (int intCont = 0; intCont < intArr.length; intCont++){
            intArr[intCont] = (int) (Math.random() * intMax + 1);
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrNumeros; //Variable array donde se guardaran los numeros
        int intLongitud; //Variable para definir la longitud del array de numeros
        int intMaximo; //Variable para definir el valor maximo
        int intValorABuscar; //Variable para definiri el valor a buscar dentro del array
        int[] intIndices; //Variable array donde se guardaran los indices que contengan el valor a buscar

        //SOLICITUD DE DATOS
        System.out.print("Defina longitud del array: ");
        intLongitud = scEntrada.nextInt();

        System.out.print("Defina valor maximo del array: ");
        intMaximo = scEntrada.nextInt();

        //INICIALIZACION DEL ARRAY NUMERICO
        intArrNumeros = new int[intLongitud];

        //LLAMADA A LA FUNCION rellenaArray(int[], int);
        rellenaArray(intArrNumeros, intMaximo);

        //IMPRESION DEL ARRAY
        System.out.println(Arrays.toString(intArrNumeros));

        //SOLICITUD DE DATOS
        System.out.print("Defina valor a buscar: ");
        intValorABuscar = scEntrada.nextInt();

        scEntrada.close();

        //LLAMADA A LA FUNCION buscarTodos(int[], int);
        intIndices = buscarTodos(intArrNumeros, intValorABuscar);

        //IMPRESION DE RESULTADOS
        System.out.println(intIndices.length != 0 ? "El valor " + intValorABuscar + " se encuentra en los indices: "
                                                    + Arrays.toString(intIndices)
                                                  : "El valor " + intValorABuscar + " no se encuentra en el array.");
    }
    public static void main(String[] args) {
        inicio();
    }
}

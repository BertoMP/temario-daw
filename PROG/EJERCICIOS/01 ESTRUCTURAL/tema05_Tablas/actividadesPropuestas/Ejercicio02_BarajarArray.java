package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear una funcion que reciba un array por parametro lo desordene y lo imprima.                                      *
 ***********************************************************************************************************************/
public class Ejercicio02_BarajarArray {
    /*******************************************************************************************************************
     * Funcion encargada de desordenar un array.                                                                       *
     *                                                                                                                 *
     * @param intArrT -> Array de numeros que va a ser desordenado                                                     *
     *******************************************************************************************************************/
    public static void desordenar(int[] intArrT){
        //DECLARACION DE VARIABLES
        int intAuxiliar; //Variable auxiliar para guardar el valor de un indice
        int intNumAleatorio; //Variable para guardar un numero aleatorio

        //BUCLE FOR PARA DESORDENAR EL ARRAY
        for(int intCont = 0; intCont < intArrT.length; intCont++){ /* Se generara un numero aleatorio entre 0 y length -1. A continuacion
                                                                      en intAuxiliar se guardara el valor del indice correspondiente al numero
                                                                      aleatorio. En el indice del num aleatorio se insertara el valor del indice del
                                                                      contador y, por ultimo, en el indice del contador se insertara el valor guardado
                                                                      en la variable auxiliar*/
            intNumAleatorio = (int) (Math.random() * intArrT.length);
            intAuxiliar = intArrT[intCont];
            intArrT[intCont] = intArrT[intNumAleatorio];
            intArrT[intNumAleatorio] = intAuxiliar;
        }
    }
    /*******************************************************************************************************************
     * Funcion destinada a rellenar un array numerico.                                                                 *
     *                                                                                                                 *
     * @param intArr -> Variable array donde se introduciran los numeros                                               *
     * @param intMax -> Valor maximo de los numeros                                                                    *
     *******************************************************************************************************************/
    public static void rellenaArray (int[] intArr, int intMax){
        //BUCLE FOR PARA EL RELLENADO DEL ARRAY
        for (int intCont = 0; intCont < intArr.length; intCont++){
            intArr[intCont] = (int) (Math.random() * intMax + 1);
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo del programa.                                                                  *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrNumeros; //Variable array donde se guardaran los numeros
        int intLongitud; //Longitud del array numerico
        int intMaximo; //Valor maximo de los numeros del array

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
        System.out.println("El array es: " + Arrays.toString(intArrNumeros));

        //LLAMADA A LA FUNCION desordenar(int[]);
        desordenar(intArrNumeros);

        //IMPRESION DEL ARRAY CON EL NUEVO ORDEN
        System.out.println("El nuevo orden es: " + Arrays.toString(intArrNumeros));
    }
    public static void main(String[] args) {
        inicio();
    }
}

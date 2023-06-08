package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear una funcion que reciba un array por parametro. Genere una copia del mismo, lo desordene y lo devuelva         *
 * como resultado.                                                                                                     *
 ***********************************************************************************************************************/
public class Ejercicio03_BarajarArrayOtroArray {
    /*******************************************************************************************************************
     * Funcion encargada de crear un array copia del que recibe por parametro y de desordenarlo.                       *
     *                                                                                                                 *
     * @param intArrT -> Array que se va a copiar                                                                      *
     * @return intArrAuxiliar -> Array copia desordenado                                                               *
     *******************************************************************************************************************/
    public static int[] desordenar(int[] intArrT){
        //DECLARACION DE VARIABLES
        int[] intArrAuxiliar; //Array auxiliar que servira como copia
        int intAuxiliar; //Variable auxiliar para guardar el valor de un indice
        int intNumAleatorio; //Variable para guardar un numero aleatorio

        //COPIA DEL ARRAY
        intArrAuxiliar = Arrays.copyOf(intArrT, intArrT.length);

        //BUCLE FOR PARA DESORDENAR
        for(int intCont = 0; intCont < intArrAuxiliar.length; intCont++){ /* Se generara un numero aleatorio entre 0 y length -1. A continuacion
                                                                             en intAuxiliar se guardara el valor del indice correspondiente al numero
                                                                             aleatorio. En el indice del num aleatorio se insertara el valor del indice del
                                                                             contador y, por ultimo, en el indice del contador se insertara el valor guardado
                                                                             en la variable auxiliar */
            intNumAleatorio = (int) (Math.random() * intArrT.length);
            intAuxiliar = intArrAuxiliar[intNumAleatorio];
            intArrAuxiliar[intNumAleatorio] = intArrAuxiliar[intCont];
            intArrAuxiliar[intCont] = intAuxiliar;
        }
        //RETURN
        return intArrAuxiliar;
    }
    /*******************************************************************************************************************
     * Función destinada a rellenar un array numerico.                                                                 *
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
        int[] intArrNumerosDesorden; //Variable array donde se guardara el array desordenado

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
        intArrNumerosDesorden = desordenar(intArrNumeros);

        System.out.println("El array desordenado es: " + Arrays.toString(intArrNumerosDesorden));
    }
    public static void main(String[] args) {
        inicio();
    }
}
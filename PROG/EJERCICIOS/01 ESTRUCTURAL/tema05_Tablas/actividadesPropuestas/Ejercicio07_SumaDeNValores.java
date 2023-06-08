package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que realice la suma de los N elementos consecutivos de un array t. Debe realizarse a traves de    *
 * una funcion que genere y devuelva un array con todos los resultados de las sumas realizadas.                        *
 ***********************************************************************************************************************/
public class Ejercicio07_SumaDeNValores {
    /*******************************************************************************************************************
     * Funcion encargada generar un array con los resultados de la suma de los N elementos consecutivos                *
     * del array principal.                                                                                            *
     *                                                                                                                 *
     * @param intArrT -> Array donde se encuentran los numeros                                                         *
     * @param intNumElementos -> Elementos que se han de sumar en cada iteracion                                       *
     * @return intArrResultados -> Array con los resultados de las sumas de los N elementos consecutivos               *
     *******************************************************************************************************************/
    public static int[] suma(int[] intArrT, int intNumElementos){
        //DECLARACION DE VARIABLES
        int[] intArrResultados = new int[0]; //Array donde se guardaran los resultados de las sumas
        int intSuma; //Variable donde se guardara la suma de los N elementos consecutivos

        //BUCLE FOR PARA EL CALCULO DE LAS SUMAS Y EL RELLENADO DEL ARRAY DE RESULTADOS
        for(int intCont = 0; intCont != intArrT.length - (intNumElementos - 1); intCont++){ /* Bucle for que se repetira mientras el contador sea distinto a la diferencia entre
                                                                                               la longitud del array y el numero de elementos - 1. Es decir, hasta el inicio del
                                                                                               ultimo conjunto de N elementos consecutivos.
                                                                                               Durante cada iteracion del bucle lo que se hace es resetear el valor de la suma a 0 y,
                                                                                               a continuacion, se suma los N valores conscutivos decididos por el usuario, es decir,
                                                                                               el de inicio del bucle y los 2 siguientes numeros.
                                                                                               Al final de cada iteracion lo que se hace es generar una copia del array con 1 mas de
                                                                                               longitud y en el ultimo espacio (length - 1) se introduce el valor resultado de la
                                                                                               suma de los elementos. */
            intSuma = 0;
            for(int intCont2 = intCont, intCiclo = 0; intCiclo < intNumElementos; intCont2++, intCiclo++){
                intSuma += intArrT[intCont2];
            }
            intArrResultados = Arrays.copyOf(intArrResultados,intArrResultados.length + 1); //Copia del array con uno mas de longitud
            intArrResultados[intArrResultados.length - 1] = intSuma; //Introduccion del resultado de la suma en el ultimo indice del array
        }
        /***************************************************************************************************************
         * OTRA FORMA DE HACERLO (Más eficiente porque inicializa el array y no realiza copia):                        *
         *                                                                                                             *
         * int[] intArrResultados = new int[(intArrT.length - (intNumElementos - 1)];                                  *
         * int intSuma;                                                                                                *
         *                                                                                                             *
         * for(int intCont = 0; intCont < intArrResultados.length; intCont++){                                         *
         *     intSuma = 0;                                                                                            *
         *     for (int intCont2 = intCont, intCiclo = 0; intCiclo < intNumElementos; intCont2++, intCiclo++) {        *
         *          intSuma += intArrT[intCont2];                                                                      *
         *     }                                                                                                       *
         * intArrResultados[intCont] = intSuma;                                                                        *
         * }                                                                                                           *
         ***************************************************************************************************************/
        //RETURN
        return intArrResultados;
    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar el array con valores desde 1 hasta el maximo decidido por el usuario.             *
     *                                                                                                                 *
     * @param intArr -> Array donde se introduciran las posiciones                                                     *
     * @param intMax -> Valor maximo posible dentro del array                                                          *
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
        int[] intArrayNumero; //Array donde se guardaran los numeros
        int[] intArrResultados; //Array donde se guardaran las sumas
        int intLongitud; //Variable donde se guardara la longitud del array
        int intValorMaximo; //Variable donde se guardara el valor maximo del array
        int intElementos; //Variable donde se guardara el numero de elementos a sumar

        //SOLICITUD DE DATOS
        System.out.print("Introduzca longitud: ");
        intLongitud = scEntrada.nextInt();
        System.out.print("Introduzca valor maximo: ");
        intValorMaximo = scEntrada.nextInt();
        System.out.print("Introduzca numero de elementos consecutivos a sumar: ");
        intElementos = scEntrada.nextInt();
        scEntrada.close();

        intArrayNumero = new int[intLongitud]; //Inicializacion del array de numeros

        //LLAMADA A LA FUNCION rellenaArray(int[],int);
        rellenaArray(intArrayNumero,intValorMaximo);

        //IMPRESION DEL ARRAY GENERADO
        System.out.println("El array generado es: " + Arrays.toString(intArrayNumero));

        //LLAMADA A LA FUNCION suma(int[],int);
        intArrResultados = suma(intArrayNumero,intElementos);

        //IMPRESION DE RESULTADOS
        System.out.println("El resultado de la suma de los elementos consecutivos es: "
                + Arrays.toString(intArrResultados));
    }
    /*******************************************************************************************************************
     * Metodo Main. Contiene la funcion iniciadora del programa.                                                       *
     *******************************************************************************************************************/
    public static void main(String[] args) {
        inicio();
    }
}

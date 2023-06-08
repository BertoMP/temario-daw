package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que tenga una funcion int[] rellenaPares(int intLongitud, int intFin) que rellene y devuelva un   *
 * array lleno de numeros pares, desde 2 hasta intFin y que, además lo devuelva ordenado de forma creciente.           *
 ***********************************************************************************************************************/
public class Ejercicio05_FuncionRellenaPares {
    /*******************************************************************************************************************
     *                                                                                                                 *
     * Funcion creada para rellenar un array con numeros pares y, ademas, ordenarlo. Por ultimo el array sera devuelto *
     * al metodo Main para continuar con la ejecucion del programa.                                                    *
     *                                                                                                                 *
     * @param intLongitud --> Variable que guarda la dimension que va a tener el array. Lo elige el usuario            *
     *                    en el metodo Main.                                                                           *
     * @param intFin --> Variable que guarda el ultimo par que es posible obtener en la aleatorizacion. Lo elige       *
     *               el usuario en el metodo Main.                                                                     *
     * @return --> Se devuelve un array rellenado de pares y ordenado de forma creciente.                              *
     *                                                                                                                 *
     *******************************************************************************************************************/
    public static int[] rellenaPares(int intLongitud, int intFin){
        //DECLARACION DE VARIABLES
        int[] intArrPares = new int[intLongitud]; /* Declaracion e inicializacion de un array de dimension
                                                     Su dimension sera la longitud introducida por el
                                                     usuario en el metodo Main*/
        //BUCLE FOR PARA RELLENAR EL ARRAY
        for(int i = 0; i < intArrPares.length; i++){ /**ES LO MISMO QUE
                                                        int i = 0; i < intLongitud; i++ */
            int intNumeroAleatorio = (int) (Math.random() * intFin + 1); /* Variable en la que se creara un
                                                                            numero aleatorio */
            intArrPares[i] = (intNumeroAleatorio % 2 == 0) ? intNumeroAleatorio : intNumeroAleatorio + 1;
            /* Esta sentencia nos permite guardar en intArrPares solo los pares de la siguiente forma, si el
               numero creado en la aleatorizacion es par, se introducira en intArrPares; si el numero creado
               es impar se le sumara 1 para hacerlo par. */
            /** OTRAS OPCIONES EN LUGAR DE TERNARIO **/
            /** Condicional simple que verifique si el numero es impar, si lo es
             *  le sumara uno al numero.
             * if(intNumeroAleatorio % 2 != 0){
             *   ++intNumeroAleatorio;
             * }
             * intArrPares[i] = intNumeroAleatorio; */
            /** Condicional simple si el numero es par se asigna automaticamente,
             *  si es impar se le suma uno
             * if(intNumeroAleatorio % 2 == 0){
             *  intArrPares[i] = intNumeroAleatorio;
             * }else{
             *  intArrPares[i] = intNumeroAleatorio + 1;
             * }*/

        }
        /** OTRA OPCION EN LUGAR DE BUCLE FOR **/
        /** Bucle while
         * int intContador = 0; DECLARAMOS UN CONTADOR INICIADO A 0
         * while (intContador < intArrPares.length){ BUCLE WHILE
         *  int intNumeroAleatorio = (int) (Math.random() * intFin + 1); CREACION DE NUMEROS ALEATORIOS
         *  if(intNumeroAleatorio % 2 == 0){ CONDICIONAL SIMPLE PARA VALORAR SI ES PAR O NO
         *  intArrPares[intContador] = intNumeroAleatorio; SI EL NUMERO ES PAR SE INTRODUCE AL ARRAY
         *  intContador++; SI EL NUMERO ES PAR SE AUMENTA EN 1 EL CONTADOR
         *  }
         * }
         * ESTA OPCION ES MAS LENTA QUE LA ANTERIOR, EN LA ANTERIOR EN CADA ITERACION RELLENAREMOS UN NUEVO INDICE
         * EN EL ARRAY, EN ESTE CASO NO.
         */
        //IMPRIMIR ARRAY DESORDENADOR
        System.out.println("El array desordenado es: " + Arrays.toString(intArrPares));

        //ORDENAR EL ARRAY
        Arrays.sort(intArrPares);

        //DEVOLVER EL ARRAY
        return intArrPares;
    }
    public static void main(String[] args) {
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int intDimension; //Variable para guardar la dimension del array.
        int intUltimoPar; //Variable para guardar el ultimo par que querra el usuario.
        int[] intArrPares; //Array declarado para guardar el array que devolvera la funcion.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca cantidad de pares que quiere: ");
        intDimension = scEntrada.nextInt();

        do { //Bucle do/while (debe realizarse al menos una vez) por si el usuario no introduce un par.
            System.out.print("Introduzca ultimo par: ");
            intUltimoPar = scEntrada.nextInt();
        }while (intUltimoPar % 2 != 0);

        intArrPares = rellenaPares(intDimension, intUltimoPar); /* Llamada a la funcion rellenaPares el resultado se
                                                                   guardara dentro de intArrPares por lo que el
                                                                   array declarado en este Main se iniciara cuando
                                                                   la funcion termine su ejecucion y devuelva
                                                                   el array.
                                                                   Este array va a apuntar a las mismas direcciones
                                                                   de memoria (referencias) que el array que se
                                                                   creara dentro de la funcion. */

        //IMPRESION DEL ARRAY
        System.out.println("El array ordenado es el siguiente: " + Arrays.toString(intArrPares));
    }
}
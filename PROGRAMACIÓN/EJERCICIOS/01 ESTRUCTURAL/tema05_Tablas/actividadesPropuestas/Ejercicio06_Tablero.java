package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un juego de rol en el que a partir de una posicion [X] y una posicion [Y] se informe al usuario de si es      *
 * posible viajar entre ambos puntos o no.                                                                             *
 ***********************************************************************************************************************/
public class Ejercicio06_Tablero {
    /*******************************************************************************************************************
     * Funcion encargada de buscar en un array un numero y, en caso de no encontrarlo, introducirlo de forma           *
     * ordenada.                                                                                                       *
     *                                                                                                                 *
     * @param intArr -> Array de numeros                                                                               *
     * @param intNum -> Numero que podra entrar o no en el array                                                       *
     * @return intArr -> El array que podra tener o no el numero introducido                                           *
     *******************************************************************************************************************/
    public static int[] busquedaArray (int[] intArr, int intNum) {
        //DECLARACION DE VARIABLES
        int intIndiceBusqueda;//Variable que servira para guardar el indice de busqueda
        int[] intArrayAux;//Variable para guardar el array auxiliar para las copias

        //BUSQUEDA BINARIA
        intIndiceBusqueda = Arrays.binarySearch(intArr, intNum);

        //CONDICIONAL (si el numero ya existe en el array, no se introducira)
        if (intIndiceBusqueda < 0) { /* Lo que se hara es convertir el indice de busqueda en la posicion donde se debe insertar
                                        el valor. Tras esto se hara una copia del array dado por parametro desde la posicion 0
                                        hasta la posicion del indice de busqueda en el array auxiliar. A continuacion una copia
                                        desde el indice de busqueda hasta el indice de busqueda + 1.
                                        Por ultimo se sobreescribira el valor del indice de busqueda con el nuevo numero y se
                                        cambiara la referencia del array del parametro. */
            intIndiceBusqueda = -intIndiceBusqueda - 1;
            intArrayAux = new int[intArr.length + 1];

            System.arraycopy(intArr, 0, intArrayAux, 0, intIndiceBusqueda);
            System.arraycopy(intArr, intIndiceBusqueda, intArrayAux,
                    intIndiceBusqueda + 1, intArr.length - intIndiceBusqueda);
            intArrayAux[intIndiceBusqueda] = intNum;
            intArr = intArrayAux;
        }
        //RETURN DEL ARRAY
        return intArr;
    }
    /*******************************************************************************************************************
     * Funcion encargada de valorar si es posible o no viajar de una posicion a otra.                                  *
     * @param chrMatriz -> Matriz con todas las posiciones y sus valores T y F.                                        *
     * @param intInicio -> Posicion de inicio (fila)                                                                   *
     * @param intFin -> Posicion de fin (columna)                                                                      *
     * @return Booleano true/false en funcion de si el movimiento es posible o no                                      *
     *******************************************************************************************************************/
    public static boolean compruebaPosicion (char[][] chrMatriz, int intInicio, int intFin) {
        //DECLARACION DE VARIABLES
        int[] intArrPosicionesPosibles = new int[0]; /*Variable array que guardara las diferentes posiciones finales posibles (columnas) de cada
                                                       posicion de inicio.*/

        //CONDICIONAL EN CASO DE QUE LA POSICION DE INICIO Y DE FIN SEA POSIBLE DE PARTIDA
        if (chrMatriz[intInicio][intFin] == 'T') {
            //RETURN
            return true;
        }

        //BUCLE FOR PARA VALORAR LOS DESTINOS POSIBLES DE LA FILA DE INICIO
        for (int intContColumna = 0; intContColumna < chrMatriz[0].length; intContColumna++) {
            if (chrMatriz[intInicio][intContColumna] == 'T') { /* En caso de que una fila contenga una columna con valor T, se
                                                                  llamara a la funcion busquedaArray(int[],int) para valorar
                                                                  si se introduce o no en el array. */
                //LLAMADA A LA FUNCION busquedaArray(int[],int);
                intArrPosicionesPosibles = busquedaArray (intArrPosicionesPosibles, intContColumna);
            }
        }

        //BUCLE FOR PARA VALORAR EL RESTO DE FILAS
        for (int intContFila = 0; intContFila < intArrPosicionesPosibles.length; intContFila++) {
            for (int intContColumna = 0; intContColumna < chrMatriz[0].length; intContColumna++) {
                if (chrMatriz[intContFila][intFin] == 'T') {
                    //RETURN
                    return true;
                } else {
                    intArrPosicionesPosibles = busquedaArray(intArrPosicionesPosibles,intContColumna);
                }
            }
        }
        //RETURN
        return false;
    }
    /*******************************************************************************************************************
     * Funcion encargada de la solicitud de datos al usuario.                                                          *
     * @param chrMatriz -> Matriz del ejercicio                                                                        *
     * @param scEntrada -> Objeto scanner para la aentrada de datos por consola                                        *
     *******************************************************************************************************************/
    public static boolean solicitaDatos(char[][] chrMatriz, Scanner scEntrada) {
        int intPosicionInicio;
        int intPosicionFin;

        System.out.println("ELECCION DE POSICIONES");
        System.out.println("\tPosicion de inicio (FILA):");
        System.out.print("\t\tFila: ");
        intPosicionInicio = scEntrada.nextInt();
        System.out.println("\tPosicion de fin (COLUMNA):");
        System.out.print("\t\tColumna: ");
        intPosicionFin = scEntrada.nextInt();
        scEntrada.close();

        return compruebaPosicion(chrMatriz, intPosicionInicio, intPosicionFin);
    }
    /*******************************************************************************************************************
     * Funcion encargada de imprimir una matriz.                                                                       *
     *                                                                                                                 *
     * @param chrMatriz -> Matriz desde la que se imprimirán las posiciones del tablero.                               *
     *******************************************************************************************************************/
    public static void imprimeMatriz(char[][] chrMatriz){
        //DOBLE BUCLE FOR EACH PARA IMPRIMIR LA MATRIZ
        System.out.print("\t");
        for (int intCont = 0; intCont < chrMatriz.length; intCont++) {
            System.out.print(" " + intCont + "  ");
        }
        System.out.println();
        for (int intContFila = 0; intContFila < chrMatriz.length; intContFila++) {
            for (int intContColumna = 0; intContColumna < chrMatriz[0].length; intContColumna++) {
                if (intContColumna == 0) {
                    System.out.print(" " + (intContFila) + " |");
                }
                System.out.print(" " + chrMatriz[intContFila][intContColumna] + " |");
            }
            System.out.println();
        }

    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar una matriz.                                                                       *
     *                                                                                                                 *
     * @param chrMatriz -> Matriz donde se introduciran las posiciones                                                 *
     *******************************************************************************************************************/
    public static void rellenaMatriz(char[][] chrMatriz){
        //DECLARACION DE VARIABLES
        double rlnNumAleatorio;

        //BUCLE FOR PARA RELLENAR LA MATRIZ
        for (int intContFila = 0; intContFila < chrMatriz.length; intContFila++){
            for(int intContColumna = 0; intContColumna < chrMatriz[0].length; intContColumna++){
                rlnNumAleatorio = Math.random();
                if (rlnNumAleatorio < 0.5) {
                    chrMatriz[intContFila][intContColumna] = 'T';
                } else {
                    chrMatriz[intContFila][intContColumna] = 'F';
                }

            }
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        char[][] chrMatriz; //Matriz que se utilizara para guardar los valores del tablero
        int intFilas; //Variable para guardar el numero de filas del tablero

        //SOLICITUD DE DATOS (DATOS DEL TABLERO)
        System.out.print("""
                            CREACION DEL TABLERO
                            Defina filas y columnas del tablero:""");
        System.out.print(" ");
        intFilas = scEntrada.nextInt();

        chrMatriz = new char[intFilas][intFilas]; //Inicializacion de la matriz

        //LLAMADA A LA FUNCION rellenaMatriz(int[][]);
        rellenaMatriz(chrMatriz);

        //LLAMADA A LA FUNCION imprimeMatriz(int[][]);
        System.out.println();
        System.out.println("TABLERO DE JUEGO");
        imprimeMatriz(chrMatriz);

        //SOLICITUD DE DATOS (DATOS DE POSICIONES)
        System.out.println();
        System.out.println(solicitaDatos(chrMatriz,scEntrada) ? "Movimiento posible" : "Movimiento imposible");
    }
    /*******************************************************************************************************************
     * Metodo Main. Contiene la funcion iniciadora del programa.                                                       *
     *******************************************************************************************************************/
    public static void main(String[] args) {
        inicio();
    }
}

package tema05_Tablas.actividadesPropuestas;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa genere una matriz de 4x4. El usuario debe rellenarla. A continuacion comprobar si la matriz       *
 * es un cuadrado magico, es decir, si todas las filas y columnas suman el mismo valor.                                *
 ***********************************************************************************************************************/
public class Ejercicio08_CuadradoMagico {
    /*******************************************************************************************************************
     * Funcion encargada de comprobar si el cuadrado introducido por el usuario se trata o no de un cuadrado magico.   *
     *                                                                                                                 *
     * @param intMatriz -> Matriz con los valores del cuadrado.                                                        *
     * @return Booleano true/false en funcion de si es un cuadrado magico (true) o no (false).                         *
     *******************************************************************************************************************/
    public static boolean cuadradoMagico(int[][] intMatriz){
        //DECLARACION DE VARIABLES
        int intSumaFila0 = 0; //Variable que guardara la suma de los valores de la primera fila y servira como comparador para el resto
        int intSumaRestoFilas; //Variable donde se guardara la suma de cada fila
        int intSumaRestoColumnas;

        //BUCLE FOR PARA GUARDAR EL VALOR DE LA SUMA DE LA PRIMERA FILA
        for (int intContColumna = 0; intContColumna < intMatriz.length; intContColumna++) {
            intSumaFila0 += intMatriz[0][intContColumna];
        }

        //DOBLE BUCLE FOR PARA RECORRER EL ARRAY Y CONSEGUIR LA SUMA DE LAS FILAS
        for(int intContFila = 0; intContFila < intMatriz.length; intContFila++){ /* Bucle for doble para recorrer la matriz y conseguir la suma de las filas.
                                                                                    Lo primero que se hara es reiniciar la variable que guarda la suma.
                                                                                    A continuacion, y ya dentro de cada fila lo que se hara es recorrer el valor
                                                                                    de cada uno de los indices de la fila a la vez que se suma.
                                                                                    Una vez completada la suma, se compara con la suma de la primera fila, si es
                                                                                    igual se pasa a la siguiente fila (iteracion), si no lo es se devuelve
                                                                                    un false ya que no puede ser un cuadrado magico.
                                                                                    Si se completan todas las filas se pasa al siguiente punto de la funcion
                                                                                    para comprobar las columnas. */
            intSumaRestoFilas = 0;
            intSumaRestoColumnas = 0;
            for (int intContColumna = 0; intContColumna < intMatriz[0].length; intContColumna++){
                intSumaRestoFilas += intMatriz[intContFila][intContColumna];
                intSumaRestoColumnas += intMatriz[intContColumna][intContFila];
            }
            if(intSumaRestoFilas != intSumaFila0 || intSumaRestoColumnas != intSumaFila0){
                //RETURN
                return false;
            }
        }

        //RETURN
        return true;
    }
    /*******************************************************************************************************************
     * Funcion encargada de imprimir una matriz.                                                                       *
     *                                                                                                                 *
     * @param intMatriz -> Matriz desde la que se imprimirán los numeros introducidos en la matriz.                    *
     *******************************************************************************************************************/
    public static void imprimeMatriz(int[][] intMatriz){
        System.out.println("Este es el cuadrado que ha introducido: ");
        System.out.println();
        for (int[] intArray : intMatriz) {
            System.out.print("\t\t");
            for (int intValor : intArray) {
                if (intValor < 10) {
                    System.out.print("0");
                }
                System.out.print(intValor + " ");
            }
            System.out.println();
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar una matriz a traves de valores introducidos por el usuario.                       *
     *                                                                                                                 *
     * @param intMatriz -> Matriz donde se introduciran los valores del cuadrado.                                      *
     *******************************************************************************************************************/
    public static void rellenaMatriz(int[][] intMatriz){
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);

        //DOBLE BUCLE FOR PARA RELLENAR LA MATRIZ
        for (int intContFila = 0; intContFila < intMatriz.length; intContFila++){
            System.out.println("FILA " + (intContFila + 1));
            for(int intContColumna = 0; intContColumna < intMatriz[0].length; intContColumna++){
                System.out.print("Introduzca valor: ");
                intMatriz[intContFila][intContColumna] = scEntrada.nextInt();
            }
            System.out.println();
        }
        scEntrada.close();
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        int[][] intMatrizCuadrado = new int[4][4];

        //LLAMADA A LA FUNCION rellenaMatriz(int[][]);
        rellenaMatriz(intMatrizCuadrado);

        //LLAMADA A LA FUNCION imprimeMatriz(int[][]);
        imprimeMatriz(intMatrizCuadrado);

        //IMPRESION DEL RESULTADO A TRAVES DE LA LLAMADA A LA FUNCION cuadradoMagico(int[][]);
        System.out.println(cuadradoMagico(intMatrizCuadrado) ? "\nEs un cuadrado magico."
                                                             : "\nNo es un cuadrado magico.");
    }
    /*******************************************************************************************************************
     * Metodo Main. Contiene la funcion iniciadora del programa.                                                       *
     *******************************************************************************************************************/
    public static void main(String[] args) {
        inicio();
    }
}

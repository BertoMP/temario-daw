package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
/***********************************************************************************************************************
 * Crear un array bidemensional de 5x5 (int[n][m]). En cada indice se vera el resultado de 10 * n + m.                 *
 ***********************************************************************************************************************/
public class Ejercicio12_TablaBidimensional {
    /*******************************************************************************************************************
     * Funcion encargada de la impresion de la tabla tanto por metodo deepToString como por bucle for                  *
     *                                                                                                                 *
     * @param intMatriz --> Variable array bidimensional con valores.                                                  *
     *******************************************************************************************************************/
    public static void imprimeMatriz(int[][] intMatriz){
        //IMPRESION DE RESULTADOS
        System.out.println("El array resultante es: " + Arrays.deepToString(intMatriz));
        System.out.println("\nEn forma de tabla se veria asi: ");
        System.out.println();

        //BUCLE FOR-EACH PARA LA IMPRESION EN FORMA DE TABLA
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
     * Funcion encargada de rellenar un array bidemensional que se le pasa por parametro.                              *
     *                                                                                                                 *
     * @param intMatriz --> Array bidimensional (vacio).                                                               *
     *******************************************************************************************************************/
    public static void rellenaMatriz(int[][] intMatriz){
        //BUCLE FOR PARA EL RELLENADO DE LA TABLA
        for (int intContFila = 0; intContFila < intMatriz.length; intContFila++) {
            for (int intContColumna = 0; intContColumna < intMatriz[0].length; intContColumna++) {
                intMatriz[intContFila][intContColumna] = 10 * intContFila + intContColumna;
            }
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        int[][] intMatriz = new int[5][5];//Variable array bidimensional de 5 x 5

        //LLAMADA A LA FUNCION rellenaMatriz(int[][]);
        rellenaMatriz(intMatriz);

        //LLAMADA A LA FUNCION imprimeMatriz(int[][]);
        imprimeMatriz(intMatriz);
    }
    public static void main(String[] args) {
        inicio();
    }
}

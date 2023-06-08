package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que guarde 5 valores de puntuaciones en un array. A continuación preguntar al usuario sobre       *
 * puntuaciones extra. El usuario indicará que no existe n puntuación extra introduciendo un -1 por consola.           *
 * Imprimir por consola un array ordenado con las puntuaciones.                                                        *
 ***********************************************************************************************************************/
public class Ejercicio09_PuntuacionesOrdenadas {
    /*******************************************************************************************************************
     * Funcion sobrecargada de rellenaArray. Se encargara de las puntuaciones de los participantes extra, las cuales   *
     * seran añadidas en el array de forma ordenada.                                                                   *
     *                                                                                                                 *
     * @param intArr --> Array ordenado con las puntuaciones de los participantes base.                                *
     * @return intArr --> Array ordenado con todas las puntuaciones de los participantes.                              *
     *******************************************************************************************************************/
    public static int[] rellenaArray(Scanner scEntrada, int[] intArr){
        //DECLARACION DE VARIABLES
        int intPuntuacion; //Variable donde el usuario guardara la puntuacion de cada participante extra
        int intIndiceInsercion; //Variable donde se guardara el indice donde se debe insertar la nueva puntuacion

        //SOLICITUD DE DATOS AL USUARIO
        System.out.print("Introduzca la puntuacion del participante extra 1 (si no hay participante escriba -1): ");
        intPuntuacion = scEntrada.nextInt();

        //BUCLE FOR PARA RELLENAR PUNTUACIONES EXTRA
        for (int intCont = 2; intPuntuacion != -1; intCont++){ //Se mantendra hasta que el usuario introduzca un -1
            intIndiceInsercion = Arrays.binarySearch(intArr, intPuntuacion); /* Calculamos el indice de insercion, si devuelve un 0 o positivo nos informara de que el numero ya
                                                                              * existe dentro del array y ese numero sera el indice que ocupa. Si nos devuelve un negativo sera el
                                                                              * indice del numero siguiente que existe en el array pero en forma negativa. */
            if(intIndiceInsercion < 0) {
                intIndiceInsercion = -intIndiceInsercion - 1; /* Si el indice es negativo lo convertimos en positivo
                                                               * y le restamos 1 para sacar el indice real */
            }
            intArr = Arrays.copyOf(intArr, intArr.length + 1); /* Hacemos una copia del array con una longitud + 1. */

            //BUCLE FOR PARA LA COPIA DE VALORES
            for (int intIndice = intArr.length - 1; intIndice > intIndiceInsercion; intIndice--){
                intArr[intIndice] = intArr[intIndice - 1]; /* Se recorre el array desde el final copiando en cada indice el valor del indice anterior.
                                                            * Este proceso se repite hasta llegar al intIndiceInsercion. */
            }

            intArr[intIndiceInsercion] = intPuntuacion; // Sobreescribimos el valor de intIndiceInsercion con el valor que nos ha dado el usuario

            //SIGUIENTE SOLICITUD DE DATOS
            System.out.print("Introduzca la puntuacion del participante extra "
                    + intCont + " (si no hay participante escriba -1): ");
            intPuntuacion = scEntrada.nextInt();
        }

        //RETURN
        return intArr;
    }
    /*******************************************************************************************************************
     * Funcion encargada de crear un array donde se introduciran las puntuaciones de los 5 participantes base.         *
     *                                                                                                                 *
     * @return intArr --> Array con las puntuaciones base.                                                             *
     *******************************************************************************************************************/
    public static int[] rellenaArray(Scanner scEntrada){
        //DECLARACION DE VARIABLES
        int[] intArr = new int[5]; //Declaracion e inicializacion de un array de 5 indices

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for(int intCont = 0; intCont < intArr.length; intCont++){
            System.out.print("Introduzca la puntuacion del participante base " + (intCont + 1) + ": ");
            intArr[intCont] = scEntrada.nextInt();
        }

        //ORDENACION DEL ARRAY
        Arrays.sort(intArr);

        //RETURN
        return intArr;
    }
    /*******************************************************************************************************************
     * Función encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrPuntuaciones; //Declaracion de variable tipo array int donde se guardaran las puntuaciones

        //LLAMADA A LA FUNCION rellenaArray(Scanner)
        System.out.println("\nPUNTUACIONES BASE");
        intArrPuntuaciones = rellenaArray(scEntrada);

        //IMPRESION DE PUNTUACIONES BASE
        System.out.println("Las puntuaciones ordenadas son " + Arrays.toString(intArrPuntuaciones));

        //LLAMADA A LA FUNCION rellenaArray(Scanner, int[])
        System.out.println("\nPUNTUACIONES EXHIBICION");
        intArrPuntuaciones = rellenaArray(scEntrada, intArrPuntuaciones);

        scEntrada.close();

        //IMPRESION FINAL
        System.out.println("\nRESULTADO FINAL:" +
                           "\nLas puntuaciones ordenadas con los extra son " + Arrays.toString(intArrPuntuaciones));
    }
    public static void main(String[] args) {
        inicio();
    }
}

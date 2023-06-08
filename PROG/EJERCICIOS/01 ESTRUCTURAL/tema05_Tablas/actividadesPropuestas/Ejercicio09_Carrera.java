package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa para una competicion deportiva (carrera) que haga lo siguiente:                                   *
 *      1. Genere un array con todos los dorsales de los participantes en orden de llegada a meta.                     *
 *      2. Reordene el array de forma que los corredores menores ganen una posicion.                                   *
 *      3. Elimine de la competicion a los participantes que no han pasado el control antidoping.                      *
 *      4. Relegue a las ultimas posiciones a los participantes que no han pagado la cuota de inscripcion.             *
 *      5. Imprima por pantalla las posiciones 1, 2 y 3 de la carrera.                                                 *
 ***********************************************************************************************************************/

public class Ejercicio09_Carrera {
    /*******************************************************************************************************************
     * Funcion encargada de buscar y devolver un indice de un array. Si el indice no existe, devuelve -1.              *
     *                                                                                                                 *
     * @param intArray -> Array con los dorsales.                                                                      *
     * @param intNum -> Dorsal a buscar en el array.                                                                   *
     *******************************************************************************************************************/
    public static int busquedaArray(int[] intArray, int intNum){
        //DECLARACION DE VARIABLES
        int intIndice = -1;

        //FOR PARA RECORRER EL ARRAY Y BUSCAR EL DORSAL
        for(int intCont = 0; intCont < intArray.length; intCont++){
            if(intArray[intCont] == intNum){
                intIndice = intCont;
                //RETURN SI SE ENCUENTRA EL DORSAL
                return intIndice;
            }
        }
        //RETURN SI NO SE ENCUENTRA EL DORSAL
        return intIndice;
    }
    /*******************************************************************************************************************
     * Funcion encargada de informar de los corredores que han quedado en las tres primeras posiciones.                *
     *                                                                                                                 *
     * @param intArray -> Array con los dorsales.                                                                      *
     *******************************************************************************************************************/
    public static void corredoresPrimerasPosiciones(int[] intArray){
        //IMPRESION DE RESULTADOS FINALES
        System.out.println("\n\t\tPRIMERAS POSICIONES" +
                           "\nORO -> Dorsal " + intArray[0] +
                           "\nPLATA -> Dorsal " + intArray[1] +
                           "\nBONCE -> Dorsal " + intArray[2]);
    }
    /*******************************************************************************************************************
     * Funcion encargada de reordenar un array con los dorsales a traves de valores introducidos por el usuario.       *
     *                                                                                                                 *
     * @param scEntrada -> Objeto Scanner para la introduccion de datos por consola.                                   *
     * @param intArray -> Array con los dorsales.                                                                      *
     *******************************************************************************************************************/
    public static void corredoresSinInscripcion(Scanner scEntrada, int[] intArray){
        //DECLARACION DE VARIABLES
        int intDorsal; //Variable para guardar el dorsal del corredor
        int intIndiceCambio; //Variable para guardar el indice del array del corredor a relegar a las ultimas posiciones
        int intAuxiliar; //Variable para guardar el valor del corredor anterior al del corredor menor

        //SOLICITUD DE DATOS
        System.out.print("Introduzca dorsal del corredor que no ha pagado la inscripcion (-1 para finalizar): ");
        intDorsal = scEntrada.nextInt();

        //BUCLE WHILE PARA LA COPIA Y REORDENACION DEL ARRAY
        while (intDorsal != -1){ /* En este caso se utiliza un bucle while al no haber necesidad de contar con un contador, lo que hara este bucle es
                                   relegar a las últimas posiciones a los corredores con el dorsal introducido por el usuario para ello se llamara a una funcion encargada
                                   de la busqueda de indices del array, si el indice es negativo significara que el dorsal
                                   no existe en el array, si es positivo se guardara el dorsal de ese indice en una variable auxiliar y a continuacion
                                   se hara una copia del array desde la posicion siguiente al indice hasta el final y, por ultimo, se introducira
                                   el valor guardado en el auxiliar en la ultima posicion del array. */
            //LLAMADA A LA FUNCION busquedaArray(int[],int);
            intIndiceCambio = busquedaArray(intArray, intDorsal);
            if (intIndiceCambio != -1) {
                intAuxiliar = intArray[intIndiceCambio];
                System.arraycopy(intArray, intIndiceCambio + 1,intArray, intIndiceCambio,
                        intArray.length - intIndiceCambio - 1);
                intArray[intArray.length - 1] = intAuxiliar;
            } else {
                System.out.println("El dorsal " + intDorsal + " no existe.");
            }

            System.out.print("Introduzca dorsal del corredor que no supera el control antidopaje (-1 para finalizar): ");
            intDorsal = scEntrada.nextInt();
        }
        scEntrada.close();

        //IMPRESION DE RESULTADOS Y DEL ARRAY FINAL
        System.out.println("ARRAY TRAS SIN INSCRIPCIONES: " + Arrays.toString(intArray));
        System.out.println();
    }
    /*******************************************************************************************************************
     * Funcion encargada de eliminar corredores del array en funcion de los corredores que no pasan el control.        *
     *                                                                                                                 *
     * @param scEntrada -> Objeto Scanner para la introduccion de datos por consola.                                   *
     * @param intArray -> Array donde se introduciran los dorsales.                                                    *
     *******************************************************************************************************************/
    public static int[] corredoresDoping(Scanner scEntrada, int[] intArray){
        //DECLARACION DE VARIABLES
        int intDorsal; //Variable para guardar el dorsal del corredor
        int intIndiceBorrado; //Variable para guardar el indice del array del corredor a eliminar

        //SOLICITUD DE DATOS
        System.out.print("Introduzca dorsal del corredor que no supera el control antidopaje (-1 para finalizar): ");
        intDorsal = scEntrada.nextInt();

        //BUCLE WHILE PARA LA COPIA, ELIMINACION Y REDUCCION DEL ARRAY
        while(intDorsal != -1){ /* En este caso se utiliza un bucle while al no haber necesidad de contar con un contador, lo que hara este bucle es
                                   eliminar del array a los corredores con el dorsal introducido por el usuario para ello se llamara a una funcion encargada
                                   de la busqueda de indices del array, si el indice es negativo significara que el dorsal
                                   no existe en el array, si es positivo lo que se hará es copiar el array desde la posicion siguiente al indice de borrado
                                   desde el indice de borrado hasta el final y se reducirán en uno la longitud del array. */
            //LLAMADA A LA FUNCION busquedaArray(int[],int);
            intIndiceBorrado = busquedaArray(intArray, intDorsal);
            if (intIndiceBorrado != -1) {
                System.arraycopy(intArray,intIndiceBorrado + 1,intArray, intIndiceBorrado,
                        intArray.length - intIndiceBorrado - 1);
                intArray = Arrays.copyOf(intArray,intArray.length - 1);
            } else {
                System.out.println("El dorsal " + intDorsal + " no existe.");
            }

            System.out.print("Introduzca dorsal del corredor que no supera el control antidopaje (-1 para finalizar): ");
            intDorsal = scEntrada.nextInt();
        }

        //IMPRESION DE RESULTADOS FINALES
        System.out.println("ARRAY TRAS DOPING: " + Arrays.toString(intArray));
        System.out.println();

        //RETURN
        return intArray;
    }
    /*******************************************************************************************************************
     * Funcion encargada de ordenar el array en funcion de los menores introducidos.                                   *
     *                                                                                                                 *
     * @param scEntrada -> Objeto Scanner para la introduccion de datos por consola.                                   *
     * @param intArray -> Array que se reordenara.                                                                     *
     *******************************************************************************************************************/
    public static void corredoresMenores(Scanner scEntrada, int[] intArray){
        //DECLARACION DE VARIABLES
        int intDorsal; //Variable para guardar el array del corredor menor
        int intIndiceBusqueda; //Variable para guardar el indice del array del dorsal del corredor menor
        int intAuxiliar; //Variable para guardar el valor del corredor anterior al del corredor menor

        //SOLICITUD DE DATOS
        System.out.print("Introduzca dorsal del corredor menor (-1 para finalizar): ");
        intDorsal = scEntrada.nextInt();

        //BUCLE WHILE PARA BUSCAR Y REORDENAR CORREDORES
        while(intDorsal != -1){ /* En este caso se utiliza un bucle while al no haber necesidad de contar con un contador, lo que hara este bucle es
                                   cambiar de posicion (a una mas adelante) a los corredores con el dorsal introducido por el usuario para ello se
                                   llamara a una funcion encargada de la busqueda de indices del array, si el indice es negativo significara que el dorsal
                                   no existe en el array, si es positivo lo que se hará es guardar el dorsal del indice anterior (intIndiceBusqueda - 1)
                                   en una variable auxiliar, se copiara el dorsal del menor de edad en ese espacio y, por ultimo, se volvera a introducir el valor
                                   guardado en el auxiliar. */
            //LLAMADA A LA FUNCION busquedaArray(int[],int);
            intIndiceBusqueda = busquedaArray(intArray, intDorsal);
            if (intIndiceBusqueda != -1) {
                intAuxiliar = intArray[intIndiceBusqueda - 1];
                intArray[intIndiceBusqueda - 1] = intArray[intIndiceBusqueda];
                intArray[intIndiceBusqueda] = intAuxiliar;
            } else {
                System.out.println("El dorsal " + intDorsal + " no existe.");
            }

            System.out.print("Introduzca dorsal del corredor menor (-1 para finalizar): ");
            intDorsal = scEntrada.nextInt();
        }
        //IMPRESION DEL ARRAY TRAS LA REORDENACION
        System.out.println("ARRAY TRAS MENORES: " + Arrays.toString(intArray));
        System.out.println();
    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar un array con los dorsales a traves de valores introducidos por el usuario.        *
     *                                                                                                                 *
     * @param scEntrada -> Objeto Scanner para la introduccion de datos por consola.                                   *
     * @param intArray -> Array donde se introduciran los dorsales.                                                    *
     *******************************************************************************************************************/
    public static int[] rellenaArray(Scanner scEntrada, int[] intArray){
        //DECLARACION DE VARIABLES
        int intDorsal; //Variable para guardar el numero de dorsal

        //SOLICITUD DE DATOS
        System.out.print("Introduzca corredor que llega a meta en 1ª posicion (-1 para finalizar): ");
        intDorsal = scEntrada.nextInt();

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for(int intCont = 1; intDorsal != -1;){ /* Lo que se va a hacer en este bucle for es que mientras que el usuario que introduce los datos
                                                   no introduzca el dorsal -1 se creará una copia del array de dorsales y el último dorsal introducido
                                                   se guardará en la última posicion del array (length - 1)*/
            intArray = Arrays.copyOf(intArray, intArray.length + 1);
            intArray[intArray.length - 1] = intDorsal;

            System.out.print("Introduzca corredor que llega a meta en "
                    + (intCont + 1) + "ª posicion (-1 para finalizar): ");

            intDorsal = scEntrada.nextInt();
        }

        //IMPRESION DEL ARRAY
        System.out.println();
        System.out.println("ARRAY DE CORREDORES: " + Arrays.toString(intArray));
        System.out.println();

        //RETURN
        return intArray;
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrayCorredores = new int[0]; //Array donde se introduciran los dorsales de los participantes

        //LLAMADA A LA FUNCION rellenaArray(Scanner, int[]);
        intArrayCorredores = rellenaArray(scEntrada, intArrayCorredores);

        //LLAMADA A LA FUNCION corredoresMenores(Scanner, int[]);
        corredoresMenores(scEntrada, intArrayCorredores);

        //LLAMADA A LA FUNCION corredoresDoping(Scanner, int[]);
        intArrayCorredores = corredoresDoping(scEntrada, intArrayCorredores);

        //LLAMADA A LA FUNCION corredoresSinInscripcion(Scanner, int[]);
        corredoresSinInscripcion(scEntrada,intArrayCorredores);

        //LLAMADA A LA FUNCION corredoresPrimerasPosiciones(int[]);
        corredoresPrimerasPosiciones(intArrayCorredores);
    }
    /*******************************************************************************************************************
     * Metodo Main. Contiene la funcion iniciadora del programa.                                                       *
     *******************************************************************************************************************/
    public static void main(String[] args) {
        inicio();
    }
}

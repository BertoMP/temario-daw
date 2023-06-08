package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Juego de la Camara Secreta. El usuario decidira la dificultad del juego (1-5) en funcion de la cantidad de valores  *
 * que tendra una combinacion secreta y que el debera acertar. Los valores que podra tener cada indice van del 1 al 5. *
 * La aplicacion debe informar al usuario de si acierta valores o de si se ha quedado corto o se ha pasado del valor.  *
 ***********************************************************************************************************************/
public class Ejercicio11_CamaraSecreta {
    /*******************************************************************************************************************
     * Funcion encargada de comparar el valor de cada indice de cada array e informar al usuario de si ha acertado     *
     * o no el valor. En caso de no acertar le informara de si ha introducido un valor mayor o menor que la            *
     * combinacion secreta.                                                                                            *
     *                                                                                                                 *
     * @param intCombGana --> Array que contiene la combinacion ganadora                                               *
     * @param intCombUser --> Array que contiene la combinacion del usuario                                            *
     *******************************************************************************************************************/
    public static void comparaCombinaciones(int[] intCombGana, int[] intCombUser){
        //BUCLE FOR PARA COMPARAR CADA VALOR
        for (int intCont = 0; intCont < intCombUser.length; intCont++){/* Se va a comparar el valor introducido por el usuario en cada uno de sus indices con el valor de la
                                                                        *  combinacion ganadora de cada indice. En funcion de si acierta el valor, si se queda corto o si se
                                                                        *  pasa se le dara un mensaje de respuesta u otro. */
            System.out.print((intCont + 1) + "º valor de su combinacion: ");
            if(intCombGana[intCont] > intCombUser[intCont]){
                System.out.println(intCombUser[intCont] + " -> El numero de la combinacion secreta es mayor.");
            } else if (intCombGana[intCont] < intCombUser[intCont]) {
                System.out.println(intCombUser[intCont] + " -> El numero de la combinacion secreta es menor.");
                 } else {
                     System.out.println(intCombUser[intCont] + " -> Has acertado el numero.");
                 }
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar el array de la combinacion del usuario. Los datos se pediran por consola          *
     *                                                                                                                 *
     * @param intArr --> Array para la introduccion de datos de la combinacion del usuario                             *
     * @param scEntrada --> Objeto Scanner para la entrada de datos por consola.                                       *
     *******************************************************************************************************************/
    public static void combinacionUsuario(int[] intArr, Scanner scEntrada){
        //BUCLE FOR PARA RELLENAR EL ARRAY DE LA COMBINACION DEL USUARIO
        for(int intCont = 0; intCont < intArr.length; intCont++){
            System.out.print("Introduzca valor " + (intCont + 1) + " (debe estar entre 1 y 5): ");
            intArr[intCont] = scEntrada.nextInt();

            while (intArr[intCont] < 1 || intArr[intCont] > 5){
                System.out.println("Numero no valido");
                System.out.print("Introduzca valor " + (intCont + 1) + " (debe estar entre 1 y 5): ");
                intArr[intCont] = scEntrada.nextInt();
            }
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada de generar una combinacion secreta (un array de enteros de N indices).                        *
     *                                                                                                                 *
     * @param intArr --> Array de numeros enteros que guardara los N valores.                                          *
     *******************************************************************************************************************/
    public static void combinacionSecreta(int[] intArr){
        //BUCLE FOR PARA RELLENAR EL ARRAY DE LA COMBINACION SECRETA
        for(int intCont = 0; intCont < intArr.length; intCont++){
            intArr[intCont] = (int) (Math.random() * 5 + 1);
        }
    }
    /*******************************************************************************************************************
     * Funcion para el desarrollo de las instrucciones principales del programa.                                       *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intCombinacionSecreta;
        int[] intCombinacionUsuario;
        int intLongitud;
        int intIntentos = 1;

        //IMPRESION DE REGLAS
        System.out.println("\t\t.::JUEGO DE LA CAMARA SECRETA::.");
        System.out.println("""
                
                REGLAS
                1. Seleccione una longitud para la combinacion a acertar (1-5).
                2. Introduzca su combinacion.
                3. El programa le informara de si ha acertado o no el numero de la combinacion\s
                   (en caso de no acertar le informara de si es mayor o menor).
                4. Cuando acierte todos los numeros de la combinacion, el programa finalizara.""");

        //SOLICITUD DE DATOS
        System.out.print("""
                
                LONGITUD COMBINACION
                Elija longitud de la combinacion (1-5):\s""");
        intLongitud = scEntrada.nextInt();

        while (intLongitud < 1 || intLongitud > 5) {
            System.out.println("ERROR! Longitud no valida.");
            System.out.print("Elija longitud de la combinacion (1-5): ");
            intLongitud = scEntrada.nextInt();
        }

        //INICIACION DE ARRAYS
        intCombinacionSecreta = new int[intLongitud];
        intCombinacionUsuario = new int[intLongitud];

        //LLAMADA A LA FUNCION combinacionSecreta (int)
        combinacionSecreta(intCombinacionSecreta);

        System.out.println("\nINTENTO " + intIntentos);
        System.out.println("Introduzca combinacion: ");

        //LLAMADA A LA FUNCION combinacionUsuario (int, Scanner)
        combinacionUsuario(intCombinacionUsuario, scEntrada);

        //BUCLE WHILE PARA COMPROBAR SI AMBOS ARRAYS SON IGUALES
        while(!Arrays.equals(intCombinacionSecreta,intCombinacionUsuario)){ // Mientras ambos arrays tengan algun valor diferente, el bucle se repetira
            System.out.println("\nPISTAS:");

            //LLAMADA A LA FUNCION comparaCombinaciones (int[], int[])
            comparaCombinaciones(intCombinacionSecreta,intCombinacionUsuario);

            System.out.println("\nINTENTO " + ++intIntentos);
            System.out.println("Introduzca nueva combinacion: ");

            //LLAMADA A LA FUNCION combinacionUsuario(int[], Scanner)
            combinacionUsuario(intCombinacionUsuario,scEntrada);
        }
        scEntrada.close();

        //IMPRESION DE RESULTADOS FINALES
        System.out.println("\nHAS ACERTADO LA COMBINACION. Nº DE INTENTOS: " + intIntentos);
    }
    public static void main(String[] args) {
        inicio();
    }
}

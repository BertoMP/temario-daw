package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Diseñar un programa que incorpore una funcion que reciba dos combinaciones de primitiva: la primera sera la         *
 * combinacion del usuario (no ordenada), la segunda sera la combibacion ganadora (ordenada). La funcion debe buscar   *
 * los aciertos entre ambos combinaciones y anunciar al usuario el numero de aciertos que ha tenido.                   *
 ***********************************************************************************************************************/
public class Ejercicio06_Primitiva {
    /*******************************************************************************************************************
     * Funcion creada para buscar el numero de aciertos entre dos combinaciones de la primitiva, ambas combinaciones   *
     * son rellenadas en el metodo Main y se integran dentro de dos variables tipo array int que son pasadas como      *
     * parametros. La funcion envia como resultado el numero de aciertos que encuentre entre ambos arrays.             *
     *                                                                                                                 *
     * @param intGanadora -> Array que contiene los numeros de la combinacion ganadora. Este array se encuentra        *
     *                       ordenado.                                                                                 *
     * @param intUsuario -> Array que contiene los numeros de la combinacion del usuario. Este array se encuentra      *
     *                      desordenado.                                                                               *
     * @return -> Se devuelve un valor de dato int (intAciertos) que informa de la cantidad de aciertos que hay        *
     *            en la combinacion del usuario con respecto a la combinacion ganadora.                                *
     *******************************************************************************************************************/
    public static int aciertosPrimitiva(int[] intGanadora, int[] intUsuario){
        //DECLARACION DE VARIABLES
        int intAciertos = 0; //Variable que funcionara como contador dentro del bucle foreach

        //BUCLE FOR EACH
        for(int intValor : intUsuario){ /* Se utiliza un bucle for each para recorrer el array del usuario en su
                                           totalidad. En la variable intValor se guardara cada uno de los numeros
                                           que integran el array del usuario y se compararan con el array que
                                           contiene la combinacion ganadora */

            if(Arrays.binarySearch(intGanadora, intValor) >= 0){ /* Condicional simple que integra el metodo de
                                                                    de la clase Arrays .binarySearch que nos sirve para
                                                                    buscar un valor (intValor) dentro de un array
                                                                    ordenado.
                                                                    Si el dato es encontrado el metodo dara un numero
                                                                    como resultado (el indice en el que se encuentra)
                                                                    que siempre sera mayor o igual a 0, si no es
                                                                    encontrado el valor de respuesta sera negativo
                                                                    e informara de la posicion en la que deberia
                                                                    encontrarse. */
                intAciertos++; //Cada vez que se acierte un numero se incrementara en uno el contador
            }
        }
        //DEVOLUCION DE VALOR
        return intAciertos;
    }
    public static void main(String[] args) {
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrCombinacionGanadora = new int[6]; //Array que guardara los numeros de la combinacion ganadora
        int[] intArrCombinacionUsuario = new int[6]; //Array que guardara los numeros de la combinacion del usuario
        int intAciertos; //Variable que guardara el resultado de la funcion que buscara los aciertos
        String strRespuestaFinal;

        //SOLICITUD DE DATOS AL USUARIO
        System.out.println("Introduzca la combinacion ganadora: ");
        for(int i = 0; i < intArrCombinacionGanadora.length; i++){ //BUCLE FOR PARA COMBINACION GANADORA
            System.out.print((i + 1) + "º numero: ");
            intArrCombinacionGanadora[i] = scEntrada.nextInt();
        }
        System.out.println("Introduzca su combinacion: ");
        for(int i = 0; i < intArrCombinacionUsuario.length; i++){ //BUCLE FOR PARA COMBINACION DEL USUARIO
            System.out.print((i + 1) + "º numero: ");
            intArrCombinacionUsuario[i] = scEntrada.nextInt();
        }

        //IMPRESION Y ORDENACIONES
        Arrays.sort(intArrCombinacionGanadora); // Ordenamos el array de la combinacion ganadora
        System.out.println("COMBINACION GANADORA: " + Arrays.toString(intArrCombinacionGanadora));
        System.out.println("TU COMBINACION: " + Arrays.toString(intArrCombinacionUsuario));

        //LLAMADA A FUNCION
        intAciertos = aciertosPrimitiva(intArrCombinacionGanadora, intArrCombinacionUsuario);
        /* Se llama a la funcion aciertoPrimitiva y se le pasan como parametros de entrada los dos arrays que
        *  acabamos de crear. */

        //IMPRESION DEL RESULTADO
        strRespuestaFinal = (intAciertos != 0) ? "Tienes " + intAciertos + " aciertos en la combinacion."
                                               : "No has acertado ningun numero";
        System.out.println(strRespuestaFinal);
    }
}

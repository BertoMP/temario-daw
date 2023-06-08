package tema05_Tablas.actividadesResueltas;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que solicite N numeros enteros al usuario y los imprima en orden contrario de introduccion.       *
 ***********************************************************************************************************************/
public class Ejercicio03_ImpresionAlReves {
    public static void main(String[] args) {
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int intTamanyo; //Variable en la que guardaremos el tamaño (cantidad de numeros) del array.
        int[] intArrNumeros; //Declaramos el array de enteros

        //SOLICITUD DE DATOS
        System.out.print("Introduzca cantidad de numeros: "); //El usuario decide la dimension del array
        intTamanyo = scEntrada.nextInt();

        intArrNumeros = new int[intTamanyo]; //Iniciamos el array ya conociendo la dimension que va a tener

        System.out.println();
        //BUCLE FOR PARA INTRODUCIR LOS DATOS
        for(int i = 0; i < intArrNumeros.length; i++){ /**ES LO MISMO QUE
                                                            int i = 0; i < intTamanyo; i++ */
            System.out.print("Introduzca el " + (i+1) + "º numero de la serie: ");
            intArrNumeros[i] = scEntrada.nextInt();
        }

        scEntrada.close();

        //IMPRESION DEL ARRAY EN ORDEN INVERSO
        System.out.print("\nSe han introducido los numeros (orden inverso): ");
        for(int i = intArrNumeros.length - 1; i >=0; i--){ /**ES LO MISMO QUE
                                                                int i = intTamanyo - 1; i >=0; i-- */
                                                            /* Como vamos a imprimir el array en orden inverso debemos
                                                            *  de comenzar por el ultimo indice
                                                            *  intArrNumeros[intTamanyo - 1] y terminar en el
                                                            *  intArrNumeros[0] por ejemplo, si el usuario ha decidido
                                                            *  introducir 5 numeros, esta impresion empezara en el
                                                            *  intArrNumeros[4] ya que si empezara en el 5 empezaria
                                                            *  en un valor que no existe para el programa. Ademas el
                                                            *  contador debe ir hacia atras en lugar de hacia delante. */
            System.out.print(intArrNumeros[i] + " ");
        }
    }
}
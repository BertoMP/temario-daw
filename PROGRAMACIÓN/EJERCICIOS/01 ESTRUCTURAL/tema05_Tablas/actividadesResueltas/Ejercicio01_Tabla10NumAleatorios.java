package tema05_Tablas.actividadesResueltas;
import java.util.Arrays;
/********************************************************************************************************************
 * Crear un programa que guarde en una tabla 10 numeros aleatorios del 1 al 100 y realice la suma de todos ellos.   *
 ********************************************************************************************************************/
public class Ejercicio01_Tabla10NumAleatorios {
    public static void main(String[] args) {
        //DECLARACIÓN DE VARIABLES
        int intSumaNumeros = 0; //Inicializamos una variable suma a 0.
        int[] intArrNumeros = new int[10]; //Declaramos un array de numeros enteros y lo inicializamos con 10 indices

        //BUCLE FOR PARA RELLENAR LOS INDICES DEL ARRAY
        for(int i = 0;  i < intArrNumeros.length; i++){/**ES LO MISMO QUE
                                                            (int i = 0; i < 10; i++) */
            intArrNumeros[i] = (int) (Math.random() * 99 + 1); /* Como la funcion Math.random() va a devolver datos
                                                                  de tipo double debemos tipearla con (int) para guardar
                                                                  los numeros aleatorios en nuestro array. */
        }

        //IMPRESION DEL ARRAY
        //Convertimos el array en un string gracias a la funcion toString(nombreArray) de la clase Arrays.
        System.out.println("\nSe ha generado este array: " + Arrays.toString(intArrNumeros));

        //SUMA DE LOS NUMEROS
        for (int intValor : intArrNumeros) {
            intSumaNumeros += intValor;     /*Como vamos a recorrer el array entero se utiliza un for each, los numeros
                                              se guardaran en intValor y este se sumara a la variable intSumaNumeros*/
        }

        //IMPRESION DEL RESULTADO DE LA SUMA
        System.out.println("\nLa suma de los numeros es: " + intSumaNumeros);
    }
}

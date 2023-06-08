package tema05_Tablas.actividadesResueltas;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que solicite 5 numeros decimales al usuario y los imprima en orden de introduccion.               *
 ***********************************************************************************************************************/
public class Ejercicio02_NumerosDecimales {
    public static void main(String[] args) {
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        double[] rlnArrNumerosDecimales = new double[5]; /* Declaracion de un array de tipo double
                                                            (decimales), ademas se inicializa a 5 elementos */

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for(int i = 0; i < rlnArrNumerosDecimales.length; i++){/**ES LO MISMO QUE
                                                                    (int i = 0; i < 5; i++) */
            System.out.print("Introduzca el " + (i+1) + "º numero de la serie: ");
            rlnArrNumerosDecimales[i] = scEntrada.nextDouble();
        }

        scEntrada.close();

        //IMPRESION DE LOS NUMEROS INTRODUCIDOS
        System.out.print("\nSe han introducido los numeros: ");
        for (double rlnValor : rlnArrNumerosDecimales) {/*Se utiliza un bucle for each porque vamos a recorrer
                                                        el array completo. */
            System.out.print(rlnValor + " ");
        }
    }
}

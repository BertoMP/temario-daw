package tema05_Tablas.actividadesResueltas;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio07_SinRepetivosV2 {
    static int[] borraRepetidos(int[] intArray) {
        int[] intArrayAux = new int[0];
        boolean blnEncontrado;

        for (int intValor : intArray) {
            blnEncontrado = false;
            for (int intCont = 0; intCont < intArrayAux.length && !blnEncontrado; intCont++) {
                if (intArrayAux[intCont] == intValor) {
                    blnEncontrado = true;
                }
            }
            if (!blnEncontrado) {
                intArrayAux = Arrays.copyOf(intArrayAux, intArrayAux.length + 1);
                intArrayAux[intArrayAux.length - 1] = intValor;
            }
        }
        return intArrayAux;
    }
    static void rellenaArray(int[] intArray) {
        for (int intCont = 0; intCont < intArray.length; intCont++) {
            intArray[intCont] = (int) (Math.random() * 10 + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);
        int[] intArrayNumeros;
        int[] intArraySinRepetidos;
        int intLongitudArray;

        System.out.print("Defina la longitud del array: ");
        intLongitudArray = scEntrada.nextInt();
        scEntrada.close();
        intArrayNumeros = new int[intLongitudArray];

        rellenaArray(intArrayNumeros);
        intArraySinRepetidos = borraRepetidos(intArrayNumeros);
        System.out.println("El array original: " + Arrays.toString(intArrayNumeros));
        System.out.println("El array sin repetidos: " + Arrays.toString(intArraySinRepetidos));
    }
}

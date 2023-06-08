package tema04_Funciones.actividades;

import java.util.Scanner;

public class Ejercicio12_Fibonacci {
    public static int fibonacci(int intN){
        int intResultado;

        if(intN == 0 || intN == 1){
            intResultado = 1;
        }else{
            intResultado = fibonacci(intN - 1) + fibonacci(intN - 2);
        }

        return intResultado;
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intN;
        int intResultado;

        System.out.print("Introduzca N: ");
        intN = scEntrada.nextInt();

        scEntrada.close();

        intResultado = fibonacci(intN);

        System.out.println("Fibonacci(" + intN + "): " + intResultado);

    }
}

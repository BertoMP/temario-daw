package tema04_Funciones.actividades;

import java.util.Scanner;

public class Ejercicio19_NumerosAleatorios {
    public static void numerosAleatorios(int intCantidad, int intMinimo, int intMaximo){
        int intRango = (intMaximo - intMinimo) - 1;
        System.out.println("\nMostrando " + intCantidad + " numeros entre " + intMinimo + " y " + intMaximo + ":");
        for(int intCont = 1; intCont <= intCantidad; intCont++){
            int numAleatorio = (int) (Math.random() * intRango + (intMinimo + 1));
            System.out.println("Numero aleatorio " + intCont + ": " + numAleatorio);
        }
    }
    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intCantidadNumeros;
        int intNumeroMinimo;
        int intNumeroMaximo;


        System.out.print("Introduzca cantidad de numeros a mostrar: ");
        intCantidadNumeros = scEntrada.nextInt();

        System.out.print("Introduzca numero minimo: ");
        intNumeroMinimo = scEntrada.nextInt();

        System.out.print("Introduzca numero maximo: ");
        intNumeroMaximo = scEntrada.nextInt();

        scEntrada.close();

        numerosAleatorios(intCantidadNumeros, intNumeroMinimo, intNumeroMaximo);
    }
}

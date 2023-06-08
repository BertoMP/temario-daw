package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio15_Pares {
    public static void muestraPares(int intNPares){
        for(int i = 2; i <= (intNPares * 2); i += 2){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intNPares;

        System.out.print("Introduzca cantidad de pares a mostrar: ");
        intNPares = scEntrada.nextInt();

        scEntrada.close();

        muestraPares(intNPares);

    }
}

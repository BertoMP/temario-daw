package tema04_Funciones.actividades;

import java.util.Scanner;

public class Ejercicio18_NumerosAmigos {

    public static void numerosAmigos(int intNum1, int intNum2){
        int intSumaDivisoresNum1 = 0;
        int intSumaDivisoresNum2 = 0;

        for(int i = 1; i < intNum1; i++){
            if(intNum1 % i == 0){
                intSumaDivisoresNum1 += i;
            }
        }

        for(int i = 1; i < intNum2; i++){
            if(intNum2 % i == 0){
                intSumaDivisoresNum2 += i;
            }
        }

        System.out.println((intSumaDivisoresNum1 == intNum2 && intSumaDivisoresNum2 == intNum1)
                    ? "Los numeros son amigos." : "Los numeros no son amigos.");
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intNumUsuario1;
        int intNumUsuario2;

        System.out.print("Introduzca el primer numero: ");
        intNumUsuario1 = scEntrada.nextInt();

        System.out.print("Introduzca el segundo numero: ");
        intNumUsuario2 = scEntrada.nextInt();

        scEntrada.close();

        numerosAmigos(intNumUsuario1, intNumUsuario2);

    }
}

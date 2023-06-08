package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio17_DivisoresPrimos {

    public static boolean esPrimo(int intNum){
        boolean blnPrimo = true;

        for(int i = 2; i <= intNum / 2 && blnPrimo; i++){
            if(intNum % i == 0){
                blnPrimo = false;
            }
        }

        return blnPrimo;
    }

    public static void divisoresPrimos(int intNumUsuario){
        System.out.print("Los divisores primos de " + intNumUsuario + " son: ");
        for(int i = 2; i <= intNumUsuario; i++){
            if(intNumUsuario % i == 0 && esPrimo(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intNumUsuario;

        System.out.print("Introduzca un numero: ");
        intNumUsuario = scEntrada.nextInt();

        scEntrada.close();

        divisoresPrimos(intNumUsuario);
    }
}

package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio10_PotenciaRecursiva {
    public static double potencia(double rlnBase, int intExponente){
        double rlnResultado;

        if(intExponente == 0){
            rlnResultado = 1;
        }else{
            rlnResultado = rlnBase * potencia(rlnBase, intExponente - 1);
        }

        return rlnResultado;
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        double rlnBase;
        int intExponente;
        double rlnResultado;

        System.out.print("Introduzca la base: ");
        rlnBase = scEntrada.nextDouble();

        System.out.print("Introduzca el exponente: ");
        intExponente = scEntrada.nextInt();

        scEntrada.close();

        rlnResultado = potencia(rlnBase,intExponente);

        System.out.println(rlnBase + " elevado a " + intExponente + " es igual a " + rlnResultado);
    }
}

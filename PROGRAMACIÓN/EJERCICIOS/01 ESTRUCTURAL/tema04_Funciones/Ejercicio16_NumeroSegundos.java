package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio16_NumeroSegundos {
    public static int segundos(int intDias, int intHoras, int intMinutos){
        int intSegundos;
        final int INT_SEGUNDOS_MIN = 60;
        final int INT_SEGUNDOS_HORA = 3600;
        final int INT_SEGUNDOS_DIA = 86400;

        intSegundos = (intMinutos * INT_SEGUNDOS_MIN) + (intHoras * INT_SEGUNDOS_HORA) + (intDias * INT_SEGUNDOS_DIA);

        return intSegundos;
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intDias;
        int intHoras;
        int intMinutos;
        int intTotalSegundos;

        System.out.print("Introduzca numero de dias: ");
        intDias = scEntrada.nextInt();

        System.out.print("Introduzca numero de horas: ");
        intHoras = scEntrada.nextInt();

        System.out.print("Introduzca numero de minutos: ");
        intMinutos = scEntrada.nextInt();

        scEntrada.close();

        intTotalSegundos = segundos(intDias, intHoras, intMinutos);

        System.out.println("En " + intDias + " dias, " + intHoras + " horas y " + intMinutos
                         + " minutos hay un total de " + intTotalSegundos + " segundos.");
    }
}

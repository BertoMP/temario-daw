package tema04_Funciones.actividades;

import java.util.Scanner;

public class Ejercicio20_NumerosAleatoriosSobrecarga {
    public static void numerosAleatorios(int intCantidad, int intMinimo, int intMaximo){
        int intRango = (intMaximo - intMinimo) - 1;
        System.out.println("\nMostrando " + intCantidad + " numeros entre " + intMinimo + " y " + intMaximo + ":");
        for(int intCont = 1; intCont <= intCantidad; intCont++){
            int numAleatorio = (int) (Math.random() * intRango + (intMinimo + 1));
            System.out.println("Numero aleatorio " + intCont + ": " + numAleatorio);
        }
    }

    public static void numerosAleatorios(int intCantidad){
        System.out.println("\nMostrando " + intCantidad + " numeros entre 0 y 1:");
        for(int intCont = 1; intCont <= intCantidad; intCont++){
            double numAleatorio = Math.random();
            System.out.println("Numero aleatorio " + intCont + ": " + numAleatorio);
        }
    }
    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intCantidadNumeros;
        int intNumeroMinimo;
        int intNumeroMaximo;
        int intOpcionElegida;

        System.out.print("Elija una opcion"
                + "\n\t1: Numeros aleatorios enteros entre valor maximo y minimo."
                + "\n\t2: Numeros aleatorios reales entre 0 y 1."
                + "\n\tOpcion: ");
        intOpcionElegida = scEntrada.nextInt();

        switch (intOpcionElegida){
            case 1:
                System.out.print("Introduzca cantidad de numeros a mostrar: ");
                intCantidadNumeros = scEntrada.nextInt();

                System.out.print("Introduzca numero minimo: ");
                intNumeroMinimo = scEntrada.nextInt();

                System.out.print("Introduzca numero maximo: ");
                intNumeroMaximo = scEntrada.nextInt();

                scEntrada.close();

                numerosAleatorios(intCantidadNumeros, intNumeroMinimo, intNumeroMaximo);
                break;
            case 2:
                System.out.print("Introduzca cantidad de numeros a mostrar: ");
                intCantidadNumeros = scEntrada.nextInt();

                scEntrada.close();

                numerosAleatorios(intCantidadNumeros);
                break;
            default:
                System.out.println("La opcion elegida no es valida.");
        }


    }
}

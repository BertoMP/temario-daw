package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio14_DistanciaPuntos {
    public static double distancia(double rlnP1X, double rlnP1Y, double rlnP2X, double rlnP2Y){
        double rlnResultado;

        rlnResultado = Math.sqrt(Math.pow((rlnP1X - rlnP2X),2) + Math.pow((rlnP1Y - rlnP2Y),2));

        return rlnResultado;
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        double rlnPunto1X;
        double rlnPunto1Y;
        double rlnPunto2X;
        double rlnPunto2Y;
        double rlnDistanciaPuntos;

        System.out.print("Introduzca coordenada X del punto 1: ");
        rlnPunto1X = scEntrada.nextDouble();

        System.out.print("Introduzca coordenada Y del punto 1: ");
        rlnPunto1Y = scEntrada.nextDouble();

        System.out.print("Introduzca coordenada X del punto 2: ");
        rlnPunto2X = scEntrada.nextDouble();

        System.out.print("Introduzca coordenada Y del punto 2: ");
        rlnPunto2Y = scEntrada.nextDouble();

        scEntrada.close();

        rlnDistanciaPuntos = distancia(rlnPunto1X, rlnPunto1Y, rlnPunto2X, rlnPunto2Y);

        System.out.println("La distancia entre el punto 1 (" + rlnPunto1X + ", " + rlnPunto1Y + ") y el punto 2 ("
                         + rlnPunto2X + ", " + rlnPunto2Y + ") es: " + rlnDistanciaPuntos);
    }
}

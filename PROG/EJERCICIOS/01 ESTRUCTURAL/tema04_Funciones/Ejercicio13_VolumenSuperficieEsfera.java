package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio13_VolumenSuperficieEsfera {
    public static void superficieVolumenEsfera(double rlnRadio){
        double rlnSuperficie;
        double rlnVolumen;

        rlnSuperficie = 4 * Math.PI * Math.pow(rlnRadio, 2);
        rlnVolumen = (4 * Math.PI / 3) * Math.pow(rlnRadio, 3);

        System.out.println("La superficie y el volumen de una esfera de " + rlnRadio
                         + " de radio es: "
                         + "\n\t SUPERFICIE: " + rlnSuperficie
                         + "\n\t VOLUMEN: " + rlnVolumen);
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        double rlnRadio;

        System.out.print("Inserte el radio de la esfera: ");
        rlnRadio = scEntrada.nextDouble();

        scEntrada.close();

        superficieVolumenEsfera(rlnRadio);
    }

}

package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto14_TrianguloRectangulo.clases;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto14_TrianguloRectangulo.clases.poligono.Rectangulo;
import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto14_TrianguloRectangulo.clases.poligono.Triangulo;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Triangulo nuevoTriangulo; //Objeto de tipo Triangulo.
        Rectangulo nuevoRectangulo; //Objeto de tipo Rectangulo.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Variable que guardará la opción elegida por el usuario en el menú.
        double rlnBase; //Variable que guardará la base del polígono.
        double rlnAltura; //Variable que guardará la altura del polígono.

        do {
            System.out.print("Dime la base: ");
            rlnBase = scEntrada.nextDouble();

            System.out.print("Dime la altura: ");
            rlnAltura = scEntrada.nextDouble();

            System.out.println("""
                    Seleccione una opción:
                        1. Calcular el área de un triángulo.
                        2. Calcular el área de un rectángulo.
                        3. Salir.""");
            System.out.println("Opción: ");
            intOpcion = scEntrada.nextInt();

            switch (intOpcion) {
                case 1 -> {
                    nuevoTriangulo = new Triangulo(rlnBase, rlnAltura);
                    System.out.println("El área del triángulo es: " + nuevoTriangulo.area() + "cm2.");
                }
                case 2 -> {
                    nuevoRectangulo = new Rectangulo(rlnBase, rlnAltura);
                    System.out.println("El área del rectángulo es: " + nuevoRectangulo.area() + "cm2.");
                }
                case 3 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("La opción elegida no es válida.");
            }
        } while (intOpcion != 3);
        scEntrada.close();
    }
}

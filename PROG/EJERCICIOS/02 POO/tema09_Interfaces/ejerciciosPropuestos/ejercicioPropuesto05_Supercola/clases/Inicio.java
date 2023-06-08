package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto05_Supercola.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Supercola supercola = new Supercola(); //Objeto de tipo Supercola.

        //DECLARACIÓN DE VARIABLES
        int intOpcion;
        int intNum;

        do {
            System.out.println("""
                Elige una opcion:
                    1. Encolar en cola 1.
                    2. Encolar en cola 2.
                    3. Desencolar de cola 1.
                    4. Desencolar de cola 2.
                    5. Salir.""");
            System.out.print("Opción: ");
            intOpcion = scEntrada.nextInt();

            switch (intOpcion) {
                case 1, 2 -> {
                    System.out.print("Dime número a encolar: ");
                    intNum = scEntrada.nextInt();
                    supercola.push(intNum, intOpcion);
                }
                case 3, 4 -> System.out.println("Elemento desencolado: " + supercola.pop(intOpcion));
                case 5 -> System.out.println("Finalizando aplicación...");
                default -> System.out.println("Opción elegida no válida.");
            }
            if (intOpcion < 5) {
                System.out.println(supercola);
            }
            System.out.println();
        } while (intOpcion != 5);
        scEntrada.close();
    }
}

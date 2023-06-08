package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto04_FutbolistaMejorado.clases;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto04_FutbolistaMejorado.comparadores.*;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        ComparadorFutbolistaNombre comparadorFutbolistaNombre = new ComparadorFutbolistaNombre(); //Objeto de tipo ComparadorFutbolistaNombre.
        ComparadorFutbolistaEdad comparadorFutbolistaEdad = new ComparadorFutbolistaEdad(); //Objeto de tipo ComparadorFutbolistaEdad.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Int que guarda la opción del menú.
        int intFutbolista1; //Int que guarda un índice futbolistas[].
        int intFutbolista2; //Int que guarda otro índice de futbolistas[].
        Futbolista[] futbolistas = { //Array que guarda objetos de tipo Futbolista.
                new Futbolista("123456789-A", "Juan", 25, 10),
                new Futbolista("345678904-C", "María", 22, 5),
                new Futbolista("456789013-D", "Lucía", 22, 15),
                new Futbolista("234567892-B", "Pedro", 22, 20),
                new Futbolista("234567892-B", "Pedro", 30, 20),
        };

        do {
            System.out.println("""
                    Elige una opción:
                        1. Ordenar por DNI.
                        2. Ordenar por Nombre.
                        3. Ordenar por Edad.
                        4. Comparar dos DNI.
                        5. Generar nuevo futbolista.
                        6. Salir.""");
            System.out.print("Opción: ");
            intOpcion = Integer.parseInt(scEntrada.nextLine());

            switch (intOpcion) {
                case 1 -> {
                    System.out.println("Ordenados por DNI");
                    Arrays.sort(futbolistas);
                    for (int intCont = 0; intCont < futbolistas.length; intCont++) {
                        System.out.println("[" + (intCont + 1) + "] " + futbolistas[intCont]);
                    }
                }
                case 2 -> {
                    System.out.println("Ordenados por nombre");
                    Arrays.sort(futbolistas, comparadorFutbolistaNombre);
                    for (int intCont = 0; intCont < futbolistas.length; intCont++) {
                        System.out.println("[" + (intCont + 1) + "] " + futbolistas[intCont]);
                    }
                }
                case 3 -> {
                    System.out.println("Ordenados por edad");
                    Arrays.sort(futbolistas, comparadorFutbolistaEdad);
                    for (int intCont = 0; intCont < futbolistas.length; intCont++) {
                        System.out.println("[" + (intCont + 1) + "] " + futbolistas[intCont]);
                    }
                }
                case 4 -> {
                    System.out.print("Dime primer futbolista: ");
                    intFutbolista1 = Integer.parseInt(scEntrada.nextLine());
                    System.out.print("Dime segundo futbolista: ");
                    intFutbolista2 = Integer.parseInt(scEntrada.nextLine());
                    System.out.println((futbolistas[intFutbolista1].equals(futbolistas[intFutbolista2])
                            ? "Tienen el mismo DNI."
                            : "Tienen diferente DNI."));
                }
                case 5 -> {
                    futbolistas = Arrays.copyOf(futbolistas, futbolistas.length + 1);
                    futbolistas[futbolistas.length - 1] = generaFutbolista(scEntrada);
                }
                case 6 -> System.out.println("Finalizando programa...");
                default -> System.out.println("Opción no válida.");
            }
            System.out.println();
        } while(intOpcion != 6);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Futbolista.                                                         *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Futbolista.                                                                  *
     *******************************************************************************************************************/
    private static Futbolista generaFutbolista(Scanner scEntrada) {
        String strDni;
        String strNombre;
        int intEdad;
        int intNumGoles;

        System.out.print("Dime DNI: ");
        strDni = scEntrada.nextLine();
        System.out.print("Dime nombre: ");
        strNombre = scEntrada.nextLine();
        System.out.print("Dime edad: ");
        intEdad = Integer.parseInt(scEntrada.nextLine());
        System.out.print("Dime número de goles: ");
        intNumGoles = Integer.parseInt(scEntrada.nextLine());

        return new Futbolista(strDni, strNombre, intEdad, intNumGoles);
    }
}

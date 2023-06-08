package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto03_colores.clases;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    /*******************************************************************************************************************
     * Método encargado de controlar el desarrollo principal del programa.                                             *
     *******************************************************************************************************************/
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Colores colores = new Colores(); //Objeto de tipo Colores.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Variable que guardará la opción elegida por el usuario.

        do {
            System.out.println("Los colores actuales de la lista son: " + colores.getStrColores() + ".");
            System.out.println("""
                    ¿Qué quieres hacer?
                        1. Añadir un nuevo color a la lista.
                        2. Conseguir n colores aleatorios de la lista.""");
            System.out.print("OPCIÓN: ");
            intOpcion = scEntrada.nextInt();
            scEntrada.nextLine();

            switch (intOpcion) {
                case 1 -> Inicio.anadeColores(scEntrada, colores);
                case 2 -> Inicio.imprimeTabla(scEntrada, colores);
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcion != 2);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de añadir nuevos colores.                                                                      *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @param colores Objeto de tipo Colores.                                                                          *
     *******************************************************************************************************************/
    private static void anadeColores(Scanner scEntrada, Colores colores) {
        String strColores = colores.getStrColores();
        String strColor;

        System.out.print("\nDime un nuevo color: ");
        strColor = scEntrada.nextLine().toLowerCase().strip();
        if (!strColores.contains(strColor)) {
            strColores += ", " + strColor;
            colores.setStrColores(strColores);
            System.out.println("Color añadido.");
        } else {
            System.out.println("Ese color ya se encuentra en la lista.");
        }
    }

    private static void imprimeTabla(Scanner scEntrada, Colores colores) {
        int intNum;
        String[] strColores;

        do {
            System.out.print("Dime el número de colores: ");
            intNum = scEntrada.nextInt();
            if (intNum < 1) {
                System.out.println("Debes elegir al menos 1 color.");
            }
        } while (intNum < 1);

        strColores = colores.imprimeColoresSinRepetidos(intNum, scEntrada);
        System.out.println("Los colores elegidos son: " + Arrays.toString(strColores) + ".");
    }
}

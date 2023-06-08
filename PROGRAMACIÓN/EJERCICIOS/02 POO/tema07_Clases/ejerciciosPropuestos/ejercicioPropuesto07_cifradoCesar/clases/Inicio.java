package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto07_cifradoCesar.clases;
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

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Variable que guardará la opción elegida por el usuario en el menú.

        do {
            System.out.println("""
                Elige una opción:
                    1. Cifra texto.
                    2. Descifra texto.
                    3. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcion = scEntrada.nextInt();
            switch (intOpcion) {
                case 1, 2 -> Inicio.cifradoDescifrado(scEntrada, intOpcion);
                case 3 -> System.out.println("Finalizando programa...");
                default -> System.out.println("Opción elegida no válida.");
            }
            System.out.println();
        } while (intOpcion != 3);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar el texto a cifrar o descifrar e imprimir el resultado final.                      *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @param intOpcionUsuario Opción elegida por el usuario                                                           *
     *******************************************************************************************************************/
    private static void cifradoDescifrado(Scanner scEntrada, int intOpcionUsuario) {
        String strTexto;
        int intAvanceLetras;

        scEntrada.nextLine();
        System.out.print("Dime el texto: ");
        strTexto = scEntrada.nextLine();

        System.out.print("Dime el avance/retroceso de letras: ");
        intAvanceLetras = scEntrada.nextInt();

        if (intOpcionUsuario == 2 && intAvanceLetras > 0) {
            intAvanceLetras *= -1;
        }

        System.out.println("Texto original: \"" + strTexto + "\"");
        System.out.println("Resultado: \"" + Cesar.cifraODescifraTexto(strTexto, intAvanceLetras) + "\"");
    }
}

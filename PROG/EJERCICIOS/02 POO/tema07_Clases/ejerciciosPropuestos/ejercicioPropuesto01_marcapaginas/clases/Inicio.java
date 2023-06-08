package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto01_marcapaginas.clases;
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
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner
        MarcaPagina marcaPagina = new MarcaPagina(); //Objeto de tipo MarcaPagina

        //DECLARACIÓN DE VARIABLES
        int intValor; //Variable que guardará los diferentes inputs del usuario.

        do {
            System.out.println("""
                    Elige una opción:
                        1. Definir última página leída.
                        2. Iniciar una nueva lectura desde 0.
                        3. Mostrar última página leída.
                        4. Salir.""");
            System.out.print("OPCIÓN: ");
            intValor = scEntrada.nextInt();

            switch (intValor) {
                case 1 -> {
                    System.out.print("Dime la última página que has leído: ");
                    intValor = scEntrada.nextInt();
                    marcaPagina.marcaUltimaPaginaLeida(intValor);
                }
                case 2 -> marcaPagina.nuevaLectura();
                case 3 -> System.out.println("La última página leída es la "
                            + marcaPagina.dimeUltimaPaginaLeida() + ".");
                case 4 -> System.out.println("Apagando el programa.");
                default -> System.out.println("La opción elegida no es correcta.");
            }

            System.out.println();
        } while (intValor != 4);
        scEntrada.close();
    }
}

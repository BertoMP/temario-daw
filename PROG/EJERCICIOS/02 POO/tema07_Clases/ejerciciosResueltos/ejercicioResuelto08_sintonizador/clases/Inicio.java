package tema07_Clases.ejerciciosResueltos.ejercicioResuelto08_sintonizador.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de la clase Scanner.
        Sintonizador nuevoSintonizador = null; //Objeto de la clase Sintonizador.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Variable que guardará las diferentes opciones que elija el usuario.
        double rlnFrecuenciaInicio; //Variable que guardará la frecuencia de inicio.

        //SOLICITUD DE DATOS AL USUARIO
        do {
            System.out.println("""
                        ¿Desea introducir una emisora de inicio o iniciar en 80MHz?
                            1. Introducir emisora.
                            2. Iniciar en 80MHz""");
            System.out.print("OPCIÓN: ");
            intOpcion = scEntrada.nextInt();

            switch (intOpcion) {
                case 1 -> {
                    System.out.println("Dime frecuencia de inicio: ");
                    rlnFrecuenciaInicio = scEntrada.nextDouble();
                    nuevoSintonizador = new Sintonizador(rlnFrecuenciaInicio);
                }
                case 2 -> nuevoSintonizador = new Sintonizador();
                default -> System.out.println("¡ERROR! La opción introducida no es válida, " +
                        "por favor, vuelva a intentarlo.");
            }
        } while (intOpcion < 1 || intOpcion > 2);

        //DO WHILE PARA EL DESARROLLO PRINCIPAL
        do {
            System.out.println("EMISORA ACTUAL: " + nuevoSintonizador.getRlnFrecuencia() + "MHz");
            System.out.println("""
                            Elija una opción:
                                1. Aumentar frecuencia.
                                2. Disminuir frecuencia.
                                3. Mostrar frecuencia.
                                4. Apagar la radio.""");
            System.out.print("OPCIÓN: ");
            intOpcion = scEntrada.nextInt();

            switch (intOpcion) {
                case 1 -> nuevoSintonizador.up();
                case 2 -> nuevoSintonizador.down();
                case 3 -> nuevoSintonizador.display();
                case 4 -> System.out.println("Apagando la radio...");
                default -> System.out.println("La opción introducida no es válida.");
            }
        } while (intOpcion != 4);
        scEntrada.close();
    }
}

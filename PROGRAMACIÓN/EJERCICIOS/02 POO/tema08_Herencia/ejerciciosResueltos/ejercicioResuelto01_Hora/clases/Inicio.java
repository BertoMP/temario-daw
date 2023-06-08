package tema08_Herencia.ejerciciosResueltos.ejercicioResuelto01_Hora.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Hora nuevaHora; //Objeto de tipo hora (declarado, no instanciado).

        //DECLARACIÓN DE VARIABLES
        byte bytHora; //Variable que guardará la hora del objeto.
        byte bytMinuto; //Variable que guardará los minutos del objeto.
        byte bytOpcionUsuario; //Variable que guardará la opción del usuario en el menú.
        int intMinutosAIncrementar; //Variable que guardará los minutos a incrementar.

        System.out.println("Dime una hora de inicio");
        bytHora = Inicio.dimeHora(scEntrada);
        bytMinuto = Inicio.dimeMinutos(scEntrada);

        nuevaHora = new Hora(bytHora, bytMinuto);

        do {
            System.out.println("""
                    Selecciona una opción:
                        1. Incrementar la hora en n minutos.
                        2. Cambiar la hora.
                        3. Cambiar los minutos.
                        4. Mostrar la hora.
                        5. Salir.""");
            System.out.print("Opción: ");
            bytOpcionUsuario = scEntrada.nextByte();
            switch (bytOpcionUsuario) {
                case 1 -> {
                    System.out.print("Dime minutos a incrementar: ");
                    intMinutosAIncrementar = scEntrada.nextInt();
                    for (int intCont = 0; intCont < intMinutosAIncrementar; intCont++) {
                        nuevaHora.incrementa();
                    }
                }
                case 2 -> {
                    bytHora = dimeHora(scEntrada);
                    if (nuevaHora.setHora(bytHora)) {
                        System.out.println("Hora cambiada.");
                    } else {
                        System.out.println("La hora introducida no es válida.");
                    }
                }
                case 3 -> {
                    bytMinuto = dimeMinutos(scEntrada);
                    if (nuevaHora.setMinutos(bytMinuto)) {
                        System.out.println("Minutos cambiados.");
                    } else {
                        System.out.println("Los minutos introducidos no son válidos.");
                    }
                }
                case 4 -> System.out.println(nuevaHora);
                case 5 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while(bytOpcionUsuario != 5);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la hora introducida por el usuario.                                                *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve la hora introducida por el usuario.                                                            *
     *******************************************************************************************************************/
    private static byte dimeHora(Scanner scEntrada) {
        System.out.print("Dime hora: ");
        return scEntrada.nextByte();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver los minutos introducidos por el usuario.                                           *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve los minutos introducidos por el usuario.                                                       *
     *******************************************************************************************************************/
    private static byte dimeMinutos(Scanner scEntrada) {
        System.out.print("Dime minutos: ");
        return scEntrada.nextByte();
    }
}

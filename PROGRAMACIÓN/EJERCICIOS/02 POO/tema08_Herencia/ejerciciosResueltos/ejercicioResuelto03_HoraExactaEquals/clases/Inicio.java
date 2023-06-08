package tema08_Herencia.ejerciciosResueltos.ejercicioResuelto03_HoraExactaEquals.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        HoraExacta nuevaHoraExacta; //Objeto de tipo HoraExacta.
        HoraExacta otraHora; //Objeto de tipo HoraExacta.

        //DECLARACIÓN DE VARIABLES
        byte bytOpcionUsuario; //Variable que guardará la opción del usuario en el menú.
        byte bytValor; //Variable que guardará un valor del usuario para determinadas opciones del menú.
        int intSegundosAIncrementar; //Variable que guardará los segundos a incrementar.

        System.out.println("Dime una hora de inicio");
        nuevaHoraExacta = Inicio.generaHora(scEntrada);

        do {
            System.out.println("""
                    Selecciona una opción:
                        1. Incrementar la hora en n segundos.
                        2. Cambiar la hora.
                        3. Cambiar los minutos.
                        4. Cambiar los segundos.
                        5. Mostrar la hora.
                        6. Compara dos horas.
                        7. Salir.""");
            System.out.print("Opción: ");
            bytOpcionUsuario = scEntrada.nextByte();
            switch (bytOpcionUsuario) {
                case 1 -> {
                    System.out.print("Dime segundos a incrementar: ");
                    intSegundosAIncrementar = scEntrada.nextInt();
                    for (int intCont = 0; intCont < intSegundosAIncrementar; intCont++) {
                        nuevaHoraExacta.incrementa();
                    }
                }
                case 2 -> {
                    bytValor = dimeHora(scEntrada);
                    if (nuevaHoraExacta.setHora(bytValor)) {
                        System.out.println("Hora cambiada.");
                    } else {
                        System.out.println("La hora introducida no es válida.");
                    }
                }
                case 3 -> {
                    bytValor = dimeMinutos(scEntrada);
                    if (nuevaHoraExacta.setMinutos(bytValor)) {
                        System.out.println("Minutos cambiados.");
                    } else {
                        System.out.println("Los minutos introducidos no son válidos.");
                    }
                }
                case 4 -> {
                    bytValor = dimeSegundos(scEntrada);
                    if (nuevaHoraExacta.setSegundo(bytValor)) {
                        System.out.println("Segundos cambiados.");
                    } else {
                        System.out.println("Los segundos introducidos no son válidos.");
                    }
                }
                case 5 -> System.out.println(nuevaHoraExacta);
                case 6 -> {
                    System.out.println("Dime la hora para comparar");
                    otraHora = generaHora(scEntrada);
                    if (nuevaHoraExacta.equals(otraHora)) {
                        System.out.println("Es la misma hora.");
                    } else {
                        System.out.println("Es una hora distinta.");
                    }
                }
                case 7 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while(bytOpcionUsuario != 7);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar un objeto de tipo HoraExacta.                                                       *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo HoraExacta.                                                                  *
     *******************************************************************************************************************/
    private static HoraExacta generaHora(Scanner scEntrada) {
        byte bytHora;
        byte bytMinuto;
        byte bytSegundo;

        bytHora = Inicio.dimeHora(scEntrada);
        bytMinuto = Inicio.dimeMinutos(scEntrada);
        bytSegundo = Inicio.dimeSegundos(scEntrada);

        return new HoraExacta(bytHora, bytMinuto, bytSegundo);
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

    /*******************************************************************************************************************
     * Método encargado de devolver los segundos introducidos por el usuario.                                          *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve los segundos introducidos por el usuario.                                                      *
     *******************************************************************************************************************/
    private static byte dimeSegundos(Scanner scEntrada) {
        System.out.print("Dime segundos: ");
        return scEntrada.nextByte();
    }
}

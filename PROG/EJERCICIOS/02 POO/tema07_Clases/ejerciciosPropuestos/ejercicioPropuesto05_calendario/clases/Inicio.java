package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto05_calendario.clases;
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
        Calendario nuevoCalendario; //Objeto de tipo Calendario.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción elegida por el usuario.

        nuevoCalendario = generaCalendario(scEntrada);

        do {
            System.out.println();
            System.out.println(nuevoCalendario.muestraFecha());
            System.out.println("""
                        Elige una opción:
                            1. Incrementar 1 día.
                            2. Incrementar 1 mes.
                            3. Incrementar n años.
                            4. Comparar la fecha actual del programa con otra y ver si son la misma.
                            5. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = scEntrada.nextInt();

            switch (intOpcionUsuario) {
                case 1 -> nuevoCalendario.incrementaDia();
                case 2 -> nuevoCalendario.incrementaMes();
                case 3 -> Inicio.incrementaAnnos(nuevoCalendario, scEntrada);
                case 4 -> Inicio.comparaFechas(nuevoCalendario, scEntrada);
                case 5 -> System.out.println("Fin de la aplicación.");
                default -> System.out.println("La opción elegida no es válida.");
            }
        } while (intOpcionUsuario != 5);

        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar objeto de tipo Calendario.                                                          *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Calendario.                                                                  *
     *******************************************************************************************************************/
    private static Calendario generaCalendario(Scanner scEntrada) {
        byte bytDia;
        byte bytMes;
        int intAnno;
        int intDiasMaximos;

        System.out.println("Debes generar una fecha");
        System.out.print("\t- Dime el mes: ");
        bytMes = scEntrada.nextByte();
        while (bytMes < 1 || bytMes > 12) {
            System.out.println("¡ERROR! El mes introducido no existe.");
            System.out.print("\t- Dime el mes: ");
            bytMes = scEntrada.nextByte();
        }

        intDiasMaximos = Calendario.compruebaMaximo(bytMes);
        System.out.print("\t- Dime el día: ");
        bytDia = scEntrada.nextByte();
        while (bytDia < 1 || bytDia > intDiasMaximos) {
            System.out.println("¡ERROR! El día está fuera de rango de los días máximos del mes introducido ("
                    + intDiasMaximos + ").");
            System.out.print("\t- Dime el día: ");
            bytDia = scEntrada.nextByte();
        }

        System.out.print("\t- Dime el año: ");
        intAnno = scEntrada.nextInt();
        while (intAnno == 0) {
            System.out.println("¡ERROR! El año 0 no existe.");
            System.out.print("\t- Dime el año: ");
            intAnno = scEntrada.nextInt();
        }
        return new Calendario(bytDia, bytMes, intAnno);
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar el aumento de n años.                                                             *
     *                                                                                                                 *
     * @param nuevoCalendario Objeto de tipo calendario.                                                               *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     *******************************************************************************************************************/
    private static void incrementaAnnos(Calendario nuevoCalendario, Scanner scEntrada) {
        int intNumAnnos;

        System.out.print("Dime el número de años a incrementar: ");
        intNumAnnos = scEntrada.nextInt();
        while (intNumAnnos < 1) {
            System.out.println("El número de años debe ser 1 o mayor.");
            System.out.print("Dime el número de años a incrementar: ");
            intNumAnnos = scEntrada.nextInt();
        }
        nuevoCalendario.incrementaAnno(intNumAnnos);
    }

    /*******************************************************************************************************************
     * Método encargado de comparar fechas.                                                                            *
     *                                                                                                                 *
     * @param nuevoCalendario Objeto de tipo calendario.                                                               *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     *******************************************************************************************************************/
    private static void comparaFechas(Calendario nuevoCalendario, Scanner scEntrada) {
        Calendario otroCalendario;

        otroCalendario = generaCalendario(scEntrada);

        System.out.println(nuevoCalendario.equals(otroCalendario) ? "Es la misma fecha." : "No es la misma fecha.");
    }


}

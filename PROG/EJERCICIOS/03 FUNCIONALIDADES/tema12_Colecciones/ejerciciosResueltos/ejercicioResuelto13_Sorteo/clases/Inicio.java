package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto13_Sorteo.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Sorteo<Integer> sorteo = new Sorteo<>(); //Objeto sorteo.
        Integer intCantidadParticipantes = 0; //int que almacenará la cantidad de participantes.
        Integer intCantidadPremiados = 0; //int que almcenará la cantidad de ganadores.

        intCantidadParticipantes = dimeNumeroParticipantesGanadores("Dime el número de participantes: ",
                intCantidadParticipantes, scEntrada, "El número de participantes no puede ser 0 o negativo.");

        rellenaParticipantes(scEntrada, sorteo, intCantidadParticipantes);

        intCantidadPremiados = dimeNumeroParticipantesGanadores("Dime el número de posibles ganadores: ",
                intCantidadPremiados, scEntrada, "El número de ganadores no puede ser 0 o negativo.");

        scEntrada.close();

        System.out.println("Números premiados: " + sorteo.premiados(intCantidadPremiados));
    }

    /*******************************************************************************************************************
     * Método encargado de determinar el número de participantes o de ganadores.                                       *
     *                                                                                                                 *
     * @param strFraseInicio String que contiene la frase de inicio del método                                         *
     * @param intCantidad Integer con la cantidad de participantes o premiados y que se devuelve como resultado.       *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param strFraseError String que contiene el mensaje de error.                                                   *
     * @return Devuelve un Integer con el número de Participantes/Ganadores.                                           *
     *******************************************************************************************************************/
    private static Integer dimeNumeroParticipantesGanadores(String strFraseInicio, Integer intCantidad,
                                                            Scanner scEntrada, String strFraseError) {
        do {
            System.out.print(strFraseInicio);
            try {
                intCantidad = Integer.parseInt(scEntrada.nextLine());
                if (intCantidad <= 0) {
                    System.out.println(strFraseError);
                }
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un número.");
            }
        } while (intCantidad == null || intCantidad <= 0);
        return intCantidad;
    }

    /*******************************************************************************************************************
     * Método encargado de rellenar los participantes del sorteo.                                                      *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param sorteo Objeto sorteo.                                                                                    *
     * @param intCantidadParticipantes Integer que contiene la cantidad de participantes.                              *
     *******************************************************************************************************************/
    private static void rellenaParticipantes(Scanner scEntrada, Sorteo<Integer> sorteo,
                                             Integer intCantidadParticipantes) {
        int intNumero;

        for (int intCont = 0; intCont < intCantidadParticipantes;) {
            System.out.println("Dime el número del participante " + (intCont + 1) + ": ");
            try {
                intNumero = Integer.parseInt(scEntrada.nextLine());
                if (sorteo.add(intNumero)) {
                    System.out.println("Participante inscrito con éxito.");
                    intCont++;
                } else {
                    System.out.println("El número introducido pertenece a otro participante");
                }
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un número.");
            }
        }
    }
}

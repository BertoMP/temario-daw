package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto28_Brisca.clases;

import tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto28_Brisca.enumerados.*;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final int INT_NUM_CARTAS = 5; //Constante de tipo int que almacena el número de cartas a repartir.

        //DECLARACIÓN DE OBJETOS
        List<Carta> barajaDeJuego = new ArrayList<>(generaBaraja()); //ArrayList que contiene todas las cartas de la baraja.
        List<Carta> cartasJugadorUno; //Lista que almacenará las cartas del jugador uno.
        List<Carta> cartasJugadorDos; //Lista que almacenará las cartas del jugador dos.
        Map<String, Integer> mapaCartaValor = new HashMap<>(generaMapa()); //Mapa que contiene los valores de las cartas.

        int intPuntuacionJugadorUno;
        int intPuntuacionJugadorDos;

        Collections.shuffle(barajaDeJuego);

        System.out.println("\t\t\tJUGADOR 1");
        cartasJugadorUno = dameCartas(INT_NUM_CARTAS, barajaDeJuego);
        intPuntuacionJugadorUno = calculaPuntos(cartasJugadorUno, mapaCartaValor);

        System.out.println();

        System.out.println("\t\t\tJUGADOR 2");
        cartasJugadorDos = dameCartas(INT_NUM_CARTAS, barajaDeJuego);
        intPuntuacionJugadorDos = calculaPuntos(cartasJugadorDos, mapaCartaValor);
        System.out.println();
        if (intPuntuacionJugadorUno != intPuntuacionJugadorDos) {
            System.out.println((intPuntuacionJugadorUno > intPuntuacionJugadorDos) ? "Gana el jugador 1."
                                                                                   : "Gana el jugador 2.");
        } else {
            System.out.println("Hay un empate.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de generar un listado con todas las cartas posibles y devolverlo como resultado.               *
     *                                                                                                                 *
     * @return Devuelve un listado con todas las cartas.                                                               *
     *******************************************************************************************************************/
    private static List<Carta> generaBaraja() {
        //DECLARACIÓN DE OBJETOS
        List<Carta> listadoReturn = new ArrayList<>(); //ArrayList que almacena las cartas de la baraja.

        for (PaloBaraja paloValor : PaloBaraja.values()) {
            for (NumeroCarta valorValorCarta : NumeroCarta.values()) {
                listadoReturn.add(new Carta(paloValor, valorValorCarta));
            }
        }
        return listadoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de generar un mapa con la pareja carta:valor.                                                  *
     *                                                                                                                 *
     * @return Devuelve un mapa con las parejas carta:valor rellenadas.                                                *
     *******************************************************************************************************************/
    private static Map<String, Integer> generaMapa() {
        //DECLARACIÓN DE OBJETOS
        Map<String, Integer> mapaReturn = new HashMap<>(); //Mapa que almacenará las parejas carta:valor.

        mapaReturn.put("as",11);
        mapaReturn.put("tres",10);
        mapaReturn.put("sota",2);
        mapaReturn.put("caballo",3);
        mapaReturn.put("rey",4);

        return mapaReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver una mano de cartas al usuario.                                                     *
     *                                                                                                                 *
     * @param intNum Int que contiene el número de cartas a devolver.                                                  *
     * @param baraja Listado de tipo carta que contiene la baraja de cartas.                                           *
     * @return Devuelve una lista con la mano de cartas del usuario.                                                   *
     *******************************************************************************************************************/
    private static List<Carta> dameCartas(int intNum, List<Carta> baraja) {
        //DECLARACIÓN DE OBJETOS
        List<Carta> cartasJugador = new ArrayList<>(); //ArrayList que contiene las cartas de la mano del jugador.
        Iterator<Carta> iteradorBaraja = baraja.iterator(); //Iterator para recorrer la baraja.

        for (int intCont = 0; intCont < intNum; intCont++) {
            cartasJugador.add(iteradorBaraja.next());
        }
        baraja.removeAll(cartasJugador);

        return cartasJugador;
    }

    /*******************************************************************************************************************
     * Método encargado de calcular los puntos de la mano del jugador.                                                 *
     *                                                                                                                 *
     * @param listadoCartas List que contiene la mano del jugador.                                                     *
     * @param mapaCartas Mapa que contiene las parejas carta:valor.                                                    *
     *******************************************************************************************************************/
    private static int calculaPuntos(List<Carta> listadoCartas, Map<String, Integer> mapaCartas) {
        //DECLARACIÓN DE VARIABLES
        int intCuentaFinal = 0; //Int que contiene la cuenta final de la mano.
        int intPuntosCarta; //Int que guarda la cantidad de puntos de la carta a evaluar.

        System.out.println("Estas son tus cartas:");
        for (Carta cartaValor : listadoCartas) {
            intPuntosCarta = mapaCartas.getOrDefault(cartaValor.getStrNumeroCarta(), 0);
            System.out.println("\t- " + cartaValor + " (" + intPuntosCarta + " puntos).");
            intCuentaFinal += intPuntosCarta;
        }

        System.out.println("Tienes " + intCuentaFinal + " puntos.");

        return intCuentaFinal;
    }
}

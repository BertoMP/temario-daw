package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto19_Frase.clases;

import java.util.*;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        List<String> listadoPalabras; //List que se utilizará de ArrayList que almacenará las palabras de la frase.
        Set<String> listadoPalabrasRepetidas; //Set que se utilizará de TreeSet para almacenar las palabras repetidas.
        Set<String> listadoPalabrasUnicas; //Set que se utilizará de TreeSet para almacenar las palabras que aparecen una única vez.

        listadoPalabras = generaListadoFrase();
        listadoPalabrasRepetidas = generaListadoPalabrasRepetidas(listadoPalabras);
        listadoPalabrasUnicas = generaListadoPalabrasUnicas(listadoPalabras, listadoPalabrasRepetidas);

        System.out.println("Palabras de la frase -> " + listadoPalabras);
        System.out.println("Palabras que se repiten -> " + listadoPalabrasRepetidas);
        System.out.println("Palabras que aparecen una única vez:-> " + listadoPalabrasUnicas);
    }

    /*******************************************************************************************************************
     * Método para generar un listado de palabras a partir de una frase ingresada por el usuario.                      *
     *                                                                                                                 *
     * @return Devuelve una lista de String con las palabras de la frase.                                              *
     *******************************************************************************************************************/
    private static List<String> generaListadoFrase() {
        //DECLARACIÓN DE VARIABLES
        String strFraseUsuario; //String que almacena la frase del usuario.

        System.out.print("Dime una frase: ");
        strFraseUsuario = new Scanner(System.in).nextLine().toLowerCase().replaceAll("[.:,;¡!¿?]+", " ");

        return new ArrayList<>(Arrays.asList(strFraseUsuario.split("[\\s\\t]+")));
    }

    /*******************************************************************************************************************
     * Método para generar un listado de palabras repetidas a partir de una lista de palabras.                         *
     *                                                                                                                 *
     * @param listadoPalabras Una lista de String con las palabras.                                                    *
     * @return Devuelve un conjunto de String con las palabras repetidas en la lista de entrada.                       *
     *******************************************************************************************************************/
    private static Set<String> generaListadoPalabrasRepetidas(List<String> listadoPalabras) {
        Set<String> listadoPalabrasRepetidas = new TreeSet<>();

        for (String palabraValor : listadoPalabras) {
            if (Collections.frequency(listadoPalabras, palabraValor) > 1) {
                listadoPalabrasRepetidas.add(palabraValor);
            }
        }

        return listadoPalabrasRepetidas;
    }

    /*******************************************************************************************************************
     * Método para generar un listado de palabras únicas a partir de una lista de palabras y un conjunto de            *
     * palabras repetidas.                                                                                             *
     *                                                                                                                 *
     * @param listadoPalabras Una lista de String con las palabras.                                                    *
     * @param listadoPalabrasRepetidas Un conjunto de String con las palabras repetidas en la lista de entrada.        *
     * @return Devuelve un conjunto de String con las palabras únicas en la lista de entrada.                          *
     *******************************************************************************************************************/
    private static Set<String> generaListadoPalabrasUnicas(List<String> listadoPalabras,
                                                           Set<String> listadoPalabrasRepetidas) {
        Set<String> listadoPalabrasUnicas = new TreeSet<>(listadoPalabras);

        listadoPalabrasUnicas.removeAll(listadoPalabrasRepetidas);

        return listadoPalabrasUnicas;
    }
}

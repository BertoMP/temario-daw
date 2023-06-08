package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto27_VerbosIrregularesIngles.inicio;

import java.util.*;

/***********************************************************************************************************************
 * Clase que controla el desarrollo principal del programa.                                                            *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Map<String, String> mapaVerbos = new TreeMap<>(generaMapa()); //Mapa que contiene los verbos irregulares del inglés.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que contiene la opción del usuario.

        intOpcionUsuario = muestraMenu(scEntrada);

        switch (intOpcionUsuario) {
            case 1 -> todosLosVerbosEnOrden(mapaVerbos, scEntrada);
            case 2 -> verbosAleatorios(mapaVerbos, scEntrada);
            case 3 -> System.out.println("Finalizando...");
            default -> System.out.println("El valor introducido está fuera de rango.");
        }

        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú de selección y devolver la opción elegida por el usuario.                   *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un valor int con la opción elegida por el usuario.                                             *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer intOpcionUsuario = null; //Integer que guarda la opción del usuario.

        do {
            System.out.println("""
                Elige una opción:
                    1. Recorrer todos los verbos irregulares.
                    2. Recorrer X cantidad de verbos irregulares.
                    3. Salir.""");
            System.out.print("Opción: ");
            try {
                intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Se ha introducido un valor no numérico");
            }
        } while (intOpcionUsuario == null);

        return intOpcionUsuario;
    }

    /*******************************************************************************************************************
     * Método encargado de recorrer un mapa e ir solicitando las respuestas al usuario.                                *
     *                                                                                                                 *
     * @param mapaVerbos Mapa con los verbos irregulares.                                                              *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     *******************************************************************************************************************/
    private static void todosLosVerbosEnOrden(Map<String, String> mapaVerbos, Scanner scEntrada) {
        int intContadorAciertos = 0;
        int intContadorFallos = 0;

        String strVerboAAcertar;
        String strRespuestaCorrecta;

        for (Map.Entry<String, String> mapaVerbosClave : mapaVerbos.entrySet()) {
            strVerboAAcertar = mapaVerbosClave.getKey();
            strRespuestaCorrecta = mapaVerbosClave.getValue();

            if(solicitaYCompruebaRespuesta(scEntrada, strVerboAAcertar, strRespuestaCorrecta)) {
                intContadorAciertos++;
            } else {
                intContadorFallos++;
            }
        }

        imprimeResultadosFinales(intContadorAciertos, intContadorFallos);
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar la respuesta y comprobar si es correcta.                                          *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada.                                                                       *
     * @param strVerbo String que contiene el verbo a acertar.                                                         *
     * @param strRespuestaCorrecta String que contiene la respuesta correcta.                                          *
     * @return Devuelve un booleano en función de si el usuario acierta (true) o no (false).                           *
     *******************************************************************************************************************/
    private static boolean solicitaYCompruebaRespuesta(Scanner scEntrada, String strVerbo,
                                                       String strRespuestaCorrecta) {
        String strRespuestaUsuario;

        do {
            System.out.println("\nVerbo to " + strVerbo);
            System.out.print("Dime el pasado simple (si tiene dos opciones separalas con /): ");
            strRespuestaUsuario = scEntrada.nextLine().toLowerCase();
            if (strRespuestaUsuario.isEmpty()) {
                System.out.println("La respuesta no puede estar en blanco.");
            }
        } while (strRespuestaUsuario.isEmpty());

        if (strRespuestaCorrecta.equals(strRespuestaUsuario)) {
            System.out.println("Has acertado.");
            return true;
        } else {
            System.out.println("Has fallado. La respuesta correcta era: " + strRespuestaCorrecta);
            return false;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir por pantalla los resultados finales.                                               *
     *                                                                                                                 *
     * @param intContadorAciertos Int que contiene los aciertos del usuario.                                           *
     * @param intContadorFallos Int que contiene los fallos del usuario.                                               *
     *******************************************************************************************************************/
    private static void imprimeResultadosFinales(int intContadorAciertos, int intContadorFallos) {
        System.out.println("\nRESULTADOS FINALES");
        System.out.println("\t- ACIERTOS: " + intContadorAciertos);
        System.out.println("\t- FALLOS: " + intContadorFallos);
    }

    /*******************************************************************************************************************
     * Método encargado de recorrer un mapa, obtener verbos aleatorios e ir solicitando las respuestas al usuario.     *
     *                                                                                                                 *
     * @param mapaVerbos Mapa con los verbos irregulares.                                                              *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     *******************************************************************************************************************/
    private static void verbosAleatorios(Map<String, String> mapaVerbos, Scanner scEntrada) {
        int intContadorAciertos = 0;
        int intContadorFallos = 0;
        String strVerboAAcertar;
        String strRespuestaCorrecta;
        String strContinuar = "";

        List<String> listadoVerbosInfinitivo = new ArrayList<>(mapaVerbos.keySet());

        do {
            strVerboAAcertar = listadoVerbosInfinitivo.get((int) (Math.random() * listadoVerbosInfinitivo.size()));
            strRespuestaCorrecta = mapaVerbos.get(strVerboAAcertar);
            listadoVerbosInfinitivo.remove(strVerboAAcertar);

            if(solicitaYCompruebaRespuesta(scEntrada, strVerboAAcertar, strRespuestaCorrecta)) {
                intContadorAciertos++;
            } else {
                intContadorFallos++;
            }

            if (listadoVerbosInfinitivo.size() > 0) {
                System.out.print("¿Deseas continuar? (Sí / No): ");
                strContinuar = scEntrada.nextLine().toLowerCase();
            }
        } while(!strContinuar.equals("no"));

        imprimeResultadosFinales(intContadorAciertos, intContadorFallos);
    }

    /*******************************************************************************************************************
     * Método encargado de generar un mapa que contenta los verbos irregulares del inglés. Se guarda una pareja        *
     * clave:valor en función de infinitivo:pasado simple.                                                             *
     *                                                                                                                 *
     * @return Devuelve un mapa que contiene las parejas infinitivo:pasado simple de los verbos irregulares del inglés.*
     *******************************************************************************************************************/
    private static Map<String, String> generaMapa() {
        Map<String, String> mapaReturn = new HashMap<>();

        mapaReturn.put("be", "was/were");
        mapaReturn.put("begin", "began");
        mapaReturn.put("break", "broke");
        mapaReturn.put("bring", "brought");
        mapaReturn.put("build", "built");
        mapaReturn.put("buy", "bought");
        mapaReturn.put("catch", "caught");
        mapaReturn.put("choose", "chose");
        mapaReturn.put("come", "came");
        mapaReturn.put("do", "did");
        mapaReturn.put("draw", "drew");
        mapaReturn.put("drive", "drove");
        mapaReturn.put("eat", "ate");
        mapaReturn.put("fall", "fell");
        mapaReturn.put("feel", "felt");
        mapaReturn.put("find", "found");
        mapaReturn.put("fly", "flew");
        mapaReturn.put("forget", "forgot");
        mapaReturn.put("get", "got");
        mapaReturn.put("give", "gave");
        mapaReturn.put("go", "went");
        mapaReturn.put("grow", "grew");
        mapaReturn.put("have", "had");
        mapaReturn.put("hear", "heard");
        mapaReturn.put("hide", "hid");
        mapaReturn.put("hit", "hit");
        mapaReturn.put("hold", "held");
        mapaReturn.put("keep", "kept");
        mapaReturn.put("know", "knew");
        mapaReturn.put("leave", "left");
        mapaReturn.put("lend", "lent");
        mapaReturn.put("let", "let");
        mapaReturn.put("lose", "lost");
        mapaReturn.put("make", "made");
        mapaReturn.put("mean", "meant");
        mapaReturn.put("meet", "met");
        mapaReturn.put("pay", "paid");
        mapaReturn.put("put", "put");
        mapaReturn.put("muestraEmpleadosId", "muestraEmpleadosId");
        mapaReturn.put("ride", "rode");
        mapaReturn.put("ring", "rang");
        mapaReturn.put("run", "ran");
        mapaReturn.put("say", "said");
        mapaReturn.put("see", "saw");
        mapaReturn.put("sell", "sold");
        mapaReturn.put("send", "sent");
        mapaReturn.put("shine", "shone");
        mapaReturn.put("shoot", "shot");
        mapaReturn.put("show", "showed");
        mapaReturn.put("shut", "shut");
        mapaReturn.put("sing", "sang");
        mapaReturn.put("sit", "sat");
        mapaReturn.put("sleep", "slept");
        mapaReturn.put("speak", "spoke");
        mapaReturn.put("spend", "spent");
        mapaReturn.put("stand", "stood");
        mapaReturn.put("swim", "swam");
        mapaReturn.put("take", "took");
        mapaReturn.put("teach", "taught");
        mapaReturn.put("tell", "told");
        mapaReturn.put("think", "thought");
        mapaReturn.put("throw", "threw");
        mapaReturn.put("understand", "understood");
        mapaReturn.put("wake", "woke");
        mapaReturn.put("wear", "wore");
        mapaReturn.put("win", "won");
        mapaReturn.put("write", "wrote");

        return mapaReturn;
    }
}

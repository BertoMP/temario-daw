package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Realiza el juego del ahorcado. Las reglas del juego son:                                                            *
 *   a) El jugador A teclea una palabra, sin que el jugador B la vea.                                                  *
 *   b) Ahora se le muestra tanto guiones como letras tenga la palabra secreta. Por ejemplo, para "hola" será "____".  *
 *   c) El jugador B intentará acertar, letra a letra, la palabra secreta.                                             *
 *   d) Cada acierto muestra la letra en su lugar y las palabras no acertadas seguirán ocultas como guiones. Siguiendo *
 *      el ejemplo anterior, y suponiendo que ha introducido: la 'o', la 'j' y la 'a', se mostrará "_o_a".             *
 *   e) El jugador B solo tiene 7 intentos.                                                                            *
 *   f) La partida terminará al acertar todas las letras que forman la palabra secreta (gana el jugador B) o cuando    *
 *      se agoten todos los intentos (gana el jugador A).                                                              *
 ***********************************************************************************************************************/
public class Ejercicio02_Ahorcado {
    /*******************************************************************************************************************
     * Funcion encargada de imprimir un mensaje gráfico al usuario para que conozca el número de vidas que le quedan.  *
     *                                                                                                                 *
     * @param intNum → Variable que guarda el número de vidas restantes.                                               *
     *******************************************************************************************************************/
    public static void vidas(int intNum){
        //SWITCH PARA MANDAR UN MENSAJE U OTRO EN FUNCIÓN DEL NÚMERO DE VIDAS
        switch (intNum) {
            case 7 -> System.out.println("""
                                         Estás fuera de peligro. VIDAS: 7
                                                 -----------------------
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
            case 6 -> System.out.println("""
                                         Se ha colgado la cuerda. VIDAS: 6
                                                 -----------------------
                                                 |                     |
                                                 |                     |
                                                 |                     |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
            case 5 -> System.out.println("""
                                         Estás colgando de la cabeza. VIDAS: 5
                                                 -----------------------
                                                 |                     |
                                                 |                     |
                                                 |                  ___|___
                                                 |                 | _   _ |
                                                 |                 |   _   |
                                                 |                 |_______|
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
            case 4 -> System.out.println("""
                                         Estás colgando de la cabeza y del cuerpo. VIDAS: 4
                                                 -----------------------
                                                 |                     |
                                                 |                     |
                                                 |                  ___|___
                                                 |                 | _   _ |
                                                 |                 |   _   |
                                                 |                 |_______|
                                                 |                     |
                                                 |                     |
                                                 |                     |
                                                 |                     |
                                                 |                     |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
            case 3 -> System.out.println("""
                                         Estás colgando de la cabeza, del cuerpo y de un brazo. VIDAS: 3
                                                 -----------------------
                                                 |                     |
                                                 |                     |
                                                 |                  ___|___
                                                 |                 | _   _ |
                                                 |                 |   _   |
                                                 |                 |_______|
                                                 |                   / |
                                                 |                  /  |
                                                 |                 /   |
                                                 |                     |
                                                 |                     |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
            case 2 -> System.out.println("""
                                         Estás colgando de la cabeza, del cuerpo y de los dos brazos. VIDAS: 2
                                                 -----------------------
                                                 |                     |
                                                 |                     |
                                                 |                  ___|___
                                                 |                 | _   _ |
                                                 |                 |   _   |
                                                 |                 |_______|
                                                 |                   / | \\
                                                 |                  /  |  \\
                                                 |                 /   |   \\
                                                 |                     |
                                                 |                     |
                                                 |
                                                 |
                                                 |
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
            case 1 -> System.out.println("""
                                         Estás colgando de la cabeza, del cuerpo y de una de las piernas. VIDAS: 1
                                                 -----------------------
                                                 |                     |
                                                 |                     |
                                                 |                  ___|___
                                                 |                 | _   _ |
                                                 |                 |   _   |
                                                 |                 |_______|
                                                 |                   / | \\
                                                 |                  /  |  \\
                                                 |                 /   |   \\
                                                 |                     |
                                                 |                     |
                                                 |                    /
                                                 |                   /
                                                 |                  /
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
            case 0 -> System.out.println("""
                                         Estás ahorcado. Has perdido.
                                                 -----------------------
                                                 |                     |
                                                 |                     |
                                                 |                  ___|___
                                                 |                 | X   X |
                                                 |                 |   _   |
                                                 |                 |_______|
                                                 |                   / | \\
                                                 |                  /  |  \\
                                                 |                 /   |   \\
                                                 |                     |
                                                 |                     |
                                                 |                    / \\
                                                 |                   /   \\
                                                 |                  /     \\
                                                 |
                                                 |
                                                /|\\
                                               / | \\
                                              /  |  \\
                                         ____/___|___\\________________________________""");
        }
    }
    /*******************************************************************************************************************
     * Función encargada de cambiar el guion o guiones de strPalabra1 por la letra o letras de strPalabra2 que         *
     * sean iguales a chrLetra.                                                                                        *
     *                                                                                                                 *
     * @param strPalabra1 → String que guarda la palabra que se debe acertar.                                          *
     * @param strPalabra2 → String que guarda la palabra con guiones y letras acertadas por el usuario hasta           *
     *                       ese momento.                                                                              *
     * @param chrLetra → Char que guarda la letra que ha acertado el usuario.                                          *
     * @return La función devolverá strPalabra2 con los cambios realizados.                                            *
     *******************************************************************************************************************/
    public static String cambiaLetra(String strPalabra1, String strPalabra2, char chrLetra) {
        //DECLARACIÓN DE VARIABLES
        char[] chrArrLetras = strPalabra2.toCharArray(); //Array de char que guarda las letras y guiones de la palabra del usuario
        String strPalabraReturn = ""; //String que guardará la palabra a devolver.
        //BUCLE FOR
        for (int intCont = 0; intCont < strPalabra1.length(); intCont++) {
            /* El bucle recorrerá toda la palabra secreta (strPalabra1) y comprobará los lugares donde se encuentra
             * la letra que ha acertado el usuario. Si la letra del usuario es igual a la de la palabra secreta
             * en la iteración del bucle, se cambiará el valor de chrArrLetras[intCont] por el valor de la letra
             * del usuario.
             * Al final de cada iteración se guarda en strPalabraReturn el valor de chrArrLetras[intCont]*/
            if (strPalabra1.charAt(intCont) == chrLetra) {
                chrArrLetras[intCont] = chrLetra;
            }
            strPalabraReturn += chrArrLetras[intCont];
        }

        //RETURN
        return strPalabraReturn;
    }
    /*******************************************************************************************************************
     * Función encargada de buscar en la palabra secreta (strPalabra1) la letra introducida por el usuario.            *
     * @param strPalabra1 → String con la palabra secreta.                                                             *
     * @param chrLetra → Char con la letra del usuario.                                                                *
     * @return La función devolverá un true/false en función de si la letra existe en el String (intIndiceBusqueda     *
     *         != -1) o no (intIndiceBusqueda == 1).                                                                   *
     *******************************************************************************************************************/
    public static boolean buscaLetra(String strPalabra1, char chrLetra) {
        //DECLARACIÓN DE VARIABLES
        int intIndiceBusqueda; //Variable de tipo int que guardará el índice resultante del método indexOf

        intIndiceBusqueda = strPalabra1.indexOf(chrLetra);

        //RETURN
        return intIndiceBusqueda != -1;
    }
    /*******************************************************************************************************************
     * Función encargada de las reglas principales del juego.                                                          *
     *******************************************************************************************************************/
    public static void imprimeReglas() {
        System.out.println("""
                \t\t\t\t\t\t\t.::JUEGO DEL AHORCADO::.
                REGLAS:
                    a) El jugador A teclea una palabra, sin que el jugador B la vea.
                    b) Ahora se le muestra tanto guiones como letras tenga la palabra secreta.
                       Por ejemplo, para "hola" será "____".
                    c) El jugador B intentará acertar, letra a letra, la palabra secreta.
                    d) Cada acierto muestra la letra en su lugar y las palabras no acertadas seguirán
                       ocultas como guiones. Siguiendo el ejemplo anterior, y suponiendo que ha introducido:
                       la 'o', la 'j' y la 'a', se mostrará "_o_a".
                    e) El jugador B solo tiene 7 intentos.
                    f) La partida terminará al acertar todas las letras que forman la palabra secreta
                       (gana el jugador B) o cuando se agoten todos los intentos (gana el jugador A).
                       """);
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strPalabraSecreta; //String que guardará la palabra introducida por el jugador A.
        String strPalabraGuiones = ""; //String que guardará la palabra secreta en forma de guiones y letras acertadas por el jugador B.
        String strLetrasFalladas = ""; //String que guardará las letras falladas.
        char chrLetra; //Variable char que guardará la letra introducida por el jugador B en cada turno.
        int intVidas = 7; //Variable int que almacena el numero de vidas restantes.
        boolean blnLetraEncontrada; //Variable booleana para comprobar si la letra introducida por el jugador B existe o no en strPalabraSecreta.

        //LLAMADA A LA FUNCIÓN imprimeReglas();
        imprimeReglas();

        //SOLICITUD DE DATOS (PALABRA SECRETA AL JUGADOR A)
        System.out.print("Jugador A introduce una palabra: ");
        strPalabraSecreta = scEntrada.next().toLowerCase();

        //BUCLE FOR
        for (int intContador = 0; intContador < strPalabraSecreta.length(); intContador++) {
            /* El bucle se va a encargar de rellenar strPalabraGuiones con guiones bajos ('_') tantos como letras
             * letras tenga strPalabraSecreta. En cada iteración lo que se hará es añadir un nuevo guión a la
             * palabra
             *
             * El bucle se mantiene hasta que intContador alcanza la longitud de strPalabraSecreta. */
            strPalabraGuiones += '_';
        }

        System.out.println("Jugador B debes acertar la siguiente palabra: ");

        //BUCLE WHILE
        while (intVidas > 0 && !strPalabraGuiones.equals(strPalabraSecreta)) {
            /* El bucle while va a controlar el desarrollo principal del juego y se va a mantener mientras el número
             * de vidas del jugador B será mayor a 0 o que el jugador B no haya acertado la palabra.
             * Lo primero que se hará es imprimir el String strPalabraGuiones para que el jugador B conozca la
             * situación actual de la palabra y, a continuación, se le solicitará una nueva letra, la cual se
             * comprobará si existe en strPalabraSecreta:
             *    - Si existe: se llamará a la función cambiaLetra para cambiar el guion por la letra.
             *    - Si no existe: se le restará una vida. */
            System.out.println(strPalabraGuiones);
            if (!strLetrasFalladas.isEmpty()) { //Imprime un String con las letras falladas salvo que esté vacío.
                System.out.println("Letras falladas: " + strLetrasFalladas);
            }
            System.out.println();

            System.out.print("Introduce una letra: ");
            chrLetra = Character.toLowerCase(scEntrada.next().charAt(0));

            //LLAMADA A LA FUNCIÓN buscaLetra(String, char);
            blnLetraEncontrada = buscaLetra(strPalabraSecreta, chrLetra);

            if (blnLetraEncontrada) {
                System.out.println("La letra " + chrLetra + " está en la palabra.");
                //LLAMADA A LA FUNCIÓN cambiaLetra(String, String, char);
                strPalabraGuiones = cambiaLetra(strPalabraSecreta,strPalabraGuiones, chrLetra);
            } else {
                intVidas--;
                System.out.println("La letra " + chrLetra + " no está en la palabra, pierdes una vida.");
                if (strLetrasFalladas.indexOf(chrLetra) == -1) { //Guarda la letra fallada en el String si previamente no se había introducido
                    strLetrasFalladas += chrLetra + " ";
                }
            }

            //LLAMADA A LA FUNCIÓN vidas(int);
            vidas(intVidas);
            System.out.println();
        }
        scEntrada.close();

        //IMPRESIÓN DE RESULTADOS
        if (intVidas == 0) {
            System.out.print("La palabra era: " + strPalabraSecreta);
        } else {
            System.out.println("¡Felicidades! Has acertado la palabra.");
        }
    }

    public static void main(String[] args) {
        inicio();
    }
}

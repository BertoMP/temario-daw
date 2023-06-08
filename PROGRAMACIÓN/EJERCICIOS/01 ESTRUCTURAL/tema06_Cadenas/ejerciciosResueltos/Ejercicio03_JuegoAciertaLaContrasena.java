package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Diseñar el juego "Acierta la contraseña". La mecánica del juego es la siguiente: el primer jugador introduce la     *
 * contraseña, el segundo jugador debe teclear palabras hasta que acierte. Realizar dos versiones: en la primera se    *
 * facilita el juego, indicando si la palabra introducida es mayor o menor alfabéticamente que la contraseña.          *
 * En la segunda, el programa mostrará la longitud de la contraseña y una cadena con los caracteres acertados en sus   *
 * lugares respectivos y asteriscos en los no acertados.                                                               *
 **********************************************************************************************************************/
public class Ejercicio03_JuegoAciertaLaContrasena {
    /*******************************************************************************************************************
     * Función encargada de desarrollar la modalidad difícil del juego.                                                *
     *                                                                                                                 *
     * @param scEntrada -> Scanner para la entrada de datos.                                                           *
     *******************************************************************************************************************/
    public static void modalidadDificil(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strPalabraSecreta; //Variable String que guardará la palabra secreta que funcionará como contraseña
        String strPalabraUsuario; //Variable String que guardará la palabra intento del usuario
        String strPalabraAsteriscos; //Variable String que funcionará como pista para el usuario

        //SOLICITUD DE DATOS (PALABRA SECRETA QUE FUNCIONARÁ COMO CONTRASEÑA)
        System.out.print("Jugador 1 introduzca la contraseña: ");
        strPalabraSecreta = scEntrada.nextLine();

        //INFORMACIÓN AL USUARIO 2 SOBRE EL NÚMERO DE LETRAS DE LA PALABRA
        System.out.println("La contraseña tiene: " + strPalabraSecreta.length() + " letras.");
        for (int intCont = 0; intCont < strPalabraSecreta.length(); intCont++) {
            System.out.print('*');
        }

        //SOLICITUD DE DATOS AL USUARIO 2
        System.out.print("\n\nJugador 2 introduzca palabra: ");
        strPalabraUsuario = scEntrada.nextLine();

        //BUCLE WHILE
        while (!strPalabraUsuario.equals(strPalabraSecreta)) {
            /* El bucle se repetirá hasta que la palabra del usuario sea la palabra secreta. En cada iteración se
             * inicializará el String de asteriscos vacío y se rellenará con las letras que haya acertado el usuario
             * en su intento.
             * Al final de la iteración se solicitará al usuario una nueva palabra. */
            strPalabraAsteriscos = "";
            for (int intContador = 0; intContador < strPalabraSecreta.length(); intContador++) {
                if (strPalabraUsuario.charAt(intContador) == strPalabraSecreta.charAt(intContador)) {
                    strPalabraAsteriscos += strPalabraSecreta.charAt(intContador);
                } else {
                    strPalabraAsteriscos += '*';
                }
            }
            System.out.println(strPalabraAsteriscos);
            System.out.print("\nJugador 2 introduzca palabra: ");
            strPalabraUsuario = scEntrada.nextLine();
        }
        System.out.println("Has acertado la contraseña");
    }
    /*******************************************************************************************************************
     * Función encargada de desarrollar la modalidad fácil del juego.                                                  *
     *                                                                                                                 *
     * @param scEntrada -> Scanner para la entrada de datos.                                                           *
     *******************************************************************************************************************/
    public static void modalidadFacil (Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strPalabraSecreta; //Variable String que guardará la palabra secreta que funcionará como contraseña
        String strPalabraUsuario; //Variable String que guardará la palabra intento del usuario
        int intComparacion; //Variable int para guardar el resultado del método compareTo.

        //SOLICITUD DE DATOS (PALABRA SECRETA QUE FUNCIONARÁ COMO CONTRASEÑA)
        System.out.print("Jugador 1 introduzca la contraseña: ");
        strPalabraSecreta = scEntrada.nextLine();

        //BUCLE DO WHILE PARA QUE EL USUARIO 2 ACIERTE LA PALABRA)
        do {
            /* El bucle se repetirá hasta que el usuario acierte la palabra, en cada iteración se solicitará
             * una palabra y se informará al usuario de si ha acertado, si la contraseña es menor o si la
             * contraseña es mayor. */

            //SOLICITUD DE DATOS
            System.out.print("Jugador 2 introduzca palabra: ");
            strPalabraUsuario = scEntrada.nextLine();

            //MÉTODO compareTo()
            intComparacion = strPalabraSecreta.compareTo(strPalabraUsuario);

            //RESULTADO EN FUNCIÓN DE LA RESPUESTA DEL MÉTODO ANTERIOR
            if (intComparacion == 0) {
                System.out.println("Has acertado la contraseña.");
            } else if (intComparacion < 0) {
                System.out.println("La contraseña es alfabéticamente menor.");
                    } else {
                        System.out.println("La contraseña es alfabéticamente mayor.");
                    }
        } while (!strPalabraUsuario.equals(strPalabraSecreta));

        scEntrada.close();
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    public static int modalidadJuego(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        int intOpcion;

        System.out.print("""
                Selecciona la modalidad de juego:
                1. Fácil: El jugador 2 deberá acertar la palabra introducida por el jugador 1. Se le indicará si
                   la palabra es mayor o menor alfabéticamente.
                2. Difícil: El jugador 2 deberá acertar la palabra introducida por el jugador 1. Se le indicará si
                   ha acertado alguna de las letras de la palabra.""");
        System.out.print("\nMODALIDAD ELEGIDA (1/2): ");
        intOpcion = scEntrada.nextInt();

        //BUCLE WHILE EN EL CASO DE QUE EL USUARIO INTRODUZCA UNA OPCION NO VALIDA
        while (intOpcion != 1 && intOpcion != 2) {
            System.out.println("Modalidad elegida, no válida, vuelva a introducir un valor.");
            System.out.print("MODALIDAD ELEGIDA (1/2): ");
            intOpcion = scEntrada.nextInt();
        }

        //RETURN
        return intOpcion;

    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int intModalidadDeJuego; //Variable encargada de guardar la modalidad de juego elegida

        //LLAMADA A LA FUNCIÓN modalidadJuego(scEntrada
        intModalidadDeJuego = modalidadJuego(scEntrada);
        scEntrada.nextLine(); //Refresca el buffer del Scanner

        //SWITCH PARA LLAMAR A LA FUNCIÓN CORRESPONDIENTE A LA MODALIDAD DE JUEGO ELEGIDA
        switch (intModalidadDeJuego) {
            case 1 -> modalidadFacil(scEntrada);
            case 2 -> modalidadDificil(scEntrada);
        }
    }
    public static void main(String[] args) {
        inicio();
    }
}

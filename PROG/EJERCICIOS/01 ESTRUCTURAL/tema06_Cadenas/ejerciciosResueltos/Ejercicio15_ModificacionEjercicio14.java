package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Modificar la actividad 14 para que el programa indique al jugador 2 cu�ntas letras coinciden (son iguales y est�n   *
 * en la misma posici�n) entre el texto introducido por �l y el original.                                              *
 ***********************************************************************************************************************/
public class Ejercicio15_ModificacionEjercicio14 {
    /*******************************************************************************************************************
     * Funci�n encargada de devolver el n�mero de letras acertadas (misma letra y misma posicion) entre dos palabras   *
     * pasadas como par�metro.                                                                                         *
     *                                                                                                                 *
     * @param strPalabra1 -> Primera palabra (corresponde a la palabra introducida por el jugador 1).                  *
     * @param strPalabra2 -> Segunda palabra (corresponde a la palabra intento del jugador 2).                         *
     * @return La funci�n devuelve un int en forma de contador con el n�mero de letras que se han acertado en el       *
     *         intento realizado.                                                                                      *
     *******************************************************************************************************************/
    public static int comprobarLetras(String strPalabra1, String strPalabra2) {
        //DECLARACI�N DE VARIABLES
        int intContadorReturn = 0; //Contador de letras acertadas

        //BUCLE FOR PARA COMPROBAR LAS LETRAS ACERTADAS
        for (int intContador = 0; intContador < strPalabra1.length(); intContador++) {
            /* En cada iteraci�n del bucle se realizar� una comprobaci�n letra a letra entre strPalabra1 y strPalabra2
             * si ambas letras coinciden significar� que son la misma y est�n en la misma posici�n y el contador
             * se incrementar� en uno.
             * El bucle se repetir� hasta que intCont alcance la longitud de strPalabra1. */
            if (strPalabra1.charAt(intContador) == strPalabra2.charAt(intContador)) {
                intContadorReturn++;
            }
        }

        //RETURN
        return intContadorReturn;
    }
    /*******************************************************************************************************************
     * Funci�n encargada de devolver un anagrama de una palabra introducida por par�metro.                             *
     *                                                                                                                 *
     * @param strFrase -> Palabra pasada por par�metro que deber� ser "barajada" para crear un anagrama.               *
     * @return La funci�n devuelve un String resultado de "barajar" la palabra que se le ha pasado por par�metro.      *
     *******************************************************************************************************************/
    public static String crearAnagrama(String strFrase) {
        //DECLARACI�N DE VARIABLES
        char[] chrArrAnagrama;//Variable array de tipo char que guardar� los caracteres que forman la palabra
        char chrAux;//Variable auxiliar que guardar� un caracter
        int intNumeroAleatorio;//Variable int que guardar� un n�mero aleatorio

        //CONVERSI�N DEL STRING EN ARRAY
        chrArrAnagrama = strFrase.toCharArray();

        //BUCLE FOR PARA BARAJAR EL ARRAY
        for (int intContador = 0; intContador < chrArrAnagrama.length; intContador++) {
            /* En cada iteraci�n del bucle se generar� primero un n�mero aleatorio que nos servir� para cambiar el
             * orden original de las letras. A continuaci�n:
             *   1. Se guardar� en chrAux el caracter almacenado en el �ndice correspondiente a intContador.
             *   2. Se copiar� en el �ndice del contador el caracter del �ndice del n�mero aleatorio.
             *   3. En el �ndice del n�mero aleatorio se guardar� el caracter de chrAux. */
            intNumeroAleatorio = (int) (Math.random() * chrArrAnagrama.length);
            chrAux = chrArrAnagrama[intContador];
            chrArrAnagrama[intContador] = chrArrAnagrama[intNumeroAleatorio];
            chrArrAnagrama[intNumeroAleatorio] = chrAux;
        }

        //RETURN
        return String.valueOf(chrArrAnagrama);
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo del programa.                                                                  *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACI�N DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strPalabraAdivinar;//String que guardar� la palabra a adivinar introducida por el jugador 1
        String strAnagrama;//String que guardar� un anagrama creado mediante funci�n
        String strPalabraIntento;//String que guardar� la palabra intengo del jugador 2

        System.out.print("Jugador 1 introduce una palabra: ");
        strPalabraAdivinar = scEntrada.next();

        //LLAMADA A LA FUNCI�N crearAnagrama(String)
        strAnagrama = crearAnagrama(strPalabraAdivinar);

        //IMPRESI�N DEL ANAGRAMA
        System.out.println("Jugador 2, acierta la palabra del anagrama: \'" + strAnagrama + "\'");

        //BUCLE DO WHILE PARA LA INTRODUCCI�N DE PALABRAS POR EL JUGADOR 2
        do {
            System.out.print("Introduce palabra: ");
            strPalabraIntento = scEntrada.next();
            while (strPalabraIntento.length() != strPalabraAdivinar.length()) {
                System.out.println("Las palabras tienen diferente longitud.");
                System.out.print("Introduce palabra: ");
                strPalabraIntento = scEntrada.next();
            }
            System.out.println("Letras acertadas: " + comprobarLetras(strPalabraAdivinar,strPalabraIntento));
        } while (!strPalabraAdivinar.equals(strPalabraIntento));

        scEntrada.close();

        //IMPRESI�N DE RESULTADOS
        System.out.println("Has acertado.");
    }
    public static void main(String[] args) {
        inicio();
    }
}

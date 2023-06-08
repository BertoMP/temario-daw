package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * El preprocesador del lenguaje C eliminaInicio los comentarios (/*.../) del código fuente antes de compilar. Diseña un     *
 * programa que lea por teclado una sentencia en C, y elimine los comentarios.                                         *
 ***********************************************************************************************************************/
public class Ejercicio03_PreprocesadorLenguajeC {
    /*******************************************************************************************************************
     * Función encargada de borrar los comentarios de una sentencia en C proporcionada como parámetro de función.      *
     *                                                                                                                 *
     * @param strFrase → String que contiene la sentencia en C.                                                        *
     * @return La función devolverá el String sin comentarios y con los espacios en blanco corregidos.                 *
     *******************************************************************************************************************/
    public static String borraComentarios(String strFrase) {
        //DECLARACIÓN DE VARIABLES
        String strCadenaAEliminar; //String que guardará la cadena que se debe eliminar.
        int intIndiceBusquedaInicio; //Variable int que guardará el primer índice de búsqueda.
        int intIndiceBusquedaFin; //Variable int que guardará el segundo índice de búsqueda.

        //BÚSQUEDA EN EL STRING
        intIndiceBusquedaInicio = strFrase.indexOf("/*"); //Ejecutar del comentario
        intIndiceBusquedaFin = strFrase.indexOf("*/"); //Fin del comentario

        //BUCLE WHILE
        while (intIndiceBusquedaInicio != -1) {
            /* El bucle se mantendrá hasta que el intIndiceBusquedaInicio dé un valor de -1, es decir, hasta
             * que no queden comentarios en la sentencia proporcionada por el usuario.
             * Lo que se hará en cada iteración del bucle es guardar el comentario desde su inicio (/) hasta su fin
             * el espacio post-comentario (excluido de la función substring, por lo que el último caracter que se
             * guardara en la cadena es la / de fin de comentario).
             * A continuación, se hará un replace en strFrase cambiando strCadena a eliminar por un espacio vacío.
             * Se volverá a buscar si existen comentarios en la sentencia.*/
            strCadenaAEliminar = strFrase.substring(intIndiceBusquedaInicio, intIndiceBusquedaFin + 2);
            strFrase = strFrase.replace(strCadenaAEliminar,"");

            intIndiceBusquedaInicio = strFrase.indexOf("/*");
            intIndiceBusquedaFin = strFrase.indexOf("*/");
        }

        //AJUSTES FINALES EN strFrase
        strFrase = strFrase.replace("  "," "); //Se eliminan los espacios dobles por un único espacio
        strFrase = strFrase.strip(); //Se eliminaInicio el espacio final

        //RETURN
        return strFrase;
    }
    /*******************************************************************************************************************
     * Función encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strSentenciaUsuario; //String que guardara la sentencia en C del usuario

        //SOLICITUD DE DATOS
        System.out.print("Introduzca una sentencia en C con comentarios: ");
        strSentenciaUsuario = scEntrada.nextLine();
        scEntrada.close();

        //LLAMADA A LA FUNCIÓN borraComentarios(String);
        strSentenciaUsuario = borraComentarios(strSentenciaUsuario);

        //IMPRESIÓN DE RESULTADOS
        System.out.println("La sentencia en C sin comentarios es: " + strSentenciaUsuario);
    }

    public static void main(String[] args) {
        inicio();
    }
}

package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Implementa un sencillo editor de texto que, una vez que se ha introducido el texto, permita reemplazar todas las    *
 * ocurrencias de una palabra por otra.                                                                                *
 ***********************************************************************************************************************/
public class Ejercicio09_ProcesadorTexto {
    /*******************************************************************************************************************
     * Función encargada de solicitar al usuario dos palabras, una para buscarla en un texto pasado por parámetro y    *
     * otra para cambiar todas las ocurrencias de la primera palabra por la segunda palabra.                           *
     *                                                                                                                 *
     * @param strTexto → String que contiene un texto.                                                                 *
     * @param scEntrada → Scanner para la entrada de datos.                                                            *
     * @return La función podrá devolver:                                                                              *
     *              - Un mensaje de que la palabra no se ha encontrado (en caso de que al buscar la palabra esta       *
     *                no se encuentre en el texto).                                                                    *
     *              - El texto con todas las ocurrencias de la palabra a buscar cambiadas por la segunda palabra       *
     *                solicitada al usuario.                                                                           *
     *******************************************************************************************************************/
    public static String cambiaPalabra(String strTexto, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strPalabraBusqueda; //String que guarda la palabra que se debe buscar en el texto.
        String strPalabraCambio; //String que guarda la palabra por la que se cambiarán todas las ocurrencias de la palabra buscada.
        int intIndiceBusqueda; //Variable int que guarda el índice de búsqueda.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca palabra que quiere sustituir: ");
        strPalabraBusqueda = scEntrada.nextLine();
        System.out.print("Introduzca palabra de reemplazo: ");
        strPalabraCambio = scEntrada.nextLine();
        scEntrada.close();

        //BÚSQUEDA DE LA PALABRA
        intIndiceBusqueda = strTexto.indexOf(strPalabraBusqueda);

        //RETURN
        if (intIndiceBusqueda == -1) { //Si la palabra no se encuentra en el texto.
            return "La palabra " + strPalabraBusqueda + " no se encuentra en el texto.";
        } else { //Si la palabra se encuentra en el texto.
            strTexto = strTexto.replace(strPalabraBusqueda, strPalabraCambio); //Cambio de todas las ocurrencias.
            return strTexto;
        }
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio () {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strTexto; //String que guardará el texto introducido por el usuario.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca texto: ");
        strTexto = scEntrada.nextLine();

        //LLAMADA A LA FUNCIÓN cambiaPalabra(String, Scanner);
        strTexto = cambiaPalabra(strTexto, scEntrada);

        //IMPRESIÓN DE RESULTADOS
        System.out.println(strTexto);
    }

    public static void main(String[] args) {
        inicio();
    }
}

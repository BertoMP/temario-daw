package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Escribe un programa que lea el título y el contenido de una página web. La aplicación generará por consola un       *
 * documento HTML donde el título será un encabezado de primer nivel (<h1>) y el resto del contenido será un           *
 * párrafo (<p>).                                                                                                      *
 ***********************************************************************************************************************/
public class Ejercicio05_HTML {
    /*******************************************************************************************************************
     * Función encargada de imprimir por consola la estructura principal de un documento HTML añadiendo un encabezado  *
     * h1 y un párrafo pasados como parámetros de función.                                                             *
     *                                                                                                                 *
     * @param strTitulo → String que guarda el contenido del encabezado h1.                                            *
     * @param strParrafo → String que guarda el contenido del párrafo.                                                 *
     *******************************************************************************************************************/
    public static void imprimeHTML(String strTitulo, String strParrafo) {
        //IMPRESIÓN DEL RESULTADO
        System.out.println("\nEl código HTML resultante es el siguiente:" +
                           "\n\n<!DOCTYPE html>" +
                           "\n<html lang=\"es\">" +
                           "\n\t<head>" +
                           "\n\t\t<meta charset=\"utf-8\">" +
                           "\n\t\t<title>WebJava</title>" +
                           "\n\t</head>" +
                           "\n\t<body>" +
                           "\n\t\t<h1>" + strTitulo + "</h1>" +
                           "\n\t\t<p>" + strParrafo + "</p>" +
                           "\n\t</body>" +
                           "\n</html>");
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        String strTitulo; //String que guardará el título introducido por el usuario.
        String strParrafo; //String que guardará el párrafo introducido por el usuario.

        //SOLICITUD DE DATOS
        System.out.print("Introduzca título: ");
        strTitulo = scEntrada.nextLine();
        System.out.print("Introduzca contenido: ");
        strParrafo = scEntrada.nextLine();
        scEntrada.close();

        //LLAMADA A LA FUNCIÓN imprimeHTML(String, String);
        imprimeHTML(strTitulo,strParrafo);

    }

    public static void main(String[] args) {
        inicio();
    }
}

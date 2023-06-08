package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto09_Cifrado.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_FICHERO_CODEC = "codec.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        String strCadenaUser; //String que guarda la cadena de texto introducida por el usuario.
        String strAlfabeto; //String que guarda la cadena con el alfabeto.
        String strCodificacion; //String que guarda la cadena con la codificación.
        String strCadenaCodificada; //String que guarda la cadena codificada.

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto09_Cifrado/documentos/" + STR_FICHERO_CODEC))) {
            strAlfabeto = br.readLine();
            strCodificacion = br.readLine();
            do {
                System.out.print("Introduzca un texto a cifrar: ");
                strCadenaUser = new Scanner(System.in).nextLine();
                if (strCadenaUser.isEmpty()) {
                    System.out.println("Debes introducir un texto.");
                }
            } while (strCadenaUser.isEmpty());
            strCadenaCodificada = codificaTexto(strCadenaUser, strAlfabeto, strCodificacion);
            System.out.println("La cadena codificada es: " + strCadenaCodificada);
            escribeCadena(strCadenaCodificada);
            System.out.println("Escritura realizada con éxito.");
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se encontró el fichero " + STR_FICHERO_CODEC);
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error durante la lectura del fichero " + STR_FICHERO_CODEC);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de codificar un texto, generar una cadena con ese texto y devolverla.                          *
     *                                                                                                                 *
     * @param strCadena String que almacena la cadena a cifrar.                                                        *
     * @param strAlfabeto String que guarda el alfabeto a utilizar.                                                    *
     * @param strCodificacion String que guarda el código de codificación.                                             *
     * @return El método devuelve un String con el texto codificado.                                                   *
     *******************************************************************************************************************/
    private static String codificaTexto(String strCadena, String strAlfabeto, String strCodificacion) {
        String strReturn = ""; //String que se devolverá como resultado del método. Contendrá la cadena de texto codificada.
        char chrCaracter; //Char que almacena cada caracter de la cadena.
        int intIndiceBusqueda; //Int que guarda un indice de búsqueda

        for (int intCont = 0; intCont < strCadena.length(); intCont++) {
            chrCaracter = strCadena.charAt(intCont);
            intIndiceBusqueda = strAlfabeto.indexOf(chrCaracter);
            if (intIndiceBusqueda == -1) {
                strReturn += chrCaracter;
            } else {
                strReturn += strCodificacion.charAt(intIndiceBusqueda);
            }
        }

        return strReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de escribir en un documento la cadena de texto que se pasa por parámetro.                      *
     *                                                                                                                 *
     * @param strCadena String que contiene la cadena de texto a escribir en un documento.                             *
     *******************************************************************************************************************/
    private static void escribeCadena (String strCadena) {
        final String STR_NOMBRE_FICHERO = "codificado.txt"; //Constante String que almacena el nombre del fichero.

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED WRITER
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto09_Cifrado/documentos/" + STR_NOMBRE_FICHERO))) {
            bw.write(strCadena);
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error durante la escritura del fichero " + STR_NOMBRE_FICHERO);
        }
    }
}

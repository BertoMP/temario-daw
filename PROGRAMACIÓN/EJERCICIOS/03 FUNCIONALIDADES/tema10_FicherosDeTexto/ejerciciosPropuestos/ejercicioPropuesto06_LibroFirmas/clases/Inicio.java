package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto06_LibroFirmas.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE_FICHERO = "firmas.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Int que guardará la opción elegida por el usuario.
        String strFirma; //String que guardará la firma.
        boolean blnEncontrado; //Booleano que actuará de bandera.

        do {
            intOpcion = muestraMenu();

            System.out.println();

            switch (intOpcion) {
                case 1 -> {
                    System.out.print("Introduzca su nombre: ");
                    strFirma = new Scanner(System.in).nextLine();

                    blnEncontrado = buscaNombre(strFirma, STR_NOMBRE_FICHERO);

                    if (!blnEncontrado) {
                        escribeNombre(strFirma, STR_NOMBRE_FICHERO);
                    } else {
                        System.out.println("Su firma ya se encuentra en el libro.");
                    }
                }
                case 2 -> imprimeLibro(STR_NOMBRE_FICHERO);
                case 3 -> System.out.println("Finalizando el programa...");
                case 0 -> System.out.println("Ha introducido un valor no numérico.");
                default -> System.out.println("La opción introducida no es válida.");
            }

            System.out.println();
        } while (intOpcion != 3);
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el menú y, además, devolver la opción elegida por el usuario.                       *
     *                                                                                                                 *
     * @return El método devuelve un int con la opción elegida por el usuario.                                         *
     *******************************************************************************************************************/
    private static int muestraMenu() {
        System.out.println("""
                Selecciona una opción:
                1. Introducir una nueva firma.
                2. Listar todas las firmas.
                3. Salir.""");
        System.out.print("Opción: ");

        //BLOQUE TRY-WITH-RESOURCES PARA UN SCANNER
        try (Scanner scEntrada = new Scanner(System.in)){
            return Integer.parseInt(scEntrada.nextLine());
        } catch (NumberFormatException e) { //En caso de que el texto introducido por el usuario no se pueda convertir a int.
            return 0;
        }
    }

    /*******************************************************************************************************************
     * Método encargado de buscar un nombre dentro de un fichero.                                                      *
     *                                                                                                                 *
     * @param strNombre String con un nombre.                                                                          *
     * @param strNombreFichero String con el nombre del fichero.                                                       *
     * @return Devuelve un booleano en función de si se ha encontrado o no el nombre.                                  *
     *******************************************************************************************************************/
    private static boolean buscaNombre(String strNombre, String strNombreFichero) {
        String strLinea; //String que guardará el contenido de una línea del documento.

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto06_LibroFirmas/documentos/" + strNombreFichero))) {
            strLinea = br.readLine();
            while (strLinea != null) {
                if (strLinea.equals(strNombre)) {
                    return true;
                }
                strLinea = br.readLine();
            }
        } catch (FileNotFoundException e) { //En caso de que el archivo no exista.
            System.out.println("No se encontró el fichero \"" + strNombreFichero + "\".");
        } catch (IOException e) { //En caso de que haya un error de lectura.
            System.out.println("Se produjo un error durante la lectura del fichero \"" + strNombreFichero + "\".");
        }

        return false;
    }

    /*******************************************************************************************************************
     * Método encargado de escribir un nuevo nombre en el fichero que actúa como contenedor de firmas.                 *
     *                                                                                                                 *
     * @param strNombre String que contiene el nombre que se debe incluir en el fichero.                               *
     * @param strNombreFichero String que contiene el nombre del fichero.                                              *
     *******************************************************************************************************************/
    private static void escribeNombre(String strNombre, String strNombreFichero) {
        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED WRITER
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto06_LibroFirmas/documentos/" + strNombreFichero, true))) {
            bw.write(strNombre);
            bw.newLine();
            System.out.println("Firma añadida con éxito en el libro.");
        } catch (IOException e) { //En caso de un error de escritura en el fichero.
            System.out.println("Se produjo un error durante la escritura del fichero \"" + strNombreFichero + "\".");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir por pantalla el contenido de un fichero.                                           *
     *                                                                                                                 *
     * @param strNombreFichero String que contiene el nombre del fichero.                                              *
     *******************************************************************************************************************/
    private static void imprimeLibro(String strNombreFichero){
        String strLinea;

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED WRITER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto06_LibroFirmas/documentos/" + strNombreFichero))) {
            strLinea = br.readLine();

            if (strLinea == null) {
                System.out.println("No existen firmas en el libro.");
            } else {
                System.out.println("FIRMAS DEL LIBRO");
            }

            while (strLinea != null) {
                System.out.println(strLinea);
                strLinea = br.readLine();
            }
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se encontró el fichero " + strNombreFichero);
        } catch (IOException e) { //En caso de que se produzca un error durante la lectura del fichero.
            System.out.println("Se produjo un error durante la lectura del fichero " + strNombreFichero);
        }
    }
}

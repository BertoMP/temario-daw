package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto03_DosListasEnUna.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final int INT_CANT_FICHEROS = 2; //Int con el número total de ficheros a leer.

        //DECLARACIÓN DE VARIABLES
        int[] intNumeros = new int[0]; //Array de int para guardar los números que se encuentren en los ficheros.
        int intNum; //Int para almacenar cada número del documento.
        String strLinea; //String para almacenar cada línea del documento
        String strNombreDocumento; //String que guarda el nombre del documento a leer.
        String strNombreDocumentoFinal; //String qu guarda el nombre del documento a escribir.

        for (int intCont = 1; intCont <= INT_CANT_FICHEROS; intCont++) {
            strNombreDocumento = dimeNombreDocumento(intCont);
            //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER
            try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                    "ejerciciosPropuestos/ejercicioPropuesto03_DosListasEnUna/documentos/" + strNombreDocumento))) {
                strLinea = br.readLine();
                while (strLinea != null) {
                    try { //Intenta convertir la línea en un entero
                        intNum = Integer.parseInt(strLinea);
                        intNumeros = Arrays.copyOf(intNumeros, intNumeros.length + 1);
                        intNumeros[intNumeros.length - 1] = intNum;
                    } catch (NumberFormatException ignored) {} //En caso de no poder convertir la línea en número, lo ignora.
                    strLinea = br.readLine();
                }
            } catch (FileNotFoundException e) { //En caso de no encontrar el archivo.
                System.out.println("No se encontró el fichero " + strNombreDocumento);
            } catch (IOException e) { //En caso de que se produzca un error en la lectura del archiv.
                System.out.println("Se produjo un error durante la lectura de " + strNombreDocumento);
            }
        }

        Arrays.sort(intNumeros);

        do {
            System.out.print("Dime el nombre que le quieres dar al documento con todos los números: ");
            strNombreDocumentoFinal = new Scanner(System.in).nextLine();
            if (strNombreDocumentoFinal.isEmpty()) {
                System.out.println("El nombre del documento no puede estar vacío. Vuelve a introducir un nombre.");
            }
        } while (strNombreDocumentoFinal.isEmpty());

        if (!strNombreDocumentoFinal.contains(".txt")) {
            strNombreDocumentoFinal += ".txt";
        }

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED WRITER
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto03_DosListasEnUna/documentos/" + strNombreDocumentoFinal))) {
            for (int intValor : intNumeros) {
                bw.write(Integer.toString(intValor));
                bw.newLine();
            }
            System.out.println("Fichero \"" + strNombreDocumentoFinal + "\" creado con éxito.");
        } catch (IOException e) { //En caso de que se produzca un error durante la escritura.
            System.out.println("Se produjo un error durante la escritura del documento " + strNombreDocumentoFinal);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el nombre del archivo a leer.                                                      *
     *                                                                                                                 *
     * @param intNum Número del archivo.                                                                               *
     * @return El método devuelve un String que contiene el nombre del archivo a leer.                                 *
     *******************************************************************************************************************/
    private static String dimeNombreDocumento(int intNum) {
        String strReturn = "";

        switch (intNum) {
            case 1 -> strReturn = "pares.txt";
            case 2 -> strReturn = "impares.txt";
        }

        return strReturn;
    }
}

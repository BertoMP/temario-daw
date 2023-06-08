package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto10_Comp.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        String STR_NOMBRE_FICH1 = "texto1.txt"; //Constante String que almacena el nombre del fichero1.
        String STR_NOMBRE_FICH2 = "texto2.txt"; //Constante String que almacena el nombre del fichero2.

        //DECLARACIÓN DE VARIABLES
        String strLineaF1; //String que contiene una línea del fichero1.
        String strLineaF2; //String que contiene una línea del fichero2.
        boolean blnSonDiferentes = false; //Boolean que actuará como bandera.
        int intContLinea = 0; //Int que funciona como contador.

        //BLOQUE TRY-WITH-RESOURCES PARA DOS BUFFERED READERS
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto10_Comp/documentos/" + STR_NOMBRE_FICH1));
             BufferedReader br2 = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                     "ejerciciosPropuestos/ejercicioPropuesto10_Comp/documentos/" + STR_NOMBRE_FICH2))){
            strLineaF1 = br.readLine();
            strLineaF2 = br2.readLine();
            while (strLineaF1 != null && strLineaF2 != null && !blnSonDiferentes) {
                intContLinea++;
                if (!strLineaF1.equals(strLineaF2)) {
                    blnSonDiferentes = true;
                } else {
                    strLineaF1 = br.readLine();
                    strLineaF2 = br2.readLine();
                }
            }
            if (blnSonDiferentes) {
                System.out.println("Los documentos son distintos.");
                System.out.println("La primera diferencia se encuentra en: ");
                System.out.println("\t - Línea: " + intContLinea);
                comparaCadenas(strLineaF1, strLineaF2);
            } else {
                System.out.println("Los documentos son iguales.");
            }
        } catch (FileNotFoundException e) { //En caso de que un fichero no se encuentre.
            System.out.println("No se ha encontrado uno de los archivos necesarios: \""
                    + STR_NOMBRE_FICH1 + "\" y \"" + STR_NOMBRE_FICH2 + "\".");
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error durante la lectura de los archivos \""
                    + STR_NOMBRE_FICH1 + "\" y \"" + STR_NOMBRE_FICH2 + "\".");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de comparar dos cadenas que se pasan por parámetro.                                            *
     *                                                                                                                 *
     * @param strCadena1 String que contiene una cadena de texto.                                                      *
     * @param strCadena2 String que contiene otra cadena de texto.                                                     *
     *******************************************************************************************************************/
    private static void comparaCadenas(String strCadena1, String strCadena2) {
        //DECLARACIÓN DE VARIABLES
        boolean blnBandera = false; //Booleano que actuará como bandera.
        int intCont; //Int que funcionará como un contador.

        for (intCont = 0; intCont < strCadena1.length() && intCont < strCadena2.length() && !blnBandera; intCont++) {
            if (strCadena1.charAt(intCont) != strCadena2.charAt(intCont)) {
                blnBandera = true;
                System.out.println("\t - Se diferencian en el carácter de la posición " + (intCont + 1));
                System.out.println("\t\t - Carácter fichero 1: " + strCadena1.charAt(intCont));
                System.out.println("\t\t - Carácter fichero 2: " + strCadena2.charAt(intCont));
            }
        }

        if (!blnBandera && intCont == strCadena1.length()) {
            System.out.println("\t - Se diferencian porque la línea del fichero 2 tiene más caracteres.");
        } else if (!blnBandera && intCont == strCadena2.length()){
            System.out.println("\t - Se diferencian porque la línea del fichero 1 tiene más caracteres.");
        }
    }
}

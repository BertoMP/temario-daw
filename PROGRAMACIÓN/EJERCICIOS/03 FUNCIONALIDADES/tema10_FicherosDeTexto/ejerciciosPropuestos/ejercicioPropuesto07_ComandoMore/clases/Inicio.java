package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto07_ComandoMore.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final int INT_NUM_LINEAS_MUESTRA = 24; //Constante int que almacena el número de líneas a mostrar.
        final String STR_NOMBRE_FICHERO = "fichero.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        int intContadorLinea = 1; //Int que funciona como contador.
        String strLinea; //String que guardará cada línea que se lea.
        char chrUsuario = 0; //Char que guardará la opción del usuario.

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER Y UN SCANNER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto07_ComandoMore/documentos/" + STR_NOMBRE_FICHERO));
             Scanner scEntrada = new Scanner(System.in)){

            strLinea = br.readLine();
            while (strLinea != null && chrUsuario != 'q') {
                for (int intCont = 0; intCont < INT_NUM_LINEAS_MUESTRA && strLinea != null; intCont++, intContadorLinea++) {
                    System.out.println(intContadorLinea + " " + strLinea);
                    strLinea = br.readLine();
                }

                if (strLinea != null) {
                    System.out.println("\nIntroduce una letra para seguir leyendo o 'q' para salir.");
                    chrUsuario = scEntrada.nextLine().charAt(0);
                }
            }

            if (chrUsuario == 'q') {
                System.out.println("Finalizando...");
            } else {
                System.out.println("FIN DEL DOCUMENTO");
            }
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se encontró el fichero \"" + STR_NOMBRE_FICHERO + "\".");
        } catch (IOException e) { //En caso de se produzca un error de lectura en el fichero.
            System.out.println("Se produjo un error en la lectura del fichero \"" + STR_NOMBRE_FICHERO + "\".");
        }
    }
}

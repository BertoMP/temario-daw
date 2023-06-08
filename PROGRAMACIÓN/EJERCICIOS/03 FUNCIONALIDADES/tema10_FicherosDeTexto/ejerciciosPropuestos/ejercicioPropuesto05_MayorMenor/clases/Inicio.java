package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto05_MayorMenor.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final int INT_CANTIDAD_NUMEROS = 10; //Int que guarda la cantidad de números a guardar en el documento.
        final int INT_NUM_MAX = 200; //Int que guarda el máximo posible.
        final String STR_NOMBRE_FICHERO = "numeros.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        int[] intNumeros = new int[0]; //Array que guardará los números del documento.
        String strLinea; //String que guardará la línea leída.
        int intNumAleatorio; //Int que guardará un número aleatorio.

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED WRITER
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto05_MayorMenor/documentos/" + STR_NOMBRE_FICHERO))) {
            for (int intCont = 0; intCont < INT_CANTIDAD_NUMEROS; intCont++) {
                intNumAleatorio = (int) (Math.random() * INT_NUM_MAX) + 1;
                bw.write(Integer.toString(intNumAleatorio));
                bw.newLine();
            }
        } catch (IOException e) { //En caso de que haya un error de escritura.
            System.out.println("Se produjo un error en la escritura del fichero \"numeros.txt\"");
        }

        //BLOQUE TRY-WITH-RESOURCES PARA UN BUFFERED READER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto05_MayorMenor/documentos/numeros.txt"))) {
            strLinea = br.readLine();
            while (strLinea != null) {
                //BLOQUE TRY-WITH-RESOURCES PARA UN SCANNER
                try (Scanner scLectura = new Scanner(strLinea)) {
                    if (scLectura.hasNextInt()) {
                        intNumeros = Arrays.copyOf(intNumeros, intNumeros.length + 1);
                        intNumeros[intNumeros.length - 1] = scLectura.nextInt();
                    }
                }
                strLinea = br.readLine();
            }
            System.out.println("Estos son los números del array: ");
            System.out.println(Arrays.toString(intNumeros));
            Arrays.sort(intNumeros);
            System.out.println("\t - Número menor: " + intNumeros[0]);
            System.out.println("\t - Número mayor: " + intNumeros[intNumeros.length - 1]);
        } catch (FileNotFoundException e) { //En caso de aque no se encuentre el fichero.
            System.out.println("No se pudo encontrar el fichero \"" + STR_NOMBRE_FICHERO + "\".");
        } catch (IOException e) { //En caso de que se produzca un error de lectura en el fichero.
            System.out.println("Se produjo un error en la lectura del fichero \"" + STR_NOMBRE_FICHERO + "\".");
        }
    }
}

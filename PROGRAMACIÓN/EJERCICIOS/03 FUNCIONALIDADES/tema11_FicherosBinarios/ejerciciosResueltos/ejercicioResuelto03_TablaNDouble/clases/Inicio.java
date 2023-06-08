package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto03_TablaNDouble.clases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE = "decimales.dat"; //Constante String que guarda el nombre del fichero.

        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in);

        //DECLARACIÓN DE VARIABLES
        int intNum; //Int que almacena el número de decimales a guardar.
        int intCont = 0; //Int que gunciona como contador.
        double[] rlnArrNum; //Array de double donde se guardarán los números introducidos por teclado.

        do {
            System.out.print("Introduzca cantidad de decimales a guardar: ");
            try {
                intNum = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) { //En caso de no introducir un valor válido.
                System.out.println("Debe introducir un valor válido.");
                intNum = 0;
            }
        } while (intNum < 1);

        rlnArrNum = new double[intNum];

        do {
            System.out.print("Introduzca el " + (intCont + 1) + "º número decimal: ");
            try {
                rlnArrNum[intCont] = Double.parseDouble(scEntrada.nextLine());
                intCont++;
            } catch (NumberFormatException e) { //En caso de no introducir un valor válido
                System.out.println("No ha introducido un valor válido. Debe introducir un número");
            }
        } while (intCont < rlnArrNum.length);

        scEntrada.close();

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream
                ("src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto03_TablaNDouble/documentos/"
                        + STR_NOMBRE))) {
            outputStream.writeObject(rlnArrNum);
        } catch (FileNotFoundException e) { //En caso de que el archivo no se encuentre.
            System.out.println("No se encontró el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error en la escritura del fichero " + STR_NOMBRE);
        }
    }
}

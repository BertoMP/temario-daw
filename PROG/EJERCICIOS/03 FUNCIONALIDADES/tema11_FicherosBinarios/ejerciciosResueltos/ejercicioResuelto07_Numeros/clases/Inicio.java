package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto07_Numeros.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE = "numeros.dat"; //Constante String que guarda el nombre del fichero.
        final String STR_NOMBRE2 = "numerosCopia.dat"; //Constante String que guarda el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        int intNum = 0; //Variable int que guardará los números introducidos por el usuario.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto07_Numeros/documentos/"
                        + STR_NOMBRE));
             Scanner scEntrada = new Scanner(System.in)) {
            System.out.print("Introduce un entero: ");
            try {
                intNum = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) { //En caso de introducir un dato no válido.
                System.out.println("Numero introducido no válido. Finalizando ejecución.");
                intNum = -1;
            }

            while (intNum != -1) {
                outputStream.writeInt(intNum);
                System.out.print("Introduce un entero: ");
                try {
                    intNum = Integer.parseInt(scEntrada.nextLine());
                } catch (NumberFormatException e) { //En caso de introducir un dato no válido.
                    System.out.println("Numero introducido no válido. Finalizando ejecución.");
                    intNum = -1;
                }
            }
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se encontró el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Fallo en la escritura del fichero " + STR_NOMBRE);
        }

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto07_Numeros/documentos/"
                        + STR_NOMBRE));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                     "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto07_Numeros/documentos/"
                             + STR_NOMBRE2))) {
            while (true) {
                try {
                    intNum = inputStream.readInt();
                    System.out.print(intNum + " ");
                } catch (IOException e) { //En caso de que se produzca un error de lectura.
                    System.out.println("Se produjo un error en la lectura del fichero " + STR_NOMBRE);
                }
                try {
                    outputStream.writeInt(intNum);
                } catch (IOException e) { //En caso de que se produzca un error de escritura.
                    System.out.println("Se produjo un error de escritura en el fichero" + STR_NOMBRE2);
                }
            }
        } catch (EOFException ignored) { //En caso de llegar al final del fichero.
        } catch (FileNotFoundException e) { //En caso de no encontrar un fichero.
            System.out.println("No se encontró el fichero " + STR_NOMBRE + " o el fichero " + STR_NOMBRE2);
        } catch (IOException e) { //En caso de error de lectura o escritura.
            System.out.println("Error de lecto-escritura.");
        }
    }
}

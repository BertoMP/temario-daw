package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto17_TextoLineaALinea.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto17_TextoLineaALinea/documentos/texto.dat"); //File que contiene el fichero donde se almacenarán los Strings.

        //DECLARACIÓN DE VARIABLES
        String strLinea; //String que almacena la nueva línea a guardar en el fichero.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero));
            Scanner scEntrada = new Scanner(System.in)){

            System.out.print("Dime texto a introducir en el fichero (o introduce una línea en blanco para finalizar): ");
            strLinea = scEntrada.nextLine();

            while (!strLinea.isEmpty()) {
                escritura.writeObject(strLinea);
                System.out.print("Dime texto a introducir en el fichero (o introduce una línea en blanco para finalizar): ");
                strLinea = scEntrada.nextLine();
            }

        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (IOException e) { //En caso de que se produzca un error de escritura en el fichero.
            System.out.println("Se produjo un error en la escritura del fichero texto.dat.");
        }

        if (fichero.exists()) {
            System.out.println("\nLeyendo fichero...");
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
                while (true) {
                    System.out.println((String) lectura.readObject());
                }
            } catch (EOFException e) { //En caso de que se alcance el final del fichero.
                System.out.println("Final del fichero texto.dat.");
            } catch (FileNotFoundException ignored) { //En caso de que no exista el fichero.
            } catch (IOException e) { //En caso de que se produzca un error de lectura en el fichero.
                System.out.println("Se produjo un error en la lectura del fichero texto.dat.");
            } catch (ClassNotFoundException e) { //En caso de que no se encuentro un objeto de la clase indicada.
                System.out.println("No se ha encontrado un String en el fichero texto.dat.");
            }
        }
    }
}

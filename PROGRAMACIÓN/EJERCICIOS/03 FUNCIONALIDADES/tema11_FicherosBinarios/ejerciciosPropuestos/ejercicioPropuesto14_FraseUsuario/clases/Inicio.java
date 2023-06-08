package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto14_FraseUsuario.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File archivo = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto14_FraseUsuario/documentos/frase.dat"); //Objeto File que guarda la ruta del fichero.
        String strFraseUsuario; //String que almacena la frase del usuario.

        System.out.print("Dime la frase a guardar: ");
        strFraseUsuario = new Scanner(System.in).nextLine();

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(archivo))) {
            escritura.writeObject(strFraseUsuario);
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se encontró el fichero frase.dat.");
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error de escritura en el fichero frase.dat.");
        }

        if (archivo.exists()) {
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo))) {
                while (true) {
                    System.out.println((String) lectura.readObject());
                }
            } catch (EOFException e) { //En caso de que se alcance el final del fichero.
                System.out.println("Fin del fichero frase.dat");
            } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
                System.out.println("No se encontró el fichero frase.dat.");
            } catch (IOException e) { //En caso de que se produzca un error de lectura o de escritura.
                System.out.println("Se produjo un error de lectura del fichero frase.dat.");
            } catch (ClassNotFoundException e) { //En caso de que no se encuentre un objeto de la clase indicada.
                System.out.println("El fichero frase.dat no contiene un String.");
            }
        }
    }
}

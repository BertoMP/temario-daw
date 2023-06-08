package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto11_GuardarDouble.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File archivo = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto11_GuardarDouble/documentos/double.dat"); //Objeto File que guarda la ruta del fichero.

        //DECLARACIÓN DE VARIABLES
        double rlnNumUsuario = 0; //Variable double que guarda el número decimal introducido por el usuario.
        boolean blnNumeroValido = false; //Variable boolean que actúa como bandera.

        do {
            System.out.print("Dime un número decimal: ");
            try {
                rlnNumUsuario = Double.parseDouble(new Scanner(System.in).nextLine());
                blnNumeroValido = true;
            } catch (NumberFormatException e) { //En caso de que no se produzca un número válido.
                System.out.println("No has introducido un valor válido. Debe ser un número.");
            }
        } while (!blnNumeroValido);

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream lectura = new ObjectOutputStream(new FileOutputStream(archivo))) {
            lectura.writeDouble(rlnNumUsuario);
        } catch (FileNotFoundException e) { //En caso de que el fichero no exista.
            System.out.println("No se ha encontrado el fichero double.dat.");
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error de escritura en el fichero double.dat.");
        }
    }
}


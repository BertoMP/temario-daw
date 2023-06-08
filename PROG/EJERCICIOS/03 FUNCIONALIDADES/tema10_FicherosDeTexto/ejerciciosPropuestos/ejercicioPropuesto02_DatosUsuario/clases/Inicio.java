package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto02_DatosUsuario.clases;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE_FICHERO = "datos.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que guardará el nombre del usuario.
        byte bytEdad = 0; //Int que guardará la edad del usuario.

        //BLOQUE TRY-WITH-RESOURCES PARA INTENTAR ABRIR UN BUFFERED WRITER Y UN SCANNER
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto02_DatosUsuario/documentos/" + STR_NOMBRE_FICHERO, true));
             Scanner scEntrada = new Scanner(System.in)) {

            System.out.print("Dime el nombre del usuario: ");
            strNombre = scEntrada.nextLine();

            do {
                System.out.print("Dime la edad del usuario: ");
                try { //Intenta convertir el dato introducido en un dato de tipo byte.
                    bytEdad = Byte.parseByte(scEntrada.nextLine());
                    if (bytEdad < 0 || bytEdad > 120) {
                        System.out.println("Debe introducir una edad comprendida entre 0 y 120 años.");
                    }
                } catch (NumberFormatException e) { //En caso de que el dato no pueda ser convertido.
                    System.out.println("Error: La edad debe ser un número entero. Vuelva a intentarlo.");
                }
            } while (bytEdad < 0 || bytEdad > 120);

            bw.write(strNombre + "\t" + bytEdad);
            bw.newLine();
            System.out.println("Usuario agregado correctamente.");
        } catch (IOException e) { //En caso de que se produzca un error de escritura
            System.out.println("Se produjo un error durante la escritura del fichero \"" + STR_NOMBRE_FICHERO + "\".");
        }
    }
}

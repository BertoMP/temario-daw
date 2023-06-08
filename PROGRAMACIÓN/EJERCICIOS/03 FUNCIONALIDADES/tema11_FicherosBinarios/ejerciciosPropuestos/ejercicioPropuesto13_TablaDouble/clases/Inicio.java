package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto13_TablaDouble.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File archivo = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto13_TablaDouble/documentos/tablaDouble.dat"); //Objeto File que guarda la ruta del fichero.
        double[] rlnArrNumeros; //Array de double que guardará los números.

        //DECLARACIÓN DE VARIABLES
        double rlnNumAleatorio; //Variable double que guardará el siguiente número aleatorio.
        int intCantidad = 0; //Variable int que almacena la cantidad de números decimales a guardar.

        do {
            System.out.print("Dime cantidad de números decimales que quieres guardar: ");
            try {
                intCantidad = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) { //En caso de que no se introduzca un valor válido.
                System.out.println("No has introducido un valor válido.");
            }
            if (intCantidad < 1) {
                System.out.println("La cantidad debe ser un valor positivo.");
            }
        } while (intCantidad < 1);

        rlnArrNumeros = new double[intCantidad];

        for (int intCont = 0; intCont < rlnArrNumeros.length; intCont++) {
            rlnNumAleatorio = Math.random() * 10;
            rlnArrNumeros[intCont] = rlnNumAleatorio;
        }

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(archivo))) {
            escritura.writeObject(rlnArrNumeros);
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se ha encontrado el fichero tablaDouble.dat.");
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se ha producido un error de escritura en el fichero tablaDouble.dat.");
        }

        if (archivo.exists()) {
            //BLOQUE TRY-CATCH WITH RESOURCES
            try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo))) {
                while (true) {
                    System.out.println(Arrays.toString((double[]) lectura.readObject()));
                }
            } catch (EOFException e) { //En caso de llegar al final del fichero.
                System.out.println("Fin del fichero tablaDouble.dat.");
            } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
                System.out.println("No se ha encontrado el fichero tablaDouble.dat.");
            } catch (IOException e) { //En caso de que se produzca un error de lectura.
                System.out.println("Se ha producido un error de lectura en el fichero tablaDouble.dat.");
            } catch (ClassNotFoundException e) { //En caso de que no se encuentre un objeto de la clase indicada.
                System.out.println("El fichero tablaDouble.dat no contiene un array de doubles.");
            }
        }
    }
}

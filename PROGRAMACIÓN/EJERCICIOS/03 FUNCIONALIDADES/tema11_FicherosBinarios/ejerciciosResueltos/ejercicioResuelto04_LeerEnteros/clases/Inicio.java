package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto04_LeerEnteros.clases;

import java.io.*;
import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE = "enteros.dat"; //Constante String que guarda el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        int[] intArrNumeros = new int[10]; //Array de int que guardará los números.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream
                ("src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto04_LeerEnteros/documentos/"
                        + STR_NOMBRE))) {
            for (int intCont = 0; intCont < intArrNumeros.length; intCont++) {
                intArrNumeros[intCont] = inputStream.readInt();
            }
        } catch (EOFException ignored) { //En caso de llegar al final del fichero.
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se encontró el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que ocurra un error de lectura.
            System.out.println("Se produjo un error en la lectura del fichero " + STR_NOMBRE);
        }

        System.out.println(Arrays.toString(intArrNumeros));
    }
}

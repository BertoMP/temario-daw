package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto05_LeerTablaEnteros.clases;

import java.io.*;
import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        final String STR_NOMBRE = "datos.dat"; //Constante String que guarda el nombre del fichero.
        int[] intArrNumeros; //Array de int que guarda los números.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto05_LeerTablaEnteros/documentos/"
                        + STR_NOMBRE))) {
            intArrNumeros = (int[]) inputStream.readObject();
            System.out.println(Arrays.toString(intArrNumeros));
        } catch (EOFException ignored) { //En caso de llegar al final del fichero.
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se encontró el fichero " + STR_NOMBRE);
        } catch (ClassNotFoundException e) { //En caso de que el archivo no contenga el objeto seleccionado.
            System.out.println("El fichero no almacena un objeto de tipo tabla enteros.");
        } catch (IOException e) { //En caso de que ocurra un error de lectura.
            System.out.println("Se produjo un error en la lectura del fichero " + STR_NOMBRE);
        }
    }
}

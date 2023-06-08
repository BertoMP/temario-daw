package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto01_Tabla10Enteros.clases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_ARCHIVO = "datos.dat"; //Constante String que guarda el nombre del fichero.

        //DECLARACIÓN DE VARIABLES
        int[] intArrNumeros = {0,1,2,3,4,5,6,7,8,9}; //Array de int que guarda los números a escribir.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto01_Tabla10Enteros/documentos/"
                        + STR_ARCHIVO))) {
            for (int intValor : intArrNumeros) {
                oos.writeInt(intValor);
            }
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se encontró el fichero " + STR_ARCHIVO + ".");
        } catch (IOException e) { //En caso de fallo en la escritura del fichero.
            System.out.println("Se produjo de escritura en el fichero " + STR_ARCHIVO + ".");
        }
    }
}

package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto18_LibroFirmas.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto18_LibroFirmas/documentos/firmas.dat"); //File que contiene el fichero donde se almacenarán las firmas.

        //DECLARACIÓN DE VARIABLES
        String[] strArrFirmas; //Array de String que almacenará las firmas.
        int intOpcion; //Int que guardará la opción elegida por el usuario.

        strArrFirmas = fichero.exists() ? generaListado(fichero) : new String[0];

        intOpcion = muestraMenu();

        switch (intOpcion) {
            case 0 -> System.out.println("El valor introducido no es numérico.");
            case 1 -> muestraLibro(strArrFirmas);
            case 2 -> addFirma(strArrFirmas, fichero);
            default -> System.out.println("El valor introducido está fuera de rango.");
        }
    }

    /*******************************************************************************************************************
     * Muestra un menú con opciones y solicita al usuario que seleccione una opción.                                   *
     *                                                                                                                 *
     * @return El número de opción seleccionado por el usuario, o 0 si se produce una excepción al intentar leer       *
     *         la entrada del usuario.                                                                                 *
     *******************************************************************************************************************/
    private static int muestraMenu() {
        System.out.println("""
                Elige una opción:
                    1. Mostrar las firmas contenidas en el libro.
                    2. Añadir una nueva firma.""");
        System.out.print("Opción: ");
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) { //En caso de que se introduzca un formato numérico no válido.
            return 0;
        }
    }

    /*******************************************************************************************************************
     * Lee un array de Strings desde un fichero utilizando un ObjectInputStream y lo devuelve.                         *
     *                                                                                                                 *
     * @param fichero El fichero que contiene el array de Strings.                                                     *
     * @return El array de Strings leído del fichero, o un array vacío si se produce una excepción durante la lectura. *
     *******************************************************************************************************************/
    private static String[] generaListado(File fichero) {
        //DECLARACIÓN DE VARIABLES
        String[] strArrReturn = new String[0]; //Array de String que se devolverá

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            strArrReturn = (String[]) lectura.readObject();
        } catch (FileNotFoundException e){
            System.out.println("No se ha encontrado el fichero.");
        } catch (IOException e) {
            System.out.println("Se produjo un error de lectura en el fichero.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado un objeto de la clase array de Strings en el fichero.");
        }

        return strArrReturn;
    }

    /*******************************************************************************************************************
     * Muestra por consola cada elemento de un array de Strings.                                                       *
     *                                                                                                                 *
     * @param strArrNombres El array de Strings que se desea mostrar.                                                  *
     *******************************************************************************************************************/
    private static void muestraLibro(String[] strArrNombres) {
        System.out.println("\nLISTADO DE FIRMAS");
        for (String strValor : strArrNombres) {
            System.out.println(strValor);
        }
    }

    /*******************************************************************************************************************
     * Añade una firma al array de Strings y lo guarda en un fichero.                                                  *
     *                                                                                                                 *
     * @param strArrNombres El array de Strings al que se desea añadir la firma.                                       *
     * @param fichero El fichero en el que se desea guardar el array de Strings actualizado.                           *
     *******************************************************************************************************************/
    private static void addFirma(String[] strArrNombres, File fichero) {
        String strNombre;

        do {
            System.out.print("Dime nombre a introducir: ");
            strNombre = new Scanner(System.in).nextLine().toLowerCase();

            if (strNombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (strNombre.isEmpty());

        if (!buscaNombre(strNombre, strArrNombres)) {
            strArrNombres = Arrays.copyOf(strArrNombres, strArrNombres.length + 1);
            strArrNombres[strArrNombres.length - 1] = strNombre;
            escribeLibro(strArrNombres, fichero);
        } else {
            System.out.println("El fichero ya contiene esa firma.");
        }
    }

    /*******************************************************************************************************************
     * Busca un nombre en un array de Strings.                                                                         *
     * @param strNombre El nombre que se desea buscar en el array.                                                     *
     * @param strArrNombres El array de Strings en el que se desea buscar el nombre.                                   *
     * @return true si el nombre está en el array, false en caso contrario.                                            *
     *******************************************************************************************************************/
    private static boolean buscaNombre(String strNombre, String[] strArrNombres) {
        for (String strValor : strArrNombres) {
            if (strValor.equals(strNombre)) {
                return true;
            }
        }
        return false;
    }

    /*******************************************************************************************************************
     * Escribe un array de Strings en un archivo usando ObjectOutputStream.                                            *
     *                                                                                                                 *
     * @param strArrNombres El array de Strings que se desea escribir en el archivo.                                   *
     * @param fichero El archivo en el que se desea escribir el array de Strings.                                      *
     *******************************************************************************************************************/
    private static void escribeLibro(String[] strArrNombres, File fichero) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(strArrNombres);
            System.out.println("Nombre introducido con éxito.");
        } catch (FileNotFoundException ignored){
        } catch (IOException e) {
            System.out.println("Se produjo un error de escritura en el fichero firmas.dat.");
        }
    }
}

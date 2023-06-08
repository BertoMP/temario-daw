package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto19_ListadoLlamadas.clases;

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
                "ejercicioPropuesto19_ListadoLlamadas/documentos/registroLlamadas.dat"); //File que contiene el fichero donde se almacenará el registro de llamadas.

        //DECLARACIÓN DE VARIABLES
        Registro[] arrRegistros; //Array de objetos Registro que almacenará los registros.
        int intOpcion; //Int que guarda la opción del usuario en el menú.

        arrRegistros = fichero.exists() ? generaRegistro(fichero) : new Registro[0];

        intOpcion = muestraMenu();

        switch (intOpcion) {
            case 0 -> System.out.println("El valor introducido no es numérico.");
            case 1 -> muestraRegistro(arrRegistros);
            case 2 -> addRegistro(arrRegistros, fichero);
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
                    1. Mostrar los registros previos.
                    2. Añadir un nuevo registro.""");
        System.out.print("Opción: ");
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) { //En caso de que no se introduzca un número en un formato válido.
            return 0;
        }
    }

    /*******************************************************************************************************************
     * Genera un array de objetos de tipo Registro a partir de los datos almacenados en un fichero de objetos.         *
     *                                                                                                                 *
     * @param fichero El fichero de objetos del que se desea leer los datos.                                           *
     * @return Un array de objetos de tipo Registro con los datos leídos del fichero. Si se produce un error al leer   *
     *         el fichero, se devuelve un array vacío.                                                                 *
     *******************************************************************************************************************/
    private static Registro[] generaRegistro(File fichero) {
        //DECLARACIÓN DE VARIABLES
        Registro[] registrosReturn = new Registro[0]; //Array de registros que se devolverá como resultado del método.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            registrosReturn = (Registro[]) lectura.readObject();
        } catch (FileNotFoundException ignored){ //En caso de que el fichero no se encuentre.
        } catch (IOException e) { //En caso de que se produzca un error de lectura en el fichero.
            System.out.println("Se produjo un error de lectura en el fichero.");
        } catch (ClassNotFoundException e) { //En caso de que no se encuentre un objeto de la clase indicada.
            System.out.println("No se ha encontrado un objeto de la clase array de Strings en el fichero.");
        }

        return registrosReturn;
    }

    /*******************************************************************************************************************
     * Muestra por pantalla los registros presentes en un array de objetos Registro que se pasa por parámetro.         *
     *                                                                                                                 *
     * @param arrRegistros El array de objetos Registro a mostrar.                                                     *
     *******************************************************************************************************************/
    private static void muestraRegistro(Registro[] arrRegistros) {
        for (Registro registroValor : arrRegistros) {
            System.out.println(registroValor);
        }
    }

    /*******************************************************************************************************************
     * Agrega un nuevo registro al arreglo de registros y lo escribe en el archivo indicado.                           *
     *                                                                                                                 *
     * @param arrRegistros el arreglo de registros actual.                                                             *
     * @param fichero el archivo en el que se escribirá el arreglo actualizado.                                        *
     *******************************************************************************************************************/
    private static void addRegistro(Registro[] arrRegistros, File fichero) {
        //DECLARACIÓN DE VARIABLES
        boolean blnNumeroValido; //Variable booleana que actúa como bandera.
        int intCantidadLlamadas = 0; //Int que guarda la cantidad de llamadas a registrar.

        do {
            System.out.print("Dime número de llamadas recibidas: ");
            try {
                intCantidadLlamadas = Integer.parseInt(new Scanner(System.in).nextLine());
                blnNumeroValido = true;
            } catch (NumberFormatException e) { //En caso de que no se introduzca un número en un formato válido.
                System.out.println("El número introducido no es válido.");
                blnNumeroValido = false;
            }
        } while (!blnNumeroValido || intCantidadLlamadas < 0);

        arrRegistros = Arrays.copyOf(arrRegistros, arrRegistros.length + 1);
        arrRegistros[arrRegistros.length - 1] = new Registro(intCantidadLlamadas);

        escribeFichero(arrRegistros, fichero);
    }

    /*******************************************************************************************************************
     * Escribe el array de objetos Registro en un archivo especificado.                                                *
     *                                                                                                                 *
     * @param arrRegistros El array de objetos Registro que se va a escribir en el archivo.                            *
     * @param fichero El archivo en el que se va a escribir el array de objetos Registro.                              *
     *******************************************************************************************************************/
    private static void escribeFichero(Registro[] arrRegistros, File fichero) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(arrRegistros);
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            System.out.println("Se produjo un error de escritura en el fichero.");
        }
    }
}

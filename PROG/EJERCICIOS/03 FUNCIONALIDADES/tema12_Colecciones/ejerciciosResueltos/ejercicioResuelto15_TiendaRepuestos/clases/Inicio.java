package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto15_TiendaRepuestos.clases;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Map<String, Integer> registroStock; //Mapa con pareja código : unidades.
        File fichero = new File("src/tema12_Colecciones/ejerciciosResueltos/" + //Fichero donde leer/escribir los datos.
                "ejercicioResuelto15_TiendaRepuestos/documentos/stock.dat");

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que almacena la opción del usuario.

        registroStock = fichero.exists() ? leeFichero(fichero) : new TreeMap<>();

        do {
            intOpcionUsuario = muestraMenu(scEntrada);
            switch (intOpcionUsuario) {
                case 1 -> altaProducto(registroStock, scEntrada);
                case 2 -> bajaProducto(registroStock, scEntrada);
                case 3 -> modificaStock(registroStock, scEntrada);
                case 4 -> listaExistencias(registroStock);
                case 5 -> {
                    System.out.println("Finalizando...");
                    scEntrada.close();
                    escribeFichero(registroStock, fichero);
                }
                default -> System.out.println("La opción introducida está fuera de rango.");
            }
            System.out.println();
        } while (intOpcionUsuario != 5);

    }

    /*******************************************************************************************************************
     * Método encargado de leer un fichero y recuperar el mapa que tiene en su interior.                               *
     *                                                                                                                 *
     * @param fichero Fichero a leer.                                                                                  *
     * @return Devuelve un Map<String, Integer> leído del fichero.                                                     *
     *******************************************************************************************************************/
    private static Map<String, Integer> leeFichero(File fichero) {
        Map<String, Integer> mapaReturn = new TreeMap<>();

        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            mapaReturn = (TreeMap<String, Integer>) lectura.readObject();
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            System.out.println("Se produjo un error de lectura en el fichero stock.dat.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró un objeto de tipo TreeMap<String, Integer>.");
        }

        return mapaReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú de selección y devolver la opción elegida por el usuario.                   *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un valor int con la opción elegida por el usuario.                                             *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer integerOpcion = null; //Integer que guarda la opción del usuario.

        do {
            System.out.println("""
                Elige una opción:
                    1. Alta producto.
                    2. Baja producto.
                    3. Cambio stock de producto.
                    4. Listar existencias.
                    5. Salir.""");
            System.out.print("Opción: ");
            try {
                integerOpcion = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un número. Vuelve a introducir un número.");
            }
        } while (integerOpcion == null);

        return integerOpcion;
    }

    /*******************************************************************************************************************
     * Método encargado de añadir un producto al mapa pasado por parámetro.                                            *
     *                                                                                                                 *
     * @param mapaProductos Mapa donde guardar la nueva pareja producto : stock.                                       *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     *******************************************************************************************************************/
    private static void altaProducto(Map<String, Integer> mapaProductos, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strCodigoProducto; //String que almacena el código del producto.
        int intStock; //Int que almacena el stock del producto.

        strCodigoProducto = dimeCodigoProducto(scEntrada);

        if (!mapaProductos.containsKey(strCodigoProducto)) {
            intStock = dimeStock(scEntrada);

            mapaProductos.put(strCodigoProducto, intStock);
        } else {
            System.out.println("El producto ya existe.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar el código del producto y devolverlo como resultado de la función.                 *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un String con el código introducido por el usuario.                                            *
     *******************************************************************************************************************/
    private static String dimeCodigoProducto(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strCodigo; //String donde se almacenará el código.

        do {
            System.out.print("Dime código del producto: ");
            strCodigo = scEntrada.nextLine();
            if (strCodigo.isEmpty()) {
                System.out.println("El código no puede estar vacío.");
            }
        } while(strCodigo.isEmpty());
        return strCodigo;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar el stock y devolverlo como resultado de la función.                               *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un Integer con el stock introducido por el usuario.                                            *
     *******************************************************************************************************************/
    private static Integer dimeStock(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Integer intStock = null; //Integer que almacenará el stock.

        System.out.println("Dime stock del producto: ");
        do {
            try {
                intStock = Integer.parseInt(scEntrada.nextLine());
                if (intStock < 0) {
                    System.out.println("El stock no puede ser menor de 0. Se fija a 0.");
                    intStock = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("No se ha introducido un valor numérico.");
            }
        } while (intStock == null);

        return intStock;
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar un producto al mapa pasado por parámetro.                                          *
     *                                                                                                                 *
     * @param mapaProductos Mapa donde eliminar el elemento.                                                           *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     *******************************************************************************************************************/
    private static void bajaProducto(Map<String, Integer> mapaProductos, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strCodigoProducto; //String donde se almacenará el código.

        strCodigoProducto = dimeCodigoProducto(scEntrada);

        if (mapaProductos.remove(strCodigoProducto) > 0) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No existe un producto con ese código.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de eliminar el stock de un producto de mapa pasado por parámetro.                              *
     *                                                                                                                 *
     * @param mapaProductos Mapa donde modificar el stock.                                                             *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     *******************************************************************************************************************/
    private static void modificaStock(Map<String, Integer> mapaProductos, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strProducto; //String donde se almacenará el código.
        Integer intStock; //Integer que almacenará el stock.

        strProducto = dimeCodigoProducto(scEntrada);

        if (mapaProductos.containsKey(strProducto)) {
            intStock = dimeStock(scEntrada);
            mapaProductos.put(strProducto, intStock);
        } else {
            System.out.println("No existe ese producto.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de imprimir por pantalla el contenido del mapa pasado por parámetro.                           *
     *                                                                                                                 *
     * @param mapaProductos Mapa a imprimir.                                                                           *
     *******************************************************************************************************************/
    private static void listaExistencias(Map<String, Integer> mapaProductos) {
        for (Map.Entry<String, Integer> mapaEntryValor : mapaProductos.entrySet()) {
            System.out.println(mapaEntryValor);
        }
    }

    /*******************************************************************************************************************
     * Método encargado de escribir en un fichero el mapa pasado por parámetro.                                        *
     *                                                                                                                 *
     * @param mapaProductos Mapa a escribir.                                                                           *
     * @param fichero Fichero donde se debe escribir.                                                                  *
     *******************************************************************************************************************/
    private static void escribeFichero(Map<String, Integer> mapaProductos, File fichero) {
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(mapaProductos);
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            System.out.println("Error en la escritura del fichero stock.dat.");
        }
    }
}

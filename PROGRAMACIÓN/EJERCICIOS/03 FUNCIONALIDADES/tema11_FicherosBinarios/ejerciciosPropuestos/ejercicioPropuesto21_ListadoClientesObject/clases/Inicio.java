package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto21_ListadoClientesObject.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto21_ListadoClientesObject/documentos/clientes.dat"); //File que contiene el fichero donde se almacenará el listado de clientes.
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Lista listaClientes; //Lista que almacena los clientes.

        int intOpcionUsuario;

        listaClientes = fichero.exists() ? new Lista(leeFichero(fichero)) : new Lista();

        intOpcionUsuario = muestraMenu(scEntrada);

        switch (intOpcionUsuario) {
            case 0 -> System.out.println("Has introducido un valor inválido.");
            case 1 -> listaClientes.addCliente(generaCliente(scEntrada));
            case 2 -> listaClientes.modCliente(dimeIdCliente(scEntrada), scEntrada);
            case 3 -> listaClientes.delCliente(dimeIdCliente(scEntrada));
            case 4 -> listaClientes.listaClientes();
            default -> System.out.println("Has introducido un valor fuera de rango.");
        }

        if (intOpcionUsuario > 0 && intOpcionUsuario < 4) {
            guardaFichero(fichero, listaClientes);
        }
    }

    /*******************************************************************************************************************
     * Lee una lista de objetos Cliente desde un archivo utilizando un ObjectInputStream.                              *
     *                                                                                                                 *
     * @param fichero Archivo desde el cual se va a leer.                                                              *
     * @return Una lista de objetos Cliente leído desde el archivo especificado, o una lista vacía si se produjo un    *
     *         error durante la lectura.                                                                               *
     *******************************************************************************************************************/
    private static Lista leeFichero(File fichero) {
        //DECLARACIÓN DE OBJETOS
        Lista listaReturn = null; //Lista que se devolverá.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            listaReturn = (Lista) lectura.readObject();
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error de lectura en el fichero.");
        } catch (ClassNotFoundException e) { //En caso de que el fichero no contenga un objeto de la clase indicada.
            System.out.println("El fichero no contiene un objeto de tipo Lista.");
        }

        return listaReturn;
    }

    /*******************************************************************************************************************
     * Muestra un menú con opciones y solicita al usuario que seleccione una opción.                                   *
     *                                                                                                                 *
     * @return El número de opción seleccionado por el usuario, o 0 si se produce una excepción al intentar leer       *
     *         la entrada del usuario.                                                                                 *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que almacena la opción elegida por el usuario.

        System.out.println("""
                Elige una opción:
                    1. Añadir nuevo cliente.
                    2. Modificar datos.
                    3. Dar de baja cliente.
                    4. Listar los clientes.""");
        System.out.print("Opción: ");
        try {
            intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
        } catch (NumberFormatException e) { //En caso de introducir un número en un formato no válido.
            intOpcionUsuario = 0;
        }

        return intOpcionUsuario;
    }

    /*******************************************************************************************************************
     * Método para generar un nuevo objeto Cliente a partir de la entrada por teclado.                                 *
     *                                                                                                                 *
     * @param scEntrada Objeto Scanner para la entrada por teclado.                                                    *
     * @return Objeto Cliente creado a partir de la entrada por teclado.                                               *
     *******************************************************************************************************************/
    private static Cliente generaCliente(Scanner scEntrada) {
        String strIdCliente; //String que almacena el ID del cliente.
        String strNombreCliente; //String que almacena el nombre del cliente.
        int intNumeroCliente = 0; //Int que almacena el número del cliente.
        boolean blnNumeroValido; //Booleano que actuará como bandera.

        System.out.println("Generando nuevo cliente...");

        strIdCliente = dimeIdCliente(scEntrada);

        do {
            System.out.print("Dime nombre del cliente: ");
            strNombreCliente = scEntrada.nextLine();

            if (strNombreCliente.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (strNombreCliente.isEmpty());

        do {
            System.out.print("Dime número del cliente: ");
            try {
                intNumeroCliente = Integer.parseInt(scEntrada.nextLine());
                blnNumeroValido = true;
            } catch (NumberFormatException e) { //En caso de introducir un número en un formato no válido.
                System.out.println("El número introducido no es válido");
                blnNumeroValido = false;
            }
        } while (intNumeroCliente < 0 || !blnNumeroValido);

        return new Cliente(strIdCliente, strNombreCliente, intNumeroCliente);
    }

    /*******************************************************************************************************************
     * Devuelve el ID del cliente introducido por el usuario a través del scanner de entrada.                          *
     *                                                                                                                 *
     * @param scEntrada El objeto Scanner para recibir la entrada del usuario.                                         *
     * @return El ID del cliente introducido por el usuario.                                                           *
     *******************************************************************************************************************/
    private static String dimeIdCliente(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strIdReturn; //String que almacena el ID del cliente.

        do {
            System.out.print("Dime ID del cliente: ");
            strIdReturn = scEntrada.nextLine();

            if (strIdReturn.isEmpty()) {
                System.out.println("El ID no puede estar vacío.");
            }
        } while (strIdReturn.isEmpty());

        return strIdReturn;
    }

    /*******************************************************************************************************************
     * Guarda una lista de objetos de la clase Cliente en un fichero mediante ObjectOutputStream.                      *
     *                                                                                                                 *
     * @param fichero El fichero en el que se guardará la lista de clientes.                                           *
     * @param listaClientes El objeto Lista de clientes que se desea guardar.                                          *
     *******************************************************************************************************************/
    private static void guardaFichero(File fichero, Lista listaClientes) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(listaClientes);
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error de escritura en el fichero.");
        }
    }
}

package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto20_ListadoClientes.clases;

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
                "ejercicioPropuesto20_ListadoClientes/documentos/clientes.dat"); //File que contiene el fichero donde se almacenará el listado de clientes.
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.

        //DECLARACIÓN DE VARIABLES
        Cliente[] arrClientes; //Array de objetos Cliente.
        int intOpcionUsuario; //Int que almacenará la opción elegida por el usuario.

        arrClientes = fichero.exists() ? leeFichero(fichero) : new Cliente[0];

        intOpcionUsuario = muestraMenu(scEntrada);

        switch (intOpcionUsuario) {
            case 0 -> System.out.println("Has introducido un valor inválido.");
            case 1 -> arrClientes = addCliente(arrClientes, generaCliente(scEntrada));
            case 2 -> modCliente(arrClientes, scEntrada);
            case 3 -> arrClientes = delCliente(arrClientes, scEntrada);
            case 4 -> listaClientes(arrClientes);
            default -> System.out.println("Has introducido un valor fuera de rango.");
        }

        scEntrada.close();

        if (intOpcionUsuario > 0 && intOpcionUsuario < 4) {
            guardaFichero(fichero, arrClientes);
        }
    }

    /*******************************************************************************************************************
     * Lee un array de objetos Cliente desde un archivo utilizando un ObjectInputStream.                               *
     *                                                                                                                 *
     * @param fichero Archivo desde el cual se va a leer.                                                              *
     * @return Un array de objetos Cliente leído desde el archivo especificado, o un array vacío si se produjo un      *
     *         error durante la lectura.                                                                               *
     *******************************************************************************************************************/
    private static Cliente[] leeFichero(File fichero) {
        //DECLARACIÓN DE VARIABLES
        Cliente[] clientesReturn = new Cliente[0]; //Array de objetos Cliente que se devolverá como resultad.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            clientesReturn = (Cliente[]) lectura.readObject();
        } catch (FileNotFoundException ignored) { //En caso de que no exista el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de lectura en el fichero.
            System.out.println("Se produjo un error de lectura en el fichero.");
        } catch (ClassNotFoundException e) { //En caso de que no se encuentre un objeto de la clase indicada.
            System.out.println("El fichero no contiene un objeto de tipo array de Cliente.");
        }

        return clientesReturn;
    }

    /*******************************************************************************************************************
     * Muestra un menú con opciones y solicita al usuario que seleccione una opción.                                   *
     *                                                                                                                 *
     * @return El número de opción seleccionado por el usuario, o 0 si se produce una excepción al intentar leer       *
     *         la entrada del usuario.                                                                                 *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que guardará la opción seleccionada por el usuario.

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
     * Añade un objeto Cliente al final de un array de objetos Cliente.                                                *
     *                                                                                                                 *
     * @param arrClientes El array de objetos Cliente al cual se desea añadir el nuevo cliente.                        *
     * @param nuevoCliente El objeto Cliente que se va a añadir al array.                                              *
     * @return El array de objetos Cliente con el nuevo cliente añadido al final.                                      *
     *******************************************************************************************************************/
    private static Cliente[] addCliente(Cliente[] arrClientes, Cliente nuevoCliente) {
        arrClientes = Arrays.copyOf(arrClientes, arrClientes.length + 1);
        arrClientes[arrClientes.length - 1] = nuevoCliente;
        System.out.println("Cliente añadido.");

        return arrClientes;
    }

    /*******************************************************************************************************************
     * Método para generar un nuevo objeto Cliente a partir de la entrada por teclado.                                 *
     *                                                                                                                 *
     * @param scEntrada Objeto Scanner para la entrada por teclado.                                                    *
     * @return Objeto Cliente creado a partir de la entrada por teclado.                                               *
     *******************************************************************************************************************/
    private static Cliente generaCliente(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strIdCliente; //String que almacena el ID del cliente.
        String strNombreCliente; //String que almacena el nombre del cliente.
        int intNumeroCliente = 0; //Int que almacena el número del cliente.
        boolean blnNumeroValido; //Boolean que actuará como bandera para verificar que el número tiene un formato válido.

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
            } catch (NumberFormatException e) { //En caso de que el número introducido no tenga un formato válido.
                System.out.println("El número introducido no es válido");
                blnNumeroValido = false;
            }
        } while (intNumeroCliente < 0 || !blnNumeroValido);

        return new Cliente(strIdCliente, strNombreCliente, intNumeroCliente);
    }

    /*******************************************************************************************************************
     * Devuelve el ID del cliente introducido por el usuario a través del scanner de entrada.                          *
     *                                                                                                                 *
     * @param scEntrada el objeto Scanner para recibir la entrada del usuario.                                         *
     * @return el ID del cliente introducido por el usuario.                                                           *
     *******************************************************************************************************************/
    private static String dimeIdCliente(Scanner scEntrada) {
        String strIdReturn;

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
     * Método que modifica los datos de un cliente existente en el array de clientes.                                  *
     *                                                                                                                 *
     * @param arrClientes Array de clientes existente.                                                                 *
     * @param scEntrada Scanner utilizado para obtener entrada del usuario.                                            *
     *******************************************************************************************************************/
    private static void modCliente(Cliente[] arrClientes, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strIdCliente; //String que almacena el ID del cliente.
        String strNuevoNombre; //String que almacena el nuevo nombre del cliente.
        int intIndiceBusqueda; //Int que almacena el número
        int intOpcionUsuario; //Int con la opción seleccionada por el usuario.
        int intNuevoNumero = 0; //Int con el nuevo numero del cliente.
        boolean blnNumeroValido; //Boolean que actuará de bandera.

        strIdCliente = dimeIdCliente(scEntrada);
        intIndiceBusqueda = buscaCliente(arrClientes, strIdCliente);

        if (intIndiceBusqueda >= 0 && intIndiceBusqueda < arrClientes.length) {
           intOpcionUsuario = menuMod(scEntrada);
           switch (intOpcionUsuario) {
               case 0 -> System.out.println("Introdujo un valor no válido. No se producirán cambios.");
               case 1 -> {
                   do {
                       System.out.print("Dime nuevo nombre del cliente: ");
                       strNuevoNombre = scEntrada.nextLine();
                       if (strNuevoNombre.isEmpty()) {
                           System.out.println("El nombre no puede estar vacío.");
                       } else {
                           arrClientes[intIndiceBusqueda].setStrNombre(strNuevoNombre);
                           System.out.println("Nombre cambiado con éxito.");
                       }
                   } while (strNuevoNombre.isEmpty());
               }
               case 2 -> {
                   do {
                       System.out.print("Dime nuevo número del cliente: ");
                       try {
                           intNuevoNumero = Integer.parseInt(scEntrada.nextLine());
                           blnNumeroValido = true;
                       } catch (NumberFormatException e) { //En caso de que se introduzca un formato número inválido.
                           System.out.println("Formato de número no válido. No se producirán cambios.");
                           blnNumeroValido = false;
                       }
                   } while (!blnNumeroValido || intNuevoNumero < 0);

                   arrClientes[intIndiceBusqueda].setIntNum(intNuevoNumero);
                   System.out.println("Número cambiado con éxito.");
               }
               default -> System.out.println("Opción introducida fuera de rango.");
           }
        } else {
            System.out.println("No existe un cliente con ese ID.");
        }
    }

    /*******************************************************************************************************************
     * Elimina un cliente del arreglo de clientes proporcionado, a partir de su ID.                                    *
     *                                                                                                                 *
     * @param arrClientes Array de objetos Cliente en el que se buscará y eliminará el cliente.                        *
     * @param scEntrada Objeto Scanner utilizado para la entrada de datos.                                             *
     * @return El array de objetos Cliente actualizado después de eliminar el cliente o el mismo array si no           *
     *         se encontró el cliente.                                                                                 *
     *******************************************************************************************************************/
    private static Cliente[] delCliente(Cliente[] arrClientes, Scanner scEntrada) {
        //DECALRACIÓN DE VARIABLES
        String strIdCliente; //String que guardará el ID del cliente.
        int intIndiceBusqueda; //Int que almacenará el índice de búsqueda.

        strIdCliente = dimeIdCliente(scEntrada);
        intIndiceBusqueda = buscaCliente(arrClientes, strIdCliente);

        if (intIndiceBusqueda >= 0 && intIndiceBusqueda < arrClientes.length) {
            System.arraycopy(arrClientes, intIndiceBusqueda + 1, arrClientes, intIndiceBusqueda,
                    arrClientes.length - intIndiceBusqueda - 1);
            arrClientes = Arrays.copyOf(arrClientes, arrClientes.length - 1);
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("No existe un cliente con ese ID.");
        }

        return arrClientes;
    }

    /*******************************************************************************************************************
     * Imprime todos los clientes del array de clientes recibido como parámetro.                                       *
     *                                                                                                                 *
     * @param arrClientes Arreglo de clientes a listar.                                                                *
     *******************************************************************************************************************/
    private static void listaClientes(Cliente[] arrClientes) {
        //DECLARACIÓN DE VARIABLES
        int intCont = 0; //Int que funcionará como contador.

        for (Cliente clienteValor : arrClientes) {
            System.out.println("CLIENTE " + (intCont + 1));
            System.out.println(clienteValor);
            intCont++;
        }
    }

    /*******************************************************************************************************************
     * Busca un cliente en el arreglo de clientes según su ID.                                                         *
     *                                                                                                                 *
     * @param arrClientes Arreglo de clientes donde se va a buscar el cliente.                                         *
     * @param strId ID del cliente a buscar.                                                                           *
     * @return El índice del cliente en el arreglo si se encuentra, -1 en caso contrario.                              *
     *******************************************************************************************************************/
    private static int buscaCliente(Cliente[] arrClientes, String strId) {
        //DECLARACIÓN DE VARIBALES
        int intCont = 0; //Int que guncionará como contador.

        for (Cliente clienteValor : arrClientes) {
            if (clienteValor.getSTR_ID().equals(strId)) {
                return intCont;
            }
            intCont++;
        }

        return -1;
    }

    /*******************************************************************************************************************
     * Muestra un menú con opciones y solicita al usuario que seleccione una opción.                                   *
     *                                                                                                                 *
     * @return El número de opción seleccionado por el usuario, o 0 si se produce una excepción al intentar leer       *
     *         la entrada del usuario.                                                                                 *
     *******************************************************************************************************************/
    private static int menuMod(Scanner scEntrada) {
        System.out.println("""
                Elige una opción de modificación:
                    1. Nombre cliente.
                    2. Número cliente.""");
        System.out.print("Opción: ");
        try {
            return Integer.parseInt(scEntrada.nextLine());
        } catch (NumberFormatException e) { //En caso de que se introduzca un formato número inválido.
            return 0;
        }
    }

    /*******************************************************************************************************************
     * Guarda un array de objetos de la clase Cliente en un fichero mediante ObjectOutputStream.                       *
     *                                                                                                                 *
     * @param fichero El fichero en el que se guardará el array de clientes.                                           *
     * @param arrClientes El array de clientes que se desea guardar.                                                   *
     *******************************************************************************************************************/
    private static void guardaFichero(File fichero, Cliente[] arrClientes) {
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(arrClientes);
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error de escritura en el fichero.");
        }
    }
}

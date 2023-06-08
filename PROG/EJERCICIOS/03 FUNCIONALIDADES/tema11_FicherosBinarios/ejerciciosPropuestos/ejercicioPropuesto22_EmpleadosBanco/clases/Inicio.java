package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto22_EmpleadosBanco.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto22_EmpleadosBanco/documentos/empleados.dat"); //File que contiene el fichero donde se almacenará el listado de empleados.
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        Lista listaEmpleados; //Lista que almacena los clientes.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que almacena el int del usuario.

        listaEmpleados = fichero.exists() ? new Lista(leeFichero(fichero)) : new Lista();

        do {
            intOpcionUsuario = muestraMenu(scEntrada);
            switch (intOpcionUsuario) {
                case 0 -> System.out.println("Has introducido un valor inválido.");
                case 1 -> listaEmpleados.addEmpleado(generaEmpleado(scEntrada));
                case 2 -> listaEmpleados.delEmpleado(dimeDniEmplado(scEntrada));
                case 3 -> listaEmpleados.muestraEmpleado(dimeDniEmplado(scEntrada));
                case 4 -> listaEmpleados.listaEmpleados();
                case 5 -> {
                    System.out.println("Finalizando...");
                    guardaFichero(fichero, listaEmpleados);
                }
                default -> System.out.println("Has introducido un valor fuera de rango.");
            }
            System.out.println();
        } while(intOpcionUsuario != 5);

        scEntrada.close();

    }

    /*******************************************************************************************************************
     * Lee una lista de objetos Empleado desde un archivo utilizando un ObjectInputStream.                             *
     *                                                                                                                 *
     * @param fichero Archivo desde el cual se va a leer.                                                              *
     * @return Una lista de objetos Empleado leído desde el archivo especificado, o una lista vacía si se produjo un   *
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
                    1. Alta empleado.
                    2. Baja empleado.
                    3. Mostrar datos empleados.
                    4. Listar empleados.
                    5. Salir.""");
        System.out.print("Opción: ");
        try {
            intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
        } catch (NumberFormatException e) { //En caso de introducir un número en un formato no válido.
            intOpcionUsuario = 0;
        }

        return intOpcionUsuario;
    }

    /*******************************************************************************************************************
     * Método para generar un nuevo objeto Empleado a partir de la entrada por teclado.                                *
     *                                                                                                                 *
     * @param scEntrada Objeto Scanner para la entrada por teclado.                                                    *
     * @return Objeto Empleado creado a partir de la entrada por teclado.                                              *
     *******************************************************************************************************************/
    private static Empleado generaEmpleado(Scanner scEntrada) {
        String strDniEmpleado; //String que almacena el DNI del empleado.
        String strNombreEmpleado; //String que almacena el nombre del empleado.
        double rlnSueldoEmpleado = 0; //Double que almacena el sueldo del empleado.
        boolean blnSueldoValido; //Booleano que actuará como bandera.

        System.out.println("Generando nuevo empleado...");

        strDniEmpleado = dimeDniEmplado(scEntrada);

        do {
            System.out.print("Dime nombre del empleado: ");
            strNombreEmpleado = scEntrada.nextLine();

            if (strNombreEmpleado.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (strNombreEmpleado.isEmpty());

        do {
            System.out.print("Dime sueldo del empleado: ");
            try {
                rlnSueldoEmpleado = Double.parseDouble(scEntrada.nextLine());
                blnSueldoValido = true;
            } catch (NumberFormatException e) { //En caso de introducir un número en un formato no válido.
                System.out.println("El sueldo introducido no es válido.");
                blnSueldoValido = false;
            }
        } while (rlnSueldoEmpleado < 0 || !blnSueldoValido);

        return new Empleado(strDniEmpleado, strNombreEmpleado, rlnSueldoEmpleado);
    }

    /*******************************************************************************************************************
     * Devuelve el DNI del empleado introducido por el usuario a través del scanner de entrada.                        *
     *                                                                                                                 *
     * @param scEntrada El objeto Scanner para recibir la entrada del usuario.                                         *
     * @return El DNI del empleado introducido por el usuario.                                                         *
     *******************************************************************************************************************/
    private static String dimeDniEmplado(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strDniReturn; //String que almacena el DNI del empleado.

        do {
            System.out.print("Dime DNI del cliente: ");
            strDniReturn = scEntrada.nextLine();

            if (strDniReturn.isEmpty()) {
                System.out.println("El DNI no puede estar vacío.");
            }
        } while (strDniReturn.isEmpty());

        return strDniReturn;
    }

    /*******************************************************************************************************************
     * Guarda una lista de objetos de la clase Empleado en un fichero mediante ObjectOutputStream.                     *
     *                                                                                                                 *
     * @param fichero El fichero en el que se guardará la lista de clientes.                                           *
     * @param listaEmpleados El objeto Lista de empleados que se desea guardar.                                        *
     *******************************************************************************************************************/
    private static void guardaFichero(File fichero, Lista listaEmpleados) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(listaEmpleados);
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            System.out.println("Se produjo un error de escritura en el fichero.");
        }
    }
}

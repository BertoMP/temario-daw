package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto26_NumerosFicheroAleatorio.clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto26_NumerosFicheroAleatorio/documentos/numeros.dat"); //File que contiene el fichero con los números.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Int que almacena la opción elegida por el usuario.

        if (fichero.exists()) {
            do {
                intOpcionUsuario = muestraMenu(scEntrada);
                switch (intOpcionUsuario) {
                    case 0 -> System.out.println("Has introducido un valor inválido.");
                    case 1 -> addNumeroInicio(scEntrada, fichero);
                    case 2 -> addNumeroFinal(scEntrada, fichero);
                    case 3 -> muestraFichero(fichero);
                    case 4 -> cambiaNumero(scEntrada, fichero);
                    case 5 -> System.out.println("Finalizando...");
                    default -> System.out.println("Has introducido un valor fuera de rango.");
                }
                System.out.println();
            } while(intOpcionUsuario != 5);
        }
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Muestra un menú con opciones y solicita al usuario que seleccione una opción.                                   *
     *                                                                                                                 *
     * @return El número de opción seleccionado por el usuario, o 0 si se produce una excepción al intentar leer       *
     *         la entrada del usuario.                                                                                 *
     *******************************************************************************************************************/
    private static int muestraMenu(Scanner scEntrada) {
        System.out.println("""
                Elige una opción:
                    1. Añadir número al principio del fichero.
                    2. Añadir número al final del fichero.
                    3. Mostrar el fichero.
                    4. Sustituir un número por otro número.
                    5. Salir.""");
        System.out.print("Opción: ");
        try {
            return Integer.parseInt(scEntrada.nextLine());
        } catch (NumberFormatException e) { //En caso de que se introduzca un número no válido.
            return  0;
        }
    }

    /*******************************************************************************************************************
     * Añade un número al principio de un archivo de números en formato binario.                                       *
     *                                                                                                                 *
     * @param scEntrada Scanner para leer la entrada del usuario.                                                      *
     * @param fichero Archivo en el que se desea añadir el número.                                                     *
     *******************************************************************************************************************/
    private static void addNumeroInicio(Scanner scEntrada, File fichero) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "rw")) {
            ficheroAleatorio.seek(0);
            ficheroAleatorio.writeDouble(dimeNumero(scEntrada));
            System.out.println("Número añadido con éxito al inicio del fichero.");
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (IOException e) { //En caso de que se produzca un error de lecto-escritura.
            System.out.println("Se produjo un error de lecto-escritura");
        }
    }

    /*******************************************************************************************************************
     * Añade un número al final de un archivo de números en formato binario.                                           *
     *                                                                                                                 *
     * @param scEntrada Scanner para leer la entrada del usuario.                                                      *
     * @param fichero Archivo en el que se desea añadir el número.                                                     *
     *******************************************************************************************************************/
    private static void addNumeroFinal(Scanner scEntrada, File fichero) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "rw")) {
            ficheroAleatorio.seek(ficheroAleatorio.length());
            ficheroAleatorio.writeDouble(dimeNumero(scEntrada));
            System.out.println("Número añadido con éxito al final del fichero.");
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (IOException e) { //En caso de que se produzca un error de lecto-escritura.
            System.out.println("Se produjo un error de lecto-escritura");
        }
    }

    /*******************************************************************************************************************
     * Muestra el contenido de un fichero que contiene números en formato double.                                      *
     *                                                                                                                 *
     * @param fichero el archivo que se desea mostrar                                                                  *
     *******************************************************************************************************************/
    private static void muestraFichero(File fichero) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "r")) {
            ficheroAleatorio.seek(0);
            while (ficheroAleatorio.getFilePointer() < ficheroAleatorio.length()) {
                System.out.println(ficheroAleatorio.readDouble());
            }
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error de lectura.");
        }
    }

    /*******************************************************************************************************************
     * Cambia un número en un archivo de tipo RandomAccessFile que contiene números en formato double.                 *
     *                                                                                                                 *
     * @param scEntrada El objeto Scanner utilizado para recibir entrada del usuario.                                  *
     * @param fichero El archivo que se desea modificar.                                                               *
     *******************************************************************************************************************/
    private static void cambiaNumero(Scanner scEntrada, File fichero) {
        //DECLARACIÓN DE VARIABLES
        double rlnNumACambiar; //double que guarda el número a cambiar.
        double rlnNumNuevo; //double que guarda el nuevo número.
        boolean blnCambiado = false; //boolean que actúa como bandera.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (RandomAccessFile ficheroAleatorio = new RandomAccessFile(fichero, "rw")) {
            System.out.println("NÚMERO A CAMBIAR");
            rlnNumACambiar = dimeNumero(scEntrada);
            System.out.println("NÚMERO NUEVO");
            rlnNumNuevo = dimeNumero(scEntrada);

            ficheroAleatorio.seek(0);

            while (ficheroAleatorio.getFilePointer() < ficheroAleatorio.length()) {
                if (ficheroAleatorio.readDouble() == rlnNumACambiar) {
                    ficheroAleatorio.seek(ficheroAleatorio.getFilePointer() - 8);
                    ficheroAleatorio.writeDouble(rlnNumNuevo);
                    blnCambiado = true;
                }
            }

            if (!blnCambiado) {
                System.out.println("El número " + rlnNumACambiar + " no se encuentra en el fichero.");
            } else {
                System.out.println("Número cambiado con éxito.");
            }
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (IOException e) { //En caso de que se produzca un error de lecto-escritura.
            System.out.println("Se produjo un error de lecto-escritura.");
        }
    }

    /*******************************************************************************************************************
     * Solicita al usuario que ingrese un número válido y devuelve ese número como un valor double.                    *
     *                                                                                                                 *
     * @param scEntrada El objeto Scanner utilizado para recibir entrada del usuario.                                  *
     * @return El número válido ingresado por el usuario.                                                              *
     *******************************************************************************************************************/
    private static double dimeNumero(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLEs
        double rlnNumeroReturn = 0; //double que almacena el número a devolver.
        boolean blnNumeroValido; //boolean que actúa como bandera.

        do {
            System.out.print("Dime número: ");
            try {
                rlnNumeroReturn = Double.parseDouble(scEntrada.nextLine());
                blnNumeroValido = true;
            } catch (NumberFormatException e) { //En caso de que se introduzca un número no válido.
                System.out.println("Se ha introducido un valor no válido.");
                blnNumeroValido = false;
            }
        } while(!blnNumeroValido);

        return rlnNumeroReturn;
    }
}

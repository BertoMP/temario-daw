package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto25_BuscaNumero.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE VARIABLES
        String[] strNombreFicheros = {"fichero1.dat", "fichero2.dat", "fichero3.dat", "fichero4.dat",}; //Array de String que almacena los nombres de los ficheros.
        int intNumABuscar = 0; //Int que almacena el número a buscar.
        boolean blnNumeroValido; //Boolean que actúa como bandera para comprobar si el número tiene un formato válido.
        int intCont = 0; //Int que actúa como contador cada vez que el método boolean buscaNumero(String strNombreFichero, int intNum) produce un resultado true.

        for (String strNombreFichero : strNombreFicheros) {
            System.out.println("\nGenerando " + strNombreFichero);
            generaFichero(strNombreFichero);
        }

        do {
            System.out.print("\nDime número a buscar: ");
            try {
                intNumABuscar = Integer.parseInt(new Scanner(System.in).nextLine());
                blnNumeroValido = true;
            } catch (NumberFormatException e) { //En caso de introducir un número con un formato no válido.
                System.out.println("El valor introducido no es un número válido.");
                blnNumeroValido = false;
            }
        } while(!blnNumeroValido);

        for (String strNombreFicheroValor : strNombreFicheros) {
            if (buscaNumero(strNombreFicheroValor, intNumABuscar)) {
                intCont++;
            }
        }

        if (intCont == 0) {
            System.out.println("No se ha encontrado el " + intNumABuscar + " en los ficheros.");
        }
    }

    /*******************************************************************************************************************
     * Genera un archivo binario que contiene un array de enteros generado aleatoriamente.                             *
     *                                                                                                                 *
     * @param strFichero Nombre del archivo que se va a crear.                                                         *
     *******************************************************************************************************************/
    public static void generaFichero(String strFichero) {
        //DECLARACIÓN DE OBJETOS
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto25_BuscaNumero/documentos/" + strFichero); //File que contiene el fichero donde se almacenará el array de números.

        //DECLARACIÓN DE VARIABLES
        int[] intArray; //Array de int que se guardará en el fichero

        intArray = generaArray();

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(intArray);
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no exista.
        } catch (IOException e) { //En caso de que se produzca un error de escritura en el fichero.
            System.out.println("Se produjo un error de escritura en el fichero " + strFichero + ".");
        }
    }

    /*******************************************************************************************************************
     * Genera un array de enteros aleatorios y lo devuelve ordenado de menor a mayor.                                  *
     *                                                                                                                 *
     * @return Array de enteros generado aleatoriamente.                                                               *
     *******************************************************************************************************************/
    public static int[] generaArray() {
        //DECLARACIÓN DE CONSTANTES
        final int INT_NUM_MAX = 10; //Constante int que almacena el número máximo posible a generar.

        //DECLARACIÓN DE VARIABLES
        int[] intArrReturn; //Array de enteros que se devolverá como resultado del método.
        int intCantidad = 0; //Int que almacena la cantidad de números a lamacenar.
        int intNumAleatorio; //Int que almacena un número aleatorio.
        boolean blnNumeroValido; //Boolean que actúa como bandera para comprobar que el número introducido para la cantidad es válido.

        do {
            System.out.print("Dime cantidad de números a guardar: ");
            try {
                intCantidad = Integer.parseInt(new Scanner(System.in).nextLine());
                blnNumeroValido = true;
                if (intCantidad <= 0) {
                    System.out.println("El número debe ser positivo.");
                }
            } catch (NumberFormatException e) { //En caso de introducir un número con un formato no válido.
                System.out.println("El valor introducido no es un número válido.");
                blnNumeroValido = false;
            }
        } while(!blnNumeroValido || intCantidad <= 0);

        intArrReturn = new int[intCantidad];

        for (int intCont = 0; intCont < intArrReturn.length; intCont++) {
            intNumAleatorio = (int) (Math.random() * INT_NUM_MAX) + 1;
            intArrReturn[intCont] = intNumAleatorio;
        }

        Arrays.sort(intArrReturn);
        System.out.println("El array generado es: " + Arrays.toString(intArrReturn));
        return intArrReturn;
    }

    /*******************************************************************************************************************
     * Busca un número entero en un fichero de números enteros y devuelve si se ha encontrado o no.                    *
     *                                                                                                                 *
     * @param strNombreFichero Nombre del fichero a leer.                                                              *
     * @param intNumBusqueda Número entero a buscar.                                                                   *
     * @return true si se encuentra el número en el fichero, false en caso contrario.                                  *
     *******************************************************************************************************************/
    public static boolean buscaNumero(String strNombreFichero, int intNumBusqueda) {
        //DECLARACIÓN DE OBJETOS
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto25_BuscaNumero/documentos/" + strNombreFichero); //File que contiene el fichero el array de números.

        //DECLARACIÓN DE VARIABLES
        int[] intArrayBusqueda = new int[0]; //Array de int que contiene el array del fichero.
        boolean blnFinBucle = false; //Boolean que actúa como bandera.
        boolean blnEncontrado = false; //Boolean cuyo resultado se devuelve como resultado de la función.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(fichero))) {
            intArrayBusqueda = (int[]) lectura.readObject();
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error de lectura en el fichero " + strNombreFichero);
        } catch (ClassNotFoundException e) { //En caso de que el fichero no contenga un objeto de la clase indicada.
            System.out.println("El fichero " + strNombreFichero + " no contiene un array de int.");
        }

        for (int intCont = 0; intCont < intArrayBusqueda.length && !blnFinBucle; intCont++) {
            if (intArrayBusqueda[intCont] > intNumBusqueda) {
                blnFinBucle = true;
            } else if (intArrayBusqueda[intCont] == intNumBusqueda) {
                System.out.println("\t- Número encontrado en el fichero " + strNombreFichero +
                        " en la posición " + (intCont + 1) + ".");
                blnEncontrado = true;
            }
        }
        return blnEncontrado;
    }
}

package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto16_ListaNombresOrdenada.clases;

import java.io.*;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        File ficheroNombres = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto16_ListaNombresOrdenada/documentos/nombres.dat"); //File que contiene el fichero donde se almacenará el listado de nombres.
        Scanner scEntrada = new Scanner(System.in); //Scanner que servirá para la entrada de datos.
        Lista listadoNombres = new Lista(); //Lista que almacenará el listado de nombres.

        //DECLARACIÓN DE VARIABLES
        String strNombreNuevo; //String que guarda el nuevo nombre a almacenar en el listado.

        if (ficheroNombres.exists()) {
            leeFichero(ficheroNombres, listadoNombres);
        }

        do {
            System.out.print("\nLos nombres introducidos hasta ahora son: ");
            listadoNombres.muestraLista();

            System.out.print("Dime nombre a introducir (o introduce \"fin\" para terminar): ");
            strNombreNuevo = scEntrada.nextLine().toLowerCase().trim();

            if (strNombreNuevo.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            } else if (!strNombreNuevo.equals("fin")) {
                listadoNombres.addNombre(strNombreNuevo);
            }
        } while (!strNombreNuevo.equals("fin"));

        scEntrada.close();

        escribeFichero(ficheroNombres, listadoNombres);
    }

    /*******************************************************************************************************************
     * Método encargado de leer un fichero y extraer un elemento lista.                                                *
     *                                                                                                                 *
     * @param ficheroNombres Fichero con el listado.                                                                   *
     * @param listadoNombres Listado a generar.                                                                        *
     *******************************************************************************************************************/
    private static void leeFichero(File ficheroNombres, Lista listadoNombres) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(ficheroNombres))) {
            listadoNombres.addListadoPrevio((Lista) lectura.readObject());
        } catch (FileNotFoundException ignored) { //En caso de que el fichero no se encuentre.
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error en la lectura del fichero nombres.dat.");
        } catch (ClassNotFoundException e) { //En caso de que el fichero no contenga la clase indicada.
            System.out.println("El fichero nombres.dat no contiene un array de String.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de escribir en un fichero un elemento lista pasado por parámetro.                              *
     *                                                                                                                 *
     * @param ficheroNombres Fichero donde se escribirá.                                                               *
     * @param listadoNombres Listado a escribir en el fichero.                                                         *
     *******************************************************************************************************************/
    private static void escribeFichero(File ficheroNombres, Lista listadoNombres) {
        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(ficheroNombres))) {
            escritura.writeObject(listadoNombres);
            System.out.println("Listado de nombres almacenado con éxito.");
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error en la escritura del fichero nombres.dat.");
        }
    }
}

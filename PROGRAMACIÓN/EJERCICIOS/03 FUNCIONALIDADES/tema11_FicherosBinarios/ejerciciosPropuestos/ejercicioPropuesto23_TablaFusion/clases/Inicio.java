package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto23_TablaFusion.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.

        //DECLARACIÓN DE CONSTANTES
        final String STR_FICHERO_1 = "fichero1.dat"; //Constante String que almacena el nombre del primer fichero.
        final String STR_FICHERO_2 = "fichero2.dat"; //Constante String que almacena el nombre del segundo fichero.

        //DECLARACIÓN DE VARIABLES
        Integer[] arrIntegerFusionado; //Array de integer que almacenará el resultado final.

        System.out.println("FICHERO 1");
        generaFichero(generaLista(scEntrada), STR_FICHERO_1);

        System.out.println("\nFICHERO 2");
        generaFichero(generaLista(scEntrada), STR_FICHERO_2);

        scEntrada.close();

        arrIntegerFusionado = Lista.fusionar(STR_FICHERO_1, STR_FICHERO_2);

        System.out.print("\nEl array fusionado final es: ");
        System.out.println(Arrays.toString(arrIntegerFusionado));
    }

    /*******************************************************************************************************************
     * Genera una nueva lista a partir de la entrada proporcionada por el usuario.                                     *
     *                                                                                                                 *
     * @param scEntrada Un objeto Scanner que se utiliza para obtener la entrada del usuario.                          *
     * @return Una nueva instancia de la clase Lista que contiene los números introducidos por el usuario.             *
     *******************************************************************************************************************/
    private static Lista generaLista(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS
        Lista listaReturn = new Lista(); //Lista que se devolverá como resultado del método.

        //DECLARACIÓN DE VARIABLES
        int intCantidad = 0; //Int que almacena la cantidad de números a guardar en la lista.
        int intNum; //Int que almacena el número introducido por el usuario.
        boolean blnNumeroValido; //Boolean que actúa como bandera.

        do {
            System.out.print("¿Cuántos números quieres añadir? ");
            try {
                intCantidad = Integer.parseInt(scEntrada.nextLine());
                blnNumeroValido = true;
                if (intCantidad <= 0) {
                    System.out.println("El número debe ser mayor de 0.");
                }
            } catch (NumberFormatException e) { //En caso de que se introduzca un número con un formato no válido.
                System.out.println("El número introducido no tiene un formato válido.");
                blnNumeroValido = false;
            }
        } while(!blnNumeroValido || intCantidad <= 0);

        for (int intCont = 0; intCont < intCantidad;) {
            System.out.print("\t- Dime el " + (intCont + 1) + "º número de la lista: ");
            try {
                intNum = Integer.parseInt(scEntrada.nextLine());
                listaReturn.addInteger(intNum);
                intCont++;
            } catch (NumberFormatException e) { //En caso de que se introduzca un número con un formato no válido.
                System.out.println("El número introducido no tiene un formato válido.");
            }
        }

        return listaReturn;
    }

    /*******************************************************************************************************************
     * Genera un archivo binario que contiene la lista especificada.                                                   *
     *                                                                                                                 *
     * @param lista La lista que se desea escribir en el archivo.                                                      *
     * @param strNombreFichero El nombre del archivo que se desea crear.                                               *
     *******************************************************************************************************************/
    private static void generaFichero(Lista lista, String strNombreFichero) {
        //DECLARACIÓN DE OBJETOS
        File fichero = new File("src/tema11_FicherosBinarios/ejerciciosPropuestos/" +
                "ejercicioPropuesto23_TablaFusion/documentos/" + strNombreFichero); //File que contiene el fichero donde se almacenará el listado de números.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(fichero))) {
            escritura.writeObject(lista);
        } catch (FileNotFoundException ignored) { //En caso de que no se encuentre el fichero.
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error de escritura.");
        }
    }
}

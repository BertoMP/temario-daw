package tema10_FicherosDeTexto.ejerciciosPropuestos.ejercicioPropuesto11_AgendaTelefonica.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada de controlar el desarrollo principal del programa.                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final int INT_MAXIMO = 20; //Constante int con el número máximo de contactos posibles.
        final String STR_NOMBRE_FICHERO = "agenda.txt"; //Constante String que almacena el nombre del fichero.

        //DECLARACIÓN DE ARRAY
        int intOpcion; //Int que guarda la opción elegida por el usuario en el menú.
        Contacto[] agendaTelefonica; //Array que almacena los contactos de la agenda

        agendaTelefonica = generaAgenda(STR_NOMBRE_FICHERO);

        System.out.println(Arrays.deepToString(agendaTelefonica));

        do {
            intOpcion = muestraMenu();

            switch (intOpcion) {
                case 1 -> {
                    if (agendaTelefonica.length == INT_MAXIMO) {
                        System.out.println("No se pueden agregar más contactos.");
                    } else {
                        agendaTelefonica = nuevoContacto(agendaTelefonica);
                    }
                }
                case 2 -> {
                    if (agendaTelefonica.length > 0) {
                        buscaContacto(agendaTelefonica);
                    } else {
                        System.out.println("La agenda está vacía.");
                    }
                }
                case 3 -> {
                    if (agendaTelefonica.length > 0) {
                        muestraTodos(agendaTelefonica);
                    } else {
                        System.out.println("La agenda está vacía.");
                    }
                }
                case 4 -> {
                    guardaAgenda(agendaTelefonica, STR_NOMBRE_FICHERO);
                    System.out.println("Finalizando...");
                }
                case 0 -> System.out.println("Has introducido un valor no numérico.");
                default -> System.out.println("La opción introducida no es válida.");
            }
            System.out.println();
        } while (intOpcion != 4);
    }

    /*******************************************************************************************************************
     * Método encargado de generar una agenda de contactos (array) basada en un archivo de texto y devolverlo como     *
     * resultado del método.                                                                                           *
     *                                                                                                                 *
     * @return El método devuelve un array con todos los contactos.                                                    *
     *******************************************************************************************************************/
    public static Contacto[] generaAgenda(String strFichero) {
        Contacto[] arrReturn = new Contacto[0];
        String strLinea;
        String strNombre;
        int intNum = 0;

        //BLOQUE TRY-WITH RESOURCES PARA UN BUFFERED READER
        try (BufferedReader br = new BufferedReader(new FileReader("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto11_AgendaTelefonica/documentos/" + strFichero))){
            strLinea = br.readLine();
            while (strLinea != null) {
                strNombre = "";
                try (Scanner scLectura = new Scanner(strLinea)) {
                    while (scLectura.hasNextLine()) {
                        if (!scLectura.hasNextInt()) {
                            strNombre += scLectura.next() + " ";
                        } else {
                            intNum = scLectura.nextInt();
                        }
                    }
                }
                arrReturn = Arrays.copyOf(arrReturn, arrReturn.length + 1);
                arrReturn[arrReturn.length - 1] = new Contacto(strNombre.strip(), intNum);
                strLinea = br.readLine();
            }
        } catch (FileNotFoundException e) { //En caso de que no se encuentre el fichero.
            System.out.println("No se ha encontrado el fichero \"" + strFichero + "\".");
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error durante la lectura del fichero \"" + strFichero + "\".");
        }

        return arrReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú de opciones y devolver la opción elegida por el usuario.                    *
     *                                                                                                                 *
     * @return Se devuelve un int con la opción elegida por el usuario.                                                *
     *******************************************************************************************************************/
    private static int muestraMenu() {
        //DECLARACIÓN DE VARIABLES
        int intReturn; //Int que almacenará la opción elegida por el usuario

        System.out.println("""
                Elige una opción:
                    1. Nuevo contacto.
                    2. Buscar por nombre.
                    3. Mostrar todos.
                    4. Salir.""");
        System.out.print("Opción: ");

        //BLOQUE TRY CATCH
        try {
            intReturn = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) { //En caso de que el texto no sea convertible
            intReturn = 0;
        }

        return intReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de añadir objetos Contacto a un array de Contacto que se le pasa por parámetro.                *
     *                                                                                                                 *
     * @param arrContactos Array de contactos.                                                                         *
     * @return Devuelve el array con un nuevo contacto (en caso de que se pueda añadir).                               *
     *******************************************************************************************************************/
    private static Contacto[] nuevoContacto(Contacto[] arrContactos) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que almacena el nombre del contacto a introducir.
        int intNum; //Int que almacena el número del nuevo contacto.
        boolean blnEncontrado = false; //Boolean que actúa de bandera en la comprobación de nombres.
        boolean blnNumeroValido = false; //Boolean que actúa de bandera en la comprobación de que el número sea válido.

        System.out.print("Dime nombre del contacto: ");
        strNombre = new Scanner(System.in).nextLine().strip();

        for (int intCont = 0; intCont < arrContactos.length & !blnEncontrado; intCont++) {
            if (strNombre.equals(arrContactos[intCont].getStrNombre())) {
                blnEncontrado = true;
                System.out.println("El contacto ya está en la agenda.");
            }
        }

        if (!blnEncontrado) {
            do {
                System.out.print("Dime número del contacto: ");
                try {
                    intNum = Integer.parseInt(new Scanner(System.in).nextLine());
                    blnNumeroValido = true;
                    arrContactos = Arrays.copyOf(arrContactos, arrContactos.length + 1);
                    arrContactos[arrContactos.length - 1] = new Contacto(strNombre, intNum);
                    System.out.println("Contacto añadido con éxito.");
                } catch (NumberFormatException e) { //En caso de que el String no se pueda convertir a int.
                    System.out.println("El número introducido no es válido, vuelva a intentarlo.");
                }
            } while (!blnNumeroValido);
        }

        return arrContactos;
    }

    /*******************************************************************************************************************
     * Método encargado de buscar un contacto en el array que se pasa por parámetro.                                   *
     *                                                                                                                 *
     * @param arrContactos Array con los contactos.                                                                    *
     *******************************************************************************************************************/
    private static void buscaContacto(Contacto[] arrContactos){
        //DECLARACIÓN DE VARIABLES
        boolean blnEncontrado = false; //Boolean que funcionará como bandera.
        String strPatron; //String que guarda el patrón de búsqueda.

        System.out.print("Dime patrón de búsqueda: ");
        strPatron = new Scanner(System.in).nextLine();

        for (Contacto contactoValor : arrContactos) {
            if (contactoValor.getStrNombre().contains(strPatron)) {
                System.out.println("\n" + contactoValor);
                blnEncontrado = true;
            }
        }

        if (!blnEncontrado) {
            System.out.println("No se han encontrado contactos.");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de guardar la agenda de contactos a partir de un array de objetos Contacto que se le pasa      *
     * por parámetro.                                                                                                  *
     *                                                                                                                 *
     * @param arrContactos Array que contiene los objetos contacto.                                                    *
     * @param strNombreFichero String con el nombre del fichero.                                                       *
     *******************************************************************************************************************/
    private static void guardaAgenda(Contacto[] arrContactos, String strNombreFichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/tema10_FicherosDeTexto/" +
                "ejerciciosPropuestos/ejercicioPropuesto11_AgendaTelefonica/documentos/" + strNombreFichero))){
            for (Contacto contactoValor : arrContactos) {
                bw.write(contactoValor.getStrNombre() + " " + contactoValor.getIntNum());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error durante la escritura del fichero \"" + strNombreFichero + "\".");
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar todos los contactos de la agenda.                                                   *
     *                                                                                                                 *
     * @param arrContactos                                                                                             *
     *******************************************************************************************************************/
    private static void muestraTodos(Contacto[] arrContactos){
        Arrays.sort(arrContactos);

        for (Contacto contactoValor : arrContactos) {
            System.out.println("\n" + contactoValor);
        }
    }
}

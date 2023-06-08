package tema06_Cadenas.ejerciciosPropuestos;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Diseña una aplicación que se comporte como una pequeña agenda. Mediante un menú el usuario podrá elegir             *
 * entre:                                                                                                              *
 *      a) Añadir un nuevo contacto (nombre y teléfono).                                                               *
 *      b) Buscar el teléfono de un contacto a partir de su nombre.                                                    *
 *      c) Mostrar la información de todos los contactos ordenados alfabéticamente mediante el nombre.                 *
 * Pista: El nombre y el teléfono se pueden codificar como una única cadena con la forma «nombre:teléfono».            *
 ***********************************************************************************************************************/
public class Ejercicio04_AgendaTelefonica {
    /*******************************************************************************************************************
     * Función encargada de imprimir todos los contactos ordenados de forma alfabética.                                *
     *                                                                                                                 *
     * @param strArr → Array con los contactos                                                                         *
     *******************************************************************************************************************/
    public static void imprimeContactos(String[] strArr) {
        //DECLARACIÓN DE VARIABLES
        int intIndiceBusquedaDosPuntos; //Índice que guardará la posición donde se encuentran los dos puntos (':') en el índice del array.

        //ORDENAMIENTO DEL ARRAY
        Arrays.sort(strArr);

        //IMPRESIÓN DE RESULTADOS
        System.out.println("\nLISTA COMPLETA DE CONTACTOS");

        //BUCLE FOR EACH PARA LA IMPRESIÓN DE RESULTADOS
        for (String strValor : strArr) {
            /* El bucle recorrerá el array y comprobará si algún contacto contiene el nombre introducido por el
             * usuario.
             * En caso de encontrar una coincidencia, se buscará la posición de los dos puntos a través del método
             * String.indexOf(':') y se imprimirá el índice del array en dos partes:
             *      - Una primera parte con el nombre del contacto (con la primera letra en mayúscula).
             *      - Una segunda parte con el número del contacto. */
            intIndiceBusquedaDosPuntos = strValor.indexOf(':');
            System.out.println(strValor.substring(0, 1).toUpperCase()
                    + strValor.substring(1, intIndiceBusquedaDosPuntos)
                    + " - " + strValor.substring(intIndiceBusquedaDosPuntos + 1));
        }
    }
    /*******************************************************************************************************************
     * Función encargada de mostrar los contactos que contienen el nombre exacto o parte de él en la agenda.           *
     *                                                                                                                 *
     * @param strArr → Array con todos los contactos de la agenda.                                                     *
     * @param scEntrada → Scanner para la entrada de datos                                                             *
     *******************************************************************************************************************/
    public static void buscaContacto (String[] strArr, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String con el nombre del contacto que se debe buscar.
        int intIndiceBusquedaDosPuntos; //Índice que guardará la posición donde se encuentran los dos puntos (':') en el índice del array.
        boolean blnEncontrado = false; //Booleano que informará de si se ha encontrado o no el contacto.

        //SOLICITUD DE DATOS
        System.out.print("\nIntroduce el nombre del contacto: ");
        strNombre = scEntrada.nextLine().toLowerCase();

        //BUCLE FOR EACH PARA LA IMPRESIÓN DE RESULTADOS
        for (String strValor : strArr) {
            /* El bucle recorrerá el array y comprobará si algún contacto contiene el nombre introducido por el
             * usuario.
             * En caso de encontrar una coincidencia, se buscará la posición de los dos puntos a través del método
             * String.indexOf(':') y se imprimirá el índice del array en dos partes:
             *      - Una primera parte con el nombre del contacto (con la primera letra en mayúscula).
             *      - Una segunda parte con el número del contacto. */
            if (strValor.contains(strNombre)) {
                blnEncontrado = true;
                intIndiceBusquedaDosPuntos = strValor.indexOf(':');
                System.out.println(strValor.substring(0, 1).toUpperCase()
                        + strValor.substring(1, intIndiceBusquedaDosPuntos)
                        + " - " + strValor.substring(intIndiceBusquedaDosPuntos + 1));
            }
        }

        //MENSAJE EN CASO DE NO ENCONTRAR NINGÚN CONTACTO
        if (!blnEncontrado) {
            System.out.println("El contacto no se encuentra en la lista.");
        }
    }
    /*******************************************************************************************************************
     * Función encargada de guardar contactos en la agenda.                                                            *
     *                                                                                                                 *
     * @param strArr → Array donde se guardarán el contacto.                                                           *
     * @param scEntrada → Scanner para la entrada de datos.                                                            *
     * @return La función devolverá el array con el nuevo contacto guardado en su interior.                            *
     *******************************************************************************************************************/
    public static String[] nuevoContacto(String[] strArr, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String donde se guardará el nombre del contacto
        int intNumTelefono; //Int donde se guardará el número del contacto

        //SOLICITUD DE DATOS
        System.out.print("\nIntroduce nombre del contacto: ");
        strNombre = scEntrada.nextLine().toLowerCase();
        System.out.print("Introduce numero de teléfono: ");
        intNumTelefono = scEntrada.nextInt();

        //COPIA DEL ARRAY CON UN ÍNDICE MÁS
        strArr = Arrays.copyOf(strArr, strArr.length + 1);

        //ALMACENAMIENTO DEL CONJUNTO NOMBRE:NÚMERO EN ÚLTIMO ÍNDICE DEL ARRAY
        strArr[strArr.length - 1] = strNombre + ":" + intNumTelefono;

        //IMPRESIÓN DEL RESULTADO
        System.out.println("Contacto añadido con éxito.");

        //RETURN
        return strArr;
    }
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        char chrOpcionElegida; //Char que guarda la opción elegida por el usuario en el menú principal.
        String[] strArrNombresYTelefonos = new String[0]; //Array de Strings que guardará el nombre y el teléfono en un único índice.

        //BUCLE DO WHILE
        do {
            /* En cada iteración del bucle, el cual se mantendrá hasta que el usuario no quiera hacer otra acción sobre
             * la agenda telefónica, primero se preguntará al usuario sobre qué desea hacer, a continuación en
             * función de la opción elegida se llamará a una de las funciones. Por último, se le preguntará si
             * desea realizar otra acción. */
            //SOLICITUD DE DATOS
            System.out.println("""
                         Elige una opción:
                           a. Añadir un nuevo contacto (nombre y teléfono).
                           b. Buscar el teléfono de un contacto a partir de su nombre.
                           c. Mostrar la información de todos los contactos.""");
            System.out.print("Opcion: ");
            chrOpcionElegida = scEntrada.nextLine().charAt(0);

            //BUCLE WHILE PARA CONTROLAR QUE LA OPCIÓN INTRODUCIDA ES VÁLIDA
            while (chrOpcionElegida != 'a' && chrOpcionElegida != 'b' && chrOpcionElegida != 'c') {
                System.out.println("Opción no valida.");
                System.out.print("Opcion: ");
                chrOpcionElegida = scEntrada.nextLine().charAt(0);
            }

            //SWITCH PARA LAS OPCIONES DISPONIBLES
            switch (chrOpcionElegida) {
                //LLAMADA A LA FUNCIÓN nuevoContacto(String, Scanner);
                case 'a' -> strArrNombresYTelefonos = nuevoContacto(strArrNombresYTelefonos, scEntrada);
                //LLAMADA A LA FUNCIÓN buscaContacto(String, Scanner);
                case 'b' -> buscaContacto(strArrNombresYTelefonos, scEntrada);
                //LLAMADA A LA FUNCIÓN imprimeContactos(String, Scanner);
                case 'c' -> imprimeContactos(strArrNombresYTelefonos);
            }

            scEntrada.nextLine();
            //SOLICITUD DE DATOS 2
            System.out.print("\n¿Desea realizar otra operación? (S/N) ");
            chrOpcionElegida = scEntrada.nextLine().toLowerCase().charAt(0);

            //BUCLE WHILE PARA CONTROLAR QUE LA OPCIÓN INTRODUCIDA ES VÁLIDA
            while (chrOpcionElegida != 's' && chrOpcionElegida != 'n') {
                System.out.println("Opción no válida.");
                System.out.print("\n¿Desea realizar otra operación? (S/N) ");
                chrOpcionElegida = scEntrada.nextLine().toLowerCase().charAt(0);
            }
            System.out.println();

        } while (chrOpcionElegida != 'n');

        scEntrada.close();
    }

    public static void main(String[] args) {
        inicio();
    }
}

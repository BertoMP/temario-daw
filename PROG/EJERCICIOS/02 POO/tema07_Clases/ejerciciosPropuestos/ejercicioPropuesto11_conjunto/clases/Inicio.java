package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto11_conjunto.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    /*******************************************************************************************************************
     * Método encargado de controlar el desarrollo principal del programa.                                             *
     *******************************************************************************************************************/
    public static void inicio() {
        //DECLARACIÓN E INICIALIZACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Conjunto conjunto1 = new Conjunto(); //Objeto de tipo Conjunto.
        Conjunto conjunto2 = new Conjunto(); //Objeto de tipo Conjunto.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Variable que guarda la opción elegida por el usuario en el menú.

        do {
            System.out.println("""
            Elige una de las siguientes opciones:
                1. Mostrar el número de elementos de un conjunto.
                2. Inserta un número en un conjunto (sólo si no existe el número en el conjunto elegido).
                3. Inserta un conjunto en otro conjunto.
                4. Elimina un elemento de un conjunto (sólo si el elemento existe en el conjunto).
                5. Elimina un conjunto en otro conjunto.
                6. Buscar un elemento en un conjunto.
                7. Mostrar todos los elementos del conjunto.
                8. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcion = scEntrada.nextInt();

            switch (intOpcion) {
                case 1 -> {
                    switch (Inicio.eligeConjunto(scEntrada)) {
                        case 1 -> Inicio.numeroElementos(conjunto1);
                        case 2 -> Inicio.numeroElementos(conjunto2);
                    }
                }
                case 2 -> {
                    switch (Inicio.eligeConjunto(scEntrada)) {
                        case 1 -> Inicio.insertaElemento(conjunto1, scEntrada);
                        case 2 -> Inicio.insertaElemento(conjunto2, scEntrada);
                    }
                }
                case 3 -> {
                    switch (Inicio.eligeDireccion(scEntrada)) {
                        case 1 -> Inicio.insertaConjunto(conjunto2, conjunto1, eligeOpcion(scEntrada));
                        case 2 -> Inicio.insertaConjunto(conjunto1, conjunto2, eligeOpcion(scEntrada));
                    }
                }
                case 4 -> {
                    switch (Inicio.eligeConjunto(scEntrada)) {
                        case 1 -> Inicio.eliminaElemento(conjunto1, scEntrada);
                        case 2 -> Inicio.eliminaElemento(conjunto2, scEntrada);
                    }
                }
                case 5 -> {
                    switch (Inicio.eligeDireccion(scEntrada)) {
                        case 1 -> Inicio.eliminaConjunto(conjunto2, conjunto1, eligeOpcion(scEntrada));
                        case 2 -> Inicio.eliminaConjunto(conjunto1, conjunto2, eligeOpcion(scEntrada));
                    }
                }
                case 6 -> {
                    switch (Inicio.eligeConjunto(scEntrada)) {
                        case 1 -> Inicio.buscaElemento(conjunto1, scEntrada);
                        case 2 -> Inicio.buscaElemento(conjunto2, scEntrada);
                    }
                }
                case 7 -> {
                    switch (Inicio.eligeConjunto(scEntrada)) {
                        case 1 -> Inicio.muestraElementos(conjunto1);
                        case 2 -> Inicio.muestraElementos(conjunto2);
                    }
                }
                case 8 -> System.out.println("Fin del programa.");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcion != 8);

        scEntrada.close();
    }


    /*******************************************************************************************************************
     * Método encargado de desplegar un menú de selección del conjunto.                                                *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un int con el valor del método elegido.                                                        *
     *******************************************************************************************************************/
    private static int eligeConjunto(Scanner scEntrada) {
        int intOpcion;

        do {
            System.out.println("""
                    Elige el conjunto:
                        1. Conjunto 1.
                        2. Conjunto 2.""");
            intOpcion = Inicio.devuelveOpcion(scEntrada);
        } while (intOpcion < 1 || intOpcion > 2);

        return intOpcion;
    }

    /*******************************************************************************************************************
     * Método encargado de desplegar un menú de selección de dirección de inserción.                                   *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un int con el valor de la dirección elegida.                                                   *
     *******************************************************************************************************************/
    private static int eligeDireccion(Scanner scEntrada) {
        int intOpcion;

        do {
            System.out.println("""
                Elige la dirección:
                    1. Los elementos del Conjunto 1 al Conjunto 2.
                    2. Los elementos del Conjunto 2 al Conjunto 1.""");
            intOpcion = Inicio.devuelveOpcion(scEntrada);
        } while (intOpcion < 1 || intOpcion > 2);

        return intOpcion;
    }

    /*******************************************************************************************************************
     * Método encargado de desplegar un menú de selección de dirección de inserción.                                   *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un int con el valor de la dirección elegida.                                                   *
     *******************************************************************************************************************/
    private static int eligeOpcion(Scanner scEntrada) {
        int intOpcion;

        do {
            System.out.println("""
                Realizarlo:
                    1. Teniendo en cuenta todos los elementos.
                    2. Sin tener en cuenta todos los elementos.""");
            intOpcion = Inicio.devuelveOpcion(scEntrada);
        } while (intOpcion < 1 || intOpcion > 2);

        return intOpcion;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar una opción.                                                                       *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un int con el valor introducido por consola.                                                   *
     *******************************************************************************************************************/
    private static int devuelveOpcion(Scanner scEntrada) {
        int intOpcion;

        System.out.print("Opción: ");
        intOpcion = scEntrada.nextInt();
        if (intOpcion < 1 || intOpcion > 2) {
            System.out.println("La opción elegida no es válida, vuelva a intentarlo.");
            System.out.println();
        }

        return intOpcion;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar un número al usuario.                                                             *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve el número insertado por teclado.                                                               *
     *******************************************************************************************************************/
    private static int dimeNumero(Scanner scEntrada) {
        System.out.print("Dime el número: ");

        return scEntrada.nextInt();
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar el número de elementos de un conjunto.                                              *
     *                                                                                                                 *
     * @param conjunto Objeto de tipo Conjunto.                                                                        *
     *******************************************************************************************************************/
    private static void numeroElementos(Conjunto conjunto) {
        System.out.println("El número de elementos del conjunto es: " + conjunto.numeroElementos() + ".");
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar si un elemento se ha insertado o no en el conjunto.                                 *
     *                                                                                                                 *
     * @param conjunto Objeto de tipo Conjunto.                                                                        *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     *******************************************************************************************************************/
    private static void insertaElemento(Conjunto conjunto, Scanner scEntrada) {
        boolean blnReturn;

        blnReturn = conjunto.insertar(dimeNumero(scEntrada));

        System.out.println(blnReturn ? "Valor insertado." : "Valor no insertado porque ya existe en el conjunto.");
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar si un conjunto se ha insertado o no en el conjunto.                                 *
     *                                                                                                                 *
     * @param conjunto Objeto de tipo Conjunto.                                                                        *
     * @param otroConjunto Objeto de tipo Conjunto.                                                                    *
     *******************************************************************************************************************/
    private static void insertaConjunto(Conjunto conjunto, Conjunto otroConjunto, int intNum) {
        boolean blnReturn;

        blnReturn = conjunto.insertar(otroConjunto, intNum);

        System.out.println(blnReturn ? "Valores insertados." : "Valores no insertados (ya existe alguno).");
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar si un elemento se ha eliminado o no en el conjunto.                                 *
     *                                                                                                                 *
     * @param conjunto Objeto de tipo Conjunto.                                                                        *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     *******************************************************************************************************************/
    private static void eliminaElemento(Conjunto conjunto, Scanner scEntrada) {
        boolean blnReturn;

        blnReturn = conjunto.eliminarElemento(Inicio.dimeNumero(scEntrada));

        System.out.println(blnReturn ? "Valor eliminado." : "El valor introducido no existe en el conjunto.");
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar si un conjunto se ha insertado o no en el conjunto.                                 *
     *                                                                                                                 *
     * @param conjunto Objeto de tipo Conjunto.                                                                        *
     * @param otroConjunto Objeto de tipo Conjunto.                                                                    *
     *******************************************************************************************************************/
    private static void eliminaConjunto(Conjunto conjunto, Conjunto otroConjunto, int intNum) {
        boolean blnReturn;

        blnReturn = conjunto.eliminarConjunto(otroConjunto, intNum);

        System.out.println(blnReturn ? "Valores eliminados." : "Valores no eliminados (no existe alguno).");
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar si un elemento pertenece o no al conjunto.                                          *
     *                                                                                                                 *
     * @param conjunto Objeto de tipo Conjunto.                                                                        *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     *******************************************************************************************************************/
    private static void buscaElemento(Conjunto conjunto, Scanner scEntrada) {
        boolean blnReturn;

        blnReturn = conjunto.pertenece(Inicio.dimeNumero(scEntrada));

        System.out.println(blnReturn ? "El valor pertenece al conjunto." : "El valor no pertenece al conjunto.");
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar los elementos de un conjunto.                                                       *
     *                                                                                                                 *
     * @param conjunto Objeto de tipo Conjunto.                                                                        *
     *******************************************************************************************************************/
    private static void muestraElementos(Conjunto conjunto) {
        System.out.println("Los elementos del conjunto elegido son: " + conjunto.muestra());
    }
}

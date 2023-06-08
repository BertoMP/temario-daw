package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto06_ListaImplementsColaPilaObject.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista lista = new Lista(); //Objeto de tipo Lista.
        Object objeto; //Objeto de tipo Object.

        //DECLARACIÓN DE VARIABLES
        int intCantidad; //Int que guarda la cantidad de elementos a apilar/encolar.

        //APILADO POR DEFECTO
        rellenaLista(lista);

        System.out.println("\nAPILANDO");
        System.out.print("Dime el número de objetos a apilar: ");
        intCantidad = Integer.parseInt(scEntrada.nextLine());

        for (int intCont = 0; intCont < intCantidad; intCont++) {
            desarrollo(lista, scEntrada);
        }

        System.out.println("\nDESAPILANDO");
        objeto = lista.popPila();
        while (objeto != null) {
            System.out.println("\nElemento desapilado: " + objeto + "\nLa pila actual es:");
            lista.muestraLista();
            objeto = lista.popPila();
        }

        //ENCOLADO POR DEFECTO
        rellenaLista(lista);

        System.out.println("\nENCOLANDO");
        System.out.print("Dime el número de objetos a encolar: ");
        intCantidad = Integer.parseInt(scEntrada.nextLine());

        for (int intCont = 0; intCont < intCantidad; intCont++) {
            desarrollo(lista, scEntrada);
        }

        System.out.println("\nDESENCOLANDO");
        objeto = lista.popCola();
        while (objeto != null) {
            System.out.println("\nElemento desencolado: " + objeto + "\nLa pila actual es:");
            lista.muestraLista();
            objeto = lista.popCola();
        }
    }

    /*******************************************************************************************************************
     * Método encargado del desarrollo del encolado/apilado.                                                           *
     *                                                                                                                 *
     * @param lista Lista en la que apilar/encolar elementos.                                                          *
     * @param scEntrada Objeto Scanner.                                                                                *
     *******************************************************************************************************************/
    private static void desarrollo(Lista lista, Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        Object objeto; //Objeto de tipo Object

        System.out.println("Lista actual: ");
        lista.muestraLista();
        System.out.println();
        objeto = generaObjeto(scEntrada);
        lista.push(objeto);
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Persona.                                                            *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Persona.                                                                     *
     *******************************************************************************************************************/
    private static Persona generaPersona(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que guarda el nombre de la persona.
        String strOficio; //String que guarda el oficio de la persona.
        int intEdad; //Int que guarda la edad de la persona.

        System.out.print("Dime nombre de la persona: ");
        strNombre = scEntrada.nextLine();
        System.out.print("Dime oficio de la persona: ");
        strOficio = scEntrada.nextLine();
        System.out.print("Dime edad de la persona: ");
        intEdad = Integer.parseInt(scEntrada.nextLine());

        System.out.println("Persona creada.\n");

        return new Persona(strNombre, strOficio, intEdad);
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Perro.                                                              *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Perro.                                                                       *
     *******************************************************************************************************************/
    private static Perro generaPerro(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que guarda el nombre del perro.
        String strRaza; //String que guarda la raza del perro.
        int intEdad; //Int que guarda la edad de la persona.

        System.out.print("Dime nombre del perro: ");
        strNombre = scEntrada.nextLine();
        System.out.print("Dime raza del perro: ");
        strRaza = scEntrada.nextLine();
        System.out.print("Dime edad del perro: ");
        intEdad = Integer.parseInt(scEntrada.nextLine());

        System.out.println("Perro creado.\n");

        return new Perro(strNombre, strRaza, intEdad);
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos.                                                                            *
     *                                                                                                                 *
     * @param scEntrada Objeto Scanner.                                                                                *
     * @return Devuelve un objeto.                                                                                     *
     *******************************************************************************************************************/
    private static Object generaObjeto(Scanner scEntrada) {
        Object objetoReturn = null;

        int intOpcion;

        System.out.println("""
                Elige una opción:
                    1. Generar objeto Persona.
                    2. Generar objeto Perro.""");
        System.out.print("Opción: ");
        intOpcion = Integer.parseInt(scEntrada.nextLine());

        while (intOpcion < 1 || intOpcion > 2) {
            System.out.println("Opción no válida: ");
            System.out.println("""
                Elige una opción:
                    1. Generar objeto Persona.
                    2. Generar objeto Perro.""");
            System.out.print("Opción: ");
            intOpcion = Integer.parseInt(scEntrada.nextLine());
        }

        switch (intOpcion) {
            case 1 -> objetoReturn = Inicio.generaPersona(scEntrada);
            case 2 -> objetoReturn = Inicio.generaPerro(scEntrada);
        }

        return objetoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de insertar unos valores por defecto en la lista.                                              *
     *                                                                                                                 *
     * @param lista Lista en la que se deben guardar los valores.                                                      *
     *******************************************************************************************************************/
    private static void rellenaLista(Lista lista) {
        lista.push(new Persona("Alejandro", "Informático", 23));
        lista.push(new Perro("Toby", "Golden Retriever", 2));
        lista.push(new Persona("Sofía", "Administrativa", 32));
        lista.push(new Perro("Nala","Pastor alemán",5));
    }
}

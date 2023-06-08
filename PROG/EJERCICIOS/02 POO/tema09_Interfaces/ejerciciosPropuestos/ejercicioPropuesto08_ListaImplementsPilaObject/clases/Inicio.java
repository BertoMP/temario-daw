package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto08_ListaImplementsPilaObject.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del control principal del programa.                                                                 *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de la clase Scanner.
        Lista lista = new Lista(); //Objeto de la clase Lista.
        Object objeto; //Objeto de la clase Object.

        //DECLARACIÓN DE VARIABLES
        int intOpcion; //Int que guarda la opción elegida por el usuario.

        //LISTA POR DEFECTO
        lista.push(new Persona("Alejandro", "Informático", 23));
        lista.push(new Perro("Toby", "Golden Retriever", 2));
        lista.push(new Persona("Sofía", "Administrativa", 32));
        lista.push(new Perro("Nala","Pastor alemán",5));

        do {
            System.out.println("Lista actual: ");
            lista.muestraLista();
            System.out.println();
            System.out.println("""
                Elige una opción:
                    1. Apilar objeto Persona.
                    2. Apilar objeto Perro.
                    3. Desapilar objetos.
                    4. Salir.""");
            System.out.print("Opción: ");
            intOpcion = Integer.parseInt(scEntrada.nextLine());

            switch (intOpcion) {
                case 1 -> lista.push(Inicio.generaPersona(scEntrada));
                case 2 -> lista.push(Inicio.generaPerro(scEntrada));
                case 3 -> {
                    objeto = lista.pop();
                    while (objeto != null) {
                        System.out.println("Elemento desapilado -> " + objeto);
                        System.out.println("Quedan en la pila: ");
                        lista.muestraLista();
                        System.out.println();
                        objeto = lista.pop();
                    }
                }
                case 4 -> System.out.println("Finalizando aplicación...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcion != 4);
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

        System.out.println("Persona creada.");

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

        System.out.println("Perro creado.");

        return new Perro(strNombre, strRaza, intEdad);
    }
}

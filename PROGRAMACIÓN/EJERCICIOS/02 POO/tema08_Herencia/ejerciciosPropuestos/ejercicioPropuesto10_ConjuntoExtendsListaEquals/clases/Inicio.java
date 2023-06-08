package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto10_ConjuntoExtendsListaEquals.clases;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto10_ConjuntoExtendsListaEquals.clases.lista.Conjunto;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de la clase Scanner.
        Conjunto nuevoConjunto = new Conjunto(); //Objeto de la clase Conjunto.
        Conjunto otroConjunto; //Objeto de la clase Conjunto.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción del usuario.
        int intValor; //Variable que guardará un valor a pasar por parámetro.
        int intPosicion; //Variable que guardará una posición del conjunto.
        Integer intRetorno; //Variable que guardará un Integer que se reciba como return de método.

        do {
            System.out.println("""
                Elige una opción:
                    1. Obtener el número de elementos insertados en el conjunto.
                    2. Insertar un número al final del conjunto.
                    3. Insertar un número al principio del conjunto.
                    4. Insertar un número en un lugar del conjunto cuyo índice se pasa como parámetro.
                    5. Añadir al final del conjunto los elementos de otro conjunto que se pasa como parámetro.
                    6. Eliminar un elemento cuyo índice en el conjunto se pasa como parámetro.
                    7. Obtener el elemento cuyo índice se pasa como parámetro.
                    8. Buscar un número en el conjunto, devolviendo el índice del primer lugar donde se encuentre.
                       Si no está devolverá -1.
                    9. Mostrar los elementos del conjunto por consola.
                    10. Comparar dos conjuntos.
                    11. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = scEntrada.nextInt();
            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El número de elementos es: " + nuevoConjunto.numeroElementos());
                case 2 -> {
                    System.out.print("Dime número a añadir: ");
                    intValor = scEntrada.nextInt();
                    nuevoConjunto.insertarFinal(intValor);
                }
                case 3 -> {
                    System.out.print("Dime número a añadir: ");
                    intValor = scEntrada.nextInt();
                    nuevoConjunto.insertarInicio(intValor);
                }
                case 4 -> {
                    System.out.print("Dime número a añadir: ");
                    intValor = scEntrada.nextInt();
                    System.out.print("Dime posición en la que introducirlo: ");
                    intPosicion = scEntrada.nextInt();
                    nuevoConjunto.insertarEnLugar(intValor, intPosicion);
                }
                case 5 -> {
                    otroConjunto = Inicio.generaConjunto(scEntrada);
                    nuevoConjunto.anadeOtraLista(otroConjunto);
                }
                case 6 -> {
                    System.out.print("Dime el índice que quieres eliminar: ");
                    intValor = scEntrada.nextInt();
                    nuevoConjunto.elimina(intValor);
                }
                case 7 -> {
                    System.out.print("Dime el índice que quieras conocer: ");
                    intValor = scEntrada.nextInt();
                    intRetorno = nuevoConjunto.dimeElemento(intValor);
                    System.out.println((intRetorno != null)
                            ? "En la posición " + intValor + " está el elemento " + intRetorno
                            : "No existe el elemento.");
                }
                case 8 ->  {
                    System.out.print("Dime el número que quieras buscar: ");
                    intValor = scEntrada.nextInt();
                    intRetorno = nuevoConjunto.buscaElemento(intValor);
                    System.out.println((intRetorno != -1)
                            ? "El número " + intValor + " está en la posición " + intRetorno
                            : "No existe el número en el conjunto.");
                }
                case 9 -> System.out.println(nuevoConjunto);
                case 10 -> {
                    otroConjunto = Inicio.generaConjunto(scEntrada);
                    System.out.println(nuevoConjunto.equals(otroConjunto)
                            ? "Son el mismo conjunto."
                            : "Son conjuntos diferentes.");
                }
                case 11 -> System.out.println("Finalizando programa...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 11);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar un conjunto y devolverlo.                                                           *
     *                                                                                                                 *
     * @param scEntrada Objeto de la clase Scanner.                                                                    *
     * @return Devuelve un Conjunto.                                                                                   *
     *******************************************************************************************************************/
    private static Conjunto generaConjunto(Scanner scEntrada) {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Conjunto conjuntoReturn = new Conjunto();

        //DECLARACIÓN DE VARIABLES
        int intValor; //Variable que guarda el valor introducido por el usuario.
        int intOpcion; //Variable que guarda la opción elegida por el usuario.

        do {
            System.out.print("Dime número a añadir en el nuevo conjunto: ");
            intValor = scEntrada.nextInt();
            conjuntoReturn.insertarFinal(intValor);
            System.out.println("""
                            ¿Quieres añadir otro valor?
                                1. Sí.
                                2. No.""");
            System.out.print("Opción: ");
            intOpcion = scEntrada.nextInt();
        } while (intOpcion != 2);

        return conjuntoReturn;
    }
}

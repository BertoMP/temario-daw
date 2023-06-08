package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto15_ListaStringOrden.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del control principal del programa.                                                                 *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista nuevaLista = new Lista(); //Objeto de tipo Lista.
        Lista otraLista = new Lista(); //Objeto de tipo Lista.
        Object objetoCadena; //Objeto de tipo Object.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción del usuario.
        int intValor; //Variable que guardará un valor a pasar por parámetro.
        int intPosicion; //Variable que guardará una posición de la lista.
        int intRetorno; //Variable que guardará un Integer que se reciba como return de método.
        int intOpcion; //Variable que guarda una opción del usuario en los menús.

        //LISTA POR DEFECTO
        nuevaLista.insertarFinal("esto");
        nuevaLista.insertarPrincipio("es");
        nuevaLista.insertarFinal("un");
        nuevaLista.insertarPrincipio("texto");
        nuevaLista.insertarFinal("de");
        nuevaLista.insertarPrincipio("prueba");

        do {
            System.out.println("""
                    Elige una opción:
                        1. Obtener el número de elementos insertados en la lista.
                        2. Insertar un String al final de la lista.
                        3. Insertar un String al principio de la lista.
                        4. Insertar un String en un lugar de a lista cuyo índice se pasa como parámetro.
                        5. Añadir al final de la lista los elementos de otra lista que se pasa como parámetro.
                        6. Eliminar un elemento cuyo índice en la lista se pasa como parámetro.
                        7. Obtener el elemento cuyo índice se pasa como parámetro.
                        8. Buscar un String en la lista, devolviendo el índice del primer lugar donde se encuentre.
                           Si no está devolverá -1.
                        9. Mostrar los elementos de la lista por consola.
                        10. Ordenar Strings de forma alfabética.
                        11. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El número de elementos es: " + nuevaLista.numeroElementos());
                case 2 -> {
                    System.out.print("Dime String a añadir: ");
                    objetoCadena = scEntrada.nextLine().toLowerCase();
                    nuevaLista.insertarFinal(objetoCadena);
                }
                case 3 -> {
                    System.out.print("Dime String a añadir: ");
                    objetoCadena = scEntrada.nextLine().toLowerCase();
                    nuevaLista.insertarPrincipio(objetoCadena);
                }
                case 4 -> {
                    System.out.print("Dime String a añadir: ");
                    objetoCadena = scEntrada.nextLine().toLowerCase();
                    System.out.print("Dime posición en la que introducirlo: ");
                    intPosicion = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.insertarPosicion(intPosicion, objetoCadena);
                }
                case 5 -> {
                    do {
                        System.out.print("Dime String a añadir en la nueva lista: ");
                        objetoCadena = scEntrada.nextLine().toLowerCase();
                        otraLista.insertarFinal(objetoCadena);
                        System.out.println("""
                                ¿Quieres añadir otro valor?
                                    1. Sí.
                                    2. No.""");
                        System.out.print("Opción: ");
                        intOpcion = Integer.parseInt(scEntrada.nextLine());
                    } while (intOpcion != 2);
                    nuevaLista.insertarFinal(otraLista);
                }
                case 6 -> {
                    System.out.print("Dime el índice que quieres eliminar: ");
                    intValor = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.eliminar(intValor);
                }
                case 7 -> {
                    System.out.print("Dime el índice que quieras conocer: ");
                    intValor = scEntrada.nextInt();
                    objetoCadena = nuevaLista.dimeObjeto(intValor);
                    System.out.println((objetoCadena != null)
                            ? "En la posición " + intValor + " está el String: " + objetoCadena
                            : "No existe el elemento.");
                }
                case 8 -> {
                    System.out.print("Dime el String que quieras buscar: ");
                    objetoCadena = scEntrada.nextLine().toLowerCase();
                    intRetorno = nuevaLista.buscaObjeto(objetoCadena);
                    System.out.println((intRetorno != -1)
                            ? "El String " + objetoCadena + " está en la posición " + intRetorno
                            : "No existe el número en la lista.");
                }
                case 9 -> nuevaLista.imprimeArray();
                case 10 -> {
                    nuevaLista.ordenar();
                    System.out.println("Array ordenado");
                    nuevaLista.imprimeArray();
                }
                case 11 -> System.out.println("Finalizando programa...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 11);
        scEntrada.close();
    }
}

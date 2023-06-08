package tema07_Clases.ejerciciosResueltos.ejercicioResuelto11_lista.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de la clase Scanner.
        Lista nuevaLista = new Lista(); //Objeto de la clase Lista.
        Lista otraLista = new Lista(); //Objeto de la clase Lista.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción del usuario.
        int intValor; //Variable que guardará un valor a pasar por parámetro.
        int intPosicion; //Variable que guardará una posición de la lista.
        int intRetorno; //Variable que guardará un Integer que se reciba como return de método.
        char chrOpcionUsuario; //Variable

        //BUCLE DO WHILE PARA EL DESARROLLO PRINCIPAL
        do {
            System.out.println("""
                Elige una opción:
                    1. Obtener el número de elementos insertados en la lista.
                    2. Insertar un número al final de la lista.
                    3. Insertar un número al principio de la lista.
                    4. Insertar un número en un lugar de a lista cuyo índice se pasa como parámetro.
                    5. Añadir al final de la lista los elementos de otra lista que se pasa como parámetro.
                    6. Eliminar un elemento cuyo índice en la lista se pasa como parámetro.
                    7. Obtener el elemento cuyo índice se pasa como parámetro.
                    8. Buscar un número en la lista, devolviendo el índice del primer lugar donde se encuentre. 
                       Si no está devolverá -1.
                    9. Mostrar los elementos de la lista por consola.
                    10. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = scEntrada.nextInt();
            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El número de elementos es: " + nuevaLista.numeroElementos());
                case 2 -> {
                    System.out.print("Dime número a añadir: ");
                    intValor = scEntrada.nextInt();
                    nuevaLista.insertarFinal(intValor);
                }
                case 3 -> {
                    System.out.print("Dime número a añadir: ");
                    intValor = scEntrada.nextInt();
                    nuevaLista.insertarInicio(intValor);
                }
                case 4 -> {
                    System.out.print("Dime número a añadir: ");
                    intValor = scEntrada.nextInt();
                    System.out.print("Dime posición en la que introducirlo: ");
                    intPosicion = scEntrada.nextInt();
                    nuevaLista.insertarEnLugar(intValor, intPosicion);
                }
                case 5 -> {
                    do {
                        System.out.print("Dime número a añadir en la nueva lista: ");
                        intValor = scEntrada.nextInt();;
                        otraLista.insertarFinal(intValor);
                        scEntrada.nextLine();
                        System.out.print("¿Quieres añadir otro valor? (S o N) ");
                        chrOpcionUsuario = scEntrada.nextLine().toLowerCase().charAt(0);
                    } while (chrOpcionUsuario != 'n');
                    nuevaLista.anadeOtraLista(otraLista);
                }
                case 6 -> {
                    System.out.print("Dime el índice que quieres eliminar: ");
                    intValor = scEntrada.nextInt();
                    nuevaLista.elimina(intValor);
                }
                case 7 -> {
                    System.out.print("Dime el índice que quieras conocer: ");
                    intValor = scEntrada.nextInt();
                    intRetorno = nuevaLista.dimeElemento(intValor);
                    System.out.println((intRetorno != -1)
                            ? "En la posición " + intValor + " está el elemento " + intRetorno
                            : "No existe el elemento.");
                }
                case 8 ->  {
                    System.out.print("Dime el número que quieras buscar: ");
                    intValor = scEntrada.nextInt();
                    intRetorno = nuevaLista.buscaElemento(intValor);
                    System.out.println((intRetorno != -1)
                            ? "El número " + intValor + " está en la posición " + intRetorno
                            : "No existe el número en la lista.");
                }
                case 9 -> nuevaLista.muestraLista();
                case 10 -> System.out.println("Finalizando programa...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 10);
        scEntrada.close();
    }
}

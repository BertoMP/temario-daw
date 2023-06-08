package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto01_ListaString.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista nuevaLista = new Lista(); //Objeto de tipo Lista.
        Lista otraLista = new Lista(); //Objeto de tipo Lista.

        //DECLARACIÓN DE VARIABLES
        String strCadena; //Variable que guardará las cadenas introducidas por el usuario.
        String strRetorno; //Variable que guardará un String que se recibirá como return de un método.
        int intOpcionUsuario; //Variable que guardará la opción del usuario.
        int intValor; //Variable que guardará un valor a pasar por parámetro.
        int intPosicion; //Variable que guardará una posición de la lista.
        int intRetorno; //Variable que guardará un Integer que se reciba como return de método.
        int intOpcion; //Variable que guarda una opción del usuario en los menús.

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
                    10. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El número de elementos es: " + nuevaLista.numeroElementos());
                case 2 -> {
                    System.out.print("Dime String a añadir: ");
                    strCadena = scEntrada.nextLine();
                    nuevaLista.insertaFinal(strCadena);
                }
                case 3 -> {
                    System.out.print("Dime String a añadir: ");
                    strCadena = scEntrada.nextLine();
                    nuevaLista.insertaPrincipio(strCadena);
                }
                case 4 -> {
                    System.out.print("Dime String a añadir: ");
                    strCadena = scEntrada.nextLine();
                    System.out.print("Dime posición en la que introducirlo: ");
                    intPosicion = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.insertaLugar(intPosicion, strCadena);
                }
                case 5 -> {
                    do {
                        System.out.print("Dime String a añadir en la nueva lista: ");
                        strCadena = scEntrada.nextLine();
                        otraLista.insertaFinal(strCadena);
                        System.out.println("""
                            ¿Quieres añadir otro String?
                                1. Sí.
                                2. No.""");
                        System.out.print("Opción: ");
                        intOpcion = Integer.parseInt(scEntrada.nextLine());
                    } while (intOpcion != 2);
                    nuevaLista.insertaFinal(otraLista);
                }
                case 6 -> {
                    System.out.print("Dime el índice que quieres eliminar: ");
                    intValor = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.elimina(intValor);
                }
                case 7 -> {
                    System.out.print("Dime el índice que quieras conocer: ");
                    intValor = Integer.parseInt(scEntrada.nextLine());
                    strRetorno = nuevaLista.dimeString(intValor);
                    System.out.println((strRetorno != null)
                            ? "En la posición " + intValor + " está el String: " + strRetorno + "."
                            : "No existe el elemento.");
                }
                case 8 ->  {
                    System.out.print("Dime el String que quieras buscar: ");
                    strCadena = scEntrada.nextLine();
                    intRetorno = nuevaLista.buscar(strCadena);
                    System.out.println((intRetorno != -1)
                            ? "El String " + strCadena + " está en la posición " + intRetorno + "."
                            : "No existe el String " + strCadena + "en la lista.");
                }
                case 9 -> System.out.println(nuevaLista);
                case 10 -> System.out.println("Finalizando programa...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 10);
        scEntrada.close();
    }
}

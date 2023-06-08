package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto08_ColaDoble.clases;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto08_ColaDoble.clases.lista.ColaDoble;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        ColaDoble nuevaColaDoble = new ColaDoble(); //Objeto de tipo Cola.
        Integer numero = null; //Objeto de tipo Integer.

        //DECLARACIÓN DE VARIABLES
        int intCantidad; //Variable que guarda la cantidad de elementos a push.
        int intOpcion; //Variable que guarda la opción del usuario en un menú.
        int intNum; //Variable que guarda el número que quiere introducir el usuario.

        System.out.print("Dime la cantidad de elementos a encolar: ");
        intCantidad = scEntrada.nextInt();

        while (intCantidad <= 0) {
            System.out.print("¡ERROR! La cantidad introducida debe ser mayor de 0.");
            System.out.println("Dime la cantidad de elementos a encolar: ");
            intCantidad = scEntrada.nextInt();
        }

        System.out.println("\nENCOLANDO");
        for (int intCont = 0; intCont < intCantidad;) {
            System.out.print("Dime el número a encolar: ");
            intNum = scEntrada.nextInt();
            System.out.println("""
                    Selecciona dónde quieres encolar el elemento:
                        1. Al inicio.
                        2. Al final.""");
            System.out.print("Opción: ");
            intOpcion = scEntrada.nextInt();
            switch (intOpcion) {
                case 1 -> {
                    nuevaColaDoble.encolarPrincipio(intNum);
                    System.out.println("Elemento encolado: " + intNum + " -> La cola actual es: " + nuevaColaDoble);
                    intCont++;
                }
                case 2 -> {
                    nuevaColaDoble.encolarFinal(intNum);
                    System.out.println("Elemento encolado: " + intNum + " -> La cola actual es: " + nuevaColaDoble);
                    intCont++;
                }
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println("La cola actual es: " + nuevaColaDoble);
            System.out.println();
        }

        System.out.println("\nDESENCOLANDO");
        for (int intCont = intCantidad; intCont > 0;) {
            System.out.println("""
                    Selecciona dónde quieres desencolar el elemento:
                        1. Al inicio.
                        2. Al final.""");
            System.out.print("Opción: ");
            intOpcion = scEntrada.nextInt();
            switch (intOpcion) {
                case 1 -> {
                    numero = nuevaColaDoble.desencolarInicio();
                    System.out.println("Elemento desencolado: " + numero + " -> La cola actual es: " + nuevaColaDoble);
                    intCont--;
                }
                case 2 -> {
                    numero = nuevaColaDoble.desencolarFinal();
                    System.out.println("Elemento desencolado: " + numero + " -> La cola actual es: " + nuevaColaDoble);
                    intCont--;
                }
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println("Elemento desencolado: " + numero);
            System.out.println("La cola actual es: " + nuevaColaDoble);
            System.out.println();
        }
        scEntrada.close();
    }
}
package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto06_PilaExtendsLista.clases;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto06_PilaExtendsLista.clases.lista.Pila;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Pila pila = new Pila(); //Objeto de la clase Pila
        Scanner scEntrada = new Scanner(System.in);

        //DECLARACIÓN DE VARIALES
        Integer numero; //Integer que guardará el número desapilado.
        int intElementos; //Variable que guarda el número de elementos a apilar.

        System.out.print("Dime el número de elementos: ");
        intElementos = scEntrada.nextInt();
        while (intElementos < 1) {
            System.out.println("No puede haber elementos 0 o negativo.");
            System.out.println("Dime el número de elementos: ");
            intElementos = scEntrada.nextInt();
        }
        scEntrada.close();

        System.out.println("\nAPILANDO");
        for (int intCont = 0; intCont < intElementos; intCont++) {
            pila.apila(intCont);
            System.out.println("Apilando elemento: " + intCont + " -> La pila actual es: " + pila);
        }

        System.out.println("\nDESAPILANDO");
        for (int intCont = intElementos - 1; intCont >= 0; intCont--) {
            numero = pila.desapila();
            System.out.println("Desapilando elemento: " + numero + " -> La pila actual es: " + pila);
        }
    }
}

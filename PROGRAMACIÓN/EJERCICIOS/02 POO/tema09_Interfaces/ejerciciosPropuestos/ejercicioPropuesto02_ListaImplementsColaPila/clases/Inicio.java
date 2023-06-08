package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto02_ListaImplementsColaPila.clases;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista lista = new Lista(); //Objeto de tipo Lista.

        //DECLARACIÓN DE VARIABLES
        String strPalabra; //String que guarda la palabra o texto a push/apilar

        System.out.println("APILANDO");
        System.out.print("Dime palabra a apilar (-1 para dejar de apilar): ");
        strPalabra = scEntrada.nextLine();
        while (!strPalabra.equals("-1")) {
            lista.push(strPalabra);
            System.out.println("Elemento apilado: " + strPalabra + " -> La pila actual es: " + lista);
            System.out.print("Dime palabra a apilar (-1 para dejar de apilar): ");
            strPalabra = scEntrada.nextLine();
        }

        System.out.println("\nDESAPILANDO");
        strPalabra = lista.popPila();
        while (strPalabra != null) {
            System.out.println("Elemento desapilado: " + strPalabra + " -> La pila actual es: " + lista);
            strPalabra = lista.popPila();
        }

        System.out.println("\nENCOLANDO");
        System.out.print("Dime palabra a encolar (-1 para dejar de encolar): ");
        strPalabra = scEntrada.nextLine();
        while (!strPalabra.equals("-1")) {
            lista.push(strPalabra);
            System.out.println("Elemento encolado: " + strPalabra + " -> La cola actual es: " + lista);
            System.out.print("Dime palabra a encolar (-1 para dejar de encolar): ");
            strPalabra = scEntrada.nextLine();
        }

        System.out.println("\nDESENCOLANDO");
        strPalabra = lista.popCola();
        while (strPalabra != null) {
            System.out.println("Elemento encolado: " + strPalabra + " -> La cola actual es: " + lista);
            strPalabra = lista.popCola();
        }
    }
}

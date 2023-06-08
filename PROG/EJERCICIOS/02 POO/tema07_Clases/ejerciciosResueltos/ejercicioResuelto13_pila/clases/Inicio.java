package tema07_Clases.ejerciciosResueltos.ejercicioResuelto13_pila.clases;

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
        Integer numero; //Integer que guardará

        int intElementos;

        System.out.println("Dime el número de elementos: ");
        intElementos = scEntrada.nextInt();
        while (intElementos < 1) {
            System.out.println("No puede haber elementos 0 o negativo.");
            System.out.println("Dime el número de elementos: ");
            intElementos = scEntrada.nextInt();
        }
        scEntrada.close();

        for (int intCont = 0; intCont < intElementos; intCont++) {
            pila.apilar(intCont);
            System.out.println("Elemento apilado: " + intCont);
            System.out.println(pila.muestraPila());
        }

        System.out.println();
        numero = pila.desapilar();

        while (numero != null) {
            System.out.println("Elemento desapilado: " + numero + " ");
            System.out.println(pila.muestraPila());
            numero = pila.desapilar();
        }
    }
}

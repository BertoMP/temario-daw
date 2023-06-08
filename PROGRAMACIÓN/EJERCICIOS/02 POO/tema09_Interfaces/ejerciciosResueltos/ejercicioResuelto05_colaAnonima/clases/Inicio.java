package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto05_colaAnonima.clases;

import tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto05_colaAnonima.clases.interfaces.Cola;

import java.util.Scanner;
/***********************************************************************************************************************
 * Clase para el desarrollo principal del programa.                                                                    *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Cola cola = new Cola() {
            Lista lista = new Lista();
            @Override
            public void encolar(Integer numero) {
                lista.encolar(numero);
            }

            @Override
            public Integer desencolar() {
                return lista.desencolar();
            }
        };

        Integer numero; //Objeto de tipo Integer.
        int intNum; //Variable que guardará el número a apilar/push

        System.out.println("\nENCOLANDO");
        System.out.println("Introduce números en una lista, si introduces un negativo, terminará la introducción:");
        System.out.print("Número: ");
        intNum = scEntrada.nextInt();
        while (intNum >= 0) {
            cola.encolar(intNum);
            System.out.println("Elemento encolado: " + intNum + " -> La cola actual es: " + cola);
            System.out.print("Número: ");
            intNum = scEntrada.nextInt();
        }

        System.out.println("\nDESENCOLANDO");
        numero = cola.desencolar();
        while (numero != null) {
            System.out.println("Elemento desencolado: " + numero + " -> La cola actual es: " + cola);
            numero = cola.desencolar();
        }
    }
}

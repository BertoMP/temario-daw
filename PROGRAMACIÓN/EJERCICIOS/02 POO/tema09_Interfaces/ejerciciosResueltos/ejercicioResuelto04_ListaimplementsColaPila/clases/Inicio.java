package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto04_ListaimplementsColaPila.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase para el desarrollo principal del programa.                                                                    *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista listaCola = new Lista(); //Objeto de tipo Lista.
        Lista listaPila = new Lista(); //Objeto de tipo Lista.
        Integer numero; //Objeto de tipo Integer.
        int intNum; //Variable que guardará el número a apilar/push

        System.out.println("\nENCOLANDO");
        System.out.println("Introduce números en una lista, si introduces un negativo, terminará la introducción:");
        System.out.print("Número: ");
        intNum = scEntrada.nextInt();
        while (intNum >= 0) {
            listaCola.push(intNum);
            System.out.println("Elemento encolado: " + intNum + " -> La cola actual es: " + listaCola);
            System.out.print("Número: ");
            intNum = scEntrada.nextInt();
        }

        System.out.println("\nDESENCOLANDO");
        numero = listaCola.popCola();
        while (numero != null) {
            System.out.println("Elemento desencolado: " + numero + " -> La cola actual es: " + listaCola);
            numero = listaCola.popCola();
        }

        System.out.println("\nAPILANDO");
        System.out.println("Introduce números en una lista, si introduces un negativo, terminará la introducción:");
        System.out.print("Número: ");
        intNum = scEntrada.nextInt();
        while (intNum >= 0) {
            listaPila.push(intNum);
            System.out.println("Elemento apilado: " + intNum + " -> La pila actual es: " + listaPila);
            System.out.print("Número: ");
            intNum = scEntrada.nextInt();
        }

        System.out.println("\nDESAPILANDO");
        numero = listaPila.popPila();
        while (numero != null) {
            System.out.println("Elemento desapilado: " + numero + " -> La pila actual es: " + listaPila);
            numero = listaPila.popPila();
        }
    }
}

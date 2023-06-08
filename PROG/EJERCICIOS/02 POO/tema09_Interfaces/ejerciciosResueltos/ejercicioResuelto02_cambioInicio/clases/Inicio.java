package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto02_cambioInicio.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase para el desarrollo principal del programa.                                                                    *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista lista = new Lista(); //Objeto de tipo Lista.
        Integer numero; //Objeto de tipo Integer.
        int intNum; //Variable que guardará el número a push.

        System.out.println("\nENCOLANDO");
        System.out.println("Introduce números en una lista, si introduces un negativo, terminará la introducción:");
        System.out.print("Número: ");
        intNum = scEntrada.nextInt();
        while (intNum >= 0) {
            lista.encolar(intNum);
            System.out.println("Elemento encolado: " + intNum + " -> La cola actual es: " + lista);
            System.out.print("Número: ");
            intNum = scEntrada.nextInt();
        }

        System.out.println("\nDESENCOLANDO");
        numero = lista.desencolar();
        while (numero != null) {
            System.out.println("Elemento desencolado: " + numero + " -> La cola actual es: " + lista);
            numero = lista.desencolar();
        }
    }
}

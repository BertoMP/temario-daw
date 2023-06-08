package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto01_ListaimplementsCola.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase para el desarrollo principal del programa.                                                                    *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista lista = new Lista(); //Objeto de tipo Cola.
        Integer numero; //Objeto de tipo Integer.

        //DECLARACIÓN DE VARIABLES
        int intCantidad; //Variable que guarda la cantidad de elementos a push.

        System.out.print("Dime la cantidad de elementos a push: ");
        intCantidad = scEntrada.nextInt();

        while (intCantidad <= 0) {
            System.out.print("¡ERROR! La cantidad introducida debe ser mayor de 0.");
            System.out.println("Dime la cantidad de elementos a push: ");
            intCantidad = scEntrada.nextInt();
        }
        scEntrada.close();

        System.out.println("\nENCOLANDO");
        for (int intCont = 0; intCont < intCantidad; intCont++) {
            lista.encolar(intCont);
            System.out.println("Elemento encolado: " + intCont + " -> La cola actual es: " + lista);
        }

        System.out.println("\nDESENCOLANDO");
        for (int intCont = intCantidad;  intCont > 0; intCont--) {
            numero = lista.desencolar();
            System.out.println("Elemento desencolado: " + numero + " -> La cola actual es: " + lista);
        }
    }
}

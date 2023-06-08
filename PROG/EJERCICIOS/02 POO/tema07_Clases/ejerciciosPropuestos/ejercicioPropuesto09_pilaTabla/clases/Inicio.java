package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto09_pilaTabla.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    /*******************************************************************************************************************
     * Método encargado de controlar el desarrollo principal del programa.                                             *
     *******************************************************************************************************************/
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Pila pila = new Pila(); //Objeto de tipo Pila.
        Integer numero; //Objeto de tipo Integer.

        //DECLARACIÓN DE VARIABLES
        int intElementos; //Variable que guardará el número de elementos a apilar.

        System.out.print("Dime la cantidad de elementos a apilar: ");
        intElementos = scEntrada.nextInt();
        while (intElementos <= 0) {
            System.out.println("El número de elementos debe ser mayor de 0.");
            System.out.print("Dime la cantidad de elementos a apilar: ");
            intElementos = scEntrada.nextInt();
        }
        scEntrada.close();

        System.out.println("\nAPILANDO");
        for (int intCont = 0; intCont < intElementos; intCont++) {
            pila.apila(intCont);
            System.out.println("Apilando elemento: " + intCont + " -> La pila actual es: " + pila.muestraPila());
        }

        System.out.println("\nDESAPILANDO");
        for (int intCont = intElementos - 1; intCont >= 0; intCont--) {
            numero = pila.desapila(intCont);
            System.out.println("Desapilando elemento: " + numero + " -> La pila actual es: " + pila.muestraPila());
        }
    }
}

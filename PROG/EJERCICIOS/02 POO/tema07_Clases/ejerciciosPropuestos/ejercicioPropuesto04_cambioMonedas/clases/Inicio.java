package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto04_cambioMonedas.clases;
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
        Cambio cambio = new Cambio(); //Objeto de tipo Cambio.

        //DECLARACIÓN DE VARIABLES
        double rlnImporte; //Variable que guardará el importe de la compra.
        double rlnDineroCliente; //Variable que guardará el importe que entrega el cliente.
        double rlnDineroExtraCliente; //Variable que guardará el importe extra que entrega el cliente.
        double rlnCambioAEntregar; //Variable que guardará el cambio que se debe entregar.

        System.out.print("Dime el importe de la compra: ");
        rlnImporte = scEntrada.nextDouble();
        System.out.print("Dime el dinero que entrega el cliente: ");
        rlnDineroCliente = scEntrada.nextDouble();

        if (rlnImporte > rlnDineroCliente) {
            while (rlnImporte > rlnDineroCliente) {
                System.out.println("El cliente no ha entregado suficiente dinero.");
                System.out.println("Faltan: " + Math.round((rlnImporte - rlnDineroCliente) * 100) / 100.0 + "€");
                System.out.print("Dime el dinero extra que entrega el cliente: ");
                rlnDineroExtraCliente = scEntrada.nextDouble();
                rlnDineroCliente += rlnDineroExtraCliente;
            }
        }
        scEntrada.close();

        rlnCambioAEntregar = Math.round((rlnDineroCliente - rlnImporte) * 100) / 100.0;

        if (rlnCambioAEntregar == 0) {
            System.out.println("El cliente ha dado el dinero justo y no hay cambio.");
        } else {
            System.out.println("El cambio a entregar es: " + rlnCambioAEntregar + " €.");
            System.out.println("Hay que devolver: ");
            cambio.calculaCambio(rlnCambioAEntregar);
        }
    }
}

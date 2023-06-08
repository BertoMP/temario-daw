package tema07_Clases.ejerciciosResueltos.ejercicioResuelto06_hora.clases;
import java.util.Scanner;

public class Iniciador {
    public static void inicio() {
        //INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in);
        Hora nuevaHora = new Hora();

        //DECLARACIÓN DE VARIABLES
        int intValor; //Variable que servirá para pasar los valores a los sets de la clase Hora.
        int intSegundosAImprimir; //Variable que servirá para guardar el número de segundos a imprimir.

        //SOLICITUD DE DATOS Y LLAMADA A LOS SETS DE LA CLASE HORA
        System.out.print("Dime la hora actual: ");
        intValor = scEntrada.nextInt();
        nuevaHora.setIntHora(intValor);

        System.out.print("Dime los minutos actuales: ");
        intValor = scEntrada.nextInt();
        nuevaHora.setIntMinuto(intValor);

        System.out.print("Dime los segundos actuales: ");
        intValor = scEntrada.nextInt();
        nuevaHora.setIntSegundo(intValor);

        //SOLICITUD DE NÚMERO DE SEGUNDOS A IMPRIMIR
        System.out.print("Dime los segundos que quieres que pasen: ");
        intSegundosAImprimir = scEntrada.nextInt();
        scEntrada.close();

        System.out.println("\nHORA ACTUAL");
        nuevaHora.muestraHora();

        System.out.println("\nHORAS EN LOS " + intSegundosAImprimir + " SEGUNDOS SIGUIENTES");

        //BUCLE FOR PARA IMPRIMIR LOS RESULTADOS
        for (int intCont = 0; intCont < intSegundosAImprimir; intCont++) {
            nuevaHora.muestraHora();
        }
    }
}

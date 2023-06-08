package tema07_Clases.ejerciciosResueltos.ejercicioResuelto08_sintonizador.main;
import tema07_Clases.ejerciciosResueltos.ejercicioResuelto08_sintonizador.clases.Inicio;
/***********************************************************************************************************************
 * Definir una clase que permita controlar un sintonizador digital de emisoras FM concretamente, se desea dotar al     *
 * controlador de una interfaz que permita subir (up) o bajar (down) la frecuencia (en saltos de 0.5 MHz) y mostrar la *
 * frecuencia sintonizada en un momento dado (display). Supondremos que el rango de frecuencias para manejar oscila    *
 * entre los 80 MHz y los 108 MHz y que, al inicio, el controlador sintonice la frecuencia indicada en el              *
 * constructor u 80 MHz por defecto Si durante una operación de subida o bajada se sobrepasa uno de los límites,       *
 * la frecuencia sintonizada debe pasar a ser la del extremo contrario Escribir un pequeño programa principal para     *
 * probar su funcionamiento.                                                                                           *
 ***********************************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

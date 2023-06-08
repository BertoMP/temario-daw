package tema07_Clases.ejerciciosResueltos.ejercicioResuelto09_bombilla.main;
import tema07_Clases.ejerciciosResueltos.ejercicioResuelto09_bombilla.clases.Inicio;
/***********************************************************************************************************************
 * Modelar una casa con muchas bombillas, de forma que cada bombilla se pueda encender o apagar individualmente.       *
 * Para ello, hacer una clase Bombilla con una variable privada que indique si está encendida o pagada, así como un    *
 * método que nos diga el estado de una bombilla concreta. Además, queremos poner un interruptor general, de forma que *
 * si este se apaga, todas las bombillas quedan apagadas.                                                              *
 * Cuando el interruptor general se activa, las bombillas vuelven a estar encendidas o apagadas, según estuvieran      *
 * antes Cada bombilla se enciende y se apaga individualmente, pero solo responde que está encendida si su interruptor *
 * particular está activado y además hay luz general.                                                                  *
 ***********************************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

package main;
import clases.*;
public class Main {
    public static void main(String[] args) {
        inicio();
    }

    private static void inicio() {
        Entrenador entrenador = new Entrenador("Tomás", "Fernández",
                57, 3);
        Jugador jugador = new Jugador("Iván", "de Tomás",
                20, 1, "Base");
        Fisio fisio = new Fisio("Laura", "Rodríguez", 32, 10,
                "Máster en Fisioterapia Deportiva");

        entrenador.acudeEntrenamiento();
        jugador.acudeEntrenamiento();
        fisio.acudeEntrenamiento();

        System.out.println();

        entrenador.acudePartido();
        jugador.acudePartido();
        fisio.acudePartido();
    }
}

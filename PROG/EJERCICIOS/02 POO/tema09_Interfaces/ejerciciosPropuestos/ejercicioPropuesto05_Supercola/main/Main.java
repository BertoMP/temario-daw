package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto05_Supercola.main;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto05_Supercola.clases.Inicio;

/***********************************************************************************************************************
 * Implementar la clase Supercola, que tiene como atributos dos colas para enteros, en las que se encola y desencola   *
 * por separado. Sin embargo, si una de las colas queda vacía, al llamar a su método desencolar, se desencola de la    *
 * otra mientras tenga elementos. Solo cuando las dos colas estén vacías, cualquier llamada a desencolar devolverá     *
 * null.                                                                                                               *
 * Escribir un programa con el menú:                                                                                   *
 *      1. Encolar en cola1.                                                                                           *
 *      2. Encolar en cola2.                                                                                           *
 *      3. Desencolar de cola1.                                                                                        *
 *      4. Desencolar de cola2.                                                                                        *
 *      5. Salir.                                                                                                      *
 * Después de cada operación se mostrará el estado de las dos colas para seguir su evolución.                          *
 ***********************************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

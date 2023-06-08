package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto11_Contenedor30Enteros.clases;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Contenedor<Integer> contenedor = new Contenedor<>(new Integer[0]); //Objeto de tipo Contenedor que contendrá los números.

        for (int intCont = 0; intCont < 30; intCont++) {
            contenedor.insertarAlFinal((int) (Math.random() * 10) + 1);
        }

        System.out.println("Contenedor sin ordenar -> " + contenedor);

        contenedor.ordenar();

        System.out.println("Contender ordenado creciente -> " + contenedor);
    }
}

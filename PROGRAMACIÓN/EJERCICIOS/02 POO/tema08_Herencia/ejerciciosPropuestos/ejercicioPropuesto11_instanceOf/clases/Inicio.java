package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto11_instanceOf.clases;

/***********************************************************************************************************************
 * Clase que controla el desarrollo principal del programa.                                                            *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        Operacion nuevaOperacion = new Operacion();

        System.out.println("¿El número 50.67 es un número? " + Operacion.esNumero(50.67));
        System.out.println("\n¿La palabra \"hola\" es un número? " + Operacion.esNumero("hola"));

        System.out.println("\n¿Es posible concatenar las palabras \"hola\" y \"mundo\"?");
        System.out.println(nuevaOperacion.sumar("hola", "mundo"));

        System.out.println("\n¿Es posible sumar el número 5 y el 7.9?");
        System.out.println(nuevaOperacion.sumar(5, 7.9));

        System.out.println("\n¿Es posible sumar el número 5 y la palabra \"hola\"?");
        nuevaOperacion.sumar(5, "hola");

    }
}

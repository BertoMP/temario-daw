package tema07_Clases.ejerciciosResueltos.ejercicioResuelto09_bombilla.clases;
/***********************************************************************************************************************
 * Clase encargada del desarrollo general del programa.                                                                *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Bombilla bombilla1 = new Bombilla(); //Objeto 1 de la clase bombilla.
        Bombilla bombilla2 = new Bombilla(); //Objeto 2 de la clase bombilla.
        Bombilla bombilla3 = new Bombilla(); //Objeto 3 de la clase bombilla.

        //COMPROBACIÓN DE LOS DIFERENTES MÉTODOS DE LA CLASE Bombilla
        System.out.println("ENCENDEMOS LAS 3 BOMBILLAS");
        bombilla1.setBlnEstadoBombilla(true);
        bombilla2.setBlnEstadoBombilla(true);
        bombilla3.setBlnEstadoBombilla(true);
        System.out.println("La bombilla 1 está: " + bombilla1.muestraEstadoBombilla());
        System.out.println("La bombilla 2 está: " + bombilla2.muestraEstadoBombilla());
        System.out.println("La bombilla 3 está: " + bombilla3.muestraEstadoBombilla());

        System.out.println("\nAPAGAMOS LA LUZ GENERAL");
        Bombilla.setBlnInterruptorLuzGeneral(false);
        System.out.println("La bombilla 1 está: " + bombilla1.muestraEstadoBombilla());
        System.out.println("La bombilla 2 está: " + bombilla2.muestraEstadoBombilla());
        System.out.println("La bombilla 3 está: " + bombilla3.muestraEstadoBombilla());

        System.out.println("\nENCENDEMOS LA LUZ GENERAL Y APAGAMOS LA BOMBILLAS 1 Y 3");
        Bombilla.setBlnInterruptorLuzGeneral(true);
        bombilla1.setBlnEstadoBombilla(false);
        bombilla3.setBlnEstadoBombilla(false);
        System.out.println("La bombilla 1 está: " + bombilla1.muestraEstadoBombilla());
        System.out.println("La bombilla 2 está: " + bombilla2.muestraEstadoBombilla());
        System.out.println("La bombilla 3 está: " + bombilla3.muestraEstadoBombilla());
    }
}

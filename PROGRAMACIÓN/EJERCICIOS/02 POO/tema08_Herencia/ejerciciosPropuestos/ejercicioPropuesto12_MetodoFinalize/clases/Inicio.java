package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto12_MetodoFinalize.clases;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        for (int intCont = 0; intCont < 20; intCont++) {
            new Persona();
        }
        System.gc(); //Llamada al recolector de basura.
    }
}

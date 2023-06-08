package tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.maquinaria;
import tema07_Clases.ejerciciosResueltos.ejercicioResuelto10_empresaFerroviaria.clases.personal.Maquinista;

import java.util.Arrays;

/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Tren y de manejar sus atributos y métodos correspondientes.              *
 ***********************************************************************************************************************/
public class Tren {
    //DECLARACIÓN DE VARIABLES
    private Locomotora locomotora; //Objeto de tipo locomotora.
    private Maquinista maquinista; //Objeto de tipo maquinista.
    private Vagon[] vagonesArray; //Variable array que guardará los vagonesArray del tren.
    private int intContNumVagones; //Variable que funcionará como contador de vagonesArray.
    private final static int _NUM_MAX_VAGONES = 5;

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param locomotora Objeto locomotora asignado al objeto tren.                                                    *
     * @param maquinista Objeto maquinista asignado al objeto tren.                                                    *
     *******************************************************************************************************************/
    public Tren (Locomotora locomotora, Maquinista maquinista) {
        this.locomotora = locomotora;
        this.maquinista = maquinista;
        this.vagonesArray = new Vagon[0];
        this.intContNumVagones = 0;
    }

    /*******************************************************************************************************************
     * Método encargado de añadir vagonesArray al tren hasta su máximo (5). Los objetos vagon se guardan en            *
     * un array de tipo Vagon.                                                                                         *
     *                                                                                                                 *
     * @param vagon Objeto de tipo vagon.                                                                              *
     *******************************************************************************************************************/
    public void anadeVagon (Vagon vagon) {
        if (this.vagonesArray.length < Tren._NUM_MAX_VAGONES) {
            this.vagonesArray = Arrays.copyOf(vagonesArray, vagonesArray.length + 1);
            this.vagonesArray[vagonesArray.length - 1] = vagon;
        } else {
            System.out.println("No se pueden añadir más vagonesArray a este tren.");
        }
    }
}

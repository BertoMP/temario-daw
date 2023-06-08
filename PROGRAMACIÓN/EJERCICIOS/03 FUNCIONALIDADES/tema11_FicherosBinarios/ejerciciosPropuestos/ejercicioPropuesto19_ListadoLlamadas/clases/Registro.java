package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto19_ListadoLlamadas.clases;

import java.io.Serializable;
import java.time.LocalDate;

/***********************************************************************************************************************
 * Clase registro.                                                                                                     *
 ***********************************************************************************************************************/
public class Registro implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private LocalDate fecha; //Fecha del registro.
    private int intNumLlamadas; //Número de llamadas recibidas.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param intNumLlamadas Número de llamadas recibidas.                                                             *
     *******************************************************************************************************************/
    public Registro(int intNumLlamadas) {
        this.intNumLlamadas = intNumLlamadas;
        this.fecha = LocalDate.now();
    }

    /*******************************************************************************************************************
     * Devuelve una representación en String del objeto.                                                               *
     *                                                                                                                 *
     * @return Una cadena de caracteres que representa el objeto, con información sobre el día de la llamada y el      *
     *         número de llamadas recibidas.                                                                           *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Día: " + this.fecha + "\n\t-Llamadas recibidas: " + this.intNumLlamadas;
    }
}

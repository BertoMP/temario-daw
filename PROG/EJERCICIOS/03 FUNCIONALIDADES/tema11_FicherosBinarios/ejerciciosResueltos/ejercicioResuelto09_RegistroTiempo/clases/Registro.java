package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto09_RegistroTiempo.clases;

import java.io.Serializable;
import java.time.LocalDateTime;

/***********************************************************************************************************************
 * Clase registro.                                                                                                     *
 ***********************************************************************************************************************/
public class Registro implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    double rlnTemperatura; //Double que guarda la temperatura del registro.
    LocalDateTime fecha; //LocalDateTime que guarda la fecha y hora del registro.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param rlnTemperatura Temperatura del registro.                                                                 *
     *******************************************************************************************************************/
    public Registro (double rlnTemperatura) {
        this.rlnTemperatura = rlnTemperatura;
        this.fecha = LocalDateTime.now();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del socio.                                                 *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Registro{" +
                "rlnTemperatura=" + rlnTemperatura +
                ", fecha=" + fecha +
                '}';
    }
}

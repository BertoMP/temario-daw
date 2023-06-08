package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto14_EstacionMeteorologica.clases;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/***********************************************************************************************************************
 * Clase Registro.                                                                                                     *
 ***********************************************************************************************************************/
public class Registro implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private LocalTime horaDelRegistro; //Hora en la que se realiza el registro.
    private double rlnTemperatura; //Temperatura registrada.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param rlnTemperatura Temperatura registrada.                                                                   *
     *******************************************************************************************************************/
    public Registro(double rlnTemperatura) {
        this.horaDelRegistro = LocalTime.now();
        this.rlnTemperatura = rlnTemperatura;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver la temperatura del registro.                                                       *
     *                                                                                                                 *
     * @return Devuelve el atributo rlnTemperatura del objeto registro que hace la llamada.                            *
     *******************************************************************************************************************/
    public double getRlnTemperatura() {
        return this.rlnTemperatura;
    }

    /*******************************************************************************************************************
     * Método encargado de convertir los atributos del objeto invocante en un String.                                  *
     *                                                                                                                 *
     * @return Devuelve un String con los valores de los atributos.                                                    *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Hora -> " + this.horaDelRegistro.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)
                .withLocale(Locale.getDefault())) + ", Temperatura -> " + this.rlnTemperatura + "ºC";
    }
}

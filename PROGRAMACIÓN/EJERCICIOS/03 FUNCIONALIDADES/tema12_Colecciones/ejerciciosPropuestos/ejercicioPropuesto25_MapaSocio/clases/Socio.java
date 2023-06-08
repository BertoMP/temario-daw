package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto25_MapaSocio.clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Socio implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private String strNombre; //String que almacena el nombre del Socio.
    private LocalDate fechaAlta; //LocalDate que almacena la fecha de alta del Socio.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strNombre String con el nombre del socio.                                                                *
     * @param strFechaAlta String con la fecha de alta del socio.                                                      *
     *******************************************************************************************************************/
    public Socio(String strNombre, String strFechaAlta) {
        this.strNombre = strNombre;
        this.fechaAlta = LocalDate.parse(strFechaAlta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el año de ingreso.                                                                 *
     *                                                                                                                 *
     * @return Devuelve un int con el año de ingreso.                                                                  *
     *******************************************************************************************************************/
    public int getAnnoIngreso() {
        return fechaAlta.getYear();
    }

    /*******************************************************************************************************************
     * Método encargado de calcular la antigüedad de un Socio.                                                         *
     *                                                                                                                 *
     * @return Devuelve un int resultado de la diferencia entre la fecha actual y la fecha de alta del socio. El       *
     *         cálculo se hace en años.                                                                                *
     *******************************************************************************************************************/
    public int antiguedad() {
        return (int) this.fechaAlta.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el valor de los diferentes atributos del objeto.                     *
     *                                                                                                                 *
     * @return Devuelve un String con el valor de los atributos del objeto.                                            *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Nombre: " + this.strNombre + ", Fecha de alta: " + this.fechaAlta;
    }
}

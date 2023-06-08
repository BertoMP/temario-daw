package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto11_Socios.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/***********************************************************************************************************************
 * Clase Socio que implementa la interfaz Comparable.                                                                  *
 ***********************************************************************************************************************/

public class Socio implements Comparable<Socio> {
    //DECLARACIÓN DE ATRIBUTOS
    private final String STR_DNI; //Constante String que almacena el DNI del Socio.
    private String strNombre; //String que almacena el nombre del Socio.
    private LocalDate fechaAlta; //LocalDate que almacena la fecha de alta del Socio.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *                                                                                                                 *
     * @param strDni String con el DNI del socio.                                                                      *
     * @param strNombre String con el nombre del socio.                                                                *
     * @param strFechaAlta String con la fecha de alta del socio.                                                      *
     *******************************************************************************************************************/
    public Socio(String strDni, String strNombre, String strFechaAlta) {
        this.STR_DNI = strDni;
        this.strNombre = strNombre;
        this.fechaAlta = LocalDate.parse(strFechaAlta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /*******************************************************************************************************************
     * Constructor basado en el DNI.                                                                                   *
     *                                                                                                                 *
     * @param strDni String con el DNI del socio.                                                                      *
     *******************************************************************************************************************/
    public Socio(String strDni) {
        this(strDni, null, "01/01/0001");
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
     * Método encargado de comprobar si un objeto pasado por parámetro es igual que el objeto que hace la llamada.     *
     * La comparación se hace en base al DNI del socio.                                                                *
     *                                                                                                                 *
     * @param objeto Objeto a comparar.                                                                                *
     * @return Devuelve un true (en el caso de que ambos objetos sean el mismo) o false (en el caso de que no          *
     *         no lo sean).                                                                                            *
     *******************************************************************************************************************/
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;

        Socio otroSocio = (Socio) objeto;

        return this.STR_DNI.equals(otroSocio.STR_DNI);
    }

    /*******************************************************************************************************************
     * Método encargado de calcular el valor hash code del objeto que hace la llamada. Este cálculo se hace en base    *
     * del atributo STR_DNI del objeto Socio.                                                                          *
     *                                                                                                                 *
     * @return Devuelve el valor hash code del objeto invocante.                                                       *
     *******************************************************************************************************************/
    @Override
    public int hashCode() {
        return this.STR_DNI.hashCode();
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con el valor de los diferentes atributos del objeto.                     *
     *                                                                                                                 *
     * @return Devuelve un String con el valor de los atributos del objeto.                                            *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "DNI: " + this.STR_DNI + ", Nombre: " + this.strNombre + ", Fecha de Alta: " + this.fechaAlta;
    }

    /*******************************************************************************************************************
     * Implementación del método compareTo(Object o) de la interfaz Comparable parametrizado para la clase Socio.      *
     *                                                                                                                 *
     * @param otroSocio El objeto a comparar.                                                                          *
     * @return Devuelve un valor positivo, 0 o negativo resultado de la comparación.                                   *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Socio otroSocio) {
        return this.STR_DNI.compareTo(otroSocio.STR_DNI);
    }

}

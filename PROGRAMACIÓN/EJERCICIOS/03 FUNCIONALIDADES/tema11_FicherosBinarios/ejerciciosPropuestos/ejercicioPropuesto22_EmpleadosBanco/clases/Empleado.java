package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto22_EmpleadosBanco.clases;

import java.io.Serializable;

/***********************************************************************************************************************
 * Clase Empleado.                                                                                                        *
 ***********************************************************************************************************************/

public class Empleado implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private final String STR_DNI; //DNI del empleado.
    private String strNombre; //Nombre del empleado.
    private double rlnSueldo; //Sueldo del empleado.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strDni DNI del empleado.                                                                                 *
     * @param strNombre Nombre del empleado.                                                                           *
     * @param rlnSueldo Sueldo del empleado.                                                                           *
     *******************************************************************************************************************/
    public Empleado(String strDni, String strNombre, double rlnSueldo) {
        this.STR_DNI = strDni;
        this.strNombre = strNombre;
        this.rlnSueldo = rlnSueldo;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo STR_DNI del objeto Cliente.                                  *
     *                                                                                                                 *
     * @return Devuelve el valor del atributo STR_DNI.                                                                 *
     *******************************************************************************************************************/
    public String getSTR_DNI() {
        return this.STR_DNI;
    }

    /*******************************************************************************************************************
     * Devuelve una representación en String del objeto.                                                               *
     *                                                                                                                 *
     * @return Una cadena de caracteres que representa el objeto, con información sobre el DNI del empleado, su nombre *
     *         y su sueldo.                                                                                            *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "\t-NOMBRE: " + this.strNombre + "\n\t-DNI: " + this.STR_DNI + "\n\t-SUELDO: " + this.rlnSueldo + "€";
    }
}

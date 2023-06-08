package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto14_SelectEmpleadosList.clases;

import java.time.LocalDate;

/***********************************************************************************************************************
 * Clase Empleado.                                                                                                     *
 ***********************************************************************************************************************/

public class Empleado {
    //DECLARACIÓN DE ATRIBUTOS
    private String strApellido; //String que almacena el apellido del empleado.
    private LocalDate dFechaContratacion; //LocalDate que almacena la fecha de contratación.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strApellido Apellido del empleado.                                                                       *
     * @param dFechaContratacion Fecha de contratación del empleado.                                                   *
     *******************************************************************************************************************/
    public Empleado(String strApellido, LocalDate dFechaContratacion) {
        this.strApellido = strApellido;
        this.dFechaContratacion = dFechaContratacion;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los valores de los atributos del empleado.                           *
     *                                                                                                                 *
     * @return Devuelve un String con los datos del empleado.                                                          *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return this.strApellido + " (" + this.dFechaContratacion + ").";
    }
}

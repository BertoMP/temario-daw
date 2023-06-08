package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto16_RAE.clases;

/***********************************************************************************************************************
 * Clase Academico.                                                                                                    *
 ***********************************************************************************************************************/

public class Academico implements Comparable<Academico> {
    //DECLARACIÓN DE ATRIBUTOS
    private String strNombre; //String que almacena el nombre del académico.
    private int intAnnoIngreso; //Int que almacena el año de ingreso del académico.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strNombre String que almacena el nombre del académico.                                                   *
     * @param intAnnoIngreso Int que almacena el año de ingreso.                                                       *
     *******************************************************************************************************************/
    public Academico(String strNombre, int intAnnoIngreso) {
        this.strNombre = strNombre;
        this.intAnnoIngreso = intAnnoIngreso;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el año de ingreso.                                                                 *
     *                                                                                                                 *
     * @return Devuelve un int con el año de ingreso.                                                                  *
     *******************************************************************************************************************/
    public int getIntAnnoIngreso() {
        return this.intAnnoIngreso;
    }

    /*******************************************************************************************************************
     * Implementación del método compareTo de la intefaz Comparable.                                                   *
     * @param otroAcademico El objeto a comparar.                                                                      *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compareTo(Academico otroAcademico) {
        return this.strNombre.compareTo(otroAcademico.strNombre);
    }

    /*******************************************************************************************************************
     * Método encargado de convertir los atributos del objeto invocante en un String.                                  *
     *                                                                                                                 *
     * @return Devuelve un String con los valores de los atributos.                                                    *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Nombre: " + this.strNombre + ", Año ingreso en RAE: " + this.intAnnoIngreso;
    }
}

package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto18_CompruebaOficina.clases;

/***********************************************************************************************************************
 * Clase Empleado.                                                                                                     *
 ***********************************************************************************************************************/

public class Empleado {
    //DECLARACIÓN DE ATRIBUTOS
    private int intNum; //Int que almacena el número del empleado.
    private String strApellido; //String que almacena el apellido del empleado.
    private String strOficio; //String que almacena el oficio del empleado.
    private int intDirector; //Int que almacena el número de empleado del director.
    private int intSalario; //Int que almacena el salario del empleado.
    private int intComision; //Int que almacena la comisión del empleado.
    private int intDepartamento; //Int que almacena el departamento del empleado.

    /*******************************************************************************************************************
     * Constructor de la clase                                                                                         *
     *                                                                                                                 *
     * @param intNum Número del empleado.                                                                              *
     * @param strApellido Apellido del empleado.                                                                       *
     * @param strOficio Oficio del empleado.                                                                           *
     * @param intDirector Director del empleado.                                                                       *
     * @param intSalario Salario del empleado.                                                                         *
     * @param intComision Comisión del empleado.                                                                       *
     * @param intDepartamento Departamento del empleado.                                                               *
     *******************************************************************************************************************/
    public Empleado(int intNum, String strApellido, String strOficio, int intDirector, int intSalario,
                    Integer intComision, int intDepartamento) {
        this.intNum = intNum;
        this.strApellido = strApellido;
        this.strOficio = strOficio;
        this.intDirector = intDirector;
        this.intSalario = intSalario;
        this.intComision = intComision;
        this.intDepartamento = intDepartamento;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo intNum del objeto invocante.                                 *
     *                                                                                                                 *
     * @return Devuelve el valor de intNum.                                                                            *
     *******************************************************************************************************************/
    public int getIntNum() {
        return this.intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo strApellido del objeto invocante.                            *
     *                                                                                                                 *
     * @return Devuelve el valor de strApellido.                                                                       *
     *******************************************************************************************************************/
    public String getStrApellido() {
        return this.strApellido;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo strOficio del objeto invocante.                              *
     *                                                                                                                 *
     * @return Devuelve el valor de strOficio.                                                                         *
     *******************************************************************************************************************/
    public String getStrOficio() {
        return this.strOficio;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo intDirecto del objeto invocante.                             *
     *                                                                                                                 *
     * @return Devuelve el valor de intDirector.                                                                       *
     *******************************************************************************************************************/
    public int getIntDirector() {
        return this.intDirector;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo intSalario del objeto invocante.                             *
     *                                                                                                                 *
     * @return Devuelve el valor de intSalario.                                                                        *
     *******************************************************************************************************************/
    public int getIntSalario() {
        return this.intSalario;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo intComision del objeto invocante.                            *
     *                                                                                                                 *
     * @return Devuelve el valor de intComision.                                                                       *
     *******************************************************************************************************************/
    public int getIntComision() {
        return this.intComision;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo intDepartamento del objeto invocante.                        *
     *                                                                                                                 *
     * @return Devuelve el valor de intNum.                                                                            *
     *******************************************************************************************************************/
    public int getIntDepartamento() {
        return this.intDepartamento;
    }
}

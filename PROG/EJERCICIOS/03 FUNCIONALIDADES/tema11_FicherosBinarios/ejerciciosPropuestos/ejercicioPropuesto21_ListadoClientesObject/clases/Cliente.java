package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto21_ListadoClientesObject.clases;

import java.io.Serializable;

/***********************************************************************************************************************
 * Clase Cliente.                                                                                                      *
 ***********************************************************************************************************************/

public class Cliente implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private final String STR_ID; //ID del cliente.
    private String strNombre; //Nombre del cliente.
    private int intNum; //Número del cliente.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strId ID del cliente.                                                                                    *
     * @param strNombre Nombre del cliente.                                                                            *
     * @param intNum Número del cliente.                                                                               *
     *******************************************************************************************************************/
    public Cliente(String strId, String strNombre, int intNum) {
        this.STR_ID = strId;
        this.strNombre = strNombre;
        this.intNum = intNum;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver el valor del atributo STR_ID del objeto Cliente.                                   *
     *                                                                                                                 *
     * @return Devuelve el valor del atributo STR_ID.                                                                  *
     *******************************************************************************************************************/
    public String getSTR_ID() {
        return this.STR_ID;
    }

    /*******************************************************************************************************************
     * Método encargado de fichar el valor del atributo strNombre del objeto Cliente.                                  *
     *                                                                                                                 *
     * @param strNombre Nuevo valor del atributo strNombre.                                                            *
     *******************************************************************************************************************/
    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    /*******************************************************************************************************************
     * Método encargado de fichar el valor del atributo intNum del objeto Cliente.                                     *
     *                                                                                                                 *
     * @param intNum Nuevo valor del atributo intNum.                                                                  *
     *******************************************************************************************************************/
    public void setIntNum(int intNum) {
        this.intNum = intNum;
    }

    /*******************************************************************************************************************
     * Devuelve una representación en String del objeto.                                                               *
     *                                                                                                                 *
     * @return Una cadena de caracteres que representa el objeto, con información sobre el ID del cliente, su nombre   *
     *         y su número.                                                                                            *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "\t-ID: " + this.STR_ID + "\n\t-NOMBRE: " + this.strNombre + "\n\t-NÚMERO: " + this.intNum;
    }
}

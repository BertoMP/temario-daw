package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto08_SociosSerializable.clases;

import java.io.Serializable;

/***********************************************************************************************************************
 * Clase Socio.                                                                                                        *
 ***********************************************************************************************************************/
public class Socio implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    String strDni; //String que guardará el DNI del socio.
    String strNombre; //String que guardará el nombre del socio.

    /*******************************************************************************************************************
     * Constructor de la clase.                                                                                        *
     *                                                                                                                 *
     * @param strDni Dni del socio.                                                                                    *
     * @param strNombre Nombre del socio.                                                                              *
     *******************************************************************************************************************/
    public Socio (String strDni, String strNombre) {
        this.strDni = strDni;
        this.strNombre = strNombre;
    }

    /*******************************************************************************************************************
     * Método encargado de devolver un String con los datos del socio.                                                 *
     *******************************************************************************************************************/
    @Override
    public String toString() {
        return "Socio{" +
                "strDni='" + strDni + '\'' +
                ", strNombre='" + strNombre + '\'' +
                '}';
    }
}

package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto22_EmpleadosBanco.clases;

import java.io.Serializable;
import java.util.Arrays;

/***********************************************************************************************************************
 * Clase Lista.                                                                                                        *
 ***********************************************************************************************************************/

public class Lista implements Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private Object[] arrObjetos; //Array de objetos.

    /*******************************************************************************************************************
     * Constructor principal de la clase.                                                                              *
     *******************************************************************************************************************/
    public Lista() {
        this.arrObjetos = new Object[0];
    }

    /*******************************************************************************************************************
     * Constructor de la clase en caso de pasarse una lista por parámetros.                                            *
     *                                                                                                                 *
     * @param lista Objeto lista que contiene un array de Object.                                                      *
     *******************************************************************************************************************/
    public Lista(Lista lista) {
        this.arrObjetos = lista.arrObjetos;
    }

    /*******************************************************************************************************************
     * Añade un objeto empleado al final del array de objetos.                                                         *
     *                                                                                                                 *
     * @param empleado el objeto Empleado que se va a añadir.                                                          *
     *******************************************************************************************************************/
    public void addEmpleado(Empleado empleado) {
        this.arrObjetos = Arrays.copyOf(this.arrObjetos, this.arrObjetos.length + 1);
        this.arrObjetos[this.arrObjetos.length - 1] = empleado;
    }

    /*******************************************************************************************************************
     * Elimina (si existe) un objeto Empleado del array de objetos.                                                    *
     *                                                                                                                 *
     * @param strDni El DNI del Empleado que se va a eliminar.                                                         *
     *******************************************************************************************************************/
    public void delEmpleado(String strDni) {
        //DECLARACIÓN DE VARIABLES
        int intIndiceBusqueda; //Int que guarda el índice de búsqueda.

        intIndiceBusqueda = buscaEmpleado(strDni);

        if (intIndiceBusqueda >= 0 && intIndiceBusqueda < this.arrObjetos.length) {
            System.arraycopy(this.arrObjetos, intIndiceBusqueda + 1, this.arrObjetos, intIndiceBusqueda,
                    this.arrObjetos.length - intIndiceBusqueda - 1);
            arrObjetos = Arrays.copyOf(this.arrObjetos, this.arrObjetos.length - 1);
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("No existe el empleado. No se eliminó ninguno.");
        }
    }

    /*******************************************************************************************************************
     * Imprime (si existe) los datos de un empleado a partir de su DNI.                                                *
     *                                                                                                                 *
     * @param strDni DNI del cliente a mostrar.                                                                        *
     *******************************************************************************************************************/
    public void muestraEmpleado(String strDni) {
        //DECLARACIÓN DE VARIABLES
        int intIndiceBusqueda; //Int que guarda el índice de búsqueda.

        intIndiceBusqueda = buscaEmpleado(strDni);

        if (intIndiceBusqueda >= 0 && intIndiceBusqueda < this.arrObjetos.length) {
            System.out.println("Empleado encontrado, mostrando datos...");
            System.out.println(this.arrObjetos[intIndiceBusqueda]);
        } else {
            System.out.println("No se ha encontrado a ningún empleado.");
        }
    }

    /*******************************************************************************************************************
     * Imprime todos los empleados del array.                                                                          *
     *******************************************************************************************************************/
    public void listaEmpleados() {
        //DECLARACIÓN DE VARIABLES
        int intCont = 0; //Int que funciona como contador.

        for (Object objetoValor : this.arrObjetos) {
            System.out.println("EMPLEADO " + (intCont + 1));
            System.out.println(objetoValor);
            intCont++;
        }
    }

    /*******************************************************************************************************************
     * Busca un objeto Empleado del array de objetos.                                                                  *
     *                                                                                                                 *
     * @param strDniBusqueda El DNI del Empleado que se va a buscar.                                                   *
     *******************************************************************************************************************/
    private int buscaEmpleado(String strDniBusqueda) {
        //DECLARACIÓN DE VARIABLES
        int intCont = 0; //Int que funciona como contador.

        for (Object objetoValor : this.arrObjetos) {
            if (((Empleado) objetoValor).getSTR_DNI().equals(strDniBusqueda)) {
                return intCont;
            }
            intCont++;
        }

        return -1;
    }
}

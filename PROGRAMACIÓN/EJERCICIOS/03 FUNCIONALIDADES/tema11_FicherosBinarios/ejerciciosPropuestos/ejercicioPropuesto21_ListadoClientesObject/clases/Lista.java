package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto21_ListadoClientesObject.clases;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

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
     * Añade un objeto Cliente al final del array de objetos.                                                          *
     *                                                                                                                 *
     * @param cliente el objeto Cliente que se va a añadir.                                                            *
     *******************************************************************************************************************/
    public void addCliente(Cliente cliente) {
        this.arrObjetos = Arrays.copyOf(this.arrObjetos, this.arrObjetos.length + 1);
        this.arrObjetos[this.arrObjetos.length - 1] = cliente;
        System.out.println("Cliente añadido.");
    }

    /*******************************************************************************************************************
     * Modifica el nombre o número de teléfono de un Cliente en el array de objetos, según la opción elegida por el    *
     * usuario en un menú.                                                                                             *
     *                                                                                                                 *
     * @param strId El ID del Cliente a modificar.                                                                     *
     * @param scEntrada El objeto Scanner que se utiliza para leer la entrada del usuario.                             *
     *******************************************************************************************************************/
    public void modCliente(String strId, Scanner scEntrada) {
        int intIndiceBusqueda; //Int que guarda el índice de búsqueda.
        int intOpcionCambio; //Int que guarda la opción del menú elegida por el usuario.
        int intNuevoNumero = 0; //Int que guarda el nuevo número del usuario.
        String strNuevoNombre; //String que guarda el nuevo nombre del usuario.
        boolean blnNumeroValido; //Boolean que actúa como bandera.

        intIndiceBusqueda = buscaCliente(strId);

        if (intIndiceBusqueda >= 0 && intIndiceBusqueda < this.arrObjetos.length) {
            intOpcionCambio = menuMod(scEntrada);
            switch (intOpcionCambio) {
                case 0 -> System.out.println("Introdujo un valor no válido. No se producirán cambios.");
                case 1 -> {
                    do {
                        System.out.print("Dime nuevo nombre del cliente: ");
                        strNuevoNombre = scEntrada.nextLine();
                        if (strNuevoNombre.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío.");
                        } else {
                            ((Cliente) arrObjetos[intIndiceBusqueda]).setStrNombre(strNuevoNombre);
                            System.out.println("Nombre cambiado con éxito.");
                        }
                    } while (strNuevoNombre.isEmpty());
                }
                case 2 -> {
                    do {
                        System.out.print("Dime nuevo número del cliente: ");
                        try {
                            intNuevoNumero = Integer.parseInt(scEntrada.nextLine());
                            blnNumeroValido = true;
                        } catch (NumberFormatException e) { //En caso de introducir un formato no válido.
                            System.out.println("Formato de número no válido. No se producirán cambios.");
                            blnNumeroValido = false;
                        }
                    } while (!blnNumeroValido || intNuevoNumero < 0);

                    ((Cliente) arrObjetos[intIndiceBusqueda]).setIntNum(intNuevoNumero);
                    System.out.println("Número cambiado con éxito.");
                }
                default -> System.out.println("Opción introducida fuera de rango.");
            }
        } else {
            System.out.println("No existe un cliente con ese ID.");
        }
    }

    /*******************************************************************************************************************
     * Elimina (si existe) un objeto Cliente del array de objetos.                                                     *
     *                                                                                                                 *
     * @param strId El ID del Cliente que se va a eliminar.                                                            *
     *******************************************************************************************************************/
    public void delCliente(String strId) {
        //DECLARACIÓN DE VARIABLES
        int intIndiceBusqueda; //Int que guarda el índice de búsqueda.

        intIndiceBusqueda = buscaCliente(strId);

        if (intIndiceBusqueda >= 0 && intIndiceBusqueda < this.arrObjetos.length) {
            System.arraycopy(this.arrObjetos, intIndiceBusqueda + 1, this.arrObjetos, intIndiceBusqueda,
                    this.arrObjetos.length - intIndiceBusqueda - 1);
            this.arrObjetos = Arrays.copyOf(this.arrObjetos, this.arrObjetos.length - 1);
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("No existe un cliente con ese ID.");
        }
    }

    /*******************************************************************************************************************
     * Imprime todos los clientes del array.                                                                           *
     *******************************************************************************************************************/
    public void listaClientes() {
        //DECLARACIÓN DE VARIABLES
        int intCont = 0; //Int que funciona como contador.

        for (Object objetoValor : this.arrObjetos) {
            System.out.println("CLIENTE " + (intCont + 1));
            System.out.println(objetoValor);
            intCont++;
        }
    }

    /*******************************************************************************************************************
     * Busca un objeto Cliente del array de objetos.                                                                   *
     *                                                                                                                 *
     * @param strId El ID del Cliente que se va a buscar.                                                              *
     *******************************************************************************************************************/
    private int buscaCliente(String strId) {
        //DECLARACIÓN DE VARIABLES
        int intCont = 0; //Int que funciona como contador.

        for (Object objetoValor : this.arrObjetos) {
            if (((Cliente) objetoValor).getSTR_ID().equals(strId)) {
                return intCont;
            }
            intCont++;
        }

        return -1;
    }

    /*******************************************************************************************************************
     * Muestra un menú con opciones y solicita al usuario que seleccione una opción.                                   *
     *                                                                                                                 *
     * @return El número de opción seleccionado por el usuario, o 0 si se produce una excepción al intentar leer       *
     *         la entrada del usuario.                                                                                 *
     *******************************************************************************************************************/
    private static int menuMod(Scanner scEntrada) {
        System.out.println("""
                Elige una opción de modificación:
                    1. Nombre cliente.
                    2. Número cliente.""");
        System.out.print("Opción: ");
        try {
            return Integer.parseInt(scEntrada.nextLine());
        } catch (NumberFormatException e) { //En caso de introducir un formato no válido.
            return 0;
        }
    }
}

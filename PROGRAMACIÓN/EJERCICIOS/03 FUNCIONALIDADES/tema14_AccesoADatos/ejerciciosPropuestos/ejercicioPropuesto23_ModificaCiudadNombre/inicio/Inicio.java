package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto23_ModificaCiudadNombre.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto23_ModificaCiudadNombre.clases.OficinaDAO;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Scanner para la entrada de datos.
        OficinaDAO oficinaDAO = new OficinaDAO(); //Objeto de tipo OficinaDAO

        //DECLARACIÓN DE VARIABLES
        Integer intIdOficina = null; //Int que guarda el ID de la oficina.
        int intOpcionUsuario; //Int que guarda la opción del usuario en el menú.

        if (oficinaDAO.existeConexion()) {
            do {
                do {
                    System.out.print("Dime el ID de la oficina: ");
                    try {
                        intIdOficina = Integer.parseInt(scEntrada.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("El ID de la oficina debe ser un número entero.");
                    }
                } while (intIdOficina == null);

                if (oficinaDAO.existeOficina(intIdOficina)) {
                    intOpcionUsuario = generaMenu(scEntrada, 1);

                    oficinaDAO.update(intIdOficina, intOpcionUsuario,
                            getString(scEntrada, intOpcionUsuario == 1 ? "ciudad" : "nombre", 14));

                } else {
                    System.out.println("No existe la oficina con ese número.");
                }
                System.out.println();
            } while (generaMenu(scEntrada, 2) != 2);

            oficinaDAO.cierraConexion();
            scEntrada.close();
        }
    }

    /*******************************************************************************************************************
     * Método encargado de mostrar un menú de selección y devolver la opción elegida por el usuario.                   *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @return Devuelve un valor int con la opción elegida por el usuario.                                             *
     *******************************************************************************************************************/
    private static int generaMenu(Scanner scEntrada, int intMenu) {
        //DECLARACIÓN DE VARIABLES
        Integer intReturn = null; //Int que devuelve la opción elegida por el usuario.
        String strImpresion;

        strImpresion = (intMenu == 1)
                ? """
                Elige la opción a modificar:
                    1. Ciudad.
                    2. Nombre de la oficina."""
                : """
                ¿Desea realizar una consulta sobre otra oficina?
                    1. Sí.
                    2. No.""";

        do {
            System.out.println(strImpresion);
            System.out.print("Opción: ");
            try {
                intReturn = Integer.parseInt(scEntrada.nextLine());
                if (intReturn < 1 || intReturn > 2) {
                    System.out.println("La opción elegida no es válida. Vuelva a intentarlo.");
                    intReturn = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("La opción debe ser un número entero.");
            }
        } while (intReturn == null);

        return intReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de solicitar al usuario los diferentes campos VARCHAR de la tabla.                             *
     *                                                                                                                 *
     * @param scEntrada Scanner para la entrada de datos.                                                              *
     * @param strOpcion Campo a insertar.                                                                              *
     * @param intMaxLength Longitud máxima del campo.                                                                  *
     * @return Devuelve un String con el valor insertado por el usuario.                                               *
     *******************************************************************************************************************/
    private static String getString(Scanner scEntrada, String strOpcion, int intMaxLength) {
        //DECLARACIÓN DE VARIABLES
        String strReturn; //String que se devuelve como resultado del método.

        do {
            System.out.print("Dime " + strOpcion + ": ");
            strReturn = scEntrada.nextLine().toUpperCase();
            if (strReturn.isEmpty()) {
                System.out.println("El campo del " + strOpcion + " no puede estar vacío");
            } else if (strReturn.length() > intMaxLength){
                System.out.println("El campo del " + strOpcion + " no puede tener más de " + intMaxLength
                        + " caracteres.");
                strReturn = "";
            }
        } while (strReturn.isEmpty());
        return strReturn;
    }
}

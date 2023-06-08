package tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto20_ListadoClientes.main;

import tema11_FicherosBinarios.ejerciciosPropuestos.ejercicioPropuesto20_ListadoClientes.clases.Inicio;

/***********************************************************************************************************************
 * Implementa una aplicación que permita guardar y recuperar los datos de los clientes de una empresa. Para ello,      *
 * define la clase Cliente, que tendrá los atributos: id (identificador de cliente), nombre y teléfono. Los objetos    *
 * Cliente se insertarán en una tabla.                                                                                 *
 * Para realizar las distintas operaciones, la aplicación tendrá el siguiente menú:                                    *
 *      1. Añadir nuevo cliente.                                                                                       *
 *      2. Modificar datos.                                                                                            *
 *      3. Dar de baja cliente.                                                                                        *
 *      4. Listar los clientes.                                                                                        *
 * La información se guardará en un fichero binario, que se cargará en la memoria al iniciar la aplicación y se        *
 * grabará en disco, actualizada, al terminar.                                                                         *
 ***********************************************************************************************************************/

public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

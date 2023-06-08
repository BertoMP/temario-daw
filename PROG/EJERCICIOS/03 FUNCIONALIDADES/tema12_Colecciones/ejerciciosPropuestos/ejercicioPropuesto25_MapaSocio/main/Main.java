package tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto25_MapaSocio.main;

import tema12_Colecciones.ejerciciosPropuestos.ejercicioPropuesto25_MapaSocio.clases.Inicio;

/***********************************************************************************************************************
 * Implementa una aplicación que gestione un club donde se identifica a los socios por un apodo personal y único. De   *
 * cada socio, además del apodo, se guarda el nombre y su fecha de ingreso en el club. Utiliza un mapa donde las claves*
 * serán los apodos y los valores, objetos de la clase Socio. Los datos se guardarán en un fichero llamado "club.dat", *
 * de donde se leerá el mapa al arrancar y donde se volverá a guardar actualizado al salir. Las operaciones se         *
 * mostrarán en un menú que tendrá las siguientes opciones:                                                            *
 *      1. Alta socio.                                                                                                 *
 *      2. Baja socio.                                                                                                 *
 *      3. Modificación socio.                                                                                         *
 *      4. Listar socios por apodo.                                                                                    *
 *      5. Listar socios por antigüedad.                                                                               *
 *      6. Listar socios con alta anterior a un año determinado.                                                       *
 *      7. Salir.                                                                                                      *
 ***********************************************************************************************************************/

public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

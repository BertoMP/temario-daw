package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto14_EstacionMeteorologica.main;

import tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto14_EstacionMeteorologica.clases.Inicio;

/***********************************************************************************************************************
 * Implementar una aplicación simula el registro de las temperaturas, a lo largo de un día, en una estación            *
 * meteorológica. La aplicación mostrará un menú con las opciones:                                                     *
 *      1. Nuevo registro (que introduciremos manualmente, aunque se supone que, en el sistema original,               *
 *         estaría controlado por un reloj).                                                                           *
 *      2. Listar registros.                                                                                           *
 *      3. Mostrar estadística (con los valores máximo, mínimo y promedio de las temperaturas registradas hasta el     *
 *         momento desde la primera lectura del día).                                                                  *
 *      4. Salir.                                                                                                      *
 * Al salir, los datos se grabarán en un fichero binario cuyo nombre estará compuesto por la cadena "registros"        *
 * concatenada con la fecha del día en el formato "yyyyMMdd" y extensión ".dat".                                       *
 * Cada registro constará de la temperatura en grados centígrados y la hora, que se leerá del sistema en el momento de *
 * la creación del registro.                                                                                           *
 ***********************************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto11_conjunto.main;
import tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto11_conjunto.clases.Inicio;
/***********************************************************************************************************************
 * Un conjunto es una estructura dinámica de datos como la lista, con dos diferencias: en primer lugar, en una lista   *
 * puede haber elementos repetidos, mientras que en un conjunto, no. Además, en una lista el orden de inserción de     *
 * los elementos puede ser relevante y debemos tenerlo en cuenta, mientras que en un conjunto solo interesa si un      *
 * elemento pertenece o no al conjunto y no el lugar que ocupa. Se pide implementar la clase Conjunto utilizando       *
 * una lista para almacenar números de tipo integer. Implementa los siguientes métodos:                                *
 *  - Un constructor sin parámetros.                                                                                   *
 *  - int numeroElementos (): devuelve el número de elementos del conjunto.                                            *
 *  - boolean insertar (integer nuevo): insertaFinal un nuevo elemento en el conjunto.                                 *
 *  - boolean insertar (Conjunto otroConjunto): añade al conjunto los elementos del conjunto otroConjunto.             *
 *  - boolean eliminarElemento (Integer elemento): en caso de pertenecer al conjunto, eliminaInicio elemento.                *
 *  - boolean eliminarConjunto (Conjunto otroConjunto): eliminaInicio del conjunto invocante los elementos del conjunto      *
 *    que se pasa como parámetro.                                                                                      *
 *  - boolean pertenece (Integer elemento): indica si el elemento que se le pasa como parámetro pertenece o            *
 *    no al conjunto.                                                                                                  *
 *  - muestra (): muestra el conjunto por consola.                                                                     *
 * De forma general, los métodos que devuelven un booleano indican con él si el conjunto se ha modificado.             *
 ***********************************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto16_RAE.main;

import tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto16_RAE.clases.Inicio;

/***********************************************************************************************************************
 * Los miembros de la Real Academia de la Lengua ocupan sillones con las letras del abecedario español, minúsculas y   *
 * mayúsculas (en la práctica, las letras v, w, x, y, z, Ñ, W, Y nunca se ocupan, pero nosotros no lo tendremos en     *
 * cuenta). Cuando un sillón queda vacante, se nombre un nuevo académico para ocuparlo.                                *
 * Implementar la clase Academico, cuyos atributos son el nombre y el año de ingreso. El criterio de ordenación        *
 * natural será por nombres.                                                                                           *
 * Implementar un programa donde se crean cinco objetos Academico, que se insertan en un mapa en el que la clave es    *
 * la letra del sillón que ocupan, y el valor un objeto de la clase Academico. Para ello implementar el método         *
 * estático:                                                                                                           *
 *      static boolean nuevoAcademico(Map<Character, Academico> academia, Academico nuevo, Character letra),           *
 * donde se lleva a cabo la inserción después de comprobar que el carácter pasado como parámetro es una letra del      *
 * abecedario.                                                                                                         *
 * Hacer diversos listados de los académicos: primero sin letra, por orden de nombre y de año de ingreso; y después    *
 * con letra, por orden de letra (clave), nombre y fecha de ingreso. Debemos recordar que, en código Unicode, las      *
 * mayúsculas van antes que las minúsculas.                                                                            *
 ***********************************************************************************************************************/

public class Main {
    public static void main(String[] args) {
        Inicio.inicio();
    }
}

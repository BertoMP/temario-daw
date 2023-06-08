package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto13_ComparatorSocioNombreReversed.comparadores;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto12_ComparatorSocioNombre.clases.Socio;

import java.util.Comparator;

/***********************************************************************************************************************
 * Clase ComparadorSocioNombre que implementa la interfaz Comparator.                                                  *
 ***********************************************************************************************************************/
public class ComparadorSocioNombre implements Comparator {
    /*******************************************************************************************************************
     * Implementación del método abstracto de la interfaz Comparator modificado para comparar dos objetos por su       *
     * atributo nombre.                                                                                                *
     *                                                                                                                 *
     * @param objeto Objeto de la clase Object.                                                                        *
     * @param otroObjeto Objeto de la clase Object.                                                                    *
     * @return Devuelve un int resultado de la comparación.                                                            *
     *******************************************************************************************************************/
    @Override
    public int compare(Object objeto, Object otroObjeto) {
        Socio socio = (Socio) objeto;
        Socio otroSocio = (Socio) otroObjeto;

        return socio.getStrNombre().compareTo(otroSocio.getStrNombre());
    }
}

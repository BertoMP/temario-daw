package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto04_FutbolistaMejorado.comparadores;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto04_FutbolistaMejorado.clases.Futbolista;

import java.util.Comparator;

/***********************************************************************************************************************
 * Clase que implementa la interfaz Comparator                                                                         *
 ***********************************************************************************************************************/
public class ComparadorFutbolistaNombre implements Comparator {
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
        Futbolista futbolista = (Futbolista) objeto;
        Futbolista otroFutbolista = (Futbolista) otroObjeto;
        return futbolista.getStrNombre().compareTo(otroFutbolista.getStrNombre());
    }
}

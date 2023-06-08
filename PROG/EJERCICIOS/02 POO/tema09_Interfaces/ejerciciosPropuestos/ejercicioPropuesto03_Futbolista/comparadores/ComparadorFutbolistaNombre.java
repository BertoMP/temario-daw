package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto03_Futbolista.comparadores;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto03_Futbolista.clases.Futbolista;

import java.util.Comparator;

/***********************************************************************************************************************
 * Clase que implementa la interfaz Comparator destinada a comparar objetos de tipo Futbolista en base a su nombre.    *
 ***********************************************************************************************************************/
public class ComparadorFutbolistaNombre implements Comparator {
    @Override
    public int compare(Object objeto, Object otroObjeto) {
        Futbolista futbolista = (Futbolista) objeto;
        Futbolista otroFutbolista = (Futbolista) otroObjeto;
        return futbolista.getStrNombre().compareTo(otroFutbolista.getStrNombre());
    }
}
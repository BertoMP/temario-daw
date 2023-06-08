package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto03_Futbolista.comparadores;

import tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto03_Futbolista.clases.Futbolista;

import java.util.Comparator;

/***********************************************************************************************************************
 * Clase que implementa la interfaz Comparator destinada a comparar objetos de tipo Futbolista en base a su edad.      *
 ***********************************************************************************************************************/
public class ComparadorFutbolistaEdad implements Comparator {
    @Override
    public int compare(Object objeto, Object otroObjeto) {
        Futbolista futbolista = (Futbolista) objeto;
        Futbolista otroFutbolista = (Futbolista) otroObjeto;
        return Integer.compare(futbolista.getIntEdad(), otroFutbolista.getIntEdad());
    }
}

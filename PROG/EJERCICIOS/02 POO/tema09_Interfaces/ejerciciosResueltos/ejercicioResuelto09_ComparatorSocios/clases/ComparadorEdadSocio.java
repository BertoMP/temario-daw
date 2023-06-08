package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto09_ComparatorSocios.clases;

import java.util.Comparator;

public class ComparadorEdadSocio implements Comparator {
    @Override
    public int compare(Object objeto1, Object objeto2) {
        Socio socio = (Socio) objeto1;
        Socio otroSocio = (Socio) objeto2;
        return socio.getIntEdad() - otroSocio.getIntEdad();
    }
}

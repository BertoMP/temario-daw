package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto10_ComparatorNumerosAleatorios.clases;

import java.util.Comparator;

public class ComparadorNumeros implements Comparator {
    @Override
    public int compare(Object objeto1, Object objeto2) {
        Integer num1 = (Integer) objeto1;
        Integer num2 = (Integer) objeto2;

        return num2 - num1;
    }
}

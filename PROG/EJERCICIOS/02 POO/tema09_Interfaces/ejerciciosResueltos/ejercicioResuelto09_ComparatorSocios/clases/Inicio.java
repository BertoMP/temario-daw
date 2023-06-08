package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto09_ComparatorSocios.clases;

import java.util.Arrays;

public class Inicio {
    public static void inicio() {
        Socio[] arrSocios = {new Socio(5,"Pepe", 32),
                new Socio(7,"María", 35),
                new Socio(2,"Julio", 27)};
        ComparadorEdadSocio comp1 = new ComparadorEdadSocio();

        Arrays.sort(arrSocios, comp1);
        System.out.println("Array Ordenado: " + Arrays.deepToString(arrSocios));

        Arrays.sort(arrSocios, comp1.reversed());
        System.out.println("Array Ordenado: " + Arrays.deepToString(arrSocios));
    }
}

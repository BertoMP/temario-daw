package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto10_ComparatorNumerosAleatorios.clases;

import java.util.Arrays;

public class Inicio {
    public static void inicio() {
        Integer intNumAleatorio;
        Integer[] intNum = new Integer[20];
        ComparadorNumeros nuevoComparador = new ComparadorNumeros();
        for (int intCont = 0; intCont < 20; intCont++) {
            intNumAleatorio = (int) (Math.random() * 100) + 1;
            intNum[intCont] = intNumAleatorio;
        }

        Arrays.sort(intNum, nuevoComparador);

        System.out.println(Arrays.deepToString(intNum));
    }
}

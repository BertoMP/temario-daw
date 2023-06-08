package tema12_Colecciones.ejerciciosResueltos.ejercicioResuelto02_Contenedor.clases;

public class Inicio {
    public static void inicio() {
        Contenedor<Integer> contenedor = new Contenedor<>(new Integer[0]);
        Integer integerRetorno;
        int intNumAleatorio;

        for (int intCont = 0; intCont < 10; intCont++) {
            intNumAleatorio = (int) (Math.random() * 10) + 1;

            if (intCont %2 == 0) {
                contenedor.insertarAlFinal(intNumAleatorio);
            } else {
                contenedor.insertarAlInicio(intNumAleatorio);
            }
        }

        System.out.println("Array sin ordenar: " + contenedor);
        contenedor.ordenar();
        System.out.println("Array ordenado: " + contenedor);
        integerRetorno = contenedor.extraerDelPrincipio();
        System.out.println("Primer Integer: " + integerRetorno);
        System.out.println(contenedor);
        integerRetorno = contenedor.extraerDelFinal();
        System.out.println("Último Integer: " + integerRetorno);
        System.out.println(contenedor);

    }
}

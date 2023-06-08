package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaArrayBidimensional.clases;

public class Videojuego implements Comparable {
    private String strTitulo;
    private int intAnnoPublicacion;
    private String strEstudio;

    public Videojuego(String strTitulo, int intAnnoPublicacion, String strEstudio) {
        this.strTitulo = strTitulo;
        this.intAnnoPublicacion = intAnnoPublicacion;
        this.strEstudio = strEstudio;
    }

    @Override
    public String toString() {
        return "Videojuego -> Título: \"" + this.strTitulo + "\", Año Publicación: " + this.intAnnoPublicacion +
                ", Estudio: " + this.strEstudio;
    }

    @Override
    public int compareTo(Object objeto) {
        Videojuego otroVideojuego = (Videojuego) objeto;
        int intDevolver;

        intDevolver = Integer.compare(this.intAnnoPublicacion, otroVideojuego.intAnnoPublicacion);

        if (intDevolver == 0) {
            intDevolver = this.strTitulo.compareTo(otroVideojuego.strTitulo);
        }

        return intDevolver;
    }
}

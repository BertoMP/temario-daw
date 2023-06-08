package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaArrayBidimensional.clases;

public class Pelicula implements Comparable {
    private String strTitulo;
    private int intAnnoEstreno;
    private String strDirector;

    public Pelicula(String strTitulo, int intAnnoEstreno, String strDirector) {
        this.strTitulo = strTitulo;
        this.intAnnoEstreno = intAnnoEstreno;
        this.strDirector = strDirector;
    }

    @Override
    public String toString() {
        return "Película -> Título: \"" + this.strTitulo + "\", Año de estreno: " + this.intAnnoEstreno +
                ", Director: " + this.strDirector;
    }

    @Override
    public int compareTo(Object objeto) {
        Pelicula otraPelicula = (Pelicula) objeto;
        return this.strTitulo.compareTo(otraPelicula.strDirector);
    }
}

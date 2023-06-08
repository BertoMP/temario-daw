package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto08_ComparableSocioNombre.clases;

public class Socio implements Comparable{
    private int intId;
    private String strNombre;

    public Socio(int intId, String strNombre) {
        this.intId = intId;
        this.strNombre = strNombre;
    }

    @Override
    public int compareTo(Object objeto) {
        Socio otroSocio = (Socio) objeto;
        return this.strNombre.compareTo(otroSocio.strNombre);
    }

    @Override
    public String toString() {
        return "ID:" + this.intId + " Nombre: " + this.strNombre;
    }
}

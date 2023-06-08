package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto07_ComparableSocio.clases;

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
        return Integer.compare(this.intId, otroSocio.intId);
    }

    @Override
    public String toString() {
        return "ID:" + this.intId + " Nombre: " + this.strNombre;
    }
}

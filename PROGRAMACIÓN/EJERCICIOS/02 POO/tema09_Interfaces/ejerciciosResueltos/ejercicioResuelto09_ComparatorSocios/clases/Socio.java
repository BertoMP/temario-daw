package tema09_Interfaces.ejerciciosResueltos.ejercicioResuelto09_ComparatorSocios.clases;

public class Socio {
    private int intId;
    private String strNombre;

    private int intEdad;

    public Socio(int intId, String strNombre, int intEdad) {
        this.intId = intId;
        this.strNombre = strNombre;
        this.intEdad = intEdad;
    }

    public int getIntEdad() {
        return this.intEdad;
    }

    @Override
    public String toString() {
        return "ID: " + this.intId + " Nombre " + this.strNombre + " Edad: " + this.intEdad;
    }
}

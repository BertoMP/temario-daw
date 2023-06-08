package clases;
public class Fisio extends Persona {
    private int intAnnosExperiencia;
    private String strTitulacion;

    public Fisio(String strNombre, String strApellidos, int intEdad, int intAnnosExperiencia, String strTitulacion) {
        super(strNombre, strApellidos, intEdad);
        this.intAnnosExperiencia = intAnnosExperiencia;
        this.strTitulacion = strTitulacion;
    }

    public void setIntAnnosExperiencia(int intAnnosExperiencia) {
        this.intAnnosExperiencia = intAnnosExperiencia;
    }

    public void setStrTitulacion(String strTitulacion) {
        this.strTitulacion = strTitulacion;
    }

    public int getIntAnnosExperiencia() {
        return intAnnosExperiencia;
    }

    public String getStrTitulacion() {
        return strTitulacion;
    }

    public void acudePartido() {
        System.out.println("La fisio " + getStrNombre() + " " + getStrApellidos() +
                " (" + getStrTitulacion() + ") trata lesiones que se produzcan en el partido.");
    }

    public void acudeEntrenamiento() {
        System.out.println("La fisio " + getStrNombre() + " " + getStrApellidos() +
                " (" + getStrTitulacion() + ") trata lesiones que se produzcan en el entrenamiento.");
    }
}

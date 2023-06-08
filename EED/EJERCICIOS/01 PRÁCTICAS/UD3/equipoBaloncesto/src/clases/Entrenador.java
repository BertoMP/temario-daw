package clases;
public class Entrenador extends Persona {
    private int intAnnosExperiencia;

    public Entrenador(String strNombre, String strApellidos, int intEdad, int intAnnosExperiencia) {
        super(strNombre, strApellidos, intEdad);
        this.intAnnosExperiencia = intAnnosExperiencia;
    }

    public void setIntAnnosExperiencia(int intAnnosExperiencia) {
        this.intAnnosExperiencia = intAnnosExperiencia;
    }

    public int getIntAnnosExperiencia() {
        return intAnnosExperiencia;
    }

    public void acudePartido() {
        System.out.println("El entrenador " + getStrNombre() + " " + getStrApellidos()
                + " (" + getIntAnnosExperiencia() + " años dirigiendo al equipo) dirige el partido.");
    }

    public void acudeEntrenamiento() {
        System.out.println("El entrenador " + getStrNombre() + " " + getStrApellidos()
                + " (" + getIntAnnosExperiencia() + " años dirigiendo al equipo) dirige el entrenamiento.");
    }
}

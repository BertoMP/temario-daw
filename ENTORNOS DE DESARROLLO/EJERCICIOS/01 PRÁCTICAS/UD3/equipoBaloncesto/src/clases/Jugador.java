package clases;
public class Jugador extends Persona {
    private int intDorsal;
    private String strPosicion;

    public Jugador(String strNombre, String strApellidos, int intEdad, int intDorsal, String strPosicion) {
        super(strNombre, strApellidos, intEdad);
        this.intDorsal = intDorsal;
        this.strPosicion = strPosicion;
    }

    public void setIntDorsal(int intDorsal) {
        this.intDorsal = intDorsal;
    }

    public void setStrPosicion(String strPosicion) {
        this.strPosicion = strPosicion;
    }

    public int getIntDorsal() {
        return intDorsal;
    }

    public String getStrPosicion() {
        return strPosicion;
    }

    public void acudePartido() {
        System.out.println("El jugador " + getStrNombre() + " " + getStrApellidos()
                + " (dorsal: " + getIntDorsal() + " y posición: " + getStrPosicion()
                + ") juega el partido.");
    }

    public void acudeEntrenamiento() {
        System.out.println("El jugador " + getStrNombre() + " " + getStrApellidos()
                + " (dorsal: " + getIntDorsal() + " y posición: " + getStrPosicion()
                + ") realiza el entrenamiento.");
    }
}

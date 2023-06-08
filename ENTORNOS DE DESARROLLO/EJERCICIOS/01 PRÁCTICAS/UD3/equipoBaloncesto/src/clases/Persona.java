package clases;
public abstract class Persona {
    protected String strNombre;
    protected String strApellidos;
    protected int intEdad;

    public Persona(String strNombre, String strApellidos, int intEdad) {
        this.strNombre = strNombre;
        this.strApellidos = strApellidos;
        this.intEdad = intEdad;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public void setStrApellidos(String strApellidos) {
        this.strApellidos = strApellidos;
    }

    public void setIntEdad(int intEdad) {
        this.intEdad = intEdad;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public String getStrApellidos() {
        return strApellidos;
    }

    public int getIntEdad() {
        return intEdad;
    }

    public void cumplirAnnos() {
        intEdad++;
    }

    public void comer(String strComida) {
        System.out.println(getStrNombre() + " come " + strComida + ".");
    }

}

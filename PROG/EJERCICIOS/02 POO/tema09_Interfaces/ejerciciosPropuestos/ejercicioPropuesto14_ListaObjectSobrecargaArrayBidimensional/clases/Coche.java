package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaArrayBidimensional.clases;


public class Coche implements Comparable {
    private String strMarca;
    private String strModelo;
    private String strMatricula;

    public Coche(String strMarca, String strModelo, String strMatricula) {
        this.strMarca = strMarca;
        this.strModelo = strModelo;
        this.strMatricula = strMatricula;
    }

    @Override
    public String toString() {
        return "Coche -> Marca: " + this.strMarca + ", Modelo: " + this.strModelo + ", Matrícula: " + this.strMatricula;
    }

    @Override
    public int compareTo(Object objeto) {
        Coche otroCoche = (Coche) objeto;
        return this.strMatricula.compareTo(otroCoche.strMatricula);
    }
}

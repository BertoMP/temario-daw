package clases;
public class Estudiante extends Persona{
// Incluye un método de clase que se une a los heredados
	int curso;
	public Estudiante() {
		edad=25;
		nombre = "Luis";
		curso = 1;
	}
	public void presentarse(){
	System.out.println("Soy " + nombre + " Alumno de " + Integer.toString(curso) 
		+ " y tengo una edad de: " + Integer.toString(edad));
	}
	public String preguntacolor(){
		presentarse();
		Ordenador mipc = new Ordenador();
		return mipc.color();
	}
}

package clases;
public class Profesor extends Persona{
	public Profesor() {} // Constructor
	// Hace la pregunta al estudiante sobre el color
	public String preguntacolor(){
		Estudiante alumno = new Estudiante();
		String colorRec = alumno.preguntacolor();
		return colorRec; 
	} 
}

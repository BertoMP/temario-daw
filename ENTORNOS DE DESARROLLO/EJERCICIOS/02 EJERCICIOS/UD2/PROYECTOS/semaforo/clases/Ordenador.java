package clases;
import java.util.Random;
public class Ordenador {
	public Ordenador() {}
	public String color(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(3);
		if(randomInt == 0){
			return "rojo";
		} else if(randomInt == 1) {
			return "amarillo";
		}else{
			return "verde";
		}
	}
}

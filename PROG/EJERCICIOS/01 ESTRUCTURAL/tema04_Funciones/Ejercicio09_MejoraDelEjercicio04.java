package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio09_MejoraDelEjercicio04 {

    public static int numeroMayor(int intNumUsuario1, int intNumUsuario2){
        int intNumMayor = (intNumUsuario1 > intNumUsuario2) ? intNumUsuario1 : intNumUsuario2;
        return intNumMayor;
    }

    public static int numeroMayor(int intNumUsuario1, int intNumUsuario2, int intNumUsuario3){
        int intAuxiliar = numeroMayor(intNumUsuario1, intNumUsuario2);
        int intNumMayor = (intAuxiliar > intNumUsuario3) ? intAuxiliar : intNumUsuario3;
        return intNumMayor;
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);
        int intNumUsuario1;
        int intNumUsuario2;
        int intNumUsuario3;
        int intNumMayor = 0;
        byte bytOpcionElegida;

        System.out.print("Cuantos numeros quiere introducir? (Posibilidades 2 o 3)"
                       + "\n\t Opcion elegida: ");
        bytOpcionElegida = scEntrada.nextByte();
        if(bytOpcionElegida == 2){
            System.out.print("Introduzca el primer numero: ");
            intNumUsuario1 = scEntrada.nextInt();

            System.out.print("Introduzca el segundo numero: ");
            intNumUsuario2 = scEntrada.nextInt();

            intNumMayor = numeroMayor(intNumUsuario1, intNumUsuario2);
        }
        if(bytOpcionElegida == 3){
            System.out.print("Introduzca el primer numero: ");
            intNumUsuario1 = scEntrada.nextInt();

            System.out.print("Introduzca el segundo numero: ");
            intNumUsuario2 = scEntrada.nextInt();

            System.out.print("Introduzca el tercer numero: ");
            intNumUsuario3 = scEntrada.nextInt();

            intNumMayor = numeroMayor(intNumUsuario1, intNumUsuario2, intNumUsuario3);
        }
        scEntrada.close();
        System.out.println("El numero mayor es: " + intNumMayor);
    }
}

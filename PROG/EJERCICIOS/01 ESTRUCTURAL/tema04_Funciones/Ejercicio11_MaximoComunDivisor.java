package tema04_Funciones.actividades;

import java.util.Scanner;
public class Ejercicio11_MaximoComunDivisor {
    public static int maximoComunDivisor(int intNumUsuario1, int intNumUsuario2){
        int intResultado;
        int intMenor;
        int intMayor;

        if(intNumUsuario2 == 0){
            intResultado = intNumUsuario1;
        } else if (intNumUsuario1 == 0) {
            intResultado = intNumUsuario2;
        } else{
            intResultado = (intNumUsuario1 >= intNumUsuario2)
                                        ? maximoComunDivisor(intNumUsuario1 - intNumUsuario2, intNumUsuario2)
                                        : maximoComunDivisor(intNumUsuario1, intNumUsuario2 - intNumUsuario1);
        }

        return intResultado;
    }

    public static void main(String[] args) {
        Scanner scEntrada = new Scanner(System.in);

        int intNumUsuario1;
        int intNumUsuario2;
        int intResultado;

        System.out.print("Introduzca el primer numero: ");
        intNumUsuario1 = scEntrada.nextInt();

        System.out.print("Introduzca el segundo numero: ");
        intNumUsuario2 = scEntrada.nextInt();

        intResultado = maximoComunDivisor(intNumUsuario1,intNumUsuario2);

        System.out.println("El maximo comun divisor de " + intNumUsuario1 + " y " + intNumUsuario2
                         + " es " + intResultado);
    }
}

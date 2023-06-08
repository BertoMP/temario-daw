package tema07_Clases.ejerciciosResueltos.ejercicioResuelto07_texto.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de la clase Scanner.
        Texto nuevoTexto; //Objeto de la clase Texto.

        //DECLARACIÓN DE VARIABLES
        int intLongitudMaxima; //Variable que guardará la longitud máxima del objeto de la clase Texto.
        int intOpcionUsuario; //Variable que guardará la opción elegida por el usuario.
        char chrCaracter; //Variable que guardará el carácter a añadir a la cadena del objeto de la clase Texto.
        String strCadena; //Variable que guardara la cadena a añadir a la cadena del objeto de la clase Texto.

        //SOLICITUD DE DATOS
        System.out.print("Dime la longitud máxima del texto: ");
        intLongitudMaxima = scEntrada.nextInt();
        nuevoTexto = new Texto(intLongitudMaxima);

        //BUCLE DO WHILE PARA EL DESARROLO PRINCIPAL DEL PROGRAMA
        do {
            System.out.println("""
                Elige una de las opciones:
                    1. Añadir un carácter al final de la cadena.
                    2. Añadir un carácter al inicio de la cadena.
                    3. Añadir una cadena al final de la cadena.
                    4. Añadir una cadena al inicio de la cadena.
                    5. Mostrar información de la cadena.
                    6. Calcular el número de vocales.
                    7. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = scEntrada.nextInt();
            scEntrada.nextLine();

            switch (intOpcionUsuario) {
                case 1, 2 -> {
                    System.out.print("Dime el carácter a añadir: ");
                    chrCaracter = scEntrada.nextLine().charAt(0);
                    nuevoTexto.anadeCaracter(chrCaracter, intOpcionUsuario);
                }
                case 3, 4 -> {
                    System.out.print("Dime el carácter a añadir: ");
                    strCadena = scEntrada.nextLine();
                    nuevoTexto.anadeCadena(strCadena, intOpcionUsuario);
                }
                case 5 -> System.out.println(nuevoTexto.mostrar());
                case 6 -> System.out.println("El número de vocales es: " + nuevoTexto.numeroVocales() + ".");
                case 7 -> System.out.println("Fin del programa.");
                default -> System.out.println("La opción elegida no es válida.");
            }

            System.out.println();
        } while (intOpcionUsuario != 7);
        scEntrada.close();
    }
}

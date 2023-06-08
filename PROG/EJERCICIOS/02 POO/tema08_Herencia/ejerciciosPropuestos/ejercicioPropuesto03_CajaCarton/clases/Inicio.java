package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto03_CajaCarton.clases;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto03_CajaCarton.clases.caja.CajaCarton;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        CajaCarton nuevaCajaCarton; //Objeto de tipo CajaCarton.

        //DECLARACIÓN DE VARIABLES
        int intAncho; //Variable que guardará el ancho de la caja.
        int intAlto; //Variable que guardará el alto de la caja.
        int intFondo; //Variable que guardará el fondo de la caja.
        int intOpcionUsuario; //Variable para la elección del usuario en el menú.
        String strEtiqueta; //String que guarda la cadena de texto de la etiqueta de la caja.

        System.out.println("Generando caja...");
        System.out.print("Introduce ancho: ");
        intAncho = scEntrada.nextInt();
        System.out.print("Introduce alto: ");
        intAlto = scEntrada.nextInt();
        System.out.print("Introduce fondo: ");
        intFondo = scEntrada.nextInt();

        nuevaCajaCarton = new CajaCarton(intAncho, intAlto, intFondo);

        do {
            System.out.println("""
                    Elige una opción:
                        1. Calcular el volumen de la caja.
                        2. Calcular la superficie de la caja.
                        3. Generar una etiqueta de envío.
                        4. Conseguir los datos de la caja.
                        5. Salir.""");
            System.out.print("Opción: ");
            intOpcionUsuario = scEntrada.nextInt();
            System.out.println();

            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El volumen de la caja es: " + (int) nuevaCajaCarton.getVolumen() + "cm3");
                case 2 -> System.out.println("La superficie de la caja es: " + nuevaCajaCarton.getSuperficie() + "cm2");
                case 3 -> {
                    System.out.print("Introduzca el texto a colocar en la etiqueta: ");
                    scEntrada.nextLine();
                    strEtiqueta = scEntrada.nextLine();
                    nuevaCajaCarton.setStrEtiqueta(strEtiqueta);
                }
                case 4 -> System.out.println(nuevaCajaCarton);
                case 5 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("La opción introducida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 5);
        scEntrada.close();
    }
}

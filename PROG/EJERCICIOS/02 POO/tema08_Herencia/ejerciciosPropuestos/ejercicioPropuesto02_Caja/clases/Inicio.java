package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto02_Caja.clases;

import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto02_Caja.enumerados.Unidad;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Caja nuevaCaja; //Objeto de tipo Caja.

        //DECLARACIÓN DE VARIABLES
        int intAncho; //Variable que guardará el ancho de la caja.
        int intAlto; //Variable que guardará el alto de la caja.
        int intFondo; //Variable que guardará el fondo de la caja.
        int intUnidad; //Variable para decidir en el menú la unidad de medida utilizada.
        Unidad unidadMedida = null; //Variable para guardar la unidad de medida utilizada.
        int intOpcionUsuario; //Variable para la elección del usuario en el menú.
        String strEtiqueta; //String que guarda la cadena de texto de la etiqueta de la caja.

        System.out.println("Generando caja...");
        System.out.print("Introduce ancho: ");
        intAncho = scEntrada.nextInt();
        System.out.print("Introduce alto: ");
        intAlto = scEntrada.nextInt();
        System.out.print("Introduce fondo: ");
        intFondo = scEntrada.nextInt();
        do {
            System.out.println("""
                Unidad que se ha utilizado:
                    1. Centímetros (CM).
                    2. Metros (M).""");
            System.out.print("Opción: ");
            intUnidad = scEntrada.nextInt();
            switch (intUnidad) {
                case 1 -> unidadMedida = Unidad.CM;
                case 2 -> unidadMedida = Unidad.M;
                default -> System.out.println("Opción incorrecta. Vuelva a intentarlo.");
            }
        } while (intUnidad < 1 || intUnidad > 2);

        nuevaCaja = new Caja(intAncho, intAlto, intFondo, unidadMedida);

        do {
            System.out.println("""
                    Elige una opción:
                        1. Calcular el volumen de la caja.
                        2. Generar una etiqueta de envío.
                        3. Conseguir los datos de la caja.
                        4. Salir.""");
            System.out.print("Opción: ");
            intOpcionUsuario = scEntrada.nextInt();
            System.out.println();

            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El volumen de la caja es: " + (int) nuevaCaja.getVolumen()
                            + (nuevaCaja.getUnidadMedida().equals(Unidad.M) ? "m3": "cm3"));
                case 2 -> {
                    System.out.print("Introduzca el texto a colocar en la etiqueta (30 caracteres máx): ");
                    scEntrada.nextLine();
                    strEtiqueta = scEntrada.nextLine();
                    nuevaCaja.setStrEtiqueta(strEtiqueta);
                }
                case 3 -> System.out.println(nuevaCaja);
                case 4 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("La opción introducida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 4);
        scEntrada.close();
    }
}

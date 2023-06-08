package tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.clases;
import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.clases.instrumento.Campana;
import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.clases.instrumento.Piano;
import tema08_Herencia.ejerciciosPropuestos.ejercicioPropuesto01_Campana.enumerados.NotaMusical;

import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Piano nuevoPiano = new Piano(); //Objeto de tipo Piano.
        Campana nuevaCampana = new Campana(); //Objeto de tipo Campana.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción elegida por el usuario en el menú.
        NotaMusical nota; //Variable que guardará la nota.

        do {
            System.out.println("""
                    Seleccione una opción:
                        1. Añadir una nota musical.
                        2. Interpretar la melodía.
                        3. Salir.""");
            System.out.print("Opción: ");
            intOpcionUsuario = scEntrada.nextInt();
            System.out.println();

            switch (intOpcionUsuario) {
                case 1 -> {
                    nota = Inicio.dimeNota(scEntrada);
                    System.out.println();
                    switch (Inicio.eligeInstrumento(scEntrada)) {
                        case 1 -> nuevoPiano.add(nota);
                        case 2 -> nuevaCampana.add(nota);
                    }
                }
                case 2 -> {
                    switch (Inicio.eligeInstrumento(scEntrada)) {
                        case 1 -> {
                            if (nuevoPiano.dimeLongitudMelodia() != 0) {
                                nuevoPiano.interpretar();
                            } else {
                                System.out.println("La melodía no tiene notas.");
                            }
                        }
                        case 2 -> {
                            if (nuevaCampana.dimeLongitudMelodia() != 0) {
                                nuevaCampana.interpretar();
                            } else {
                                System.out.println("La melodía no tiene notas.");
                            }
                        }
                    }
                }
                case 3 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("La opción introducida no es válida.");
            }
            System.out.println();
        } while(intOpcionUsuario != 3);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de preguntar sobre el instrumento al que se le quiere añadir una nota o interpretar su         *
     * melodía.                                                                                                        *
     *                                                                                                                 *
     * @param scEntrada Objeto de la clase Scanner.                                                                    *
     * @return Devuelve un int con la opción elegida.                                                                  *
     *******************************************************************************************************************/
    private static int eligeInstrumento(Scanner scEntrada) {
        int intInstrumento;
        do {
            System.out.println("""
                        Elige instrumento:
                            1. Piano.
                            2. Campana.""");
            System.out.print("Opción: ");
            intInstrumento = scEntrada.nextInt();
            if (intInstrumento != 1 && intInstrumento != 2) {
                System.out.println("Opción incorrecta. Vuelva a elegir.");
            }
        } while (intInstrumento < 1 || intInstrumento > 2);
        return intInstrumento;
    }

    /*******************************************************************************************************************
     * Método encargado de preguntar sobre la nota que se quiere añadir a la melodía.                                  *
     *                                                                                                                 *
     * @param scEntrada Objeto de la clase Scanner.                                                                    *
     * @return Devuelve la NotaMusical de la opción elegida.                                                           *
     *******************************************************************************************************************/
    private static NotaMusical dimeNota(Scanner scEntrada) {
        int intNotaMusical; //Variable que guardará la opción de la nota musical elegida por el usuario.
        NotaMusical nota = null; //Variable que guarda la nota musical a devolver.

        do {
            System.out.println("""
                                Elige una nota musical:
                                    1. DO.
                                    2. RE.
                                    3. MI.
                                    4. FA.
                                    5. SOL.
                                    6. LA.
                                    7. SI.""");
            System.out.print("Opción: ");
            intNotaMusical = scEntrada.nextInt();
            if (intNotaMusical < 1 || intNotaMusical > 7) {
                System.out.println("La opción no es correcta.");
            }
        } while (intNotaMusical < 1 || intNotaMusical > 7);

        switch (intNotaMusical) {
            case 1 -> nota = NotaMusical.DO;
            case 2 -> nota = NotaMusical.RE;
            case 3 -> nota = NotaMusical.MI;
            case 4 -> nota = NotaMusical.FA;
            case 5 -> nota = NotaMusical.SOL;
            case 6 -> nota = NotaMusical.LA;
            case 7 -> nota = NotaMusical.SI;
        }
        return nota;
    }
}

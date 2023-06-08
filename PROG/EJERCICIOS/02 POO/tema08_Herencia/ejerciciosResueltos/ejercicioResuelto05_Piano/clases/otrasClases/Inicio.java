package tema08_Herencia.ejerciciosResueltos.ejercicioResuelto05_Piano.clases.otrasClases;

import tema08_Herencia.ejerciciosResueltos.ejercicioResuelto05_Piano.clases.enumerados.NotaMusical;
import tema08_Herencia.ejerciciosResueltos.ejercicioResuelto05_Piano.clases.instrumento.Piano;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Piano nuevoPiano = new Piano(); //Objeto de tipo Piano.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción elegida por el usuario en el menú.
        int intNotaMusical; //Variable que guardará la nota musical elegida por el usuario.

        do {
            System.out.println("""
                    Seleccione una opción:
                        1. Añadir una nota musical.
                        2. Interpretar la melodía.
                        3. Salir.""");
            System.out.print("Opción: ");
            intOpcionUsuario = scEntrada.nextInt();

            switch (intOpcionUsuario) {
                case 1 -> {
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
                        switch (intNotaMusical) {
                            case 1 -> nuevoPiano.add(NotaMusical.DO);
                            case 2 -> nuevoPiano.add(NotaMusical.RE);
                            case 3 -> nuevoPiano.add(NotaMusical.MI);
                            case 4 -> nuevoPiano.add(NotaMusical.FA);
                            case 5 -> nuevoPiano.add(NotaMusical.SOL);
                            case 6 -> nuevoPiano.add(NotaMusical.LA);
                            case 7 -> nuevoPiano.add(NotaMusical.SI);
                            default -> System.out.println("La opción introducida no es válida.");
                        }
                    } while (intNotaMusical < 1 || intNotaMusical > 7);
                }
                case 2 -> nuevoPiano.interpretar();
                case 3 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("La opción introducida no es válida.");
            }
        } while(intOpcionUsuario != 3);
        scEntrada.close();
    }
}

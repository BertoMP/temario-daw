package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto02_resuelveEcuaciones.clases;
import java.util.Arrays;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada de llevar el control del programa.                                                                  *
 ***********************************************************************************************************************/
public class Inicio {
    /*******************************************************************************************************************
     * Método encargado de controlar el desarrollo del programa.                                                       *
     *******************************************************************************************************************/
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner
        EcuacionSegundoGrado ecuacionSegundoGrado; //Objeto de tipo EcuacionSegundoGrado

        //DECLARACIÓN DE VARIABLES
        double rlnCoeficienteA; //Variable que guardará el valor de A.
        double rlnCoeficienteB; //Variable que guardará el valor de B.
        double rlnCoeficienteC; //Variable que guardará el valor de C.
        double[] soluciones; //Array que guardará las soluciones.
        int intInputUsuarioCoeficientesCorrectos; //Variable int que servirá para solicitar datos al usuario.
        int intInputUsuarioCoeficienteCambio; //Variable int que servirá para solicitar datos al usuario.
        int intInputUsuarioOpciones; //Variable int que servirá para solicitar datos al usuario.
        int intInputUsuarioOpcionOtraEcuacion; //Variable int que servirá para solicitar datos al usuario.

        do {
            System.out.println("COEFICIENTES");
            rlnCoeficienteA = dimeCoeficienteA(scEntrada);

            System.out.print("\t- COEFICIENTE B: ");
            rlnCoeficienteB = scEntrada.nextDouble();

            System.out.print("\t- COEFICIENTE C: ");
            rlnCoeficienteC = scEntrada.nextDouble();

            ecuacionSegundoGrado = new EcuacionSegundoGrado(rlnCoeficienteA, rlnCoeficienteB, rlnCoeficienteC);

            do {
                System.out.println("\nLos coeficientes son: ");
                System.out.println(ecuacionSegundoGrado.muestraDatos());
                System.out.println(""" 
                                                                       
                        ¿Son correctos?
                            1. Sí.
                            2. No.""");
                System.out.print("OPCIÓN: ");
                intInputUsuarioCoeficientesCorrectos = scEntrada.nextInt();

                switch (intInputUsuarioCoeficientesCorrectos) {
                    case 1 -> System.out.println();
                    case 2 -> {
                        do {
                            System.out.println("""
                                                                     
                                    ¿Qué coeficiente quieres cambiar?
                                          1. Coeficiente A.
                                          2. Coeficiente B.
                                          3. Coeficiente C.""");
                            System.out.print("OPCIÓN: ");
                            intInputUsuarioCoeficienteCambio = scEntrada.nextInt();

                            switch (intInputUsuarioCoeficienteCambio) {
                                case 1 -> {
                                    rlnCoeficienteA = Inicio.dimeCoeficienteA(scEntrada);
                                    ecuacionSegundoGrado.setRlnCoeficienteA(rlnCoeficienteA);
                                }
                                case 2 -> {
                                    System.out.print("\t- COEFICIENTE B: ");
                                    ecuacionSegundoGrado.setRlnCoeficienteB(scEntrada.nextDouble());
                                }
                                case 3 -> {
                                    System.out.print("\t- COEFICIENTE C: ");
                                    ecuacionSegundoGrado.setRlnCoeficienteC(scEntrada.nextDouble());
                                }
                                default -> System.out.println("¡ERROR! Opción no válida.");
                            }
                        } while (intInputUsuarioCoeficienteCambio < 1 || intInputUsuarioCoeficienteCambio > 3);
                    }
                    default -> System.out.println("¡ERROR! Opción no válida.");
                }
            } while (intInputUsuarioCoeficientesCorrectos != 1);

            do {
                System.out.println("""                                                                                                         
                                    ¿Qué quieres saber?
                                          1. Resolver ecuación.
                                          2. El valor del discriminante.""");
                System.out.print("OPCIÓN: ");
                intInputUsuarioOpciones = scEntrada.nextInt();

                switch (intInputUsuarioOpciones) {
                    case 1 -> {
                        System.out.println("SOLUCIONES DE LA ECUACIÓN:");
                        soluciones = ecuacionSegundoGrado.resuelveEcuacion();
                        if (soluciones.length != 0) {
                            System.out.println("Soluciones: " + Arrays.toString(soluciones));
                        }
                    }
                    case 2 -> {
                        System.out.println("VALOR DEL DISCRIMINANTE");
                        ecuacionSegundoGrado.compruebaDiscriminante();
                    }
                    default -> System.out.println("¡ERROR! Opción no válida.");
                }
            } while (intInputUsuarioOpciones < 1 || intInputUsuarioOpciones > 2);

            do {
                System.out.println("""
                                                
                        ¿Quieres resolver otra ecuación?
                            1. Sí.
                            2. No.""");
                System.out.print("OPCIÓN: ");
                intInputUsuarioOpcionOtraEcuacion = scEntrada.nextInt();

                switch (intInputUsuarioOpcionOtraEcuacion) {
                    case 1 -> System.out.println("Reiniciando programa...");
                    case 2 -> System.out.println("Fin del programa.");
                    default -> System.out.println("¡ERROR! Opción no válida.");
                }
            } while (intInputUsuarioOpcionOtraEcuacion < 1 || intInputUsuarioOpcionOtraEcuacion > 2);
            System.out.println();
        } while (intInputUsuarioOpcionOtraEcuacion == 1);
        scEntrada.close();
    }

    private static double dimeCoeficienteA(Scanner scEntrada) {
        double rlnCoeficiente;

        System.out.print("\t- COEFICIENTE A: ");
        rlnCoeficiente = scEntrada.nextDouble();
        while (rlnCoeficiente == 0) {
            System.out.println("¡ERROR! El coeficiente A no puede ser 0.");
            System.out.print("\t- COEFICIENTE A: ");
            rlnCoeficiente = scEntrada.nextDouble();
        }
        return rlnCoeficiente;
    }
}

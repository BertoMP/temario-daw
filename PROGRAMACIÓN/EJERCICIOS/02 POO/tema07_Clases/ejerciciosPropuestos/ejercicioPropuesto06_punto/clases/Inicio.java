package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto06_punto.clases;
import java.util.Scanner;
/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    /*******************************************************************************************************************
     * Método encargado de controlar el desarrollo principal del programa.                                             *
     *******************************************************************************************************************/
    public static void inicio() {
        //DECLARACIÓN E INSTANCIACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Punto nuevoPunto; //Objeto de tipo Punto.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción elegida por el usuario en el menú.

        nuevoPunto = Inicio.generaPunto(scEntrada);

        do {
            System.out.println("""
                        
                        Elige una opción:
                            1. Desplazar el punto en la coordenada X.
                            2. Desplazar el punto en la coordenada Y.
                            3. Desplazar el punto en ambas coordenadas.
                            4. Calcular la distancia euclidiana con respecto a otro punto.
                            5. Muestra la ubicación del punto.
                            6. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = scEntrada.nextInt();
            System.out.println();

            switch (intOpcionUsuario) {
                case 1, 2, 3 -> Inicio.desplazaPunto(nuevoPunto, scEntrada, intOpcionUsuario);
                case 4 -> Inicio.calculaDistanciaEuclidea(nuevoPunto, scEntrada);
                case 5 -> nuevoPunto.muestra();
                case 6 -> System.out.println("Fin de la aplicación.");
                default -> System.out.println("La opción elegida no es válida.");
            }
        } while (intOpcionUsuario != 6);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar un objeto de tipo Punto.                                                            *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve una instancia de la clase Punto.                                                               *
     *******************************************************************************************************************/
    private static Punto generaPunto(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        double rlnCoordX; //Variable que guardará la coordenada X del punto.
        double rlnCoordY; //Variable que guardará la coordenada Y del punto.

        System.out.println("Generando un punto...");
        System.out.print("\t- Dime la coordenada X: ");
        rlnCoordX = scEntrada.nextDouble();
        System.out.print("\t- Dime la coordenada Y: ");
        rlnCoordY = scEntrada.nextDouble();

        return new Punto(rlnCoordX, rlnCoordY);
    }

    /*******************************************************************************************************************
     * Método encargado de desplazar el punto en X, en Y o en ambas coordenadas.                                       *
     *                                                                                                                 *
     * @param punto Objeto del tipo Punto.                                                                             *
     * @param scEntrada Objeto del tipo Scanner.                                                                       *
     * @param intNum Opción seleccionada por el usuario y que determina el desplazamiento a realizar.                  *
     *******************************************************************************************************************/
    private static void desplazaPunto(Punto punto, Scanner scEntrada, int intNum) {
        double rlnDesplazamientoX = 0; //Variable que guardará el desplazamiento en X.
        double rlnDesplazamientoY; //Variable que guardará el desplazamiento en Y.

        if (intNum == 2 || intNum == 4) {
            System.out.print("Dime el desplazamiento en X: ");
            rlnDesplazamientoX = scEntrada.nextDouble();

            if (intNum == 2) {
                punto.desplazaX(rlnDesplazamientoX);
            }
        }

        if (intNum == 3 || intNum == 4) {
            System.out.print("Dime el desplazamiento en Y: ");
            rlnDesplazamientoY = scEntrada.nextDouble();

            if (intNum == 3) {
                punto.desplazaY(rlnDesplazamientoY);
            } else {
                punto.desplazaXY(rlnDesplazamientoX, rlnDesplazamientoY);
            }
        }
    }

    /*******************************************************************************************************************
     * Método encargado de calcular la distancia euclidea entre dos puntos.                                            *
     *                                                                                                                 *
     * @param punto Objeto de tipo punto.                                                                              *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     *******************************************************************************************************************/
    private static void calculaDistanciaEuclidea(Punto punto, Scanner scEntrada) {
        Punto otroPunto;

        otroPunto = generaPunto(scEntrada);

        System.out.println("La distancia entre los puntos es: "
                + punto.distanciaEuclidea(otroPunto) + ".");
    }
}

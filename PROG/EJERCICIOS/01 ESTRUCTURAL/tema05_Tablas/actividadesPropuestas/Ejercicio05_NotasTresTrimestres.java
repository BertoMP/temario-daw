package tema05_Tablas.actividadesPropuestas;
import java.util.Scanner;
/***********************************************************************************************************************
 * Crear un programa que guarde las notas de diferentes grupos de alumnos, cada grupo estara compuesto de 5 alumnos    *
 * cada alumno debe tener 3 notas. Se debe informar de las notas de cada trimestre y calcular la nota media del        *
 * trimestre de cada grupo. Ademas tambien debe calcular la nota media de un alumno dado por consola.                  *
 ***********************************************************************************************************************/
public class Ejercicio05_NotasTresTrimestres {
    /*******************************************************************************************************************
     * Funcion encargada de calcular la nota media de un alumno a partir de su nota de los tres trimestres             *
     *                                                                                                                 *
     * @param intMatriz -> Matriz con las notas de todos los alumno                                                    *
     * @param scEntrada -> Scanner para la entrada de datos                                                            *
     *******************************************************************************************************************/
    public static void notaMediaAlumno(int[][][] intMatriz, Scanner scEntrada) {
        //DECLARACION DE VARIABLES
        int intSumaNotas = 0; //Variable para guardar la suma de las notas del alumno
        int intGrupo; //Variable para guardar el grupo del alumno
        int intAlumno; //Variable para guardar el alumno del que se quiere conocer la media

        //SOLICITUD DE DATOS (GRUPO DEL ALUMNO)
        System.out.print("Elija grupo al que pertenece el alumno (1-" + intMatriz.length + "): ");
        intGrupo = (scEntrada.nextInt() - 1); /* Como el usuario introduce un numero entre 1 y el length, se debe restar 1
                                                 para sacar el indice real de la matriz en su dimension de grupos. */


        //BUCLE WHILE PARA COMPROBAR QUE EL GRUPO EXISTE
        while (intGrupo < 0 || intGrupo > intMatriz.length) {
            System.out.println("ERROR! Grupo no valido");
            System.out.println();
            System.out.print("Elija grupo al que pertenece el alumno (1-" + intMatriz.length + "): ");
            intGrupo = (scEntrada.nextInt() - 1);
        }

        //SOLICITUD DE DATOS (ALUMNO DEL GRUPO)
        System.out.print("Elija alumno del que quiere conocer la nota (1-5): ");
        intAlumno = (scEntrada.nextInt() - 1); /* Como el usuario introduce un numero entre 1 y 5, se debe restar 1
                                                  para sacar el indice real de la matriz en su dimension de alumnos. */

        //BUCLE WHILE PARA COMPROBAR QUE EL ALUMNO EXISTE
        while (intAlumno < 0 || intAlumno > intMatriz[0][0].length) {
            System.out.println("ERROR! Alumno no valido");
            System.out.println();
            System.out.print("Elija alumno del que quiere conocer la nota (1-5): ");
            intAlumno = (scEntrada.nextInt() - 1);
        }
        scEntrada.close();

        //BUCLE FOR PARA RECORRER LA MATRIZ Y SUMAR LAS NOTAS DEL ALUMNO
        for (int intContTrimestre = 0; intContTrimestre < intMatriz[0].length; intContTrimestre++){ /* Lo que hara el bucle es recorrer la matriz en su dimension de trimestres
                                                                                                       para sumar la nota de cada trimestre del alumno y grupo decididos por el
                                                                                                       usuario. */
            intSumaNotas += intMatriz[intGrupo][intContTrimestre][intAlumno];
        }

        //IMPRESION DE RESULTADOS
        System.out.println();
        System.out.print("La nota media del alumno " + (intAlumno + 1) + " del grupo " + (intGrupo + 1) + " es: "
                + intSumaNotas / intMatriz[0].length);
    }

    /*******************************************************************************************************************
     * Funcion encargada de calcular la nota media de cada trimestre.                                                  *
     *                                                                                                                 *
     * @param intMatriz -> Array con las notas.                                                                        *
     *******************************************************************************************************************/
    public static void notaMediaGrupo(int[][][] intMatriz) {
        //DECLARACION DE VARIABLES
        int intSuma; //Variable para guardar la suma de notas de la clase

        //BUCLE FOR PARA RECORRER LA MATRIZ
        for (int intGrupo = 0; intGrupo < intMatriz.length; intGrupo++) { //CONTROLA LOS GRUPOS
            System.out.println("GRUPO " + (intGrupo + 1));
            for (int intTrimestre = 0; intTrimestre < intMatriz[0].length; intTrimestre++) { //CONTROLA LOS TRIMESTRES
                intSuma = 0;
                System.out.print("\tNOTA MEDIA " + (intTrimestre + 1) + "º TRIMESTRE ");
                for (int intAlumno = 0; intAlumno < intMatriz[0][0].length; intAlumno++) { //CONTROLA LOS ALUMNOS
                    intSuma += intMatriz[intGrupo][intTrimestre][intAlumno];
                }
                System.out.println(intSuma / intMatriz[0][0].length);
            }
            System.out.println();
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada de imprimir todas las notas introducidas.                                                     *
     *                                                                                                                 *
     * @param intMatriz -> Array con las notas.                                                                        *
     *******************************************************************************************************************/
    public static void imprimeMatriz (int[][][] intMatriz) {
        for (int intGrupo = 0; intGrupo < intMatriz.length; intGrupo++) { //CONTROLA LOS GRUPOS
            System.out.println("GRUPO " + (intGrupo + 1));
            for (int intTrimestre = 0; intTrimestre < intMatriz[0].length; intTrimestre++) { //CONTROLA LOS TRIMESTRES
                System.out.println("\tNOTAS DEL " + (intTrimestre + 1) + "º TRIMESTRE");
                for (int intAlumno = 0; intAlumno < intMatriz[0][0].length; intAlumno++) { //CONTROLA LOS ALUMNOS
                    System.out.print("\t\tALUMNO " + (intAlumno + 1) + ": "
                            + intMatriz[intGrupo][intTrimestre][intAlumno]);
                }
                System.out.println();
            }
        }
    }
    /*******************************************************************************************************************
     * Funcion encargada de rellenar una matriz.                                                                       *
     *                                                                                                                 *
     * @param intMatriz -> Matriz donde se introduciran las notas.                                                     *
     * @param scEntrada -> Scanner para la entrada de datos por consola.                                               *
     *******************************************************************************************************************/
    public static void rellenaMatriz(int[][][] intMatriz, Scanner scEntrada) {
        //BUCLE FOR PARA RELLENAR LA MATRIZ
        for (int intGrupo = 0; intGrupo < intMatriz.length; intGrupo++) { //CONTROLA LOS GRUPOS
            System.out.println("GRUPO " + (intGrupo + 1));
            for (int intTrimestre = 0; intTrimestre < intMatriz[0].length; intTrimestre++) { //CONTROLA LOS TRIMESTRES
                System.out.println("\tNOTAS DEL " + (intTrimestre + 1) + "º TRIMESTRE");
                for (int intAlumno = 0; intAlumno < intMatriz[0][0].length; intAlumno++) { //CONTROLA LOS ALUMNOS
                    System.out.print("\t\tIntroduzca nota del alumno " + (intAlumno + 1) + ": ");
                    intMatriz[intGrupo][intTrimestre][intAlumno] = scEntrada.nextInt();
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    /*******************************************************************************************************************
     * Funcion encargada del desarrollo principal del programa.                                                        *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        int[][][] intMatrizNotas;
        int intCantGrupos;

        //SOLICITUD DE DATOS (NUMERO DE GRUPOS)
        System.out.print("Introduzca cantidad de grupos: ");
        intCantGrupos = scEntrada.nextInt();
        intMatrizNotas = new int[intCantGrupos][3][5];

        //LLAMADA A LA FUNCION rellenaMatriz(int[][][],Scanner);
        rellenaMatriz(intMatrizNotas, scEntrada);

        //LLAMADA A LA FUNCION imprimeMatriz(int[][][]);
        System.out.println("NOTAS");
        imprimeMatriz(intMatrizNotas);

        //LLAMADA A LA FUNCION notaMediaGrupo(int[][][]);
        System.out.println("NOTAS MEDIAS DE CADA GRUPO");
        notaMediaGrupo(intMatrizNotas);

        //LLAMADA A LA FUNCION notaMediaAlumno(int[][][],Scanner);
        System.out.println("NOTA MEDIA DE UN ALUMNO");
        notaMediaAlumno(intMatrizNotas, scEntrada);
    }
    /*******************************************************************************************************************
     * Metodo Main. Contiene la funcion iniciadora del programa.                                                       *
     *******************************************************************************************************************/
    public static void main(String[] args) {
        inicio();
    }
}
package tema05_Tablas.actividadesPropuestas;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04_SueldosAyuntamiento {
    /*******************************************************************************************************************
     * Funcion encargada de sacar la media de un array.                                                                *
     *                                                                                                                 *
     * @param rlnArr -> Array con los sueldos de los encuestados                                                       *
     *******************************************************************************************************************/
    public static void mediaSueldos(double[] rlnArr){
        //DECLARACION DE VARIABLES
        double rlnSuma = 0; //Variable encargada de almacenar la suma de todos los sueldos

        //BUCLE FOR EACH PARA CALCULAR LA SUMA DE SUELDOS
        for(double rlnValor : rlnArr){
            rlnSuma += rlnValor;
        }

        //IMPRESION DE RESULTADOS
        System.out.println();
        System.out.println("La media de los sueldos es: " + rlnSuma / rlnArr.length);
    }
    /*******************************************************************************************************************
     * Funcion encargada de ordenar de forma decreciente el array de sueldos.                                          *
     *                                                                                                                 *
     * @param rlnArr -> Array con los sueldos de los encuestados.                                                      *
     *******************************************************************************************************************/
    public static void sueldosOrdenadosDecreciente(double[] rlnArr){
        //DECLARACION DE VARIABLES
        double rlnAuxiliar; //Variable que usaremos como auxiliar para guardar el valor de los indices que reordenaremos

        //ORDENAMIENTO DE LOS SUELDOS
        Arrays.sort(rlnArr);

        //BUCLE FOR PARA ORDENAR EL ARRAY DE FORMA DECRECIENTE
        for(int intCont = 0; intCont <= rlnArr.length / 2; intCont++){ /* El bucle se repetira hasta que el contador recorra la mitad del array
                                                                          ya que solo es necesario recorrer la mitad del array para ordenar un
                                                                          array ordenado intercambiando posiciones.
                                                                          La funcion de este bucle es, partiendo de un array ordenado de forma creciente,
                                                                          intercambiar la posicion 0 con la length - 1, la 1 con la lenght - 2, la 2 con
                                                                          la length - 3... hasta conseguir darle la vuelta al array.
                                                                          Para hacer este cambio se hace lo siguiente:
                                                                          1. El valor en el indice del contador se guarda en un array.
                                                                          2. En su lugar se sobreescribe el valor del indice contrario (length - intCont - 1).
                                                                          3. En el indice contrario al contador se escribe el valor guardado en la variable auxiliar. */
            rlnAuxiliar = rlnArr[intCont];
            rlnArr[intCont] = rlnArr[rlnArr.length - intCont - 1];
            rlnArr[rlnArr.length - intCont - 1] = rlnAuxiliar;
        }
    }
    /*******************************************************************************************************************
     * Funcion que va a guardar en un array los sueldos de los diferentes encuestados                                  *
     *                                                                                                                 *
     * @param rlnArr -> Array donde se guardaran los sueldos.                                                          *
     * @return -> Array con los sueldos                                                                                *
     *******************************************************************************************************************/
    public static double[] preguntaSueldos(double[] rlnArr){
        //DECLARACION DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        double rlnSueldo; //Variable donde se guardara el sueldo introducido por el usuario

        //SOLICITUD DE DATOS
        System.out.print("Introduzca sueldo del encuestado 1 (si no hay encuestado introduzca -1): ");
        rlnSueldo = scEntrada.nextDouble();

        //BUCLE FOR PARA RELLENAR EL ARRAY
        for(int intCont = 2; rlnSueldo != - 1; intCont++){ /* Bucle que se mantendrá hasta que el usuario introduzca un
                                                              -1 como sueldo. En cada iteracion del bucle se creara una
                                                              copia del array con un indice de longitud mas.
                                                              A continuacion, se insertara el sueldo (rlnSueldo) en el
                                                              ultimo indice del array, es decir, length - 1.
                                                              Por ultimo, se le volvera a solicitar al usuario un sueldo. */
            rlnArr = Arrays.copyOf(rlnArr, rlnArr.length + 1);
            rlnArr[rlnArr.length - 1] = rlnSueldo;

            System.out.print("Introduzca sueldo del encuestado " + intCont + " (si no hay encuestado introduzca -1): ");
            rlnSueldo = scEntrada.nextDouble();
        }

        scEntrada.close();

        //IMPRESION DE LOS SUELDOS
        System.out.println();
        System.out.println("Los sueldos registrados son los siguientes: " + Arrays.toString(rlnArr));

        //RETURN
        return rlnArr;
    }
    /*******************************************************************************************************************
     * Funcion encargada del desarrollo del programa.                                                                  *
     *******************************************************************************************************************/
    private static void inicio(){
        //DECLARACION DE VARIABLES
        double[] rlnArrSueldos = new double[0]; //Variable array donde se guardaran los sueldos de los encuestados

        //LLAMADA A LA FUNCION preguntasueldos(double[]);
        rlnArrSueldos = preguntaSueldos(rlnArrSueldos);

        //LLAMADA A LA FUNCION sueldosOrdenadosDecreciente(double[]);
        sueldosOrdenadosDecreciente(rlnArrSueldos);

        //IMPRESION DE RESULTADOS
        System.out.println();
        System.out.println("Los sueldos ordenados de forma decreciente son los siguientes: "
                + Arrays.toString(rlnArrSueldos));

        System.out.println();
        System.out.println("El sueldo maximo es: " + rlnArrSueldos[0]);
        System.out.println("El sueldo minimo es: " + rlnArrSueldos[rlnArrSueldos.length - 1]);

        //LLAMADA A LA FUNCIÓN mediaSueldos(double[]);
        mediaSueldos(rlnArrSueldos);
    }
    public static void main(String[] args) {
        inicio();
    }
}

package tema06_Cadenas.ejerciciosResueltos;
import java.util.Scanner;
/***********************************************************************************************************************
 * Los habitantes de Javalandia tienen un idioma algo extraño; cuando hablan siempre comienzan sus frases con          *
 * "Javalín, javalón", para después hacer una pausa más o menos larga (la pausa se representa mediante espacios en     *
 * blanco o tabulaciones) y, a continuación, expresan el mensaje. Existe un dialecto que no comienza sus frases con    *
 * la muletilla anterior, pero siempre las terminan con un silencio, más o menos prolongado y la coletilla             *
 * "javalén, len, len". Se pide diseñar un traductor que, en primer lugar, nos diga si la frase introducida está       *
 * escrita en el idioma de Javalandia (cualquiera de sus dialectos), y en caso afirmativo, nos muestre sólo            *
 * el mensaje sin muletillas.                                                                                          *
 ***********************************************************************************************************************/
public class Ejercicio08_Javalandia {
    /*******************************************************************************************************************
     * Función encargada de controlar el desarrollo principal del programa.                                            *
     *******************************************************************************************************************/
    private static void inicio() {
        //DECLARACIÓN DE VARIABLES
        Scanner scEntrada = new Scanner(System.in);
        final String STR_INICIO_DIALECTO1 = "Javalín, javalón"; //Variable String que contiene la expresión inicial del primer dialecto de Javalandia
        final String STR_FIN_DIALECTO2 = "javalén, len, len"; //Variable String que contiene la expresión final del segundo dialecto de Javalandia
        String strFraseATraducir; //Variable String para guardar la frase a traducir
        boolean blnDialectoJavalandia; //Variable Boolean para comprobar que la frase introducida pertenece a algún dialecto de Javalandia o no

        //SOLICITUD DE DATOS
        System.out.print("Introduzca una frase para traducir: ");
        strFraseATraducir = scEntrada.nextLine();
        scEntrada.close();

        //CONDICIONAL MÚLTIPLE
        if (strFraseATraducir.startsWith(STR_INICIO_DIALECTO1)) { //Condicional para el primer dialecto de Javalandia
            blnDialectoJavalandia = true;
            System.out.println("La frase está escrita en el primer dialecto de Javalandia.");
            strFraseATraducir = strFraseATraducir.substring(STR_INICIO_DIALECTO1.length()); //Eliminamos la parte inicial de la frase
        } else if (strFraseATraducir.endsWith(STR_FIN_DIALECTO2)) { //Condicional para el segundo dialecto de Javalandia
            blnDialectoJavalandia = true;
            System.out.println("La frase está escrita en el segundo dialecto de Javalandia.");
            strFraseATraducir = strFraseATraducir.substring(0, strFraseATraducir.length() - STR_FIN_DIALECTO2.length()); //Eliminamos la parte final de la frase
                } else { //En cualquier otro caso se tratará de una frase en un idioma diferente al de Javalandia
                    blnDialectoJavalandia = false;
                }

        //IMPRESIÓN DE RESULTADOS
        System.out.println(blnDialectoJavalandia ? "Traducción: " + strFraseATraducir.strip() //Con este método se eliminan los espacios en blanco anteriores y posteriores a la cadena
                                                 : "La frase no está escrita en ningún dialecto de Javalandia.");
    }
    public static void main(String[] args) {
        inicio();
    }
}

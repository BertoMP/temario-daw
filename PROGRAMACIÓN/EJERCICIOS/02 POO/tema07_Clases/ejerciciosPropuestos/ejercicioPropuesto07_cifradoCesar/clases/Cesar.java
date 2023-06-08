package tema07_Clases.ejerciciosPropuestos.ejercicioPropuesto07_cifradoCesar.clases;
/***********************************************************************************************************************
 * Clase encargada de generar objetos de tipo Cesar y de manejar sus atributos y métodos correspondientes.             *
 ***********************************************************************************************************************/
public class Cesar {
    //DECLARACIÓN DE VARIABLES
    private static final String STR_ABECEDARIO_MINUS = "abcdefghijklmnñopqrstuvwxyz"; //String que guarda todas las letras del abecedario

    /*******************************************************************************************************************
     * Método encargado de cifrar o descifrar una cadena de texto usando el método de cifrado César.                   *
     *                                                                                                                 *
     * @param strTexto Texto a cifrar o descifrar.                                                                     *
     * @param intCambio Avance o retroceso en la cadena alfabética                                                     *
     * @return Devuelve una cadena cifrada o descifrada empleando el método de cifrado César.                          *
     *******************************************************************************************************************/
    public static String cifraODescifraTexto(String strTexto, int intCambio) {
        String strCadena = "";
        char chrCaracter;
        int intPosicion;
        int intPosicionFinal;
        boolean blnLetraMayuscula;

        for (int intCont = 0; intCont < strTexto.length(); intCont++) {
            chrCaracter = strTexto.charAt(intCont);
            if (Character.isLetter(chrCaracter)) {
                blnLetraMayuscula = Character.isUpperCase(chrCaracter);
                intPosicion = Cesar.STR_ABECEDARIO_MINUS.indexOf(Character.toLowerCase(chrCaracter));

                if (intPosicion == -1) {
                    chrCaracter = cambiaVocal(chrCaracter);
                    intPosicion = Cesar.STR_ABECEDARIO_MINUS.indexOf(chrCaracter);
                }

                intPosicionFinal = intPosicion + intCambio;

                if (intPosicionFinal >= 0) {
                    chrCaracter = Cesar.STR_ABECEDARIO_MINUS.charAt
                            (intPosicionFinal % Cesar.STR_ABECEDARIO_MINUS.length());
                } else {
                    chrCaracter = Cesar.STR_ABECEDARIO_MINUS.charAt
                            (Cesar.STR_ABECEDARIO_MINUS.length() + intPosicionFinal);
                }

                chrCaracter = blnLetraMayuscula ? Character.toUpperCase(chrCaracter) : chrCaracter;

            }
            strCadena += chrCaracter;
        }
        return strCadena;
    }

    /*******************************************************************************************************************
     * Método encargado de cambiar vocales con tilde por vocales sin tilde.                                            *
     *                                                                                                                 *
     * @param chrVocal Vocal tildada.                                                                                  *
     * @return Devuelve una vocal sin tilde.                                                                           *
     *******************************************************************************************************************/
    private static char cambiaVocal(char chrVocal) {
        switch (chrVocal) {
            case 'á', 'Á' -> chrVocal = 'a';
            case 'é', 'É' -> chrVocal = 'e';
            case 'í', 'Í' -> chrVocal = 'i';
            case 'ó', 'Ó' -> chrVocal = 'o';
            case 'ú', 'ü', 'Ú', 'Ü' -> chrVocal = 'u';
        }
        return chrVocal;
    }
}

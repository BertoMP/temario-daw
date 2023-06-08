package tema11_FicherosBinarios.ejerciciosResueltos.ejercicioResuelto09_RegistroTiempo.clases;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE CONSTANTES
        final String STR_NOMBRE = "registro.dat"; //Constante String que guarda el nombre del fichero.

        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in);

        //DECLARACIÓN DE VARIABLES
        Registro[] registros = new Registro[0]; //Array de registros.
        int intOpcionUsuario; //int que guardará la opción del usuario en el menú.
        double rlnTemperatura = 0; //double que guardará la temperatura introducida por el usuario.
        boolean blnTemperaturaCorrecta; //booleano que actuará de bandera.

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto09_RegistroTiempo/documentos/"
                        + STR_NOMBRE))) {
            registros = (Registro[]) inputStream.readObject();
        } catch (EOFException ignored) { //En caso de alcanzar el final del fichero.
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se ha encontrado el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que se produzca un error de lectura.
            System.out.println("Se produjo un error de lectura en el fichero " + STR_NOMBRE);
        } catch (ClassNotFoundException e) { //En caso de que el fichero no contenga la clase indicada.
            System.out.println("El fichero no contiene un array de registros");
        }

        do {
            System.out.println("""
                    Elige una opción:
                        1. Nuevo registro.
                        2. Mostrar historial de registros.
                        3. Salir.""");
            System.out.print("Opción: ");
            try {
                intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
            } catch (NumberFormatException e) { //En caso de introducir un dato no válido.
                intOpcionUsuario = 0;
            }

            switch (intOpcionUsuario) {
                case 0 -> System.out.println("La opción introducida no ha sido un número.");
                case 1 -> {
                    blnTemperaturaCorrecta = false;
                    System.out.print("Introduce la temperatura: ");
                    do {
                        try {
                            rlnTemperatura = Double.parseDouble(scEntrada.nextLine());
                            blnTemperaturaCorrecta = true;
                        } catch (NumberFormatException e) { //En caso de introducir un dato no válido.
                            System.out.print("La temperatura introducida no tiene un formato correcto.");
                        }
                    } while (!blnTemperaturaCorrecta);
                    registros = Arrays.copyOf(registros, registros.length + 1);
                    registros[registros.length - 1] = new Registro(rlnTemperatura);
                }
                case 2 -> System.out.println(Arrays.deepToString(registros));
                case 3 -> System.out.println("Finalizando aplicación.");
                case 4 -> System.out.println("La opción introducida no es válida.");
            }
        } while (intOpcionUsuario != 3);
        scEntrada.close();

        //BLOQUE TRY-CATCH WITH RESOURCES
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                "src/tema11_FicherosBinarios/ejerciciosResueltos/ejercicioResuelto09_RegistroTiempo/documentos/"
                        + STR_NOMBRE))) {
            outputStream.writeObject(registros);
        } catch (FileNotFoundException e) { //En caso de no encontrar el fichero.
            System.out.println("No se ha encontrado el fichero " + STR_NOMBRE);
        } catch (IOException e) { //En caso de que se produzca un error de escritura.
            System.out.println("Se produjo un error de escritura en el fichero " + STR_NOMBRE);
        }
    }
}

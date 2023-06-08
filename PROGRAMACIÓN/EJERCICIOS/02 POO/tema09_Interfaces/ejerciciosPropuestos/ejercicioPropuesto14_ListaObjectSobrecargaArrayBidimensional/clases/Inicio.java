package tema09_Interfaces.ejerciciosPropuestos.ejercicioPropuesto14_ListaObjectSobrecargaArrayBidimensional.clases;

import java.util.Comparator;
import java.util.Scanner;

/***********************************************************************************************************************
 * Clase encargada del control principal del programa.                                                                 *
 ***********************************************************************************************************************/
public class Inicio {
    public static void inicio() {
        //DECLARACIÓN DE OBJETOS
        Scanner scEntrada = new Scanner(System.in); //Objeto de tipo Scanner.
        Lista nuevaLista = new Lista(); //Objeto de tipo Lista.
        Lista otraLista = new Lista(); //Objeto de tipo Lista.
        Object objeto; //Objeto de la clase Object.

        //DECLARACIÓN DE VARIABLES
        int intOpcionUsuario; //Variable que guardará la opción del usuario.
        int intValor; //Variable que guardará un valor a pasar por parámetro.
        int intPosicion; //Variable que guardará una posición de la lista.
        int intRetorno; //Variable que guardará un Integer que se reciba como return de método.
        int intOpcion; //Variable que guarda una opción del usuario en los menús.

        generaListaPersonas(nuevaLista);
        generaListaOtrosElementos(nuevaLista);

        do {
            System.out.println("""
                Elige una opción:
                    1. Obtener el número de elementos insertados en la lista.
                    2. Insertar un elemento al final de la lista.
                    3. Insertar un elemento al principio de la lista.
                    4. Insertar un elemento en un lugar de a lista cuyo índice se pasa como parámetro.
                    5. Añadir al final de la lista los elementos de otra lista que se pasa como parámetro.
                    6. Eliminar un elemento cuyo índice en la lista se pasa como parámetro.
                    7. Obtener el elemento cuyo índice se pasa como parámetro.
                    8. Buscar una persona en la lista, devolviendo el índice del primer lugar donde se encuentre.
                       Si no está devolverá -1.
                    9. Mostrar los elementos de la lista por consola.
                    10. Ordenar elementos de forma natural:
                        - Coches -> Matrícula.
                        - Películas -> Título.
                        - Perro -> Raza (a igual raza ordenará por edad).
                        - Personas -> DNI.
                        - Videojuegos -> Año de publicación (a igual año ordenará por título).
                    11. Ordenar personas por nombre.
                    12. Ordenar personas por edad.
                    13. Ordenar personas por oficio.
                    14. Salir.""");
            System.out.print("OPCIÓN: ");
            intOpcionUsuario = Integer.parseInt(scEntrada.nextLine());
            switch (intOpcionUsuario) {
                case 1 -> System.out.println("El número de elementos es: " + nuevaLista.numeroElementos());
                case 2 -> {
                    objeto = generaObjeto(scEntrada);
                    nuevaLista.insertarFinal(objeto);
                }
                case 3 -> {
                    objeto = generaObjeto(scEntrada);
                    nuevaLista.insertarPrincipio(objeto);
                }
                case 4 -> {
                    objeto = generaObjeto(scEntrada);
                    System.out.print("Dime posición en la que introducirlo: ");
                    intPosicion = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.insertarPosicion(intPosicion, objeto);
                }
                case 5 -> {
                    do {
                        objeto = generaObjeto(scEntrada);
                        otraLista.insertarFinal(objeto);
                        System.out.println("""
                            ¿Quieres añadir otro elemento?
                                1. Sí.
                                2. No.""");
                        System.out.print("Opción: ");
                        intOpcion = Integer.parseInt(scEntrada.nextLine());
                    } while (intOpcion != 2);
                    nuevaLista.insertarFinal(otraLista);
                }
                case 6 -> {
                    System.out.print("Dime el índice que quieres eliminar: ");
                    intValor = Integer.parseInt(scEntrada.nextLine());
                    nuevaLista.eliminar(intValor);
                }
                case 7 -> {
                    System.out.print("Dime el índice que quieras conocer: ");
                    intValor = scEntrada.nextInt();
                    objeto = nuevaLista.dimeObjeto(intValor);
                    System.out.println((objeto != null)
                            ? "En la posición " + intValor + " está la Persona: " + objeto
                            : "No existe el elemento.");
                }
                case 8 ->  {
                    objeto = generaPersona(scEntrada);
                    intRetorno = nuevaLista.buscaObjeto(objeto);
                    System.out.println((intRetorno != -1)
                            ? "El elemento está en la posición " + intRetorno
                            : "No existe el elemento en la lista.");
                }
                case 9 -> {
                    System.out.println("Los elementos de la lista son:");
                    nuevaLista.imprimeArray();
                }
                case 10 -> {
                    nuevaLista.ordenar();
                }
                case 11 -> {
                    if (nuevaLista.compruebaTipo()) {
                        nuevaLista.ordenar(new Comparator() {
                            @Override
                            public int compare(Object objeto, Object otroObjeto) {
                                Persona persona = (Persona) objeto;
                                Persona otraPersona = (Persona) otroObjeto;

                                return persona.getStrNombre().compareTo(otraPersona.getStrNombre());
                            }
                        });
                        System.out.println("Elementos ordenados por nombre:");
                        nuevaLista.imprimeArray();
                    }
                }
                case 12 -> {
                    if (nuevaLista.compruebaTipo()) {
                        nuevaLista.ordenar(new Comparator() {
                            @Override
                            public int compare(Object objeto, Object otroObjeto) {
                                Persona persona = (Persona) objeto;
                                Persona otraPersona = (Persona) otroObjeto;

                                return Integer.compare(persona.getIntEdad(), otraPersona.getIntEdad());
                            }
                        });
                        System.out.println("Elementos ordenados por edad:");
                        nuevaLista.imprimeArray();
                    }
                }
                case 13 -> {
                    if (nuevaLista.compruebaTipo()) {
                        nuevaLista.ordenar(new Comparator() {
                            @Override
                            public int compare(Object objeto, Object otroObjeto) {
                                Persona persona = (Persona) objeto;
                                Persona otraPersona = (Persona) otroObjeto;

                                return persona.getStrOficio().compareTo(otraPersona.getStrOficio());
                            }
                        });
                        System.out.println("Elementos ordenados por oficio:");
                        nuevaLista.imprimeArray();
                    }
                }
                case 14 -> System.out.println("Finalizando programa...");
                default -> System.out.println("La opción elegida no es válida.");
            }
            System.out.println();
        } while (intOpcionUsuario != 14);
        scEntrada.close();
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos.                                                                            *
     *                                                                                                                 *
     * @param scEntrada Objeto Scanner.                                                                                *
     * @return Devuelve el objeto creado.                                                                              *
     *******************************************************************************************************************/
    private static Object generaObjeto(Scanner scEntrada) {
        //DECLARACIÓN DE OBJETOS;
        Object objetoReturn = null; //Objeto de tipo Object que se devolverá.

        //DECLARACIÓN DE VARIABLES
        int intOpcionObjeto; //Int que guarda la opción del usuario.

        System.out.println("""
                            Elige una opción:
                            1. Persona.
                            2. Perro.
                            3. Coche.
                            4. Película.
                            5. Videojuego.""");
        System.out.println("Opción: ");
        intOpcionObjeto = Integer.parseInt(scEntrada.nextLine());
        while (intOpcionObjeto < 1 || intOpcionObjeto > 5) {
            System.out.println("Opción no válida.");
            System.out.println("""
                            Elige una opción:
                            1. Persona.
                            2. Perro.
                            3. Coche.
                            4. Película.
                            5. Videojuego.""");
            System.out.println("Opción: ");
            intOpcionObjeto = Integer.parseInt(scEntrada.nextLine());
        }
        switch (intOpcionObjeto) {
            case 1 -> objetoReturn = generaPersona(scEntrada);
            case 2 -> objetoReturn = generaPerro(scEntrada);
            case 3 -> objetoReturn = generaCoche(scEntrada);
            case 4 -> objetoReturn = generaPelicula(scEntrada);
            case 5 -> objetoReturn = generaVideojuego(scEntrada);
        }

        return objetoReturn;
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Persona.                                                            *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Persona.                                                                     *
     *******************************************************************************************************************/
    private static Persona generaPersona(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que guarda el nombre de la persona.
        String strDni; //String que guarda el DNI de la persona.
        String strOficio; //String que guarda el oficio de la persona.
        int intEdad; //Int que guarda la edad de la persona.

        System.out.print("Dime nombre de la persona: ");
        strNombre = scEntrada.nextLine();
        System.out.print("Dime dni de la persona (formato 12345678-A): ");
        strDni = scEntrada.nextLine();
        System.out.print("Dime edad de la persona: ");
        intEdad = Integer.parseInt(scEntrada.nextLine());
        System.out.print("Dime oficio de la persona: ");
        strOficio = scEntrada.nextLine();

        return new Persona(strNombre, strDni, intEdad, strOficio);
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Perro.                                                              *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Perro.                                                                       *
     *******************************************************************************************************************/
    private static Perro generaPerro(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strNombre; //String que guarda el nombre del perro.
        String strRaza; //String que guarda la raza del perro.
        int intEdad; //Int que guarda la edad de la persona.

        System.out.print("Dime nombre del perro: ");
        strNombre = scEntrada.nextLine();
        System.out.print("Dime raza del perro: ");
        strRaza = scEntrada.nextLine();
        System.out.print("Dime edad del perro: ");
        intEdad = Integer.parseInt(scEntrada.nextLine());

        return new Perro(strNombre, strRaza, intEdad);
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Coche.                                                              *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Coche.                                                                       *
     *******************************************************************************************************************/
    public static Coche generaCoche(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strMarca; //String que guarda la marca del coche.
        String strModelo; //String que guarda el modelo del coche.
        String strMatricula; //String que guarda la matrícula del coche.

        System.out.print("Dime marca del coche: ");
        strMarca = scEntrada.nextLine();
        System.out.print("Dime modelo del coche: ");
        strModelo = scEntrada.nextLine();
        System.out.print("Dime matrícula del coche: ");
        strMatricula = scEntrada.nextLine();

        return new Coche(strMarca, strModelo, strMatricula);
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Pelicula.                                                           *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Pelicula.                                                                    *
     *******************************************************************************************************************/
    private static Pelicula generaPelicula(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strTitulo; //String que guarda el título de la película.
        int intAnnoEstreno; //Int que guarda el año de estreno de la película.
        String strDirector; //String que guarda el director de la película.

        System.out.print("Dime título de la película: ");
        strTitulo = scEntrada.nextLine();
        System.out.print("Dime año de estreno de la película: ");
        intAnnoEstreno = Integer.parseInt(scEntrada.nextLine());
        System.out.print("Dime director de la película: ");
        strDirector = scEntrada.nextLine();

        return new Pelicula(strTitulo, intAnnoEstreno, strDirector);
    }

    /*******************************************************************************************************************
     * Método encargado de generar objetos de tipo Videojuego.                                                         *
     *                                                                                                                 *
     * @param scEntrada Objeto de tipo Scanner.                                                                        *
     * @return Devuelve un objeto de tipo Videojuego.                                                                  *
     *******************************************************************************************************************/
    private static Pelicula generaVideojuego(Scanner scEntrada) {
        //DECLARACIÓN DE VARIABLES
        String strTitulo; //String que guarda el título de la película.
        int intAnnoPublicacion; //Int que guarda el año de publicación del videojuego.
        String strEstudio; //String que guarda el estudio desarrollador del videojuego.

        System.out.print("Dime título del videojuego: ");
        strTitulo = scEntrada.nextLine();
        System.out.print("Dime año de publicación del videojuego: ");
        intAnnoPublicacion = Integer.parseInt(scEntrada.nextLine());
        System.out.print("Dime estudio desarrollador del videojuego: ");
        strEstudio = scEntrada.nextLine();

        return new Pelicula(strTitulo, intAnnoPublicacion, strEstudio);
    }

    private static void generaListaPersonas(Lista nuevaLista) {
        nuevaLista.insertarFinal(new Persona("Alejandro", "12345678-A", 20,
                "Pintor"));
        nuevaLista.insertarFinal(new Persona("Sofía", "98765432-Z", 18,
                "Administrativa"));
        nuevaLista.insertarFinal(new Persona("Julián", "02345432-S", 47,
                "Informático"));
        nuevaLista.insertarFinal(new Persona("Paula", "09127653-G", 36, "Abogada"));
    }

    private static void generaListaOtrosElementos(Lista nuevaLista) {
        nuevaLista.insertarFinal(new Perro("Todd", "Shiba Inu", 7));
        nuevaLista.insertarFinal(new Videojuego("Pokémon Rojo", 1996, "Game Freak"));
        nuevaLista.insertarFinal(new Coche("Toyota", "Corolla", "1234-ABC"));
        nuevaLista.insertarFinal(new Pelicula("Forrest Gump", 1994, "Robert Zemeckis"));
        nuevaLista.insertarFinal(new Perro("Rocky", "Golden Retriever", 2));
        nuevaLista.insertarFinal(new Pelicula("El Padrino", 1972,
                "Francis Ford Coppola"));
        nuevaLista.insertarFinal(new Videojuego("Super Mario Odyssey", 2017,
                "Nintendo EPD"));
        nuevaLista.insertarFinal(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo",
                2001, "Peter Jackson"));
        nuevaLista.insertarFinal(new Coche("Ford", "Mustang", "5678-DEF"));
        nuevaLista.insertarFinal(new Videojuego("The Legend of Zelda: Breath of the Wild",
                2017, "Nintendo EPD"));
        nuevaLista.insertarFinal(new Perro("Toby", "Golden Retriever", 3));
        nuevaLista.insertarFinal(new Coche("BMW", "Serie 3", "9012-GHI"));
        nuevaLista.insertarFinal(new Videojuego("Grand Theft Auto V", 2013,
                "Rockstar North"));
        nuevaLista.insertarFinal(new Coche("Audi", "A3", "3456-JKL"));
        nuevaLista.insertarFinal(new Perro("Nala","Border Collie", 10));
        nuevaLista.insertarFinal(new Coche("Volkswagen", "Golf", "7890-MNO"));
        nuevaLista.insertarFinal(new Pelicula("Titanic", 1997, "James Cameron"));
        nuevaLista.insertarFinal(new Videojuego("Red Dead Redemption 2", 2018,
                "Rockstar Games"));
        nuevaLista.insertarFinal(new Pelicula("Star Wars: Episodio IV - Una Nueva Esperanza",
                1977, "George Lucas"));
        nuevaLista.insertarFinal(new Videojuego("Crash Bandicoot", 1996,
                "Naughty Dog"));
        nuevaLista.insertarFinal(new Pelicula("Jurassic Park", 1993, "Steven Spielberg"));
        nuevaLista.insertarFinal(new Pelicula("Regreso al Futuro", 1985,
                "Robert Zemeckis"));
        nuevaLista.insertarFinal(new Coche("Renault", "Clio", "9481-GHI"));
        nuevaLista.insertarFinal(new Perro("Luna","Border Collie",5));
    }
}

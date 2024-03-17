<?php

/**
 * Clase abstracta para gestionar la conexión a la base de datos mediante PDO.
 */
abstract class Db {

    /**
     * Crea y devuelve una conexión a la base de datos utilizando PDO.
     *
     * @return PDO|null Una instancia de PDO si la conexión es exitosa, o null en caso de error.
     */
    public static function crearConexion(): PDO | null {
        try {
            return new PDO(
                'mysql:host=' . constant('DB_HOST') . '; port=' . constant('DB_PORT') . '; dbname=' . constant('DB_NAME'),
                constant('DB_USER'),
                constant('DB_PASS')
            );
        } catch (PDOException $e) {
            // En caso de error, se muestra un mensaje y se finaliza el script.
            echo "ERROR EN LA CONEXIÓN A LA BASE DE DATOS.";
            exit();
        }
    }
}

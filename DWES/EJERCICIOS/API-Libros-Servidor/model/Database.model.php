<?php

/**
 * Clase abstracta encargada de gestionar la conexión a la base
 * de datos mediante PDO.
 */
abstract class Database
{
    /**
     * Crea y devuelve una conexión PDO a la base de datos.
     *
     * @return PDO|null     La conexión PDO a la base de datos,
     *                      o null si ocurre un error.
     */
    public static function createConn(): PDO|null
    {
        try {
            // Crear y devolver una nueva instancia de PDO con los detalles de conexión.
            return new PDO('mysql:host=' . DB_HOST . '; port= ' . DB_PORT
                . '; dbname=' . DB_NAME, DB_USER, DB_PASS);
        } catch (PDOException $e) {
            // Manejar errores de conexión y mostrar un mensaje de error.
            echo 'ERROR EN LA CONEXIÓN A LA BASE DE DATOS BIBLIOTECA';
            exit();
        }
    }
}
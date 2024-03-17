<?php

abstract class Database
{
    // MÉTODO STATICO ENCARGADO DE GENERAR UNA CONEXIÓN A LA BASE DE DATOS.
    public static function createConn(): PDO|null
    {
        try {
            // Devuelve un objeto PDO a partir de los datos de conexión del archivo
            // config.php. En caso de que ocurra algo inesperado, devolverá un null.
            return new PDO('mysql:host=' . DB_HOST . '; port= ' . DB_PORT
                . '; dbname=' . DB_NAME, DB_USER, DB_PASS);
        } catch (PDOException $e) {
            echo 'ERROR EN LA CONEXIÓN A LA BASE DE DATOS BIBLIOTECA';
            exit();
        }
    }
}
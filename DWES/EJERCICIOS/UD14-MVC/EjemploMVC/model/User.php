<?php

/**
 * Clase User
 *
 * Representa una entidad de usuarios y proporciona
 * métodos para interactuar con la base de datos.
 */
class User {
    private string $table = 'users'; // Nombre de la tabla de la base de datos que almacena los usuarios.
    private PDO $conection; // Objeto de conexión a la base de datos.

    /**
     * Constructor de la clase.
     */
    public function __construct() {
        $this -> conection = Db::crearConexion();
    }

    /**
     * Obtiene la contraseña de un usuario por su nombre de usuario.
     *
     * @param string $username Nombre de usuario.
     * @return string|null Contraseña del usuario o null si no se encuentra.
     */
    public function getPassword($username) {
        $sql = 'SELECT PASSWORD FROM ' . $this->table
            . ' WHERE USERNAME = :username';
        $stmt = $this->conection->prepare($sql);
        $stmt -> bindParam(':username', $username);
        $stmt -> execute();

        $filaUsuario = $stmt -> fetch();

        if ($filaUsuario) {
            return $filaUsuario['PASSWORD'];
        }

        return null;
    }
}
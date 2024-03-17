<?php

use model\Database;

class User {
    private string $tabla = 'USERS';
    private PDO $conexion;

    public function __construct() {
        $this->conexion=Database::getConexion();
    }

    public function getPassword($emailUsuario): string | null {
       $sql = 'SELECT PASSWORD'
           . ' FROM ' . $this->tabla
           . ' WHERE EMAIL = :emailUsuario';
       $stmt = $this->conexion->prepare($sql);
       $stmt->bindParam(':emailUsuario', $emailUsuario);
       $stmt->execute();

       $filaUsuario = $stmt->fetch();

       Database::closeConnection($this->conexion, $stmt);

       if ($filaUsuario) {
           return $filaUsuario['PASSWORD'];
       }

       return null;
    }
}
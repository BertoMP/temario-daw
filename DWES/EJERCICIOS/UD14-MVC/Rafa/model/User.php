<?php

class User{

    private $table = 'users';
    private $conection;

    public function __construct(){
        $this->conection =  Db::abrirConexion();
    }

    /* Get user by name and password */
    public function getUserByParams($usuario, $password){
        if (is_null($usuario) || is_null($password)) return false;
        $sql = "SELECT * FROM " . $this->table . " WHERE username =\"" . $usuario . "\" and password =\"" . $password .
            "\"";
        $stmt = $this->conection->prepare($sql);
        $stmt->execute();
        return $stmt->fetch();
    }
}

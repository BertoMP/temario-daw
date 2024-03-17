<?php

use model\User;

require_once 'model/User.php';

class ControladorLogin{

    public string $page_title;
    public string $view;
    private User $userObj;

    public function __construct(){
        $this->userObj = new User();
        $this->view = 'login';
        $this->page_title = 'Login';
    }

    /* Comprobar Usuario */
    public function check(){
        $result = [];

        if (isset($_POST["usuario"]) && isset($_POST["password"])) {
            $result["usuario"] = $_POST["usuario"];
            $result["password"] = $_POST["password"];

            $usuario = $this->userObj->getUserByParams($_POST["usuario"], $_POST["password"]);
            if ($usuario != false && $usuario != '') {
                $_SESSION['logueado'] = 'verdadero';
                header("Location:index.php?controller=ControladorNota&action=list");
            } else {
                $_REQUEST['error'] = "error";
            }
        }
        return $result;
    }
    public function close(){
        session_destroy();
        session_start();
    }
}

<?php
    // Incluir archivos necesarios
use model\User;

require_once 'model/User.php';

    /**
     * ControladorUsuario Class
     *
     * Este controlador maneja la autenticación de usuarios y las acciones relacionadas con la gestión de sesiones.
     */
    class ControladorUsuario {
        public string $page_title; // Título de la página.
        public string $view; // Vista de la página.
        private User $objUserModel; // Instancia de la clase User.

        /**
         * Constructor de la clase ControladorUsuario.
         *
         * Inicializa las propiedades por defecto y crea una
         * instancia de la clase User.
         */
        public function __construct() {
            $this->page_title = 'Login'; // Título por defecto.
            $this->view = 'login'; // Vista por defecto.
            $this->objUserModel = new User(); // Instancia de la clase User.
        }

        /**
         * Realiza el proceso de inicio de sesión.
         *
         * @return array Resultado del proceso de inicio de sesión,
         *               incluyendo mensajes de error si es necesario.
         */
        public function login(): array {
            $result = [];

            if (isset($_POST['username']) and isset($_POST['password'])) {
                $result['username'] = $_REQUEST['username'];
                $result['password'] = $_REQUEST['password'];

                // Verificar si los campos del formulario no están vacíos
                if (trim($result['username']) === '' || trim($result['password']) === '') {
                    $result['error'] = 'Faltan datos. Ambos campos deben estar rellenados.';
                    return $result;
                }

                // Obtener la contraseña correcta del modelo de usuario
                $correctPassword = $this->objUserModel->getPassword($result['username']);

                // Verificar si la contraseña proporcionada es correcta
                if ($correctPassword !== null && $result['password'] === $correctPassword) {
                    $_SESSION['acceso'] = true; // Establecer la sesión como autenticada.
                    header('Location: http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php'); // Redirigir a la página principal
                } else {
                    $result['error'] = 'Usuario o contraseña incorrectos.';
                }
            }

            return $result;
        }

        /**
         * Acción que se ejecuta cuando se deniega el acceso a una página.
         */
        public function accessDenied(): void {
            $this->page_title = 'Acceso denegado';
            $this->view = 'accessDenied';
        }

        /**
         * Cierra la sesión del usuario.
         */
        public function logout(): void {
            session_destroy(); // Destruir la sesión actual
            session_start(); // Iniciar una nueva sesión
        }
    }




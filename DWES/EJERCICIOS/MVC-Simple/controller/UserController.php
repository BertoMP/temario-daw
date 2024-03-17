<?php

use model\User;

class UserController
{
    private string $strPageTitle; // Atributo que almacenará el nombre de la página.
    private string $strView; // Atributo que almacenará la vista a renderizar.
    private array $arrParams; // Atributo con los parámetros a utilizar por los métodos del controlador.
    private User $objUserModel; // Objeto Book para provocar consultas de la base de datos a la tabla LIBROS.

    public function __construct(array $arrParams)
    {
        $this->strPageTitle = 'Login'; // Título por defecto.
        $this->strView = 'login'; // Vista por defecto.
        $this->arrParams = $arrParams; // Parámetros recibidos por el constructor.
        $this->objUserModel = new User(); // Instanciación de objeto de la clase Book.
    }

    // FUNCIÓN QUE SIRVE PARA GESTIONAR LOS INTENTOS DE LOGIN DEL USUARIO
    public function login(): array
    {
        $this->strPageTitle = 'Login'; // Título de la página.
        $this->strView = 'login'; // Vista de la página.
        $arrResult = []; // Array de resultado de la función.

        // Si los inputs de 'email' y 'password' no están iniciados (por ejemplo la primera vez que carga la página)
        // provocamos una salida temprana de la función devolviendo el arrResult.
        if (!isset($_POST['email']) and !isset($_POST['password'])) {
            return $arrResult;
        }

        // Si están iniciados los devolvemos dentro de 'data', de esta forma el valor será utilizado en la siguiente
        // carga de la vista login.view.php.
        $arrResult['data']['email'] = $_POST['email'];
        $arrResult['data']['password'] = $_POST['password'];

        // Quitamos los espacios de los valores y comprobamos si están vacíos.
        if ((trim($_POST['email'] === '') || (trim($_POST['password']) === ''))) { // Si lo están...
            // Añadiumos un mensaje de error al array de retorno que se mostrará la siguiente vez.
            $arrResult['params']['error'] = 'Faltan datos. Ambos campos deben estar rellenados';

            // Realizamos una salida temprana devolviendo el array.
            return $arrResult;
        }

        // Si no están vacíos los campos, solicitamos la contraseña asociada al mail a la base de datos.
        $correctPassword = $this->objUserModel->getPassword($_POST['email']);

        // Comprobamos que la contraseña no sea ni null (el mail no existiría en la base de datos) ni que sea
        // diferente a la contraseña introducida por el usuario (contrasaña erronea)
        if ($correctPassword === null || $correctPassword !== $_POST['password']) { // Si lo son...
            // Añadimos un mensaje de error al array de retorno que se mostrará la siguiente vez.
            $arrResult['params']['error'] = 'Email o contraseña incorrectos.';

            // Realizamos una salida temprana devolviendo el array.
            return $arrResult;
        }

        // Si la contraseña es correcta inicializamos el valor 'logged' de $_SESSION a true y redirigimos al usuario
        // al index para realizar una recarga de la página ahora ya con él logado, por lo que se cargará el
        // controlador y la acción por defecto.
        $_SESSION['logged'] = true;
        header('Location: ' . INDEX_URL);

        return $arrResult;
    }

    // FUNCIÓN PARA CERRAR SESIÓN
    public function logout(): void
    {
        unset($_SESSION['logged']);
        session_destroy();
        session_start();
    }

    // MÉTODOS GET PARA DEVOLVER LOS VALORES DE LOS ATRIBUTOS
    public function getPageTitle(): string
    {
        return $this->strPageTitle;
    }

    public function getView(): string
    {
        return $this->strView;
    }
}
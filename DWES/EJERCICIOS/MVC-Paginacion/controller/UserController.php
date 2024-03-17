<?php

use model\User;

/**
 * Clase encargada de funcionar como controlador y de comunicarse
 * con la clase User.model.php.
 *
 * Hereda de la clase Controller.
 */
class UserController extends Controller
{
    private User $objUserModel; // Almacenará una instancia de la clase User.

    /**
     * Constructor de la clase.
     *
     * @param array $arrParams Recibe una serie de parámetros asociados que serán
     *                         utilizados en varios o todos los métodos de la
     *                         clase.
     */
    public function __construct(array $arrParams)
    {
        $this->strPageTitle = 'Login';          // Se asocia un título por defecto.
        $this->strView = 'login';               // Se asocia una vista por defecto.
        $this->arrParams = $arrParams;          // Se asocia el $arrParams que recibe por parámetro.
        $this->objUserModel = new User();       // Se genera una instancia de User.
    }

    /**
     * Realiza el proceso de inicio de sesión y redirecciona si es exitoso.
     *
     * Configura la página y la vista para mostrar el formulario de inicio de sesión.
     * Recupera y valida los datos de inicio de sesión proporcionados a través de la solicitud.
     * Verifica la autenticidad del email y la contraseña en comparación con la base de datos.
     * Si la autenticación es exitosa, inicia la sesión y redirecciona al usuario.
     *
     * @return array Un array que contiene datos y parámetros para la vista.
     *   - 'data': Los datos de inicio de sesión proporcionados a través de la solicitud.
     *   - 'params': Un array que contiene:
     *     - 'error': Mensaje de error si ocurre algún problema durante el inicio de sesión.
     *   - Si el inicio de sesión es exitoso, se redirecciona y no se devuelve ningún dato específico.
     */
    public function login(): array
    {
        $this->strPageTitle = 'Login';
        $this->strView = 'login';
        $arrResult = []; // Array que se devolverá como resultado de la función.

        // Verifica si no se han proporcionado datos de inicio de sesión.
        if (!isset($_REQUEST['email']) and !isset($_REQUEST['password'])) {
            return $arrResult;
        }

        // Comprueba que los inputs no incluyen inyecciones de SQL.
        $correctedData = [
            'email' => Controller::preventSQLInjection($_REQUEST['email']),
            'password' => Controller::preventSQLInjection($_REQUEST['password'])
        ];

        // Almacena los datos de inicio de sesión proporcionados a través de la solicitud.
        $arrResult['data']['email'] = $correctedData['email'];
        $arrResult['data']['password'] = $correctedData['password'];

        // Verifica si algún campo está vacío.
        if ((trim($correctedData['email'] === '') || (trim($_REQUEST['password']) === ''))) {
            $arrResult['params']['error'] = 'Faltan datos. Ambos campos deben estar rellenados';
            return $arrResult;
        }

        // Verifica si el email tiene un formato válido.
        if (!$this->checkMail($correctedData['email'])) {
            $arrResult['params']['error'] = 'El email no tiene un formato válido.';
            return $arrResult;
        }

        // Obtiene la contraseña correcta desde la base de datos para el email proporcionado
        $correctPassword = $this->objUserModel->getPassword($correctedData['email']);

        // Verifica la autenticidad de la contraseña introducida
        if ($correctPassword === null || !password_verify($correctedData['password'], $correctPassword)) {
            $arrResult['params']['error'] = 'Email o contraseña incorrectos.';
            return $arrResult;
        }

        // Inicia la sesión si la autenticación es exitosa.
        $_SESSION['logged'] = true;

        // Redirecciona al usuario a la página de inicio.
        header('Location: ' . INDEX_URL);

        return $arrResult;
    }

    /**
     * Cierra la sesión actual del usuario.
     *
     * Elimina la variable de sesión 'logged', destruye la sesión actual y reinicia una nueva sesión.
     *
     * @return void
     */
    public function logout(): void
    {
        unset($_SESSION['logged']);
        session_destroy();
        session_start();
    }

    /**
     * Muestra la página de acceso denegado.
     *
     * Configura la página y la vista para mostrar un mensaje de acceso denegado al usuario.
     *
     * @return void
     */
    public function deniedAccess(): void
    {
        $this->strPageTitle = 'Acceso denegado';
        $this->strView = 'accessDenied';
    }

    /**
     * Muestra la página de registro.
     *
     * @return void
     */
    public function register(): void
    {
        $this->strPageTitle = 'Registro de nuevo usuario';
        $this->strView = 'userRegister';
    }

    /**
     * Guarda un nuevo usuario.
     *
     * @return array Un array con información sobre el resultado de la operación.
     *               ['params']['registerTry'] será false si la operación no tuvo éxito.
     *               ['data'] contendrá los datos proporcionados ('EMAIL' y 'PASSWORD').
     */
    public function save(): array
    {
        $arrReturn = []; // Inicializa el array de retorno.

        // Corrige y filtra los datos de entrada para prevenir inyecciones SQL.
        $correctedData = [
            'userEmail' => Controller::preventSQLInjection($_REQUEST['userEmail']),
            'userPassword' => Controller::preventSQLInjection($_REQUEST['userPassword'])
        ];

        // Comprueba si los datos de entrada son válidos
        if (trim($correctedData['userEmail']) === ''
            || !$this->checkMail($correctedData['userEmail'])
            || trim($correctedData['userPassword']) === '') {
            // Si los datos no son válidos, configura el array de retorno y termina la ejecución
            $arrReturn['params']['registerTry'] = false;

            $this->strPageTitle = 'Registro de nuevo usuario';
            $this->strView = 'userRegister';
            $arrReturn['data'] = [
                'EMAIL' => $correctedData['userEmail'],
                'PASSWORD' => $correctedData['userPassword']
            ];

            return $arrReturn;
        }

        // Si los datos son válidos, configura la página de éxito y guarda el usuario
        $this->strPageTitle = 'Registro completado';
        $this->strView = 'userRegisterCompleted';
        $this->objUserModel->saveUser($correctedData);

        return $arrReturn;
    }

    /**
     * Verifica si una dirección de correo electrónico es válida.
     *
     * @param string $email La dirección de correo electrónico a validar.
     *
     * @return bool True si la dirección de correo electrónico es válida, false de lo contrario.
     */
    private static function checkMail(string $email): bool
    {
        // Filtra y valida la dirección de correo electrónico
        $filteredEmail = filter_var($email, FILTER_VALIDATE_EMAIL);

        return $filteredEmail !== false;
    }
}
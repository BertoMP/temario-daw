<?php
    // ARCHIVOS NECESARIOS PARA EL FUNCIONAMIENTO CORRECTO.
    require_once 'config/config.php';
    require_once 'models/Database.model.php';

    // SE INICIALIZA O RESTAURA UNA SESSION
    session_start();

    /**
     * Primera comprobación: Comprobamos si el usuario se ha logado
     * en nuestra página web.
     *
     * Para ello lo primero que hacemos es comprobar si el valor
     * 'accesoConcedido' del array $_SESSION se ha establecido o no.
     * Este valor sólo se establece como resultado positivo del método
     * 'comprobarPass' del controlador 'ControladorLogin'.
     */
    if (isset($_SESSION['accesoConcedido'])) { // En el caso de que esté logado...
        /**
         * Comprobamos si no está establecido el valor 'controladorElegido' en
         * el array $_GET.
         * En el caso de que no lo esté, le damos el valor 'ControladorLibros'.
         */
        if (!isset($_GET['controladorElegido'])) {
            $_GET['controladorElegido'] = 'ControladorLibros';
        }
        /**
         * Para evitar que un usuario logado acceda de nuevo al login podemos
         * hacer una nueva condición en el controlador para que, si intenta
         * acceder a 'ControladorLogin' y, además, lo hacce a un método que no sea
         * 'logout' le redirija automáticamente a 'ControladorLibros' con el
         * método 'listarLibros'.
         */
        else if ($_GET['controladorElegido'] === 'ControladorLogin') {
            if (isset($_GET['metodoElegido']) and $_GET['metodoElegido'] !== 'logout') {
                $_GET['controladorElegido'] = 'ControladorLibros';
                $_GET['metodoElegido'] = 'listarLibros';
            }
        }

        /**
         * Comprobamos si no está establecido el valor 'metodoElegido' en el
         * array $_GET.
         * En el caso de que no lo esté, le damos el valor 'Listar libros'.
         */
        if (!isset($_GET['metodoElegido'])) {
            $_GET['metodoElegido'] = 'listarLibros';
        }
    } else { // En el caso de que no esté logado...
        /**
         * Comprobamos si el usuario ha establecido un valor en 'controladorElegido'
         * en el array $_GET.
         * En el caso de que lo haya establecido y que este valor sea distinto a
         * 'controladorLogin' (el controlador por defecto), establecemos dicho
         * controlador como valor 'controladorElegido' y establecemos como método
         * 'accesoDenegado'
         */
        if (isset($_GET['controladorElegido'])
            and $_GET['controladorElegido'] !== 'controladorLogin') {
            $_GET['controladorElegido'] = constant('DEFAULT_CONTROLLER');
            $_GET['metodoElegido'] = 'accesoDenegado';
        }
        /**
         * En el caso de que no haya establecido ningún valor, se establecen los
         * valores por defecto tanto en 'controladorElegido' como en 'metodoElegido'.
         */
        else {
            $_GET['controladorElegido'] = constant('DEFAULT_CONTROLLER');
            $_GET['metodoElegido'] = constant('DEFAULT_METHOD');
        }
    }

    /**
     * Generamos una variable $rutaControlador que se construye utilizando el valor
     * asignado a $_GET['controladorElegido'].
     */
    $rutaControlador = 'controller/' . $_GET['controladorElegido'] . '.php';

    /**
     * Segunda comprobación: Comprobamos si $rutaControlador nos lleva un fichero
     * existente en el proyecto o no. En el caso de que el fichero no exista,
     * se carga el controlador de libros.
     */
    if (!file_exists($rutaControlador)) {
        $rutaControlador = 'controller/controladorLibros.php';
        $_GET['controladorElegido'] = 'controladorLibros';
        $_GET['metodoElegido'] = 'listarLibros';
    }

    /**
     * Generamos un objeto del controlador que se ha elegido en este punto del index
     * teniendo en cuenta todos los pasos anteriores.
     * Lo primero que haremos será cargar el archivo del controlador a través de
     * $rutaControlador.
     * A continuación extraeremos el nombre del controlador del valor 'controladorElegido'
     * del array $_GET.
     * Por último haremos un objeto de dicho controlador.
     *
     * Por ejemplo:
     *
     * A este punto la ruta del controlador es: 'controller/controladorLogin.php'.
     *
     *  1. Cargamos este fichero en el programa.
     *  2. Extraemos el nombre, de forma que $nombreControlador = ControladorLogin.
     *  3. Generamos un objeto del controlador, de forma que $objetoControlador = new ControladorLogin().
     */
    require_once $rutaControlador;
    $nombreControlador = $_GET['controladorElegido'];
    $objetoControlador = new $nombreControlador();

    /**
     * Última comprobación, comprobamos si el metodoElegido existe en nuestro objeto.
     */
    $datosAMostrar['datos'] = [];
    $nombreMetodo = $_GET['metodoElegido'];

    if (method_exists($objetoControlador, $nombreMetodo)) {
        $datosAMostrar['datos'] = $objetoControlador->$nombreMetodo();
    } else {
        $objetoControlador = new ControladorLibros();
        $dataToView = $objetoControlador->list();
    }

    require_once 'view/template/cabecera.php';
    require_once 'view/'.$objetoControlador->getView().'.php';
    require_once 'view/template/pie.html';

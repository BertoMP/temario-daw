<?php
// Parámetros de configuración de la base de datos
const DB_HOST               = 'localhost';                                  // Host de la base de datos.
const DB_PORT               = '3308';                                       // Puerto de conexión a la base de datos.
const DB_NAME               = 'BIBLIOTECA';                                 // Nombre de la base de datos.
const DB_USER               = 'root';                                       // Usuario de la base de datos.
const DB_PASS               = '';                                           // Contraseña del usuario de la base de datos.

// Controlador, acción y parámetros predeterminados
const DEFAULT_CONTROLLER    = 'BookController';                             // Controlador por defecto.
const DEFAULT_ACTION        = 'list';                                       // Acción por defecto.
const DEFAULT_PARAMS        = array();                                      // Parámetros por defecto.

// Otros parámetros
const DEFAULT_REGISTERS     = 4;                                            // Cantidad de registros (libros o autores) por página.
const DEFAULT_OPTIONS       = [4, 6, 8, 10, 20];                         // Options para el select de filtrado.
const APP_DIRECTORY         = 'http://localhost/Servidor/MVC-Sin-Paginacion/';  // Directorio donde se encuentra la app
const INDEX_URL             = APP_DIRECTORY . 'index.php';                  // URL archivo index.php.
const CSS_URL               = APP_DIRECTORY . 'css/style.css';              // URL archivo CSS.
const CONTROLLERs_URL       = [                                             // URLs de los controladores de la aplicación.
    'authors' => INDEX_URL . '/AuthorController/',
    'books' => INDEX_URL . '/BookController/',
    'users' => INDEX_URL . '/UserController/'
];
const USER_ROLES = [        // Roles de usuario y su valor numérico.
    'admin' => 10,
    'trabajador' => 5,
    'usuario' => 1
];

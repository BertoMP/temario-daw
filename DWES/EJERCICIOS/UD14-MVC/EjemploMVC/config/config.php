<?php
    // Configuración de la base de datos
    const DB_HOST   = 'localhost'; // Host de la base de datos
    const DB_PORT   = '3308';      // Puerto de la base de datos
    const DB_NAME   = 'mvc_ejemplo'; // Nombre de la base de datos
    const DB_USER   = 'root';      // Usuario de la base de datos
    const DB_PASS   = '';          // Contraseña de la base de datos

    // Controlador y acción predeterminados
    const DEFAULT_CONTROLLER    = "ControladorUsuario"; // Controlador por defecto
    const DEFAULT_ACTION        = "login"; // Acción por defecto

    // Acción para el caso de acceso denegado
    const DENIED_ACTION         = 'accessDenied';

    // Cantidad predeterminada de registros a mostrar
    const CANTIDAD_REGISTROS    = 3; // Número de registros a mostrar por página
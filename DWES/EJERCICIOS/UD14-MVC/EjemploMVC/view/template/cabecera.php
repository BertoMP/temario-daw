<!DOCTYPE html>
<html lang="es">
<head>
    <!-- Configuración del documento HTML -->
    <meta charset="utf-8" />
    <link rel="stylesheet" href="http://localhost/Servidor/UD14-MVC/EjemploMVC/css/style.css">
    <!-- Título de la página, se obtiene del controlador -->
    <title><?php echo $controller->page_title; ?></title>
</head>
<body>
<!-- Div principal que contiene la cabecera de la página -->
<div>
    <!-- Encabezado de la página -->
    <header>
        <!-- Contenedor del título de la página -->
        <div>
            <h1><?php echo $controller->page_title; ?></h1>
        </div>
        <?php
        // Verificar si hay sesión iniciada y mostrar enlace para cerrar sesión
        echo isset($_SESSION['acceso'])
            ? '<a href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorUsuario/logout">Cerrar sesión</a>'
            : '';
        ?>
    </header>

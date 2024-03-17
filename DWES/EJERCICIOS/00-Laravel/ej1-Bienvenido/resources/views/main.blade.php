<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Bienvenido a Laravel</title>
</head>
<body>
<header>
    <h1>Bienvenido a Laravel</h1>
    <p>Esto es un ejemplo de un proyecto en Laravel</p>
</header>
<nav>
    <a href="{{ route('home') }}">Inicio</a>
    <a href="{{ route('about') }}">Nosotros</a>
    <a href="{{ route('projects') }}">Proyecto</a>
</nav>
<main>
    @yield('content')
</main>
</body>
</html>

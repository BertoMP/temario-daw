<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>@yield('title')</title>
    <link rel="stylesheet" href="{{ asset('/css/style.css') }}">
</head>
<body>
<header>
    <h1>Biblioteca</h1>
</header>
<nav>
    <a href="{{ route('libros.listarLibros') }}">Listado de libros</a>
    <a href="{{ route('libros.formularioInsertar') }}">Añadir libro</a>
</nav>
<main>@yield('content')</main>
</body>
</html>

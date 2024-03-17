<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>@yield('title')</title>
</head>
<body>
<nav>
    <a href={{ route('noticias') }}>Blog</a> |
    <a href={{ route('galeria') }}>Fotos</a>
</nav>
<div>@yield('content') </div>
</body>
</html>

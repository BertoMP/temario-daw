<?php
// Reanuda la sesión
session_start();

// Destruir la sesión actual, eliminando todas las variables de sesión
session_destroy();

// Redirige al usuario a la página de inicio
header('Location: ../index.php');

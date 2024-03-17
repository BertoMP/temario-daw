<?php
session_start();
echo "El ID de la sesión es: " . session_id() . "<br />";
$_SESSION["idioma"] = "es";
echo "El idioma establecido es " . $_SESSION['idioma'] . "<br />";
unset($_SESSION["idioma"]);
echo "El idioma establecido es " . $_SESSION['idioma'] . "<br />";
session_destroy();

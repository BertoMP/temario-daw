<?php
// Setea una cookie que tendrá un tiempo de caducidad de 60 segundos
setcookie("idioma", "es", time() + 60);
// Imprime la cookie por pantalla
echo "primero: " . $_COOKIE['idioma'] . "<br />";
setcookie('idioma', 'pt');
echo 'segundo: ' . $_COOKIE['idioma'] . '<br />';
// // elimina la cookie
unset($_COOKIE['idioma']);
echo 'tercero: ' . $_COOKIE['idioma'] . '<br />';

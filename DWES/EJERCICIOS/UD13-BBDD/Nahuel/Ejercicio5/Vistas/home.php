<?php
    if(!isset($_SESSION["usuario"]))
        header("Location: ../index.php");

    echo "<h1>Bienvenido</h1>";

    echo "<div id=\"contenedor\">";
        echo "<a href=\"index.php?vista=peliculas\">Peliculas</a>";
        echo "<br/>";
        echo "<a href=\"index.php?vista=series\">Series</a>";
        echo "<br/>";
        echo "<a href=\"./Controladores/logOut.php\">Cerrar sesion</a>";
    echo "</div>";

?>
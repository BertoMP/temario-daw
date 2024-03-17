<?php
    $arrPeliculas = ["Your Name", "Indiana Jones", "Marte"];
    echo "<h2>Titulos Peliculas</h2>";

    echo "<ul>";
    foreach($arrPeliculas as $pelicula)
        echo "<li>" . $pelicula . "</li>";
    echo "</ul>";

    echo "<p><a href=\"index.php?vista=home\">Salir</a></p>";
?>
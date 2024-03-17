<?php
    if(!isset($_SESSION["usuario"]))
        header("Location: ../index.php");

    $arrSeries = ["Oshi no ko", "Peaky Blinders", "The 100"];
    echo "<h2>Titulos Series</h2>";

    echo "<ul>";
    foreach($arrSeries as $serie)
        echo "<li>" . $serie . "</li>";
    echo "</ul>";

    echo "<p><a href=\"index.php?vista=home\">Salir</a></p>";
?>
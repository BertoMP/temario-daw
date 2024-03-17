<?php
    $titulo = "Session";
    //include("../general/cabecera.inc.php");

    // Recuperamos la información de la sesión
    if(!isset($_SESSION)) {
        session_start();
    }

    // Y comprobamos que el usuario se haya autentificado
    if (!isset($_SESSION['usuario'])) {
       die("Error - debe <a href='12_5.php'>Logarse</a>.<br />");
    }
	if(isset($_SESSION['pelicula'])) {
		echo "<h2>Listado de Películas</h2><ul>";
		foreach($_SESSION['pelicula'] as $strPelicula)
			echo "<li>$strPelicula</li>";
		echo "</ul>";
	}
	echo "<a href=\"login.php?pagina=series\">Ir a series</a> <br />";
	echo "<a href=\"logout.php\">Salir</a>";
    //include("../general/pie.inc.html");
?>

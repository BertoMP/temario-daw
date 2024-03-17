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
	
	if(isset($_SESSION['serie'])) {
		echo "<h2>Listado de Series</h2><ul>";
		foreach($_SESSION['serie'] as $strSerie)
			echo "<li>$strSerie</li>";
		echo "</ul>";
	}
	echo "<a href=\"login.php?pagina=peliculas\">Ir a peliculas</a> <br />";
	echo "<a href=\"logout.php\">Salir</a>";
    //include("../general/pie.inc.html");
?>

<?php
    $titulo = "Session";
    //include("../general/cabecera.inc.php");
   
    // Comprobamos si ya se ha enviado el formulario
    if (isset($_REQUEST['inputUsuario'])) {
        $strUsuario = $_REQUEST['inputUsuario'];
        $strPassword = $_REQUEST['inputPassword'];

        // validamos que recibimos ambos parámetros
        if (empty($strUsuario) || empty($strPassword)) {
            $error = "Debes introducir un usuario y contraseña";
            include "12_5.php"; // se puede hacer un headder("Location) para volver a la página principal y coger alli el error
        } else {
            if ($strUsuario == $strPassword) { // usuario y password tienen que ser iguales
                // almacenamos el usuario en la sesión
                session_start();
                $_SESSION['usuario'] = $strUsuario;
				
                $_SESSION['pelicula'] = ['El señor de los anillos','La guerra de las galaxias','Matrix'];
                $_SESSION['serie'] = ['Friends','Perdidos','Juego de Tronos'];
                // cargamos la página principal
                include "peliculas.php";
            } else {
                // Si las credenciales no son válidas, se vuelven a pedir
                $error = "Usuario o contraseña no válidos!";
                include "12_5.php";
            }
        }
    }
	if (isset($_REQUEST['pagina'])) 
		if($_REQUEST['pagina']=='series')
                include "series.php";
		else if($_REQUEST['pagina']=='peliculas')
					include "peliculas.php";

    //include("../general/pie.inc.html");
?>
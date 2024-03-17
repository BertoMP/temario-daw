<?php
    // Inicializar cURL
    $objCurl = curl_init();

    // Establecer la URL a la que se realizará la solicitud del personaje 10
    curl_setopt($objCurl, CURLOPT_URL, 'https://swapi.dev/api/people/10/');

    // Configurar opciones para devolver el resultado como una cadena
    curl_setopt($objCurl, CURLOPT_RETURNTRANSFER, 1);

    // Ejecutar la solicitud y obtener la respuesta
    $strJSON = curl_exec($objCurl);

    // Comprobar errores
    if (curl_errno($objCurl)) {
        echo 'Error en la solicitud cURL: ' . curl_error($objCurl);
    } else {
        // Decodificar la respuesta JSON
        $arrPersonaje = json_decode($strJSON, true);
        // Mostrar información sobre el personaje
        echo 'Nombre: ' . $arrPersonaje['name'] . '<br>';
        echo 'Altura: ' . $arrPersonaje['height'] . '<br>';
        echo 'Peso: ' . $arrPersonaje['mass'] . '<br>';
        echo 'Año de nacimiento: ' . $arrPersonaje['birth_year'] . '<br>';
        // ... Puedes mostrar más información según la estructura de la respuesta JSON.
    }

    // Cerrar la sesión cURL
    curl_close($objCurl);
?>
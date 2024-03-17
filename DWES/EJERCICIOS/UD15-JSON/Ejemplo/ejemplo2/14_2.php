<?php
    // Verifica si cURL está habilitado
    if (function_exists('curl_version'))
        echo 'cURL está habilitado en este servidor.';
    else
        echo 'cURL no está habilitado en este servidor.';
    

?>
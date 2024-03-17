<?php
    //falla porque abre para leer un fichero existente
    echo 'lectura <br />';
    fopen("$_SERVER[DOCUMENT_ROOT]/Entorno_Servidor/UD9-Ficheros/ejemplos/fichero1", 'rb');
    //no falla, solo fallaría si existiese el fichero 
    echo 'escritura con aviso <br />';
    fopen("$_SERVER[DOCUMENT_ROOT]/Entorno_Servidor/UD9-Ficheros/ejemplos/fichero1", 'xb');
    //no falla porque abre para añadir un fichero existente y si no existe lo crea
    echo 'añadir <br />';
    fopen("$_SERVER[DOCUMENT_ROOT]/Entorno_Servidor/UD9-Ficheros/ejemplos/fichero1", 'ab');
    //no falla porque crea o sobreescribe un fichero 
    echo 'escritura <br />';
    fopen("$_SERVER[DOCUMENT_ROOT]/Entorno_Servidor/UD9-Ficheros/ejemplos/fichero1", 'wb');
?>
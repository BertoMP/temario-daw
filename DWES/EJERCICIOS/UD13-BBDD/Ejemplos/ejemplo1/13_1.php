<?php

    $strConexion = mysqli_connect("localhost", "root", "", "java");

    // COMPROBAMOS LA CONEXIÓN
    if (mysqli_connect_errno()) {
        echo "Problema al conectar con MySQL: " . mysqli_connect_error();
        exit();
    }

    // CONSULTA A LA BASE DE DATOS
    $strConsulta = "SELECT * FROM emple";
    $arrListaUsuarios = mysqli_query($strConexion, $strConsulta);

    // COMPROBAMOS SI EL SERVIDOR NOS HA DEVUELTO RESULTADOS
    if($arrListaUsuarios) 
        // RECORREMOS CADA RESULTADO QUE NOS DEVUELVE EL SERVIDOR
        foreach ($arrListaUsuarios as $arrUsuario)
            echo "$arrUsuario[EMP_NO] $arrUsuario[APELLIDO] <br \>";

    // Con orientación a objetos
    mysqli_report(MYSQLI_REPORT_ALL & ~MYSQLI_REPORT_INDEX); // PARA QUE LANCE LOS ERRORES
    $strConsulta = "SELECT * FROM emple";
    try {
        $conexion = new mysqli("localhost", "root", "", "java");
        $arrListaUsuarios=$conexion->execute_query($strConsulta);
        foreach ($arrListaUsuarios as $arrUsuario)
        echo "$arrUsuario[EMP_NO] $arrUsuario[APELLIDO] <br \>";
        print_r($arrListaUsuarios);
        $arrListaUsuarios->close();
        $conexion->close();
    } catch (mysqli_sql_exception $e) {
        echo 'error SQL ' . $e->getMessage();
    }
?>
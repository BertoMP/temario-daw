<?php
    $strModificacion = "update emple set emp_no=234 where emp_no=123";
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=java", "root", "");
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sentencia = $conexion -> prepare($strModificacion);
        $blnCorrecto = $sentencia->execute();
        if($blnCorrecto)
            echo 'Filas actualizadas ' . $sentencia->rowCount() . '<br />';
        $sentencia = null;
    }catch(PDOException $e){
        echo 'error SQL ' . $e->getMessage() .  '<br />';
    }

    $strNuevaTabla = "CREATE TABLE prueba (clave INT(2), valor VARCHAR(5), PRIMARY KEY (clave))";
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=java", "root", "");
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sentencia = $conexion -> prepare($strNuevaTabla);
        $blnCorrecto = $sentencia->execute();
        if($blnCorrecto)
            echo 'Se creo la tabla <br />';
        $sentencia = null;
    }catch(PDOException $e){
        echo 'error SQL ' . $e->getMessage() .  '<br />';
    }

    $strInsercion = "INSERT INTO prueba(clave, valor) VALUES (2,'Juan')";
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=java", "root", "");
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sentencia = $conexion -> prepare($strInsercion);
        $blnCorrecto = $sentencia->execute();
        if($blnCorrecto)
            echo 'Filas insertadas ' . $sentencia->rowCount() . '<br />';
        $sentencia = null;
    }catch(PDOException $e){
        echo 'error SQL ' . $e->getMessage() .  '<br />';
    }

    $strBorrado = "delete from prueba where clave=2";
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=java", "root", "");
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sentencia = $conexion -> prepare($strBorrado);
        $blnCorrecto = $sentencia->execute();
        if($blnCorrecto)
            echo 'Filas eliminadas ' . $sentencia->rowCount() . '<br />';
        $sentencia = null;
    }catch(PDOException $e){
        echo 'error SQL ' . $e->getMessage() .  '<br />';
    }
?>
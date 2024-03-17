<?php
    if(isset($_GET["valor"]) && strlen($_GET["valor"])>0){
        $strValor = $_GET["valor"];
        // clave y varor son los nombres de las columnas de la tabla
        $strModificacion = "update prueba set valor=:variable where clave=1";
        try {
            $conexion = new PDO("mysql:host=localhost;dbname=java", "root", "");
            $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $sentencia = $conexion -> prepare($strModificacion);
            $sentencia -> bindParam(":variable", $valor);
            $blnCorrecto = $sentencia->execute();
            if($blnCorrecto)
                echo 'Filas actualizadas ' . $sentencia->rowCount() . '<br />';
            $valor='Otro';
            $blnCorrecto = $sentencia->execute();
            if($blnCorrecto)
                echo 'Filas actualizadas ' . $sentencia->rowCount() . '<br />';
            $sentencia = null;
        }catch(PDOException $e){
            echo 'error SQL ' . $e->getMessage() .  '<br />';
        }
    }
?>
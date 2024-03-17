<?php
	mysqli_report(MYSQLI_REPORT_ALL & ~MYSQLI_REPORT_INDEX); // PARA QUE LANCE LOS ERRORES
         $strConsulta = "SELECT * FROM emple where salario between ? and ? LIMIT 5";
        try {
            $conexion = new mysqli("localhost", "root", "", "java");
            $arrListaUsuarios=$conexion->execute_query($strConsulta, [1500,2000]);
            foreach ($arrListaUsuarios as $arrUsuario)
                echo "$arrUsuario[EMP_NO] $arrUsuario[APELLIDO] salario $arrUsuario[SALARIO]<br \>";
    
            echo '<br />';
            
            $arrListaUsuarios=$conexion->execute_query($strConsulta, [2500,3500]);
            foreach ($arrListaUsuarios as $arrUsuario)
                echo "$arrUsuario[EMP_NO] $arrUsuario[APELLIDO] salario $arrUsuario[SALARIO]<br \>";
            $arrListaUsuarios->close();
            $conexion->close();
        } catch (mysqli_sql_exception $e) {
        echo 'error SQL ' . $e->getMessage();
        }
?>
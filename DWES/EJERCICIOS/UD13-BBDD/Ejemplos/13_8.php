<?php
    $strConsulta = "SELECT * FROM emple ";
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=aws", "pepe", "1234");
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sentencia = $conexion->prepare($strConsulta);
        $sentencia -> setFetchMode(PDO::FETCH_ASSOC);
        $sentencia -> execute();

        if($arrEmpleados = $sentencia -> fetchAll()){
			foreach($arrEmpleados as $arrEmpleado){
				foreach($arrEmpleado as $key=>$valor)    
					echo "$key: $valor ";
				echo '<br \>';
			}
        }
        $sentencia -> closeCursor();
    }catch(PDOException $e){
        echo 'error SQL ' . $e->getMessage();
    }
	echo '<br \>Saco el segundo registro: ' . $arrEmpleados[1]["EMP_NO"] . ' ' . $arrEmpleados[1]["APELLIDO"] . '<br \>';

?>
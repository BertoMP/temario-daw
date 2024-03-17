<?php
    $strConsulta = "SELECT * FROM emple ";
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=aws", "pepe", "1234");
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sentencia = $conexion->prepare($strConsulta);
        $sentencia -> setFetchMode(PDO::FETCH_CLASS, "Empleado");
        $sentencia -> execute();

        while($objEmpleado = $sentencia -> fetch()){
			echo"Número de empleado: " . $objEmpleado -> getNumEmp();
			echo" nombre: " . $objEmpleado -> getNombre();
			echo" oficio: " . $objEmpleado -> oficio();
			echo" jefe: " . $objEmpleado -> getDir();
			/*echo" fecha alta: " . $objEmpleado -> FECHA_ALT;
			echo" salario: " . $objEmpleado -> SALARIO;
			echo" comisión: " . $objEmpleado -> COMISION;
			echo" departamento : " . $objEmpleado -> DEPT_NO . "<br />";*/
        }
        $sentencia -> closeCursor();
    }catch(PDOException $e){
        echo 'error SQL ' . $e->getMessage();
    }

?>
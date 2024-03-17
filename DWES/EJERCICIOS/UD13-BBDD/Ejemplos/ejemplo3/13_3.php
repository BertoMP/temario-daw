<?php
$strConsulta = "SELECT * FROM emple ";
try {
    $conexion = new PDO("mysql:host=localhost;dbname=java", "root", "");
    // hay que activar el control de errores de pdo
    $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    // carga la sentencia sql
    // se puede indicar el tipo de cursor, por ejemplo si es dinámico 
    // prepare($strSentenciaSQL, [PDO::ATTR_CURSOR => PDO::CURSOR_SCROLL]);
    $sentencia = $conexion->prepare($strConsulta);
    // indica el modo en que se devuelven los datos
    $sentencia->setFetchMode(PDO::FETCH_ASSOC);
    // ejecuta la sentencia sql
    $sentencia->execute();

    // con fetch() pasa al siguiente elemento
    // en teoría con while ($fila = $sentencia->fetch(PDO::FETCH_NUM, PDO::FETCH_ORI_NEXT))  o FETCH_ORI_PRIOR
    // podría moverme por el cursor sin problema. Si uso prior, primero me tendría que colocar en la última
    // posición con $fila = $sentencia->fetch(PDO::FETCH_NUM, PDO::FETCH_ORI_LAST);
    // en las pruebas que he realizado, siempre me lo devuelve en orden y solo puedo hacer un recorrido
    while ($empleado = $sentencia->fetch()) {
        foreach ($empleado as $key => $valor)
            echo "$key: $valor ";
        echo '<br \>';
    }
    // Para ver el número de registros afectados se usa el método rowCount()
    echo  '<br />Registros que han salido: ' . $sentencia->rowCount();
    $sentencia->closeCursor();

    //Lo mismo con FetchMode por defecto PDO::FETCH_BOTH, que me da array por indice y por nombre
    echo  '<br /><br /><br />';
    $sentencia = $conexion->prepare($strConsulta);
    $sentencia->execute();

    while ($empleado = $sentencia->fetch()) {
        echo $empleado["EMP_NO"] . ' ' . $empleado["APELLIDO"] . '<br \>';
        echo $empleado[0] . ' ' . $empleado[1] . '<br \>';
    }
    $sentencia->closeCursor();
} catch (PDOException $e) {
    echo 'error SQL ' . $e->getMessage();
}

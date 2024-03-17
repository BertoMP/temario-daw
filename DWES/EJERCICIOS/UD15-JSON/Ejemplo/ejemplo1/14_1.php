<?php
    // codificamos en un array JSON
    $arrDatos = ["nombre" => "Pepe", "edad" => 25, "ciudad" => "Coslada"];
    $jsonDatos = json_encode($arrDatos);
    echo $jsonDatos; // string con el formato json

    // generamos el objeto con los datos JSON
    $obj = json_decode($jsonDatos);
    echo '<br />'; 
    print_r($obj); // Es un objeto
    // Accediendo a los datos decodificados
    echo "<br />nombre: " . $obj->nombre; // nombre: Pepe
    echo "<br />edad: " . $obj->edad;   // edad: 25
    echo "<br />ciudad: " . $obj->ciudad; // ciudad: Coslada

    // array bidimensional
    echo '<br /><br /><h3>Array bidimensional</h3>';
    $arrPersonas = ["persona1" => ["nombre" => "Pepe", "edad" => 25, "ciudad" => "Coslada"],
                    "persona2" => ["nombre" => "María", "edad" => 20, "ciudad" => "Madrid"]];
    $jsonDatos = json_encode($arrPersonas); 
    echo $jsonDatos; // string con el formato json
    $arrJson = json_decode($jsonDatos, true); // con true indico que es un array
    echo '<br />';
    print_r($arrJson); // Es un array
    echo '<br />Nombre persona 1: ' . $arrJson['persona1']['nombre']; // pepe
    echo '<br />Nombre persona 2: ' . $arrJson['persona2']['nombre']; // maria
    echo '<br />Array persona 1: ';
    print_r($arrJson['persona1']);

    $objJson = json_decode($jsonDatos); // en este claso es un objeto formado por objetos
    echo '<br />'; 
    print_r($objJson); // Es un un objeto
    echo "<br />nombre persona1: " . $objJson->persona1->nombre; // pepe
    echo "<br />nombre persona2: " . $objJson->persona2->nombre; // maría

    // control de errores json
    echo '<br /><br /><h3>Control de errores</h3>';
    $objJson = json_decode('prueba');
    if (json_last_error() != JSON_ERROR_NONE)
        echo "error al decodificar 'prueba'";
    else
        echo "sin error al decodificar 'prueba'";

    $objJson = json_decode($jsonDatos);
    if (json_last_error() != JSON_ERROR_NONE)
        echo "<br /> error al decodificar jsonDatos";
    else
        echo "<br /> sin error al decodificar jsonDatos";

?>
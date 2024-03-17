<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 3 - Sumar dos salarios</title>
</head>
<body>
    <?php
        //VARIABLES 
        $strPersona1 = "Pepe"; //Variable para guardar el nombre de la primera persona.
        $strPersona2 = "María"; //Variable para guardar el nombre de la segunda persona.

        $floatSalario1 = 1200.87; //Variable para guardar el salario de la primera persona. 
        $floatSalario2 = 1300.20; //Vairble para guardar el salario de la segunda persona.

        $floatSalarioTotal; //Variable para guardar la suma de los salarios 1 y 2.
        
        $floatSalarioTotal = $floatSalario1 + $floatSalario2;

        //DESARROLLO PRINCIPAL
        echo "$strPersona1 y $strPersona2 cobran juntos $floatSalarioTotal" . "€.";
    ?>
</body>
</html>
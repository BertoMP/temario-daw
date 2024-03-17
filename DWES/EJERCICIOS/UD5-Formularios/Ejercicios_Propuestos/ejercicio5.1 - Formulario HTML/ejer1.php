<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos introducidos</title>
</head>
<body>
<?php
    echo "<table><caption>DATOS INTRODUCIDOS</caption><tbody>";
    foreach($_REQUEST as $campo => $valor) {
        if (is_array($valor)) {
            echo "<tr><td>$campo</td><td>";
            foreach($valor as $item) {
                echo "$item<br />";
            }
            echo "</td></tr>";
        } else {
            echo "<tr><td>$campo</td><td>$valor</td></tr>";
        }
    }
    echo "</tbody></table>";
?>
</body>
</html>
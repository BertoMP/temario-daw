<!-- 
    Desarrollar un programa en PHP que permita crear un formulario para elegir una fecha (día-mes-año) entre el 1-1-2000 y el 31-12-2023.

        a) Las diferentes opciones de mes, día y año, no se deben introducir de forma manual en el código, sino que se deben realizar mediante
            un bucle de PHP.
        b) Una vez elegida la fecha, se enviará el formulario y se mostrará por pantalla la fecha elegida. Por ejemplo, "La fecha elegida es: 9/5/2020.".
        c) Se debe comprobar si la fecha es válida, es decir, si el número de días concuerda con los días del mes. Por ejemplo, 12/4/2007 es una fecha
            válida y mostrará por pantalla el mensaje "Es una fecha válida.", sin embargo, la fecha 30/2/2004 no es una fecha válida y mostrará en pantalla
            el mensaje "No es una fecha válida."
        d) Por último, habrá que tener en cuenta la posibilidad de que se haya elegido un mes bisiesto. Un año es bisiesto si es divisible entre 400 o si
            si es divisible entre 4 pero no entre 100.
-->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 01 - Pedir y comprobar una fecha</title>
</head>
<body>
    <form action="compruebaFecha.php" method="get">
        <label for="day">Día</label>
        <select name="day" id="day">
            <?php 
                for ($intCont = 1; $intCont <= 31; $intCont++) {
                    echo "<option value=" . $intCont . "> $intCont </option>";
                }
            ?>
        </select>

        <label for="month">Mes</label>
        <select name="month" id="month">
            <?php 
                for ($intCont = 1; $intCont <= 12; $intCont++) {
                    echo "<option value=" . $intCont . "> $intCont </option>";
                }
            ?>
        </select>

        <label for="year">Año</label>
        <select name="year" id="year">
            <?php 
                for ($intCont = 2000; $intCont <= 2023; $intCont++) {
                    echo "<option value=" . $intCont . "> $intCont </option>";
                }
            ?>
        </select>
        <br>
        <br>
        <input type="submit" value="Enviar fecha">
    </form>
</body>
</html>
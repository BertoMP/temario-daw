<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notas alumnos</title>
    <style>
        table {
            border-collapse: collapse;
        }

        input {
            width: 100%;
        }
    </style>
</head>

<body>
    <?php
    $arrAlumnos = isset($_GET["arrAlumnos"]) ? ($_GET["arrAlumnos"]) : array();
    $arrNotas = isset($_GET["arrNotas"]) ? ($_GET["arrNotas"]) : array();

    if (isset($_GET["nombre"]) && isset($_GET["nota"])) {
        $strNombreAlumno = $_GET["nombre"];
        $intNotaAlumno = $_GET["nota"];
        if (!empty($strNombreAlumno) && $intNotaAlumno >= 0 && $intNotaAlumno <= 10) {
            $arrAlumnos[] = $_GET["nombre"];
            $arrNotas[] = $_GET["nota"];
            echo "<p>Alumno añadido con éxito.</p>";
        } else {
            echo "<p>El alumno no se pudo añadir. Ambos campos deben tener valor y la nota debe estar entre 0 y 10.</p>";
        }
    }
    ?>

    <h1>Formulario para alumnos</h1>
    <form method="get">
        <table>
            <tbody>
                <tr>
                    <td><label for="nombre">Nombre del alumno</label></td>
                    <td><input type="text" name="nombre" id="nombre"></td>
                </tr>

                <tr>
                    <td><label for="nota">Nota del alumno (0-10)</label></td>
                    <td><input type="number" name="nota" id="nota"></td>
                    <?php
                    for($intCont = 0; $intCont < count($arrAlumnos); $intCont++) {
                        echo "<input type=\"hidden\" name=\"arrAlumnos[]\" value=\"$arrAlumnos[$intCont]\">";
                        echo "<input type=\"hidden\" name=\"arrNotas[]\" value=\"$arrNotas[$intCont]\">";
                    }
                    ?>
                </tr>

                <tr>
                    <td><input type="submit" name="agrega" formaction="index.php" value="Agregar alumno"></td>
                    <td><input type="submit" name="ver-lista" formaction="tablaNotas.php" value="Ver listado alumnos"></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
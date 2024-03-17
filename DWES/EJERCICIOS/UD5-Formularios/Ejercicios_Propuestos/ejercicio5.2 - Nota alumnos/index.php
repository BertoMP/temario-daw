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
    $arrAlumnos = (isset($_GET["arrAlumnos"]) ? unserialize($_GET["arrAlumnos"]) : array());

    if (isset($_GET["nombre"]) && isset($_GET["nota"])) {
        $strNombreAlumno = $_GET["nombre"];
        $intNotaAlumno = $_GET["nota"];

        if (!empty($strNombreAlumno) && $intNotaAlumno >= 0 && $intNotaAlumno <= 10) {
            $arrAlumnos[] = array($strNombreAlumno, $intNotaAlumno);
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
                    <td><input type="text" name="nombre" id="nombre"
                        <?= isset($_GET["nombre"]) ? "value=\"" . $_GET["nombre"] . "\"" : "" ?>></td>
                </tr>

                <tr>
                    <td><label for="nota">Nota del alumno (0-10)</label></td>
                    <td><input type="number" name="nota" id="nota"
                        <?= isset($_GET["nota"]) ? "value=\"" . $_GET["nota"] . "\"" : "" ?>></td>
                    <?php
                    echo "<input type=\"hidden\" name=\"arrAlumnos\" value='" . serialize($arrAlumnos) . "'>";
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
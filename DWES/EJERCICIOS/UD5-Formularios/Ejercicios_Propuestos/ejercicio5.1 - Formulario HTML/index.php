<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
    <style>
        button,
        input:not([type="radio"]):not([type="checkbox"]),
        select {
            width: 100%;
        }
    </style>
</head>

<body>
    <form action="ejer1.php" method="get">
        <h1>FORMULARIO DE REGISTRO</h1>
        <table>
            <tbody>
                <tr>
                    <td><label for="nombre">Nombre</label></td>
                    <td colspan="2"><input type="text" name="nombre" id="nombre" <?= isset($_GET["nombre"]) ? "value=\"" . $_GET["nombre"] . "\"" : "" ?>></td>
                </tr>
                <tr>
                    <td><label for="apellidos">Apellidos</label></td>
                    <td colspan="2"><input type="text" name="apellidos" id="apellidos" <?= isset($_GET["apellidos"]) ? "value=\"" . $_GET["apellidos"] . "\"" : "" ?>></td>
                </tr>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td colspan="2"><input type="email" name="email" id="email" <?= isset($_GET["email"]) ? "value=\"" . $_GET["email"] . "\"" : "" ?>></td>
                </tr>
                <tr>
                    <td><label for="url-personal">URL personal</label></td>
                    <td colspan="2"><input type="url" name="url-personal" id="url-personal" <?= isset($_GET["url-personal"]) ? "value=\"" . $_GET["url-personal"] . "\"" : "" ?>></td>
                </tr>
                <tr>
                    <td>
                        <p>Sexo</p>
                    </td>
                    <td colspan="2">
                        <input type="radio" name="sexo" id="hombre" value="hombre" <?= isset($_GET["sexo"]) && $_GET["sexo"] == "hombre" ? ' checked' : '' ?>>
                        <label for="hombre">Hombre</label><br>

                        <input type="radio" name="sexo" id="mujer" value="mujer" <?= isset($_GET["sexo"]) && $_GET["sexo"] == "mujer" ? ' checked' : '' ?>>
                        <label for="mujer">Mujer</label><br>

                        <input type="radio" name="sexo" id="otro" value="otro" <?= isset($_GET["sexo"]) && $_GET["sexo"] == "otro" ? ' checked' : '' ?>>
                        <label for="otro">Otro</label>
                    </td>
                </tr>
                <tr>
                    <td><label for="convivientes">Convivientes</label></td>
                    <td colspan="2"><input type="number" name="convivientes" id="convivientes" <?= isset($_GET["convivientes"]) ? "value=\"" . $_GET["convivientes"] . "\"" : "" ?>></td>
                </tr>
                <tr>
                    <td>
                        <p>Aficiones</p>
                    </td>
                    <td>
                        <input type="checkbox" name="aficiones[]" id="deportes" value="deportes" <?= isset($_GET["aficiones"]) && in_array("deportes", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="deportes">Deportes</label><br>

                        <input type="checkbox" name="aficiones[]" id="lectura" value="lectura" <?= isset($_GET["aficiones"]) && in_array("lectura", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="lectura">Leer</label><br>

                        <input type="checkbox" name="aficiones[]" id="peliculas" value="peliculas" <?= isset($_GET["aficiones"]) && in_array("peliculas", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="peliculas">Ver películas</label><br>

                        <input type="checkbox" name="aficiones[]" id="anime" value="anime" <?= isset($_GET["aficiones"]) && in_array("anime", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="anime">Ver anime</label>
                    </td>
                    <td>
                        <input type="checkbox" name="aficiones[]" id="musica" value="musica" <?= isset($_GET["aficiones"]) && in_array("musica", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="musica">Escuchar música</label><br>

                        <input type="checkbox" name="aficiones[]" id="cocina" value="cocina" <?= isset($_GET["aficiones"]) && in_array("cocina", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="cocina">Cocinar</label><br>

                        <input type="checkbox" name="aficiones[]" id="viajar" value="viajar" <?= isset($_GET["aficiones"]) && in_array("viajar", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="viajar">Viajar</label><br>

                        <input type="checkbox" name="aficiones[]" id="juegos" value="juegos" <?= isset($_GET["aficiones"]) && in_array("juegos", $_GET["aficiones"]) ? " checked" : "" ?>>
                        <label for="juegos">Juegos de mesa</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Menú favorito</p>
                    </td>
                    <td colspan="2">
                        <select name="menu[]" id="menu" multiple>
                            <option value="pasta" <?= isset($_GET["menu"]) && in_array("pasta", $_GET["menu"]) ? " selected" : "" ?>>Ensalada de pasta</option>
                            <option value="tarta" <?= isset($_GET["menu"]) && in_array("tarta", $_GET["menu"]) ? " selected" : "" ?>>Tarta de chocolate</option>
                            <option value="marmitako" <?= isset($_GET["menu"]) && in_array("marmitako", $_GET["menu"]) ? " selected" : "" ?>>Marmitako</option>
                            <option value="paella" <?= isset($_GET["menu"]) && in_array("paella", $_GET["menu"]) ? " selected" : "" ?>>Paella</option>
                            <option value="sushi" <?= isset($_GET["menu"]) && in_array("sushi", $_GET["menu"]) ? " selected" : "" ?>>Sushi</option>
                            <option value="lasanya" <?= isset($_GET["menu"]) && in_array("lasanya", $_GET["menu"]) ? " selected" : "" ?>>Lasaña</option>
                            <option value="hamburguesa" <?= isset($_GET["menu"]) && in_array("hamburguesa", $_GET["menu"]) ? " selected" : "" ?>>Hamburguesa</option>
                            <option value="pollo-asado" <?= isset($_GET["menu"]) && in_array("pollo-asado", $_GET["menu"]) ? " selected" : "" ?>>Pollo Asado</option>
                            <option value="tacos" <?= isset($_GET["menu"]) && in_array("tacos", $_GET["menu"]) ? " selected" : "" ?>>Tacos</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Enviar datos">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>

</html>
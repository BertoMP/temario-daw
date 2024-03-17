<!-- 
    Crea un minidiccionario español-inglés que contenga, al menos, 20palabras (con su traducción). 
    Utiliza un array asociativo para almacenar las parejas de palabras. El programa pedirá una palabra 
    en español y dará la correspondiente traducción en inglés.
-->
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 4 - Diccionario español-inglés</title>
</head>

<body>
    <form action="index.php" method="get">
        <label for="palabra">Introduce una palabra en español</label>
        <input type="text" name="palabra" id="palabra"><br /><br />
        <input type="submit" value="Traducir al inglés">
    </form>

    <?php
    $arrDiccionarioEspIng = [ //Array que funciona como mapa donde la clave es la palabra en castellano y el valor la palabra en inglés.
        "perro" => "dog",
        "gato" => "cat",
        "casa" => "house",
        "coche" => "car",
        "manzana" => "apple",
        "naranja" => "orange",
        "mesa" => "table",
        "silla" => "chair",
        "libro" => "book",
        "ordenador" => "computer",
        "agua" => "water",
        "fuego" => "fire",
        "sol" => "sun",
        "luna" => "moon",
        "amigo" => "friend",
        "familia" => "family",
        "trabajo" => "work",
        "comida" => "food",
        "teclado" => "keyboard",
        "dinero" => "money"
    ];
    $strPalabraEspanyol = ""; //Variable que guarda un String con la palabra elegida en español.

    if (isset($_GET["palabra"])) {
        echo "<br /><br />";
        $strPalabraEspanyol = $_GET["palabra"];
        if (key_exists($_GET["palabra"], $arrDiccionarioEspIng)) {
            echo "La palabra '$strPalabraEspanyol' en inglés es: '$arrDiccionarioEspIng[$strPalabraEspanyol]'.";
        } else {
            echo "La palabra '$strPalabraEspanyol' no se encuentra en el diccionario.";
        }
    }
?>
</body>

</html>
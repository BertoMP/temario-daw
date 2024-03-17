<?php

include_once 'config/config.php';
include_once 'classes/Functionality.php';

$arrCharacters = [];
$headers = [];
$searchValue = $_REQUEST['search-value'] ?? '';
$valueType = is_numeric($searchValue) ? 'ID' : 'nombre';
$searchType = $_REQUEST['search-type'] ?? '';
$url = BASE_URL;

if ($searchType !== '') {
    $url .= '/' . $searchType;

    if (trim($searchValue) !== '') {
        $formattedValue = str_replace(' ', '+', $searchValue);
        $url .= '/' . $formattedValue;
    }

    $arrCharacters = Functionality::getJSON($url);
}
?>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href=<?php echo CSS_URL; ?>>
    <title>API DRAGON BALL</title>
</head>
<body>
<main>
    <form method="post">
        <article>
            <label for="search-value">ID/Nombre del personaje/planeta</label>
            <input type="text" name="search-value" id="search-value" value="<?php echo $searchValue; ?>">
        </article>

        <article>
            <article>
                <label>
                    <input type="radio" name="search-type" value="Character"
                        <?php echo $searchType === 'Character' ? 'checked' : ''; ?>> Búsqueda por personaje
                </label>
            </article>
            <article>
                <label>
                    <input type="radio" name="search-type" value="Planet"
                        <?php echo $searchType === 'Planet' ? 'checked' : ''; ?>> Búsqueda por planeta
                </label>
            </article>
        </article>

        <button type="submit">Buscar</button>
    </form>
    <?php if (count($arrCharacters) > 0): ?>
        <table>
            <tr>
                <?php $headers = array_keys($arrCharacters[0]); ?>
                <?php foreach ($headers as $header): ?>
                    <th><?php echo DICTIONARY[$header] ?></th>
                <?php endforeach; ?>
            </tr>
            <?php foreach ($arrCharacters as $character): ?>
                <tr>
                    <?php foreach ($character as $attribute): ?>
                        <?php if(is_array($attribute)): ?>
                            <td>
                                <?php foreach ($attribute as $datum): ?>
                                    <?php $arrResult = Functionality::getJSON($datum) ?>
                                    <?php echo $arrResult[0]['NAME'] . '<br/>'; ?>
                                <?php endforeach; ?>
                            </td>
                        <?php elseif(str_contains($attribute, 'image')): ?>
                            <td>
                                <img src="<?php echo $attribute; ?>"
                                     alt="Foto de <?php echo $character['NAME']; ?>">
                            </td>
                        <?php else: ?>
                            <td><?php echo $attribute; ?></td>
                        <?php endif; ?>
                    <?php endforeach; ?>
                </tr>
            <?php endforeach; ?>
        </table>
    <?php elseif (isset($_REQUEST['search-value']) and $searchType === ''): ?>
        <p class="error">Debes seleccionar una forma de búsqueda.</p>
    <?php elseif ($searchValue !== ''): ?>
        <p class="error">El <?php echo DICTIONARY[$searchType]; ?> con <?php echo $valueType; ?>
            <?php echo $_REQUEST['search-value']; ?> no existe.</p>
    <?php else: ?>
        <p>Introduce un ID o el nombre de un personaje o un planeta.</p>
    <?php endif; ?>
</main>
</body>
</html>

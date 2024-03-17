<html>

<body>
    <?php
        echo "secreto 1: " . (isset($_REQUEST['secreto']) ? $_REQUEST['secreto'] : '');
        echo "<br /><br />secreto 2: [";
        $arrSecreto = $_REQUEST["secreto2"];
        foreach($arrSecreto as $valor)
            echo "$valor, ";
        echo "]";
    ?>
</body>

</html>
<html>
    <body>
        <form>
            <select name="lenguajes[]" multiple="true">
                <option value="c" <?= isset($_REQUEST["lenguajes"]) && in_array('c',$_REQUEST["lenguajes"])?'selected':'' ?>>C</option>
                <option value="java"  <?= isset($_REQUEST["lenguajes"]) && in_array('java',$_REQUEST["lenguajes"])?'selected':'' ?>>Java</option>
                <option value="php"  <?= isset($_REQUEST["lenguajes"]) && in_array('php',$_REQUEST["lenguajes"])?'selected':'' ?>>PHP</option>
                <option value="python"  <?= isset($_REQUEST["lenguajes"]) && in_array('python',$_REQUEST["lenguajes"])?'selected':'' ?>>Python</option>
            </select>
            <?php

                $strArrLenguajes = $_REQUEST["lenguajes"];

                echo "<br /><br /> Lenguajes <br />";
                foreach ($strArrLenguajes as $strLenguaje)
                    echo "$strLenguaje <br />";
            ?>
        </form>
    </body>
</html>
<html>
    <body>
        <form>
            <?php
                var_dump($_REQUEST);
                foreach($_REQUEST as $key=>$valor)
                    echo "Nombre input: $key valor: $valor<br />";
            ?>
            nombre <input type="text" name="nombre"><br />
            apellidos: <input type="text" name="apellido"><br />
            dirección: <input type="text" name="dirección"><br />
            telérfono: <input type="text" name="telérfono"><br />
            sexo: <input type="text" name="sexo"><br />
            estudios: <input type="text" name="estudios">
            <input type="submit">
        </form>
    </body>
</html>
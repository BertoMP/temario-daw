    <form action="index.php?controller=ControladorLogin&action=check" method="POST">

        <?php
        $usuario = (isset($dataToView["data"]["usuario"])) ? $dataToView["data"]["usuario"] : '';
        $password = (isset($dataToView["data"]["password"])) ? $dataToView["data"]["password"] : '';
        if (isset($_REQUEST['error']))
            echo '<p id=\'error\'>No se ha introducido correctamente el usuario/contraseña</p>';
        ?>
        <label for="user">Usuario</label>
        <br>
        <input type="text" name="usuario" id="user" value="<?php echo $usuario ?>">
        <br><br>
        <label for="contra">contraseña</label>
        <br>
        <input type="password" name="password" id="contra" value="<?php echo $password ?>">
        <br><br>
        <input type="submit" value="Guardar" />
    </form>
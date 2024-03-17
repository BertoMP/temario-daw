<!-- Div principal con clases de estilo para el formulario de inicio de sesión -->
<div class="login">
    <?php
    // Verificar si hay un error de inicio de sesión y mostrar un mensaje correspondiente
    if (isset($dataToView['data']['error'])) {
        echo '<p class="not-valid-access">' . $dataToView['data']['error'] . '</p>';
    } else {
        echo '<p>Introduzca sus datos para iniciar sesión.</p>';
    }
    ?>
    <!-- Formulario de inicio de sesión -->
    <form method="post">
        <!-- Campo para el nombre de usuario -->
        <article>
            <label for="username">Nombre usuario</label>
            <input type="text"
                   name="username"
                   id="username"
                   value="<?php echo $dataToView['data']['username'] ?? '' ?>">
        </article>
        <!-- Campo para la contraseña -->
        <article>
            <label for="password">Contraseña</label>
            <input type="password"
                   name="password"
                   id="password"
                   value="<?php echo $dataToView['data']['password'] ?? '' ?>">
        </article>
        <!-- Sección para el botón de enviar -->
        <article>
            <!-- Botón de enviar con acción dinámica para la autenticación -->
            <input type="submit"
                   formaction="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorUsuario/login"
                   value="Iniciar sesión">
        </article>
    </form>
</div>

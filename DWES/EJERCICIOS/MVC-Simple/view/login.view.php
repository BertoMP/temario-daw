<main class="login">
    <section>
        <?php
        if (isset($arrData['params']['error'])) {
            ?>
            <p class="not-valid-access"><?php echo $arrData['params']['error']; ?></p>
            <?php
        } else {
            ?>
            <p>Introduzca sus datos de inicio de sesión</p>
            <?php
        }
        ?>
        <form method="post"
              action="<?php echo CONTROLLERs_URL['users'] . 'login' ?>">
            <article>
                <label for="email">Email de usuario</label>
                <input type="email"
                       name="email"
                       id="email"
                       value="<?php echo $arrData['data']['email'] ?? ''; ?>"/>
            </article>
            <article>
                <label for="password">Contraseña</label>
                <input type="password"
                       name="password"
                       id="password"
                       value="<?php echo $arrData['data']['password'] ?? ''; ?>"/>
            </article>
            <article>
                <button type="submit">Iniciar sesión</button>
            </article>
        </form>
    </section>
</main>
<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <form action="./php/login.php" method="get">
            <?php
            foreach ($arrCampos as $claveCampo => $valorCampo) {
                echo '<article>';
                echo '<label for="' . $claveCampo . '">' . $valorCampo . '</label>';
                echo '<input type="' . ($claveCampo === 'password' ? 'password' : 'text') . '" name="' .
                    $claveCampo . '" id="' . $claveCampo . '">';
                echo '</article>';
            }
            ?>
            <button type="submit" name="envio-datos">Enviar datos</button>
        </form>
        <?php
        if (isset($_SESSION['login-correcto']) && !$_SESSION['login-correcto']) { // En caso de login incorrecto.
            echo '<p>Usuario o contraseña incorrectos. Vuelva a intentarlo.</p>';
        }
        ?>
    </section>
</main>
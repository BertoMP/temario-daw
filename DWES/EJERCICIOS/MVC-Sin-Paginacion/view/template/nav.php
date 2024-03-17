<?php

use model\User;

if (User::isLogged()) {
    ?>
    <section>
        <nav>
            <a href="<?php echo CONTROLLERs_URL['books'] . 'list' ?>">Listado libros</a>
            <a href="<?php echo CONTROLLERs_URL['authors'] . 'list' ?>">Listado autores</a>
            <a href="<?php echo CONTROLLERs_URL['users'] . 'logout' ?>">Cerrar sesión</a>
        </nav>
    </section>
    <?php
}
?>
</header>
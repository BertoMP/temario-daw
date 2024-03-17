<?php
$strUserEmail = $arrData['data']['EMAIL']??'';
$strUserPassword = $arrData['data']['PASSWORD']??'';
?>
<main class="edit-create-form">
    <?php
    if (isset($arrData['params']['registerTry']) and $arrData['params']['registerTry'] === false) {
        ?>
        <section>
            <p>No puedes introducir datos vacíos o no válidos.</p>
        </section>
        <?php
    }
    ?>
    <form method="post" action="<?php echo CONTROLLERs_URL['users'] . 'save'; ?>">
        <article>
            <label for="userEmail">Email</label>
            <input type="email" name="userEmail" id="userEmail" value="<?php echo $strUserEmail; ?>">
        </article>
        <article>
            <label for="userPassword">Contraseña</label>
            <input type="password" name="userPassword" id="userPassword" value="<?php echo $strUserPassword; ?>">
        </article>
        <article>
            <label for="userRole">Tipo de usuario</label>
            <select name="userRole" id="userRole">
            <?php
            $arrRoles = array_keys(USER_ROLES);
            foreach ($arrRoles as $role) {
            ?>
                <option value="<?php echo $role; ?>"><?php echo mb_strtoupper($role, 'UTF-8'); ?></option>
            <?php
            }
            ?>
            </select>
        </article>
        <article>
            <button type="submit">Completar registro</button>
            <a href="<?php echo INDEX_URL ?>"><button type="button">Volver a inicio</button></a>
        </article>
    </form>
</main>

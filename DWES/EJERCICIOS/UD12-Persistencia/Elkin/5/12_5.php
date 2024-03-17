<?php
    $titulo = "Session";
    //include("../general/cabecera.inc.php");
?>

<form action='login.php' method='post'>
  <fieldset>
        <legend>Login</legend>
        <div><span class='error'><?php echo isset($error)?$error:''; ?></span></div>
        <div class='fila'>
            <label for='usuario'>Usuario:</label><br />
            <input type='text' name='inputUsuario' id='usuario' maxlength="50" /><br />
        </div>
        <div class='fila'>
            <label for='password'>Contraseña:</label><br />
            <input type='password' name='inputPassword' id='password' maxlength="50" /><br />
        </div>
        <div class='fila'>
            <input type='submit' name='enviar' value='Enviar' />
        </div>
  </fieldset>
</form>

<?php
    //include("../general/pie.inc.html");
?>
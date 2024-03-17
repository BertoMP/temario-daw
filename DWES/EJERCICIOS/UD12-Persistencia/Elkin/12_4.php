<form action="pagina2.php">
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre">
    <br />
    <label for="apellidos">Apellidos</label>
    <input type="text" name="apellidos">
    <br />
    <label for="correo">Email</label>
    <input type="email" name="correo">
    <br />
    <label for="dir">Dirección (url)</label>
    <input type="url" name="dir">
    <br />
    <label for="sexo">Sexo</label>
    <select name="sexo">
        <option value="h">hombre</option>
        <option value="m">mujer</option>
    </select>
    <br />
    <input type="submit" name="enviar">
</form>
<?php
    $titulo = "12_4";
    //include("../general/cabecera.inc.php"); //quitar el body de aqui

    if (isset($_REQUEST['mensaje']) && $_REQUEST['mensaje']='vacios')
        echo "No puedes dejar campos vacíos";

  //include("../general/pie.inc.html");
?>
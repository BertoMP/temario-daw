<!-- Div principal con clases de estilo para el diseño -->
<div class="row confirm-delete">
    <!-- Formulario para confirmar la eliminación -->
    <form class="form" action="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/delete" method="POST">
        <!-- Campo oculto que lleva el ID de la nota a eliminar -->
        <input type="hidden" name="id" value="<?php echo $dataToView["data"]["id"]; ?>" />

        <!-- Alerta de advertencia con estilo de Bootstrap -->
        <div class="alert alert-warning">
            <!-- Título de la alerta -->
            <b>¿Confirma que desea eliminar esta nota?:</b>
            <!-- Título de la nota a eliminar -->
            <i><?php echo $dataToView["data"]["titulo"]; ?></i>
        </div>

        <!-- Botón para enviar el formulario y confirmar la eliminación -->
        <input type="submit" value="Eliminar" class="btn btn-danger" />

        <!-- Enlace para cancelar y volver al listado de notas -->
        <a class="btn btn-outline-success" href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list">Cancelar</a>
    </form>
</div>
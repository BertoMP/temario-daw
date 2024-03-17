<!-- Div principal con clases de estilo para el diseño -->
<div class="row complete-delete">
    <!-- Alerta de éxito con estilo de Bootstrap -->
    <div class="alert alert-success">
        <!-- Mensaje de éxito -->
        <p>Nota eliminada correctamente.</p>
        <!-- Enlace para volver al listado de notas, con URL dinámica que incluye la página seleccionada -->
        <a href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list/<?php echo $_SESSION['paginaSeleccionada']?>">Volver al listado</a>
    </div>
</div>
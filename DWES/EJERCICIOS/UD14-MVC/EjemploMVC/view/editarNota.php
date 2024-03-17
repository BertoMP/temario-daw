<?php
$id = $titulo = $contenido = "";

// Asignar valores a las variables si existen en $dataToView["data"]
if(isset($dataToView["data"]["id"])) $id = $dataToView["data"]["id"];
if(isset($dataToView["data"]["titulo"])) $titulo = $dataToView["data"]["titulo"];
if(isset($dataToView["data"]["contenido"])) $contenido = $dataToView["data"]["contenido"];
?>

<!-- Div principal con clases de estilo para el formulario de edición/creación -->
<div class="edit-create-form">
    <?php
    // Mostrar mensajes de respuesta si la variable $_GET["response"] es true
    if(isset($_GET["response"]) and $_GET["response"] === true){
        ?>
        <div>
            <?php
            // Mostrar mensaje específico según el valor de $_GET["datos-vacios"] y $_GET["creation"]
            if (isset($_GET['datos-vacios']) and $_GET['datos-vacios'] === true) {
                echo '<p>No puedes introducir datos vacíos.</p>';
            } else {
                echo '<p>';
                echo (isset($_GET['creation']) and $_GET['creation'] === true) ? 'Creación' : 'Edición';
                echo ' realizada correctamente.</p>';
            }

            // Enlace para volver al listado de notas
            echo '<a href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list/' .
                $_SESSION['paginaSeleccionada'] .'">Volver al listado</a>'
            ?>
        </div>
        <?php
    }
    ?>

    <!-- Formulario para la edición/creación de notas -->
    <form method="POST">
        <!-- Campo oculto que lleva el ID de la nota (si existe) -->
        <input type="hidden" name="id" value="<?php echo $id; ?>" />

        <!-- Campo para el título de la nota -->
        <div>
            <label>Título</label>
            <input type="text" name="titulo" value="<?php echo $titulo; ?>" />
        </div>

        <!-- Campo para el contenido de la nota -->
        <div>
            <label>Contenido</label>
            <textarea style="white-space: pre-wrap;" name="contenido"><?php echo $contenido; ?></textarea>
        </div>

        <!-- Sección para el botón de enviar y el enlace de cancelar -->
        <article>
            <!-- Botón de enviar con acción dinámica para la edición o creación -->
            <input type="submit"
                   formaction="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/save<?php
                   echo (!empty($id)) ? '/' . $id : ''; ?>"
                   value="<?php echo (!empty($id)) ? 'Editar' : 'Crear'; ?>">

            <!-- Enlace para cancelar y volver al listado de notas -->
            <?php
            echo '<a href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/list/' .
                $_SESSION['paginaSeleccionada'] .'">Cancelar</a>';
            ?>
        </article>
    </form>
</div>

<!-- Div principal con clases de estilo para la lista de notas -->
<div class="list-data">
    <!-- Sección para crear una nueva nota -->
    <div>
        <a class='create-note'
           href="http://localhost/Servidor/UD14-MVC/EjemploMVC/index.php/ControladorNota/edit">Crear nota</a>
    </div>

    <?php
    // Verificar si hay notas para mostrar
    if(count($dataToView["data"]) > 0){ // Si existen notas
        echo '<section>';

        // Mostrar paginación
        printPages();

        // Mostrar opciones para filtrar la cantidad de notas por página
        printOptions();
        echo '</section>';

        // Mostrar información sobre los resultados de la paginación
        printInfo();

        // Mostrar las notas de la página
        printNotes($dataToView['data']);
        } else { // Si no existen notas
        ?>
        <div>
            <p>Actualmente no existen notas.</p>
        </div>
        <?php
    }
    ?>
</div>
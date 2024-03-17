<div>
	<div>
		<a href="index.php?controller=ControladorNota&action=edit">Crear nota</a>
		<hr/>
	</div>
	<?php
        if(count($dataToView["data"])>0){
            foreach($dataToView["data"] as $note){
                ?>
                <div>
                    <div>
                        <h5 ><?php echo $note['titulo']; ?></h5>
                        <div><?php echo nl2br($note['contenido']); ?></div>
                        <hr/>
                        <a href="index.php?controller=ControladorNota&action=edit&id=<?php echo $note['id']; ?>" >Editar</a>
                        <a href="index.php?controller=ControladorNota&action=confirmDelete&id=<?php echo $note['id']; ?>">Eliminar</a>
                    </div>
                </div>
                <?php
            }
        }else{
	?>
            <div>
                Actualmente no existen notas.
            </div>
	<?php
	    }
	?>
</div>
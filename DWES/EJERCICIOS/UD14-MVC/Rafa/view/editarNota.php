<?php
$id = $titulo = $contenido = "";

if (isset($dataToView["data"]["id"])) $id = $dataToView["data"]["id"];
if (isset($dataToView["data"]["titulo"])) $titulo = $dataToView["data"]["titulo"];
if (isset($dataToView["data"]["contenido"])) $contenido = $dataToView["data"]["contenido"];

?>
<div>
	<?php
	if (isset($_REQUEST["response"]) and $_REQUEST["response"] === true) {
		if ($_REQUEST["id"] != "") {
	?>
			<div>
				Edición realizada correctamente. <a href="index.php?controller=ControladorNota&action=list">Volver al listado</a>
			</div>
		<?php
		} else {
		?>
			<div>
				Creación realizada correctamente. <a href="index.php?controller=ControladorNota&action=list">Volver al listado</a>
			</div>
		<?php
		}
	} else if (isset($_REQUEST["response"]) and $_REQUEST["response"] === false) {
		?>
		<div>
			Operación no se ha realizado correctamente al estar vacio. <a href="index.php?controller=ControladorNota&action=list">Volver al listado</a>
		</div>
	<?php
	}
	?>
	<form action="index.php?controller=ControladorNota&action=save" method="POST">
		<input type="hidden" name="id" value="<?php echo $id; ?>" />
		<div>
			<label>Título</label>
			<input type="text" name="titulo" value="<?php echo $titulo; ?>" />
		</div>
		<div>
			<label>Contenido</label>
			<textarea style="white-space: pre-wrap;" name="contenido"><?php echo $contenido; ?></textarea>
		</div>
		<input type="submit" value="Guardar" />
		<a href="index.php?controller=ControladorNota&action=list">Cancelar</a>
	</form>
</div>
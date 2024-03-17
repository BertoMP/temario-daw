<?php

class Nota
{

	private $table = 'notas';
	private $conection;

	public function __construct()
	{
		$this->conection =  Db::abrirConexion();
	}

	/* Set conection */
	public function getConection()
	{
		$this->conection =  Db::abrirConexion();
	}

	/* Get all notes */
	public function getNotes()
	{
		$sql = "SELECT * FROM " . $this->table;
		$stmt = $this->conection->prepare($sql);
		$stmt->execute();

		return $stmt->fetchAll();
	}

	/* Get note by id */
	public function getNoteById($id)
	{
		if (empty($id)) return false;
		$sql = "SELECT * FROM " . $this->table . " WHERE id = ?";
		$stmt = $this->conection->prepare($sql);
		$stmt->execute([$id]);

		return $stmt->fetch();
	}

	/* Save note */
	public function save($param)
	{

		/* Set default values */
		$titulo = $contenido = "";
		$id = null;

		/* Check if exists */
		$exists = false;
		if (isset($param["id"]) and $param["id"] != '') {
			$actualNote = $this->getNoteById($param["id"]);
			if (isset($actualNote["id"])) {
				$exists = true;
				/* Actual values */
				$id = $param["id"];
				$titulo = $actualNote["titulo"];
				$contenido = $actualNote["contenido"];
			}
		}

		/* Received values */
		if (isset($param["titulo"])) $titulo = $param["titulo"];
		if (isset($param["contenido"])) $contenido = $param["contenido"];

		/* Database operations */

		if ($exists) {
			$sql = "UPDATE " . $this->table . " SET titulo=?, contenido=? WHERE id=?";
			$stmt = $this->conection->prepare($sql);
			$res = $stmt->execute([$titulo, $contenido, $id]);
		} else {
			$sql = "INSERT INTO " . $this->table . " (titulo, contenido) values(?, ?)";
			$stmt = $this->conection->prepare($sql);
			$stmt->execute([$titulo, $contenido]);
			$id = $this->conection->lastInsertId();
		}
		return $id;
	}

	/* Delete note by id */
	public function deleteNoteById($id)
	{
		$sql = "DELETE FROM " . $this->table . " WHERE id = ?";
		$stmt = $this->conection->prepare($sql);
		$stmt->execute([$id]);
		return $this->getNotes();
	}
}

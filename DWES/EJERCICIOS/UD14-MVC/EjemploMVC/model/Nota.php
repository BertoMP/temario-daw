<?php

require_once 'config/config.php';

/**
 * Clase Nota
 *
 * Representa una entidad de notas y proporciona métodos
 * para interactuar con la base de datos.
 */
class Nota {
	private string $table = 'notas'; // Nombre de la tabla de la base de datos que almacena las notas.
	private PDO $conection; // Objeto de conexión a la base de datos.

    /**
     * Constructor de la clase.
     */
	public function __construct() {
        $this->conection = Db::crearConexion();
	}

    /**
     * Obtiene un conjunto de notas paginado.
     *
     * @param int $pagina Número de página solicitada.
     * @return array Arreglo con las notas de la página solicitada.
     */
	public function getNotes($pagina): array {
        $cantNotes = $_SESSION['cantNotes'] ?? constant('CANTIDAD_REGISTROS');
        $limiteInferior = ($pagina - 1) * $cantNotes;

		$sql = 'SELECT * FROM ' . $this->table
            . ' ORDER BY ID'
            . ' LIMIT ' . $limiteInferior . ', ' . $cantNotes;
		$stmt = $this->conection->prepare($sql);
		$stmt->execute();

		return $stmt->fetchAll();
	}

    /**
     * Obtiene la cantidad total de notas en la base de datos.
     *
     * @return int Cantidad total de notas.
     */
    public function getCount(): int {
        $sql = 'SELECT COUNT(ID) AS CONTADOR FROM ' . $this->table;
        $stmt = $this->conection->prepare($sql);
        $stmt->execute();

        $filaContador = $stmt->fetch();

        return $filaContador['CONTADOR'];
    }

    /**
     * Obtiene una nota específica por su identificador.
     *
     * @param int $id Identificador de la nota.
     * @return array|false Arreglo con los datos de la nota o false si no se encuentra.
     */
	public function getNoteById($id): array | false {
		if(is_null($id)) return false;
		$sql = "SELECT * FROM ".$this->table. " WHERE id = ?";
		$stmt = $this->conection->prepare($sql);
		$stmt->execute([$id]);

		return $stmt->fetch();
	}

    /**
     * Guarda una nueva nota o actualiza una existente en la base de datos.
     *
     * @param array $param Arreglo con los datos de la nota.
     * @return int Identificador de la nota guardada o actualizada.
     */
	public function save($param): int {
		$titulo = $contenido = "";

		$exists = false;
		if(isset($param["id"]) and $param["id"] !=''){
			$actualNote = $this->getNoteById($param["id"]);
			if(isset($actualNote["id"])){
				$exists = true;	
				/* Actual values */
				$id = $param["id"];
				$titulo = $actualNote["titulo"];
				$contenido = $actualNote["contenido"];
			}
		}

		if(isset($param["titulo"])) $titulo = $param["titulo"];
		if(isset($param["contenido"])) $contenido = $param["contenido"];

		if($exists){
			$sql = "UPDATE ".$this->table. " SET titulo=?, contenido=? WHERE id=?";
			$stmt = $this->conection->prepare($sql);
			$res = $stmt->execute([$titulo, $contenido, $id]);
		}else{
			$sql = "INSERT INTO ".$this->table. " (titulo, contenido) values(?, ?)";
			$stmt = $this->conection->prepare($sql);
			$stmt->execute([$titulo, $contenido]);
			$id = $this->conection->lastInsertId();
		}

		return $id;
	}

    /**
     * Elimina una nota por su identificador.
     *
     * @param int $id Identificador de la nota a eliminar.
     * @return array Arreglo con las notas de la página actual después de la eliminación.
     */
	public function deleteNoteById($id): array {
		$sql = "DELETE FROM ".$this->table. " WHERE id = ?";
		$stmt = $this->conection->prepare($sql);
		$stmt->execute([$id]);

        $arrayResultados = $this->getNotes($_SESSION['paginaSeleccionada']);

        if (count($arrayResultados) !== 0 || $_SESSION['paginaSeleccionada'] === 1) {
            return $arrayResultados;
        }

        return $this->getNotes(--$_SESSION['paginaSeleccionada']);
	}
}

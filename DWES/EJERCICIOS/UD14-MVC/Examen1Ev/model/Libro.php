<?php

use model\Database;

class Libro {
    private string $tabla = 'LIBRO';
    private PDO $conexion;

    public function __construct() {
        $this->conexion=Database::getConexion();
    }

    public function getLibros(): array{
        $sql = 'SELECT *'
            . ' FROM ' . $this->tabla
            . ' ORDER BY ID_LIBRO';
        $stmt = $this->conexion->prepare($sql);
        $stmt->execute();
        $arrayReturn = $stmt->fetchAll();
        Database::closeConnection($this->conexion, $stmt);
        return $arrayReturn;
    }

    public function getLibroById(?string $idLibro): array {
        $filaLibro = [];
        if (is_null($idLibro)) {
            return $filaLibro;
        }

        $sql = 'SELECT *'
            . ' FROM ' . $this->tabla
            . ' WHERE ID = :idLibro';
        $stmt = $this->conexion->prepare($sql);
        $stmt->bindParam(':idLibro', $idLibro);
        $stmt->execute();
        $filaLibro = $stmt->fetch();
        Database::closeConnection($this->conexion, $stmt);
        return $filaLibro;
    }

    public function creaLibro(array $datosLibro): string {
        $idLibro = $datosLibro['idLibro'];
        $titulo = $datosLibro['titulo'];
        $genero = $datosLibro['genero'];
        $pais = $datosLibro['pais'];
        $ano = $datosLibro['ano'];
        $numpaginas = $datosLibro['numpaginas'];

        $sql = 'INSERT INTO ' . $this->tabla . ' (ID_LIBRO, TITULO, GENERO, PAIS, ANO, NUMPAGINAS)'
            . ' VALUES (:idLibro, :titulo, :genero, :pais, :ano, :numpaginas)';
        $stmt = $this->conexion->prepare($sql);
        $stmt->bindParam(':idLibro', $idLibro);
        $stmt->bindParam(':titulo', $titulo);
        $stmt->bindParam(':genero', $genero);
        $stmt->bindParam(':pais', $pais);
        $stmt->bindParam(':ano', $ano);
        $stmt->bindParam(':numpaginas', $numpaginas);
        $stmt->execute();
        Database::closeConnection($this->conexion, $stmt);
        return $idLibro;
    }

    public function editaLibro(array $datosLibro) {
        $idLibro = $datosLibro['idLibro'];
        $titulo = $datosLibro['titulo'];
        $genero = $datosLibro['genero'];
        $pais = $datosLibro['pais'];
        $ano = $datosLibro['ano'];
        $numpaginas = $datosLibro['numpaginas'];

        $sql = 'UPDATE ' . $this->tabla
            . ' SET ID = :idLibro,'
            . ' TITULO = :titulo,'
            . ' GENERO = :genero,'
            . ' PAIS = :pais,'
            . ' ANO = :ano,'
            . ' NUMPAGINAS = :numpaginas
            . WHERE ID = :idLibro';
        $stmt = $this->conexion->prepare($sql);
        $stmt->bindParam(':idLibro', $idLibro);
        $stmt->bindParam(':titulo', $titulo);
        $stmt->bindParam(':genero', $genero);
        $stmt->bindParam(':pais', $pais);
        $stmt->bindParam(':ano', $ano);
        $stmt->bindParam(':numpaginas', $numpaginas);
        $stmt->execute();
        Database::closeConnection($this->conexion, $stmt);
        return $idLibro;
    }

    public function deleteLibroById(string $idLibro) {
        $sql = 'DELETE FROM ' . $this->tabla
    }
}

CREATE TABLE LIBRO (
    ID_LIBRO   INTEGER(3),
    TITULO     VARCHAR(40),
    GENERO     VARCHAR(15),
    PAIS       VARCHAR(10),
    ANO        INTEGER(4),
    NUMPAGINAS INTEGER(4),
        CONSTRAINT PK_LIBRO PRIMARY KEY (ID_LIBRO)
);
<?php 
class Director {
    public $nombre;

    public function __construct($nombre) {
        $this->nombre = $nombre;
    }
}

class Empresa {
    public $nombre;
    public $director;

    public function __construct($nombre, Director $director) {
        $this->nombre = $nombre;
        $this->director = $director;
    }

    public function clonar() {
        return clone $this;
    }

    public function __clone() {
        $this->director = clone $this->director;
    }
}

$directorOriginal = new Director("Directivo1");
$empresaOriginal = new Empresa("Mi Empresa", $directorOriginal);
$empresaClonada = $empresaOriginal->clonar();

$empresaClonada->director->nombre = "Directivo2";

echo "Nombre del director en la empresa original: " . $empresaOriginal->director->nombre . "<br>";
echo "Nombre del director en la empresa clonada: " . $empresaClonada->director->nombre . "<br>";
?>
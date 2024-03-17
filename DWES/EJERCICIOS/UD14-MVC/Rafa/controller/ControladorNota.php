<?php

require_once 'model/Nota.php';

class ControladorNota{
    public string $page_title;
    public string $view;
    private Nota $noteObj;

    public function __construct(){
        $this->view = 'listadoNotas';
        $this->page_title = 'Listado de notas';
        $this->noteObj = new Nota();
    }

    // devuelve todas las notas
    public function list(): array
    {
        return $this->noteObj->getNotes();
    }

    // devuelve una nota concreta
    public function edit($id = null)
    {
        $this->page_title = 'Editar nota';
        $this->view = 'editarNota';
        /* Id can from get param or method param */
        if (isset($_GET["id"]))
            $id = $_GET["id"];
        else
            $this->page_title = 'Crear nota';

        return $this->noteObj->getNoteById($id);
    }

    /* Create or update note */
    public function save(){
        $this->view = 'editarNota';
        $this->page_title = 'Editar nota';
        $_REQUEST["response"] = true;

        if ($_POST['id'] == "")
            $this->page_title = 'Crear nota';

        if (trim($_POST['titulo']) != "" && trim($_POST['contenido']) != "") {
            $id = $this->noteObj->save($_POST);
            $result = $this->noteObj->getNoteById($id);
        } else {
            $_REQUEST["response"] = false;
            $result = $this->noteObj->getNoteById($_POST['id']);
        }

        return $result;
    }

    /* Confirm to delete */
    public function confirmDelete()
    {
        $this->page_title = 'Eliminar nota';
        $this->view = 'confirmaBorrarNota';
        return $this->noteObj->getNoteById($_GET["id"]);
    }

    /* Delete */
    public function delete()
    {
        $this->page_title = 'Listado de notas';
        $this->view = 'listadoNotas';
        return $this->noteObj->deleteNoteById($_POST["id"]);
    }
}

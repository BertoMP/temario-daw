<?php
    // Incluir archivos necesarios
    require_once 'model/Nota.php';
    require_once 'config/config.php';

    /**
     * ControladorNota Class
     *
     * Este controlador maneja la lógica de las acciones
     * relacionadas con las notas en la aplicación.
     */
    class ControladorNota{
        public string $page_title; // Título de la página
        public string $view; // Vista por defecto
        private Nota $noteObj; // Instancia de la clase Nota

        // Constructor de la clase.
        public function __construct() {
            $this->view = 'listadoNotas'; // Vista por defecto
            $this->page_title = 'Listado de notas'; // Título de la página por defecto
            $this->noteObj = new Nota(); // Crear una instancia de la clase Nota
        }

        /**
         * Obtiene y devuelve un conjunto notas.
         *
         * @param array $params Parámetros opcionales, como la página seleccionada.
         * @return array Devuelve un array con las notas de la página seleccionada
         */
        public function list(array $params): array {
            // Obtener la página seleccionada o establecerla en 1 por defecto.
            $selectedPage = $params['page'] ?? 1;

            /* Obtener la cantidad de notas por página desde la sesión
             * o establecerla desde la constante por defecto. */
            $notesPerPage = $_SESSION['cantNotes'] ?? constant('CANTIDAD_REGISTROS');

            /* Si la solicitud incluye un cambio en la cantidad de notas por página
             * actualizar los datos asociados. */
            if (isset($_REQUEST['cantNotes'])) {
                $selectedPage = 1;
                $_SESSION['cantNotes'] = $_REQUEST['cantNotes'];
                $notesPerPage = $_REQUEST['cantNotes'];
            }

            // Actualizar el contador de notas en la sesión
            $_SESSION['contador'] = $this->noteObj->getCount();

            // Calcular el número máximo de páginas
            $_SESSION['maxPag'] = ceil($_SESSION['contador'] / $notesPerPage);

            // Ajustar la página seleccionada para asegurarse de que esté en un rango válido
            if ($selectedPage < 1) { // Si es menor de 1, lo establece en 1.
                $selectedPage = 1;
            } elseif ($selectedPage > $_SESSION['maxPag']) { // Si es mayor que el máximo, lo establece en el máximo.
                $selectedPage = $_SESSION['maxPag'];
            }

            // Actualizar la página seleccionada en la sesión
            $_SESSION['paginaSeleccionada'] = $selectedPage;

            // Obtener y devolver las notas para la página seleccionada
            return $this->noteObj->getNotes($selectedPage);
        }

        /**
         * Obtiene y devuelve una nota específica para
         * editar o crea una nueva nota.
         *
         * @param array $params Parámetros opcionales, como el
         *                      ID de la nota a editar.
         * @return array | false Devuelve un array con los datos de la nota seleccionada
         *                        o false si no lo encuentra.
         */
        public function edit(array $params): array | false {
            $this->view = 'editarNota';

            // Verificar si se proporciona un ID en los parámetros
            if(!empty($params['id'])) { // Si lo hace será una edición.
                $this->page_title = 'Editar nota';
                $id = $params['id'];
            } else { // Si no lo hace, será una creación.
                $this->page_title = 'Crear nota';
                $id = null;
            }

            // Obtener y devolver los datos de la nota correspondiente al ID
            return $this->noteObj->getNoteById($id);
        }

        /**
         * Crea o actualiza una nota en la base de datos.
         *
         * @param array $params Parámetros, como el ID y los datos
         *                      de la nota a guardar.
         * @return array | false Devuelve un array con los datos de la nota seleccionada
         *                        o false si no lo encuentra.
         */
        public function save(array $params): array | false {
            $this->view = 'editarNota';
            $this->page_title = 'Editar nota';
            $_GET["response"] = true;

            /* Establecer 'creation' en true si no hay un ID proporcionado,
             * es decir, si es la creación de una nueva nota. */
            if (empty($params['id'])) {
                $_GET['creation'] = true;
            }

            // Verificar si los campos del formulario no están vacíos
            if (trim($_REQUEST['titulo']) === '' || trim($_REQUEST['contenido']) === '') {
                $_GET["datos-vacios"] = true;
                $this->page_title = 'Crear nota';

                // Obtener el ID desde la solicitud y obtener los datos de la nota correspondiente
                if (isset($_REQUEST['id'])) {
                    $id = $_REQUEST['id'];
                    $result = $this->noteObj->getNoteById($id);
                } else {
                    $id = "";
                    $result = [];
                }

                return $result;
            }

            $id = $this->noteObj->save($_POST);
            return $this->noteObj->getNoteById($id);
        }

        /**
         * Muestra la confirmación para eliminar una nota.
         *
         * @param array $params Parámetros, como el ID de la nota a eliminar.
         * @return array | false Devuelve un array con los datos de la nota seleccionada
         *                       o false si no lo encuentra.
         */
        public function confirmDelete(array $params): array | false {
            $this->page_title = 'Eliminar nota';
            $this->view = 'confirmaBorrarNota';
            return $this->noteObj->getNoteById($params["id"]);
        }

        /**
         * Elimina una nota de la base de datos.
         * @return array | false Devuelve un array con los datos de la nota seleccionada
         *                        o false si no lo encuentra.
         */
        public function delete(): array | false {
            $this->page_title = 'Borrado completado';
            $this->view = 'notaBorrada';
            return $this->noteObj->deleteNoteById($_POST["id"]);
        }
    }

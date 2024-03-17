<?php
// Reanudación de la sesión.
session_start();

// Eliminación de la sesión.
session_destroy();

header('Location: ../index.php');
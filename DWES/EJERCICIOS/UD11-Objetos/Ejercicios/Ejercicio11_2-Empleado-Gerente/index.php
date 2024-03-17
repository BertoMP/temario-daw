<?php
$strTitulo = 'Ejercicio 11-2: Empleados y Gerentes';
$strRutaCss = './css/styles.css';
// Include de la cabecera.
include('./src/includes/cabecera.inc.php');

// Include de las clases Persona, Trabajador, Empleado y Gerente.
include('./src/classes/Persona.php');
include('./src/classes/Trabajador.php');
include('./src/classes/Empleado.php');
include('./src/classes/Gerente.php');

// Use de las clases Persona, Trabajador, Empleado y Gerente.
use T11E2\Clases\Trabajador;
use T11E2\Clases\Empleado;
use T11E2\Clases\Gerente;

// Creacion de un objeto de tipo Empleado.
$empleadoUno = new Empleado('Alberto', 'Martínez Pérez', 33, 160, 12);

// Creación de dos objetos de tipo Gerente.
$gerenteUno = new Gerente('Roberto', 'López Sánchez', 38, 1700);
$gerenteDos = new Gerente('Lucia', 'Agramón Fernández', 40, 2400);

echo '<section>';
echo '<h2>EMPLEADOS</h2>';
echo '<article>';
echo '<h3>Empleado 1</h3>';
echo Trabajador::toHTML($empleadoUno);
echo '</article>';
echo '</section>';

echo '<section>';
echo '<h2>GERENTES</h2>';
echo '<article>';
echo '<h3>Gerente 1</h3>';
echo Trabajador::toHTML($gerenteUno);
echo '</article>';

echo '<article>';
echo '<h3>Gerente 2</h3>';
$gerenteDos->anyadirTelefono(987654321);
$gerenteDos->anyadirTelefono(654321987);
echo Trabajador::toHTML($gerenteDos);
echo '</article>';
echo '</section>';

// Include del pie de página.
include('./src/includes/pie.inc.php');

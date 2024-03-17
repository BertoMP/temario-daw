<?php
$strTitulo = 'Ejercicio 11-1: Empleado-Persona';
$strRutaCss = './css/styles.css';
// Include de la cabecera.
include('./src/includes/cabecera.inc.php');

// Include de las clases Persona y Empleado.
include('./src/classes/Persona.php');
include('./src/classes/Empleado.php');

// Use de las clases Persona y Empleado.
use T11E1\Clases\Persona;
use T11E1\Clases\Empleado;

// Creación de objetos de la clase Empleado.
$empleadoUno = new Empleado('Alberto', 'Martínez', 33);
$empleadoDos = new Empleado('Adrián', 'Álvarez', 18);
$empleadoTres = new Empleado('Sara', 'López', 19, 2500);
$empleadoCuatro = new Empleado('Ana', 'García', 17, 7000);
$empleadoCinco = new Empleado('Laura', 'Sáinz', 27, 3400);

// Creación de un objeto de la clase Persona.
$personaUno = new Persona('Pablo', 'Luján', 27);

echo '<section>';
echo '<h2>MANEJO DEL LISTÍN</h2>';
$empleadoUno->anyadirTelefono(123456789);
$empleadoUno->anyadirTelefono(987654321);
$empleadoUno->anyadirTelefono(667412562);
$strTelefonos = $empleadoUno->listarTelefonos();
echo '<p>Listado actual tras añadir teléfonos: ' . $strTelefonos . '</p>';
$empleadoUno->vaciarTelefonos();
$strTelefonos = $empleadoUno->listarTelefonos();
echo '<p>Listado tras vaciar: ' . $strTelefonos . '</p>';
echo '</section>';

echo '<section>';
echo '<h2>DATOS DE LOS EMPLEADOS</h2>';
$empleadoUno->anyadirTelefono(987654321);
$empleadoUno->anyadirTelefono(667412562);

echo '<article>';
echo '<h3>Datos empleado uno</h3>';
echo Persona::toHTML($empleadoUno);
echo '</article>';

echo '<article>';
echo '<h3>Datos empleado dos</h3>';
echo Persona::toHTML($empleadoDos);
echo '</article>';

echo '<article>';
echo '<h3>Datos empleado tres</h3>';
echo Persona::toHTML($empleadoTres);
echo '</article>';

echo '<article>';
echo '<h3>Datos empleado cuatro</h3>';
echo Persona::toHTML($empleadoCuatro);
echo '</article>';

echo '<article>';
echo '<h3>Datos empleado cinco</h3>';
echo Persona::toHTML($empleadoCinco);
echo '</article>';

echo '<article>';
echo '<h3>Prueba objeto no Empleado</h3>';
echo Persona::toHTML($personaUno);
echo '</article>';
echo '</section>';

echo '<section>';
echo '<h2>CAMBIOS EN EL SUELDO TOPE</h2>';
$empleadoSueldoTope = Empleado::getSueldoTope();
echo '<p>El sueldo tope actual es: ' . $empleadoSueldoTope . '€.</p>';
Empleado::setSueldoTope(4000);
$empleadoSueldoTope = Empleado::getSueldoTope();
echo '<p>El sueldo tope actual es: ' . $empleadoSueldoTope . '€.</p>';
echo '</section>';

// Include del pie de página.
include('./src/includes/pie.inc.php');

<?php
$strTitulo = 'Ejercicio 11-3: Empresa';
$strRutaCss = './css/styles.css';
// Include de la cabecera.
include('./src/includes/cabecera.inc.php');

// Include de las clases Persona, Trabajador, Empleado, Gerente y Empresa.
include('./src/classes/Persona.php');
include('./src/classes/Trabajador.php');
include('./src/classes/Empleado.php');
include('./src/classes/Gerente.php');
include('./src/classes/Empresa.php');

// Use de las clases Persona, Trabajador, Empleado y Gerente.
use T11E3\Clases\Empleado;
use T11E3\Clases\Gerente;
use T11E3\Clases\Empresa;

// Creación de un objeto Empresa.
$empresaUno = new Empresa('Coslada Transportes', 'C/Buenos Aires, 12');

// Creación de un objeto Empleado.
$trabajadorUno = new Empleado('Alberto', 'Martínez Pérez', 33, 160, 10);

// Creación de un objeto Gerente.
$trabajadorDos = new Gerente('Luisa', 'Marín Jiménez', 35, 2000);

echo '<section>';
echo '<h2>Empresas</h2>';
echo '<article>';
echo '<h3>Empresa 1</h3>';
echo '<article>';
echo '<h4>INFORMACIÓN DE LA EMPRESA</h4>';
$strNombreEmpresa = $empresaUno->getNombre();
$strDireccionEmpresa = $empresaUno->getDireccion();
echo '<p>El nombre de la empresa es: ' . $strNombreEmpresa . '</p>';
echo '<p>La dirección de la empresa es: ' . $strDireccionEmpresa . '</p>';
echo '</article>';

echo '<article>';
echo '<h4>INFORMACIÓN DE LOS TRABAJADORES</h4>';
$empresaUno->anyadirTrabajador($trabajadorUno);
$empresaUno->anyadirTrabajador($trabajadorDos);
echo '<p>Los empleados de la empresa son: </p>' . $empresaUno->listaTrabajadoresHtml();
echo '</article>';


echo '<article>';
echo '<h4>TOTAL NÓMINAS</h4>';
$salarioTotal = $empresaUno->getCosteNominas();
echo '<p>El coste total de las nóminas es: ' . $salarioTotal . '€.</p>';
echo '</article>';
echo '</article>';
echo '</section>';

// Include del pie de página.
include('./src/includes/pie.inc.php');
